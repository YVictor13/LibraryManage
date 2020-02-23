#define HEADER4 "************************************成员********************************\n"
#define HEADER5 "*账号              |     名字     |         联系方式      *\n "
#define HEADER6 "*******************************************************************\n"
#define HEADER7 "*      用户账号        |用户名          |      书号           |         书名    *\n"
#define HEADER8 "*****************************************************************************************************************\n"
#define HEADER9 "******************************借书***********************************************\n"
#define FORMAT "*%-10s|%-15s|5d|%-15s|%-20s|%5d *\n"
#define FORMAT1 " *%-10s|%-15s|%-15s *\n"
#define FORMAT2 "*%-10s|%-15s|%-10s|%-15s*\n"
#define DATA p->data.num, p->data.name, p->data.price, p->data.author, p->data.pub,p->data.number
#define END "**************************************************************************************************************************\n"
#define Key_Up 0x4800
#define Key_Enter Ox1c0d
#define Key_Down 0x5000

typedef struct book
{
	    char num[10];
		char name[15];
		int price;
		char author[15];
		char pub[20];
		int number;
};
typedef struct Member
{
	char mnum[10];
	char mname[15];
	char tel[15];
};

typedef struct borrow
{
	char mnum[10];//会员号
	char mname[15];//会员姓名
	char num[10];//书号
	char name[15];//书名
};

typedef struct node//定义图书信息链表的结点结构
{
	struct book data;//数据域
	struct node *next;//指针域
} Node, *Link;//定义node类型的结构变量和指针变量

typedef struct mnode//定义会员信息链表的结点结构
{
	struct Member inf;//数据域
	struct mnode *next;//指针域
}Mnode, *Mlink;

typedef struct bnode//定义借书信息链表的结点结构
{
	struct borrow binf;//数据域
	struct bnode *next;//指针域
}Bnode, *Blink;

void MainMenu();
int Ide, Key;
Link l;
Mlink m;
Blink b;

void DrawMenu(int j)//选项菜单显示的函数
{
	int n;
		char *s[10] =
		{
		"Add book", "Delete book", "Search book", "Modify book"
		,"Add member","Borrow book", "Return book","Save book","Save member",
		"Quit system"
		};
		setcolor(RED);//此时输出字体颜色红色
		settextstyle(0, 0, 4);
		outtextxy(60, 50, "BOOK MANAGEMENT");//在这个表坐标位置输出book managment
		settextstyle(0, 0, 1);//设置字的字体，大小，样式
		setcolor(GREEN);
		for (n = 0; n < 10; n++)
			outtextxy(250, 110 + n * 20, s[n]);//每隔20输出字符串数组的元素，为了美观
		setcolor(RED);
		outtextxy(250, 110 + j * 20, s[j]);//j是函数中的参数，选中哪个菜单，哪个菜单就会变成红色，其他用绿色
}

