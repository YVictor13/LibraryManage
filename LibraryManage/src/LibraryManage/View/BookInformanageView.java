package LibraryManage.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LibraryManage.Model.Book;
import LibraryManageUtil.BookUtil;
import LibraryManageUtil.DbUtil;
import LibraryManageUtil.StringUtil;

public class BookInformanageView extends JFrame {

	private JPanel contentPane;
	private JTextField BookNameTxt;
	private JTable BookInformationTable;
	private JTextField BookIDTxt;
	private BookUtil bookUtil = new BookUtil();
	private DbUtil dbUtil = new DbUtil();
	/**
	 * Launch the application.
	 * 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInformanageView frame = new BookInformanageView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */


	/**
	 * Create the frame.
	 */
	public BookInformanageView() {
		setTitle("\u8BFB  \u8005");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u53F7\uFF1A");
		label.setFont(new Font("楷体", Font.BOLD, 18));
		label.setBounds(60, 96, 147, 33);
		contentPane.add(label);
		
		BookNameTxt = new JTextField();
		BookNameTxt.setBounds(492, 103, 151, 21);
		contentPane.add(BookNameTxt);
		BookNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		/**
		 * 查询按钮事件处理
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSelectActionPerformed(e);
			}
		});
		button.setFont(new Font("楷体", Font.BOLD, 18));
		button.setBounds(361, 149, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u501F\u4E66");
		/**
		 * 返回事件处理
		 */
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdministerBorrowView().setVisible(true);
			}
		});
		button_1.setFont(new Font("楷体", Font.BOLD, 18));
		button_1.setBounds(472, 149, 97, 23);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 253, 598, 188);
		contentPane.add(scrollPane);
		
		BookInformationTable = new JTable();
		BookInformationTable.setFont(new Font("宋体", Font.PLAIN, 12));
		BookInformationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u7F16\u53F7", "ISBN", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u6570\u91CF", "\u5269\u4F59\u6570\u91CF", "\u5907 \u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BookInformationTable.getColumnModel().getColumn(0).setPreferredWidth(121);
		scrollPane.setViewportView(BookInformationTable);
		
		JLabel lblTushuMigc = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		lblTushuMigc.setFont(new Font("楷体", Font.BOLD, 18));
		lblTushuMigc.setBounds(388, 96, 90, 33);
		contentPane.add(lblTushuMigc);
		
		BookIDTxt = new JTextField();
		BookIDTxt.setColumns(10);
		BookIDTxt.setBounds(209, 103, 151, 21);
		contentPane.add(BookIDTxt);
		
		JLabel label_1 = new JLabel("     ------------------------\u56FE \u4E66 \u4FE1 \u606F------------------------");
		label_1.setFont(new Font("宋体", Font.BOLD, 18));
		label_1.setBounds(48, 195, 645, 48);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6211\u770B\u770B\u4F60\uFF0C\u4F60\u770B\u770B\u672A\u6765");
		label_2.setFont(new Font("华文行楷", Font.BOLD, 28));
		label_2.setBounds(60, 10, 303, 42);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("- - - - \u897F\u7535\u56FE\u4E66");
		label_3.setFont(new Font("华文行楷", Font.BOLD, 18));
		label_3.setBounds(385, 46, 132, 33);
		contentPane.add(label_3);
		
		JButton button_2 = new JButton("\u8FD8\u4E66");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AReturnBookView().setVisible(true);
			}
		});
		button_2.setFont(new Font("楷体", Font.BOLD, 18));
		button_2.setBounds(583, 149, 97, 23);
		contentPane.add(button_2);
	}

	
	
	/**
	 * 初始化表格
	 * 
	 * @param reader
	 */
	
		private void BookInformationfillTable(Book book,int num) {
			DefaultTableModel dtm =  (DefaultTableModel) BookInformationTable.getModel();
			dtm.setRowCount(0);
			
			Connection con =null;
			try {
				
				con=dbUtil.getCon();
				String isDelete="";
				
				ResultSet ls=bookUtil.DeleteBookState(con,book.getBookID());
				if(ls.next()) {
					isDelete=ls.getString("IsDelete");
				}
				if(isDelete.equals("0")) {
					JOptionPane.showMessageDialog(null, "此书已被删除");
					return ;
				}
				
				if(num==1) {
					ResultSet rs=bookUtil.BookIDBooklist(con, book);
					int temp=0;
					while(rs.next()&&temp<1) {
						temp++;
						Vector v = new Vector();
						int Tatolnumber=bookUtil.BookNumber(con, rs.getString("ISBNNumber"));
						int count=bookUtil.BookResidueNumber(con, rs.getString("ISBNNumber"),1);
						v.add(rs.getString("bookID"));
						v.add(rs.getString("ISBNNumber"));
						v.add(rs.getString("bookName"));
						v.add(rs.getString("author"));
						v.add(rs.getString("price"));
						v.add(Tatolnumber);
						v.add(count);
						dtm.addRow(v);
					}
					
				}else if(num==2) {
					ResultSet rs=bookUtil.BookNameBooklist(con, book);
					int temp=0;
					while(rs.next()&&temp<1) {
						temp++;
						Vector v = new Vector();
						int Tatolnumber=bookUtil.BookNumber(con, rs.getString("ISBNNumber"));
						int count=bookUtil.BookResidueNumber(con, rs.getString("ISBNNumber"),1);
						v.add(rs.getString("bookID"));
						v.add(rs.getString("ISBNNumber"));
						v.add(rs.getString("bookName"));
						v.add(rs.getString("author"));
						v.add(rs.getString("price"));
						v.add(Tatolnumber);
						v.add(count);
						dtm.addRow(v);
					}
					
				}else if(num==3) {
					ResultSet rs=bookUtil.Booklist(con, book);
					int temp=0;
					while(rs.next()&&temp<1) {
						temp++;
						Vector v = new Vector();
						int Tatolnumber=bookUtil.BookNumber(con, rs.getString("ISBNNumber"));
						int count=bookUtil.BookResidueNumber(con, rs.getString("ISBNNumber"),1);
						v.add(rs.getString("bookID"));
						v.add(rs.getString("ISBNNumber"));
						v.add(rs.getString("bookName"));
						v.add(rs.getString("author"));
						v.add(rs.getString("price"));
						v.add(Tatolnumber);
						v.add(count);
						dtm.addRow(v);
					}
				}else {
					JOptionPane.showMessageDialog(null, "操作错误\n请重新输入");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	
	private void BookSelectActionPerformed(ActionEvent etv) {

		String bookid=this.BookIDTxt.getText();
		String bookname=this.BookNameTxt.getText();
		Book book=new Book();
		book.setBookName(bookname);
		book.setBookID(bookid);
		
		if(StringUtil.isEmpty(bookname)&&StringUtil.isEmpty(bookid)) {
			JOptionPane.showMessageDialog(null, "查询时，目录号和书名不能同时为空！！！");
			return;
		}else if(!StringUtil.isEmpty(bookid)&&StringUtil.isEmpty(bookname)) {
			this.BookInformationfillTable(book,1);
		}else if(StringUtil.isEmpty(bookid)&&!StringUtil.isEmpty(bookname)) {
			this.BookInformationfillTable(book,2);
		}else if(!StringUtil.isEmpty(bookid)&&!StringUtil.isEmpty(bookname)) {
			this.BookInformationfillTable(book,3);
			
		}
		
	}
}
