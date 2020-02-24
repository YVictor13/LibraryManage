package LibraryManage.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import LibraryManage.Model.BorrowAndReturn;
import LibraryManageUtil.BookUtil;
import LibraryManageUtil.DbUtil;
import LibraryManageUtil.StringUtil;

public class AddBookView extends JFrame {

	private JPanel contentPane;
	private JTextField BookISBNTxt;
	private JTextField BookNameTxt;
	private JTextField BookPriceTxt;
	private JTextField AuthorTxt;
	private JTable AddBookTable;
	private JTextField BookIDTxt;
	private DbUtil dbUtil =new DbUtil();
	private BookUtil bookUtil=new BookUtil();
	/**
	 * Launch the application.
	 * 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookView frame = new AddBookView();
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
	public AddBookView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddBookView.class.getResource("/image/add.png")));
		setTitle("\u56FE\u4E66\u5165\u5E93");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblisbn = new JLabel("\u56FE \u4E66 ISBN \u53F7 \uFF1A");
		lblisbn.setFont(new Font("楷体", Font.BOLD, 18));
		lblisbn.setBounds(137, 161, 150, 22);
		contentPane.add(lblisbn);
		
		BookISBNTxt = new JTextField();
		BookISBNTxt.setBounds(297, 163, 243, 21);
		contentPane.add(BookISBNTxt);
		BookISBNTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		/**
		 * 添加图书事件处理
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookActionPerformed(e);
			}
		});
		button.setFont(new Font("楷体", Font.BOLD, 18));
		button.setBounds(455, 346, 97, 23);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\u56FE  \u4E66  \u540D  \u79F0\uFF1A");
		label_1.setFont(new Font("楷体", Font.BOLD, 18));
		label_1.setBounds(137, 206, 150, 22);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u56FE  \u4E66  \u4F5C  \u8005\uFF1A");
		label_2.setFont(new Font("楷体", Font.BOLD, 18));
		label_2.setBounds(137, 293, 150, 22);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u56FE  \u4E66  \u4EF7  \u683C\uFF1A");
		label_3.setFont(new Font("楷体", Font.BOLD, 18));
		label_3.setBounds(137, 251, 150, 22);
		contentPane.add(label_3);
		
		BookNameTxt = new JTextField();
		BookNameTxt.setBounds(297, 208, 243, 21);
		contentPane.add(BookNameTxt);
		BookNameTxt.setColumns(10);
		
		BookPriceTxt = new JTextField();
		BookPriceTxt.setBounds(297, 253, 243, 21);
		contentPane.add(BookPriceTxt);
		BookPriceTxt.setColumns(10);
		
		AuthorTxt = new JTextField();
		AuthorTxt.setBounds(297, 295, 243, 21);
		contentPane.add(AuthorTxt);
		AuthorTxt.setColumns(10);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		/**
		 * 返回事件处理
		 */
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdministerView().setVisible(true);
			}
		});
		button_1.setFont(new Font("楷体", Font.BOLD, 18));
		button_1.setBounds(151, 568, 97, 23);
		contentPane.add(button_1);
		
		JLabel label_5 = new JLabel("\u52A0\u5165\u7684\u662F\u4E66\u7C4D\uFF0C\u9020\u798F\u7684\u662F\u4E00\u65B9");
		label_5.setFont(new Font("华文行楷", Font.BOLD, 20));
		label_5.setBounds(114, 10, 314, 42);
		contentPane.add(label_5);
		
		JButton button_2 = new JButton("\u67E5\u8BE2");
		/**
		 * 查询入库图书信息
		 */
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectBookInformationActionPerformed(e);
			}
		});
		button_2.setFont(new Font("宋体", Font.BOLD, 18));
		button_2.setBounds(415, 568, 97, 23);
		contentPane.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 423, 644, 127);
		contentPane.add(scrollPane);
		
		AddBookTable = new JTable();
		AddBookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u53F7", "\u56FE\u4E66ISBN\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u4F5C\u8005", "\u56FE\u4E66\u72B6\u6001", "\u5165\u5E93\u65F6\u95F4", "\u6CE8\u9500\u65F6\u95F4", "\u5907\u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		AddBookTable.getColumnModel().getColumn(0).setPreferredWidth(109);
		AddBookTable.getColumnModel().getColumn(2).setPreferredWidth(62);
		AddBookTable.getColumnModel().getColumn(3).setPreferredWidth(62);
		AddBookTable.getColumnModel().getColumn(4).setPreferredWidth(63);
		AddBookTable.getColumnModel().getColumn(5).setPreferredWidth(64);
		AddBookTable.getColumnModel().getColumn(6).setPreferredWidth(81);
		scrollPane.setViewportView(AddBookTable);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		/**
		 * 重置操作实现
		 */
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_3.setFont(new Font("宋体", Font.BOLD, 18));
		button_3.setBounds(151, 346, 97, 23);
		contentPane.add(button_3);
		
		JLabel label_4 = new JLabel("--------------\u5165 \u5E93 \u56FE \u4E66 \u4FE1 \u606F-----------------");
		label_4.setFont(new Font("宋体", Font.BOLD, 18));
		label_4.setBounds(134, 379, 471, 34);
		contentPane.add(label_4);
		
		JLabel label_6 = new JLabel("- - - - -\u897F\u7535\u56FE\u4E66");
		label_6.setFont(new Font("华文行楷", Font.BOLD, 18));
		label_6.setBounds(359, 62, 140, 27);
		contentPane.add(label_6);
		
		JLabel label = new JLabel("\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u53F7\uFF1A");
		label.setFont(new Font("楷体", Font.BOLD, 18));
		label.setBounds(137, 119, 150, 22);
		contentPane.add(label);
		
		BookIDTxt = new JTextField();
		BookIDTxt.setColumns(10);
		BookIDTxt.setBounds(297, 121, 243, 21);
		contentPane.add(BookIDTxt);
	}
	
	/**
	 * 初始化表格
	 * 
	 * @param reader
	 */
	
		private void AddBookFilled(Book book) {
			DefaultTableModel dtm =  (DefaultTableModel) AddBookTable.getModel();
			dtm.setRowCount(0);
			Connection con =null;
			try {
				
				con=dbUtil.getCon();
				ResultSet rs=bookUtil.SelectAddBooklist(con, book.getPutinDate());
				while(rs.next()) {
					Vector v = new Vector();
					v.add(rs.getString("bookID"));
					v.add(rs.getString("ISBNNumber"));
					v.add(rs.getString("bookName"));
					v.add(rs.getString("author"));
					v.add(rs.getString("price"));
					v.add(rs.getString("bookState"));
					v.add(rs.getString("putinDate"));
					v.add(rs.getString("outputDate"));
					dtm.addRow(v);
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
	
	
	private void SelectBookInformationActionPerformed(ActionEvent etv) {
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String putinDate = df.format(day);
		Book book=new Book();
		book.setPutinDate(putinDate);
		this.AddBookFilled(book);
		
		
	}

	/**
	 * 图书添加事件处理
	 * @param etv
	 */
		private void AddBookActionPerformed(ActionEvent etv) {
			String bookid = this.BookIDTxt.getText();
			String bookisbn=this.BookISBNTxt.getText();
			String bookname=this.BookNameTxt.getText();
			String author=this.AuthorTxt.getText();
			String price=this.BookPriceTxt.getText();
			if(StringUtil.isEmpty(bookid)) {
				JOptionPane.showMessageDialog(null, "图书目录不能为空!");
				return ;
			}
			if(StringUtil.isEmpty(bookisbn)) {
				JOptionPane.showMessageDialog(null, "图书ISBN号不能为空!");
				return;
			}
			if(StringUtil.isEmpty(bookname)) {
				JOptionPane.showMessageDialog(null, "图书名称不能为空!");
				return;
			}
			if(StringUtil.isEmpty(author)) {
				JOptionPane.showMessageDialog(null, "图书作者不能为空!");
				return;
			}
			if(StringUtil.isEmpty(price)) {
				JOptionPane.showMessageDialog(null, "图书价格不能为空!");
				return;
			}
			
			Book book=new Book(bookid,bookisbn,bookname,author,price,null,null,null);
			Connection con = null;
			try {
				con=dbUtil.getCon();
				int temp = bookUtil.AddBook(con, book);
				if(temp==1) {
					JOptionPane.showMessageDialog(null, "入库成功!");
				}else {
					JOptionPane.showMessageDialog(null, "入库失败!");
				}
				dbUtil.closeCon(con);
			} catch (Exception e) {
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "本书以加入或加入数据有误\n请核对输入数据,重新输入");
			}
				
	}

		/**
		 * 重置事件处理
		 * @param etv
		 */
		private void resetValueActionPerformed(ActionEvent etv) {
			this.BookIDTxt.setText("");
			this.BookISBNTxt.setText("");
			this.AuthorTxt.setText("");
			this.BookNameTxt.setText("");
			this.BookPriceTxt.setText("");
			
		}
}