void MainMenu()//主菜单函数
{
	int gdriver, gmode;
	void JudgeIde();//这个是后面定义的
		gdriver = DETECT;
	initgraph(&gdriver, &gmode, "");
	setbkcolor(WHITE);//设置背景颜色为白色
	cleardevice();//清屏
	Ide = 0, Key = 0
		DrawMenu(Ide);//因为Ide=0,此时我们进入drawmenu函数，第一项addbook就应该是红色的；默认状态
	do
	{
		If(bioskey(1)//判断是否有按键
		{
			Key = bioskey(0);//将按键信息赋给Key，
			switch (Key)
			{
			case Key_Down:
			{
				Ide++;
				Ide = Ide % 10;//因为我们这个菜单有10项，当我们加到第11项时，必须要仍能回到这个菜单上来才行，从头选
				DrawMenu(Ide);//调用drawmenu函数,使对应项变成红色
				break;
			}
			case Key_Up:
			{
				Ide--;
				Ide = (Ide + 10) % 10;//Ide是0的时候，会变成负值，需要加10
				DrawMenu(Ide);//重新画一下，使对应项变成红色
				Break;
			}
			}
		}
	} while (Key != Key_Enter);//判断是否是回车键
	JudgeIde();//调用judgeide函数
}
void JudgeIde() //判断Ide的这个函数
{
	switch (Ide)
	{
	case 0:
	{
		closegraph();//关闭功能菜单
		Add(l);//调用add函数，实现图书的添加
		break;
	}
	case 1:
	{
		closegraph();//关闭功能菜单
		Del(l);//调用del函数，实现图书信息的删除
		break;
	}
	case 2:
	{
		closegraph();//关闭功能菜单
		search(1);//调用search 函数，实现图书信息的查找
		break;
	}
	case 3:
	{
		closegraph();
		Modify(l);//调用modify函数，实现图书信息的修改
		break;
	}
	case(4):
	{
		closegraph();
		Addmember(l);//添加会员信息
		break;
	}
	case 5:
	{
		closegraph();
		borrow(l, m, b);//实现借书
		break;
	}
	case 6:
	{
		closegraph();
		ret(l,b);//实现还书
		break;
	}
	case 7:
	{
		closegraph();
		Save(1);//实现信息保存；保存图书信息
		break;
	}
	case 8:
	{
		closegraph();
		Savemember(m);//会员信息保存
		break;
	}
	case 9://离开系统
	{
		cleardevice();
		settextstyle(0, 0, 4);
		outtextsy(150, 200, "goodbye!!!");
		sleep(1);
		exit(0);
	}

	}
}



void Add(Link l)//增加图书记录
{
	Node *p, *r, *s;
	char ch, flag = 0, num[10];
	r = l;
	s = l->next;
	system("cls");//清屏
	Disp(1);//此函数在后面有定义，输出已有的图书的信息
	while (r->next != NULL)//这两句意思是，如果r的next不为空，还要继续往后指
		r = r->next;//会将指针移动到链表最末尾，准备添加记录
	while (l)//可以输入多条记录，输入的如果是0，退出添加操作
	{
		stringinput(num, 10, "input number(press '0'return menu):");//后面的函数，规定长度为10，输入的是书号
		flag = 0;
		if (strcmp(num, "0") == 0)
		{
			MainMenu();
		}
		s = l->next;
		while (s)//当s不为空的时候，会一直执行
		{
			if (strcmp(s->data.num, num) == 0)//查询输入的书号是否已经存在。
			{
				flag = 1;//如果存在，flag就会变为1
				break;
			}
			s = s->next;//如果不相同，在查找下一个
		}
		if (flag == 1)//提示用户是否需要重新输入
		{
			getchar();
			printf("======>the number %s is existing,try again?(y/n):", num);
			scanf("%c", &ch);
			if (ch == 'y' || ch == 'Y')//如果输入小写y或者大写Y，则就证明要继续进行
				continue;
			else
				MainMenu();//若不是，则就会返回到功能菜单选择页面
		}
		else
		{
			break;
		}
	}
	p = (Node*)malloc(sizeof(Node));//申请内存空间
	if (!p)//说明申请内存空间没有成功
	{
		printf("\n allocate memory failure");
		MainMenu();
	}
	strcpy(p->data.num, num);//申请成功，就将字符串copy到p->data.num中
	stringinput(p->data.name, 15, "Name:");//输入图书名称到p->data.name中
	p->data.price = numberinput("price");//将定价输入到p->data.price中
	stringinput(p->data.pub, 20, "publishing company:");//输入图书出版社名称到
	p->data.number = numberinput("number:");//输入图书的数量
	p->next = NULL;//也很关键
	r->next = p;//将新节点插入链表之中
	r = p;//很关键，r永远指向链表的最后一个节点
}
void Disp(Link l)//显示单链表l中存储的图书记录
{
	Node *p;
	p = l->next;
	if (p!)//如果p为空，说明没有记录；
	{
		printf("\n====>No record!\n");
		getchar();
		return;
	}
	printf("\n\n");//为了美观好看
	printf(HEADER1);
	printf(HEADER2);
	printf(HEADER3);
	while (p)//逐条输出链表中存储的图书信息
	{
		printf(FORMAT, DATA);//按照format和data的指定格式输出
		p = p->next;
		printf(HEADER3);//输出一排星号，为了分开彼此
	}
}
void Save(Link l)//将数据保存，通过都写入磁盘文件中，实现了保存
{
	FILE *fp;
	Node *p;//p是图书信息链表的指针
	int count = o;
	fp = fopen("f:\\book", "wb");//以只写的方式打开二进制文件
	if (fp = NULL)//说明二进制文件没有打开，打开文件失败
	{
		printf("n====>open file error!\n");
		getchar();
		MainMenu();
	}
	p = l->next;//l是头节点,p指向l的下一个
	while (p)//当p不为空时
	{
		if (fwrite(p, sizeof(Node), l, fp) == 1)//如果p不是空，就将相应信息写入fp指向的磁盘文件
		{
			p = p->next;//指针后移
			count++;//记录图书信息的条数
		}
		else
		{
			break;
		}
	}
	if (count > 0)
	{
		getchar();
		printf("\n\n\n\tsave file complete,total saved'srecord number is:%d\n", count);//提示一下保存了多少记录
		getchar();
		MainMenu();
	}
	else
	{
		system("cls");//清屏
		printf("the current link is empty,no student record is saved!\n");//没有学生记录保存，链表是空的
		getchar();
		MainMenu();
	}
	fclose(fp);//关闭磁盘文件
}

void Del(Link l)//删除指定的图书记录
{
	int sel;
	Node *p, *r;
	char findmess[20];
	if (!l->next)//看看这个链表是不是空链表
	{
		system("cls");
		printf("\n====no record!\n");
		getchar();
		MainMenu();
	}
	system("cls");
	Disp(l);//如果链表不是空的，就调用disp函数，显示链表l中的图书存储记录
	printf("\n            ====> 1.Delete by number         ====>2.Delete bu name  \n");//两种删除方式
	printf("please choice[1,2]:");
	scanf("%d", &sel);
	if (sel == 1)//依据书号删除
	{
		stringinput(findmess, 10, "input the existing student number:");//让你输入书号
		p = Locate(l, findmess, "num");
		if (p)//p的返回值不为0，说明依据书号查询找到了，接下来就要寻找p这个节点的位置
		{
			r = 1;//仍然让r指向表头
			while (r->next != p)//执行这个语句的时候，r在p的前面，p这个节点就是我们要删除的节点
				r = r->next;//r跳过p直接指向了p的下一个节点，相当于在这一步，实现了对p节点的删除
			r->next = p->next;//删除节点要承前启后，承接p后面的节点
			free(p);//p这个节点现在没用了，我们要将其释放出去
			printf("\n=======>delete success!\n");
			getchar();
			MainMenu();
		}
		else//p的返回值为0，说明我们压根没有找到书名为输入书名的这个节点
			Nofind();//调用函数
		getchar();
		MainMenu();
	}
	else if (sel == 2)//选择按书名查找
	{
		stringinput(findmess, 15, "input the existing book name");
		p = Locate(l, findmess, "name");
		if (p)
		{
			r = 1;
			while (r->next != p)//r指向节点的下一个节点就是我们要寻找的p节点
				r = r->next;//直接跳过p节点
			r->next = p->next;//继承p后面的其他节点
			free(p);//释放p节点，很好的习惯
			printf("\n=======>delete success!\n");
			getchar();
			MainMenu();
		}
		else
			Nofind();
		getchar();
		MainMenu();
	}
	else
		Wrong();
	getchar();
	MainMenu();
}

void stringinput(char *t, int lens, char *notice)//输入字符串，进行长度验证，lens就是规定的长度,notice也是字符串
{
	char n[50];
	do 
	{
		printf(notice);//显示提示信息
		scanf("%s", n);//输入字符串
		if (strlen(n) > lens)//如果输入的字符串大于规定的长度
			printf("\n exeed the required length!  \n");	
	} while (strlen(n) > lens);
	strcpy(t, n);//如果输入的字符串符合要求，就将输入的字符串拷贝到字符串t中
}

Node *Locate(Link l, char findmess[], char nameornum[])//链表节点的定位模式，书名或者书号
{
	Node *r;
	if (strcmp(nameornum, "num") == 0)//name or num 两种删除方式，如果和num匹配了，说明就是用书号来删除
	{
		r = l->next;//r是新定义的链表指针，我们要让他指向链表l的表头节点
		while (r)//r不为空
		{
			if (strcmp(r->data.num, findmess) == 0)//要用链表中的当前节点的书号与输入的书号进行比较，如果一致
				return r;//返回与输入内容相匹配的节点
			r = r->next;//否则，节点下移
		}
	}
	else if (strcmp(nameornum, "name") == 0)//如果是按书名来删除
	{
		r = l->next;//指针指向链表l表头节点
		while (r)//当链表不为空时，执行此循环
		{
			if (strcmp(r->data.name, findmess) == 0)//如果找到了与输入的书名匹配的节点
				return r;//返回当前节点的位置
			r = r->next;//否则就继续向下移
		}
	}
	return 0;//从始至终久未找到，凡是能查到的，都不会执行到return 0这一步
}
void Wrong()//输出按键错误信息
{
	printf("\n\n\n\n\n***********ERROR:input has wrong!press any key to continue**************\n");
	getchar();
}

void search(Link l)//实现图书的查找
{
	int select;
	char searchinput[20];
	Node *p;
	if (!l->next)//判断链表是否为空，如果为空，输出如下语句
	{
		system("cls");
		printf("\n======no record!\n");
		getchar();
		MainMenu();
	}
	system("cls");
	printf("\n            ====> 1.Search by number         ====>2.Search bu name  \n");//选择查找方式
	printf("          please choice[1,2]:");
	scanf("%d", &select);
	if (select == 1)//书名查找
	{
		stringinput(searchinput, 10, "input the existing book number:");//将输入的书号付给了searchinput
		p = Locate(l, searchinput, "num");//按书号查找，将查找到的结果赋给p
		if (p)//如果p不为空，说明查找到了
		{
			printheader();
			printdata(p);
			printf(END);
			printf("press any key to return\n");
		}
		else
			Nofind();
		getchar();
	}
	else if (select == 2)//如果按署名查找
	{
		stringinput(searchinput, 15, "input the existing book name:");
		p = Locate(l, searchinput, "name");
		if (p)
		{
			printheader();
			printdata(p);
			printf(END);
			printf("press any key to return\n");
		}
		else
			Nofind();
		getchar();
	}
	else
		Wrong();
	getchar();
	MainMenu();
}
void printheader()//格式化的一个输出函数
{
	printf(HEADER1);
	printf(HEADER2);
	printf(HEADER3);
}
void printdata(Node *pp)//格式化的输出表中数据
{
	Node *p;
	p = pp;
	printf(FORMAT, DATA);//将节点中的内容输出
}


void Nofind()//输出未查找到此书的信息
{
	printf("\n=====>not find this record!\n");
}


void Modify(Link l)//图书信息修改
{
	Node *p;
	char findmess[20];
	if (!l->next)//链表是否为空
	{
		system("cls");
		printf("\n=====>No book record! \n");
		getchar();
		MainMenu();
	}
	system("cls");
	printf("modify book recorder");
	Disp(l);//将整个图书链表中的信息显示出来
	stringinput(findmess, 10, "input the existing book number: ");
	p = Locate(l, findmess, "num");
	if (p)//p不为空就是找到了那个节点
	{
		printf("Number: %s, \n", p->data.num);
		printf("Name: %s,", p->data.name);//以上两条是输入原有的信息
		stringinput(p->data.name, 15, "input book name: ");/*调用函数,输入新的信息*/
		printf("price: %d,", p->data.price);
		p->data.price = numberinput("the price of book: ");
		printf("Author: %s,", p->data.author);
		stringinput(p->data.author, 15, " Author: ");
		printf("publishing company: %s,", p->data.pub);
		stringinput(p->data.pub, 15, "Publishing company: ");
		printf("number: %d, ", p->data.number);
		p->data.number = numberinput("the number of book: ");
		printf("\n=====>modify success! \n");
		Disp(1);//将整个图书链表的信息再输出一次
	}
	else
		Nofind();
	getchar();
	MainMenu();
}

void Mdisp(Mlink m)//显示单链表m之中存在的会员信息，注意使用的是会员信息链表m,不再是图书信息链表l
{
	Mnode *p;//会员信息链表指针
		p = m->next;
	if (!p)//会员信息链表为空
	{
		printf("\n=====>Not record! \n");
		getchar();
		return;
	}
	printf("n\n");
	printf(HEADER4);
	printf(HEADER5);
	printf(HEADER6);
	while (p)//逐条输出储存的会员链表的信息
	{
		printf(FORMAT1, p->inf.mnum, p->inf.mname, p->inf.tel);
		p = p->next;
		printf(HEADER6);
	}
	getchar();
}

int numberinput(char *notice)
{
	int t = 0;
	do
	{
		printf(notice);
		scanf("%d", &t);
		if (t < 0)
			printf("\n price must >0! \n");
	}while (t < 0);
	return t;
	MainMenu();
}

void Addmember(Mlink m)
{
	FILE *fp;
	Mnode *p, *r, *s, *q;//对应会员信息的结构体类型
	char ch, qu, flag = 0, num[10];
	r = m;
	s = m->next;
	system("cls");
	Mdisp(m);
	while (r->next != NULL)/*将原有记录输出*//*将指针移至链表最末尾,准备添加记录*/
		r = r->next;
	while (1)
	{/*可输入多条记录,输入0时退出添加操作*/
		stringinput(num, 10, "input the number of the member(press '0'return menu) :");/*输入会员号*/
			flag = 0/*输入为0,则退出添加操作,返回功能选择界面*/
			if (strcmp(num, "0") == 0)
			{
				MainMenu();
			}
		s = m->next;/*查询该会员号是否已经存在*/
		while (s)
		{
			if (strcmp(s - inf.mnum, num) == 0)
			{
				flag = 1;
				break;
			}
			s = s->next;/*提示用户是否重新输入*/
			if (flag == 1)
			{
				getchar();
				printf("=====>The number %s is existing, try again?(y/n): " num);
				scanf("%c", &ch);
				if (ch == 'y' || ch == ' Y')
					continue;
				else
					MainMenu();
			else
			{
				break;
			}
			}
			/*申请内存空间*/
			p = (Mnode *)malloc(sizeof(Mnode));
			if (!p)
			{
				/*如没有申请到,输出提示信*/
				printf("\n allocate memory failure ");
				MainMenu();
			}
			/*返回主界面*/
			strcpy(p->inf.mnum, num);
			/*将会员号复制到p->data*/
			stringinput(p->inf.mname, 15, "Name:");
			stringinput(p->inf.tel, 15, "Telephone: ");
			p->next = NULL;
			r->next = p;
			/ 将新结点插入链表中 *
				r = p;
		}
		MainMenu();
	}
}

void Savemember(Mlink m)//保存会员信息
{
	FILE *fp;
	Node *p;
	int count = 0;
	fp = fopen("f:\\member", "wb");/*以只写方式打开*/
	if (fp == NULL)
	{
		printf("n=====>open file error!\n");/*打开文件失败*/
		getchar();
		MainMenu();
	}
	p = m->next;
	while (p)
	{
		if (fwrite(p, sizeof(Mnode), 1, fp) == 1)/*写记录到磁盘文件中*/
		{
			p = p->next;
			count++;
		else
			break;
	
		}
		if (count > 0)
		{
			getchar();
			printf("\n\n\n\tsave file complete, total saved's record number is: %d\n",count);
			getchar();
			MainMenu();
		}
		else
		{
			system("cls");
			getchar();
			MainMenu();
		}
		fclose(fp);
	}
}

void borrow(Link 1, M1ink m, B1ink b)/*借书第一个是图书信息链表，第二个是会员信息链表，第三个是借书信息链表*/
{
	Mnode * p;
	Node *q;
	Bnode *t, *s, *k;
	char number[10], booknum[10];
	system("cls");
	t = b->next;
	if (!t)//说明借书信息链表时空的
	{
		printf("\n=====>Not record! \n");
		printf("\n\n");//不空的话就输出这些
		printf(HEADER9);
		printf(HEADER7);
		printf(HEADER8);
		while (t)
		{
			printf(FORMAT2, t->binf.mnum, t->binf.mname, t->binf.num, t->binf.name);//以这个格式输出第一个节点信息
			t = t->next;//指向下一个节点
			printf(HEADER8);
			while (1)
			{
				s = b;//s指向借书信息链表
				p = m->next;//p指向会员信息链表
				q = l->next;//q指向图书信息链表
				while (s->next != NULL)
					s = s->next;//用这两个语句直到s指向借书链表的最后一个节点
				stringinput(number, 10, "please input the number of member: ");/*输入会员号*/
				if (strcmp(number, "0") == 0)//看一下会员号是否为0，如果是0跳出循环
					break;
				do
				{
					if (strcmp(p->inf.mnum, number) == 0)/*查看该会员号是否存在*/
						break;//如果会员存在就跳出这个循环
					else
						p = p->next;//和这个节点的会员信息不匹配，p就会指向下一个节点
				} while (p != NULL);//直到p为空
				stringinput(booknum, 10, " please input the number of book:");/*输入书号*/
				do
				{
					if (strcmp(q->data.num, booknum) == 0)/*查看书号是否存在*/
						break;
					else
						q = q->next;
				} while (q != NULL);//与上面一致
				if (p == NULL)//你不是会员
				{
					printf("you are not a member!");
					MainMenu();
				}
				else if (q == NULL)//书不存在
				{
					printf("the book is not exist! ");
					MainMenu();
				}
				else
				{
					if (q->data.number != 0)//如果现在图书还有
					{
						q->data.number--;//相当于图书现在要借出去一本
						k = (Bnode*)malloc(sizeof(Bnode));/*申请内存空间*/
						if (!k)
						{
							printf("\n allocate memory failure");/*如没有申请到,输出提示*/
							MainMenu();/*返回功能选择界面，这个时候借书信息还没有保存，也就是书还没有接触去*/
						}
						strcpy(k->binf.num, q->data.num);
						strcpy(k->binf.name, q->data.name);
						strcpy(k->binf.mnum, p->inf.mnum);
						strcpy(k->binf.mname, p->inf.mname);
						k->next = NULL;
						s->next = k;//把这个节点加到借书信息链表，因为s经过一顿才做之后指向的是最后一个节点
						s = k;
					}
					else
						preintf("no book!");
				}
			}
			Saveoi(b);//保存借书信息
			getchar();
			MainMenu();
		}
	}
}

void Saveoi(Blink b)
{
	FILE *fp;
	Bnode *p;
	int count = 0;
	fp = fopen("f: \\borrow", "wb");/*以只写方式打开二进制文件或者说新建一个文件*/
	if (fp == NULL)/*打开文件失败*/
	{
		printf("\n=====>open file error!\n");
		getchar();
		MainMenu();
	}
	p = b->next;//b是借书链表
	while (p)
	{
		if (fwrite(p, sizeof(Bnode), 1, fp) == 1)/*每次写一条记录或一个结点信息至文件*/
		{
			p = p->next;
			count++;
		}
		else
		{
			break;
		}
	}
	if (count > 0)
	{
		getchar();
		printf("\n\n\n\n\n=====>save file complete, total saved's record number is: %d\n", count);
		getchar();
		MainMenu();
	}
	else
	{
		system("cls");
		getchar();
		MainMenu();
	}
	fclose(fp);
}

void ret(Link 1, Blink b)//第一个指向图书信息，第二个指向借书信息
{
	Bnode *p, *q;
	Node *t;
	char memnum[10], booknum[10];
	q = b;//借书链表
	p = q->next;//p指向还书信息链表的首节点
	t = l->next;
	stringinput(memnum, 10, "please input the number of member: ");
	if (strcmp(memnum, " 0") == 0)
		MainMenu();
	stringinput(booknum, 10, "please input the number of book: ");
	while (p != NULL)
	{
		if (strcmp(p->binf.num, booknum) == 0 && strcmp(p->binf.mnum, memnum) == 0)/* 如果书号与会员号都存在则可以还*/
		{
			q->next = p->next;//此举相当于要释放p节点
			do
			{
				if (strcmp(t->data.num, booknum) == 0)//要再图书信息链表之中找到那一本书，将其数量加一
					break;
				else
					t = t->next;
			} while (t != NULL);
				t->data.number++;//图书数量加1，还书成功
			free(p);//释放p节点
		}
		else//就是信息不吻合，那就移到下一个节点再进行比较
		{
			q = p;
			p = q->next;
		}
	}
	if (p == NULL)//说明整个链表都走了一遍
	{
		printf("input error");
		MainMenu();
	}
	Saveoi(b);
	getchar();
	MainMenu();
}

main()
{
	FILE *fp;//注意fp是文件的指针
	int select;
	char ch;
	int count = 0;
	Node *p, *r;//指向图书信息链表
	Mnode *q, *t;//指向会员信息链表
	Bnode *s, *k;//指向借书信息链表
	b = (Bnode *)malloc(sizeof(Bnode));
	if (!b)
	{
		printf("\n allocate memory failure ");
		MainMenu();
	}
	b->next = NULL;
	k = b;
	fp = fopen("f:\\borrow,""ab++");//打开借书文件
	if (fp == NULL)
	{
		printf("\n====>can not open file!!!\n");
		exit(0);
	}
	while (!feof(fp))
	{
		s = (Bnode *)malloc(sizeof(Bnode));//申请一个借书节点
		if (!s)
		{
			printf("memory malloc failure!\n");
			exit(0);
		}
		if (fread(s, sizeof(Bnode), l, fp) == 1)//从文件中读取借书记录
		{
			s->next = NULL;//保证新节点s是一个孤节点
			k->next = s;//新节点加入链表
			k = s;//保证k永远指向链表的最后一个节点
		}
	}
	fclose(fp);//关闭借书文件
	m = (Mnode*)malloc(sizeof(Mnode));//申请一个会员信息节点
	if (!m)
	{
		printf("\n allocate memory failure ");/*如没有申请到, 打印提示信息*/
		MainMenu();/*返回功能选择界面*/
	}
	m->next = NULL;
	t = m;
	fp = fopen("f:\\menber", "ab++");//打开会员信息文件
	if (fp == NULL)
	{
		printf("\n=====>can not open file!\n");
		exit(0);
	}
	while (!feof(fp))
	{
		q = (Mnode*)malloc(sizeof(Mnode));
		if (!q)
		{
			printf("memory malloc failure!\n");
			exit(0);
		}
		if (fread(q, sizeof(Mnode), l, fp) == 1)
		{
			q->next = NULL;//保证要新加进来的节点q是一个孤节点
			t->next = q;//让新节点q加入到链表中
			t = q;//t永远指向链表中的最后一个节点
		}
	}
	fclose(fp);/* 关闭文件*/
	l=(Node *)malloc(sizeof(Node));
	if (!l)
	{
		printf("\n allocate memory failure ");/*如没有申请到, 打印提示信息*/
		MainMenu();/*返回功能选择界面*/
	}
	l->next = NULL;
	r = 1;
	fp = fopen("f:\\book", "ab+");
	if (fp == NULL)
	{
		printf("\n=====>can not open file! n");
		exit(0);
	}
	while (!feof(fp))
	{
		p = (Node*)malloc(sizeof(Node));
		if (!p)
		{
			printf(" memory malloc failure! \n");/*没有申请成功*/
			exit(0); /* 大退出 */
		}
		if (fread(p, sizeof(Node), 1, fp) == 1)/*从文件中读取图书信息记录*/
		{
			p->next = NULL;
				r->next = p;
				r = p;
				count++;
		}
	}
	fclose(fp);
		printf("\n=====>open file sucess, the total records number is :%d\n",count);
		MainMenu();
}
