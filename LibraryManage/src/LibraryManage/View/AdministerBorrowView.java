package LibraryManage.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
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

public class AdministerBorrowView extends JFrame {

	private JPanel contentPane;
	private JTextField BookIDTxt;
	private JTable BorrowTable;
	private JTextField BookNameTxt;
	private JTextField UserID;
	private DbUtil dbUtil =new DbUtil();
	private BookUtil bookUtil=new BookUtil();
	private JTextField ReadIDTxt;
	
	/**
	 * Launch the application.
	 * 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministerBorrowView frame = new AdministerBorrowView();
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
	public AdministerBorrowView() {
		setTitle("\u501F \u4E66  \u7BA1  \u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u53F7\uFF1A");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(55, 28, 147, 40);
		contentPane.add(label);
		
		BookIDTxt = new JTextField();
		BookIDTxt.setBounds(212, 40, 118, 21);
		contentPane.add(BookIDTxt);
		BookIDTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		/**
		 * 查询读者借书信息表
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectBookActionPerformed(e);
			}
		});
		button.setFont(new Font("楷体", Font.BOLD, 18));
		button.setBounds(375, 302, 77, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9009\u62E9");
		/**
		 * 借书选择按钮事件处理
		 */
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddActionPerformed(e);
				
			}
		});
		button_1.setFont(new Font("楷体", Font.BOLD, 18));
		button_1.setBounds(250, 183, 97, 23);
		contentPane.add(button_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 346, 555, 161);
		contentPane.add(scrollPane_1);
		
		BorrowTable = new JTable();
		BorrowTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6D41\u6C34\u7F16\u53F7", "\u8BFB\u8005\u7F16\u53F7", "\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u501F\u4E66\u65F6\u95F4", "\u8FD8\u4E66\u65F6\u95F4", "\u5907 \u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BorrowTable.getColumnModel().getColumn(0).setPreferredWidth(84);
		BorrowTable.getColumnModel().getColumn(1).setPreferredWidth(83);
		BorrowTable.getColumnModel().getColumn(2).setPreferredWidth(101);
		BorrowTable.getColumnModel().getColumn(3).setPreferredWidth(83);
		BorrowTable.getColumnModel().getColumn(4).setPreferredWidth(84);
		BorrowTable.getColumnModel().getColumn(5).setPreferredWidth(82);
		scrollPane_1.setViewportView(BorrowTable);
		
		JLabel label_1 = new JLabel("-------------\u8BFB \u8005 \u5728 \u501F \u56FE \u4E66 \u4FE1 \u606F---------------");
		label_1.setFont(new Font("楷体", Font.BOLD, 18));
		label_1.setBounds(55, 245, 507, 31);
		contentPane.add(label_1);
		
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
		button_2.setBounds(473, 302, 77, 23);
		contentPane.add(button_2);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_2.setFont(new Font("Dialog", Font.BOLD, 18));
		label_2.setBounds(55, 116, 108, 31);
		contentPane.add(label_2);
		
		BookNameTxt = new JTextField();
		BookNameTxt.setColumns(10);
		BookNameTxt.setBounds(156, 123, 174, 21);
		contentPane.add(BookNameTxt);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(BorrowView.class.getResource("/image/resizeApi.png")));
		label_5.setBounds(418, 40, 174, 161);
		contentPane.add(label_5);
		
		UserID = new JTextField();
		UserID.setColumns(10);
		UserID.setBounds(156, 85, 174, 21);
		contentPane.add(UserID);
		
		JLabel label_6 = new JLabel("\u8BFB\u8005\u8D26\u53F7\uFF1A");
		label_6.setFont(new Font("Dialog", Font.BOLD, 18));
		label_6.setBounds(55, 78, 108, 31);
		contentPane.add(label_6);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		/**
		 * 重置按钮事件处理
		 */
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_3.setFont(new Font("楷体", Font.BOLD, 18));
		button_3.setBounds(66, 183, 97, 23);
		contentPane.add(button_3);
		
		ReadIDTxt = new JTextField();
		ReadIDTxt.setColumns(10);
		ReadIDTxt.setBounds(156, 304, 191, 21);
		contentPane.add(ReadIDTxt);
		
		JLabel label_3 = new JLabel("  \u8D26  \u53F7\uFF1A");
		label_3.setFont(new Font("Dialog", Font.BOLD, 18));
		label_3.setBounds(55, 297, 108, 31);
		contentPane.add(label_3);
	}

	/**
	 * 初始化表格
	 * 
	 * @param reader
	 */
	
		private void BorrowFilled(BorrowAndReturn borrow) {
			DefaultTableModel dtm =  (DefaultTableModel) BorrowTable.getModel();
			dtm.setRowCount(0);
			Connection con =null;
			try {
				
				con=dbUtil.getCon();
				ResultSet rs=bookUtil.BorrowBooklist(con, borrow.getReaderID());
				while(rs.next()) {
					Vector v = new Vector();
					v.add(rs.getString("id"));
					v.add(rs.getString("readerID"));
					v.add(rs.getString("bookID"));
					v.add(rs.getString("bookName"));
					v.add(rs.getString("borrrowdate"));
					v.add(rs.getString("returndate"));
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
	

	
	
	/**
	 *查询借书单信息事件处理
	 * @param etv
	 */
	private  void SelectBookActionPerformed(ActionEvent etv) {
		String readerID = this.ReadIDTxt.getText();
		BorrowAndReturn borrow =new BorrowAndReturn();
		borrow.setReaderID(readerID);
		this.BorrowFilled(borrow);
	}
	
/**
 * 借书事件处理
 * @param etv
 */

	private  void AddActionPerformed(ActionEvent etv) {
		String bookid=this.BookIDTxt.getText();
		String userid=this.UserID.getText();
		String bookName=this.BookNameTxt.getText();
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs =bookUtil.LookBookState(con, bookid, bookName);
			String bookstate = "";
			if(rs.next()) {
				bookstate=rs.getString("bookState");
			}
			if(bookstate.equals("1")) {
				int temp1 = bookUtil.BorrowBook(con, bookid,userid,bookName);
				int temp2 = bookUtil.BorrowUpdateBookState(con, bookid, bookName);
				if(temp1==1&&temp2==1)
				{
					JOptionPane.showMessageDialog(null, "借书成功!");
				}else {
					JOptionPane.showConfirmDialog(null, "借书失败！");
				}
				dbUtil.closeCon(con);
			}else {
				JOptionPane.showMessageDialog(null, "请输入正确的图书信息或\n请重新选择一本图书，此图书已被借阅");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "操作错误，请重新输入");
		}
		
	}


	private void resetValueActionPerformed(ActionEvent etv) {
		
		this.BookIDTxt.setText("");
		this.UserID.setText("");
		this.BookNameTxt.setText("");
		
		
	}
}

