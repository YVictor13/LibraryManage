package LibraryManage.View;

import java.awt.EventQueue;
import java.awt.Font;
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

public class CancallationBookView extends JFrame {

	private JPanel contentPane;
	private JTextField BookISBNTxt;
	private JTable DeleteTable;
	private JTextField BookIDTxt;
	private JTextField BookNameTxt;
	private DbUtil dbUtil =new DbUtil();
	private BookUtil bookUtil=new BookUtil();
	
	/**
	 * Launch the application.
	 * 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancallationBookView frame = new CancallationBookView();
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
	public CancallationBookView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u53F7");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(83, 104, 129, 26);
		contentPane.add(label);
		
		BookISBNTxt = new JTextField();
		BookISBNTxt.setBounds(224, 154, 218, 21);
		contentPane.add(BookISBNTxt);
		BookISBNTxt.setColumns(10);
		
		JButton button = new JButton("\u91CD\u7F6E");
		/**
		 * 重置事件处理
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button.setFont(new Font("楷体", Font.BOLD, 18));
		button.setBounds(88, 264, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5220\u9664");
		/**
		 * 图书删除事件处理
		 */
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletcBookActionPerformed(e);
			}
		});
		button_1.setFont(new Font("楷体", Font.BOLD, 18));
		button_1.setBounds(343, 264, 97, 23);
		contentPane.add(button_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 391, 597, 144);
		contentPane.add(scrollPane_1);
		
		DeleteTable = new JTable();
		DeleteTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u53F7", "\u56FE\u4E66ISBN\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u56FE\u4E66\u4EF7\u683C", "\u5165\u9986\u65F6\u95F4", "\u6CE8\u9500\u65F6\u95F4", "\u5907\u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		DeleteTable.getColumnModel().getColumn(0).setPreferredWidth(110);
		DeleteTable.getColumnModel().getColumn(2).setPreferredWidth(63);
		DeleteTable.getColumnModel().getColumn(3).setPreferredWidth(62);
		DeleteTable.getColumnModel().getColumn(4).setPreferredWidth(62);
		DeleteTable.getColumnModel().getColumn(5).setPreferredWidth(81);
		DeleteTable.getColumnModel().getColumn(6).setPreferredWidth(85);
		scrollPane_1.setViewportView(DeleteTable);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		/**
		 * 返回事件处理
		 */
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdministerView().setVisible(true);
			}
		});
		button_2.setFont(new Font("楷体", Font.BOLD, 18));
		button_2.setBounds(115, 565, 97, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u66F4\u65B0");
		/**
		 * 查询删除数据信息
		 */
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecDeleteBookActionPerformed(e);
			}
		});
		button_3.setFont(new Font("楷体", Font.BOLD, 18));
		button_3.setBounds(392, 565, 97, 23);
		contentPane.add(button_3);
		
		JLabel label_1 = new JLabel("  -----------------\u56FE \u4E66 \u6CE8 \u9500 \u5355------------------");
		label_1.setFont(new Font("宋体", Font.BOLD, 18));
		label_1.setBounds(56, 344, 513, 26);
		contentPane.add(label_1);
		
		JLabel lblIsbn = new JLabel("\u56FE   \u4E66  ISBN \u53F7");
		lblIsbn.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIsbn.setBounds(83, 149, 139, 26);
		contentPane.add(lblIsbn);
		
		BookIDTxt = new JTextField();
		BookIDTxt.setColumns(10);
		BookIDTxt.setBounds(224, 109, 218, 21);
		contentPane.add(BookIDTxt);
		
		JLabel label_2 = new JLabel(" \u56FE   \u4E66   \u540D   \u79F0");
		label_2.setFont(new Font("Dialog", Font.BOLD, 18));
		label_2.setBounds(83, 194, 129, 26);
		contentPane.add(label_2);
		
		BookNameTxt = new JTextField();
		BookNameTxt.setColumns(10);
		BookNameTxt.setBounds(224, 199, 218, 21);
		contentPane.add(BookNameTxt);
	}
	
	/**
	 * 初始化表格
	 * 
	 * @param reader
	 */
	
		private void AddBookFilled(Book book) {
			DefaultTableModel dtm =  (DefaultTableModel) DeleteTable.getModel();
			dtm.setRowCount(0);
			Connection con =null;
			try {
				
				con=dbUtil.getCon();
				ResultSet rs=bookUtil.SelectDeleteBooklist(con, book.getOutputDate());
				while(rs.next()) {
					Vector v = new Vector();
					v.add(rs.getString("bookID"));
					v.add(rs.getString("ISBNNumber"));
					v.add(rs.getString("bookName"));
					v.add(rs.getString("author"));
					v.add(rs.getString("price"));
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
		
	
		
	
	
	private void SelecDeleteBookActionPerformed(ActionEvent etv) {
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String outputdate = df.format(day);
		Book book=new Book();
		book.setOutputDate(outputdate);
		this.AddBookFilled(book);
		
	}

	
	/**
	 * 
	 * 图书注册事件处理
	 * @param etv
	 */
	
	private void DeletcBookActionPerformed(ActionEvent etv) {

		String bookid=this.BookIDTxt.getText();
		String bookisbn=this.BookISBNTxt.getText();
		String bookname=this.BookNameTxt.getText();
		Book book =new Book();
		book.setBookID(bookid);
		book.setBookName(bookname);
		book.setISBNNumber(bookisbn);
		
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
		
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs =bookUtil.DeleteBookState(con, book.getBookID());
			String temp = "";
			if(rs.next()) {
				temp=rs.getString("IsDelete");
			}
			if(temp.equals("0")) {
				JOptionPane.showMessageDialog(null, "此图书已注销，请重新选择!");
			}else {
				int temp1 = bookUtil.DeleteBooklist(con, book);
				if(temp1==1) {
					JOptionPane.showMessageDialog(null, "注销成功!");
				}else {
					JOptionPane.showMessageDialog(null, "注销失败!");
				}
			}
			dbUtil.closeCon(con);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "本书已注销或输入数据有误\n请核对输入数据,重新输入");
		}
			
		
		
	}

	/**
	 * 重置事件处理
	 * @param etv
	 */
	private void resetValueActionPerformed(ActionEvent etv) {
		this.BookIDTxt.setText("");
		this.BookISBNTxt.setText("");
		this.BookNameTxt.setText("");
		
	}

}
