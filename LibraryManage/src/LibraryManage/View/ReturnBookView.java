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

import LibraryManage.Model.BorrowAndReturn;
import LibraryManageUtil.BookUtil;
import LibraryManageUtil.DbUtil;

public class ReturnBookView extends JFrame {

	private JPanel contentPane;
	private JTextField BookIDTxt;
	private JTable ReturnBookTable;
	private JTextField BookNameTxt;
	private JTextField UserTxt;
	private JTextField ReaderTxt;
	private DbUtil dbUtil=new DbUtil();
	private BookUtil bookUtil = new BookUtil();
	/**
	 * Launch the application.
	 * 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBookView frame = new ReturnBookView();
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
	public ReturnBookView() {
		setResizable(false);
		setTitle("\u5F52 \u8FD8 \u56FE \u4E66");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u53F7\uFF1A");
		label.setFont(new Font("楷体", Font.BOLD, 18));
		label.setBounds(48, 87, 155, 32);
		contentPane.add(label);
		
		BookIDTxt = new JTextField();
		BookIDTxt.setBounds(198, 94, 234, 21);
		contentPane.add(BookIDTxt);
		BookIDTxt.setColumns(10);
		
		JButton button = new JButton("\u5F52\u8FD8");
		/**
		 * 归还按钮事件处理
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnActionPerformed(e);
			}
		});
		button.setFont(new Font("楷体", Font.BOLD, 18));
		button.setBounds(393, 239, 86, 21);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 385, 509, 156);
		contentPane.add(scrollPane);
		
		ReturnBookTable = new JTable();
		ReturnBookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6D41\u6C34\u7F16\u53F7", "\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u8BFB\u8005\u7F16\u53F7", "\u501F\u4E66\u65F6\u95F4", "\u8FD8\u4E66\u65F6\u95F4", "\u5907\u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ReturnBookTable.getColumnModel().getColumn(1).setPreferredWidth(121);
		ReturnBookTable.getColumnModel().getColumn(6).setPreferredWidth(109);
		scrollPane.setViewportView(ReturnBookTable);
		
		JButton button_1 = new JButton("\u67E5\u770B");
		/**
		 * 查询已还书信息
		 */
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnSelectionActionPerformed(e);
			}
		});
		button_1.setFont(new Font("楷体", Font.BOLD, 18));
		button_1.setBounds(375, 337, 86, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		/**
		 * 返回事件处理
		 */
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ReaderView().setVisible(true);
			}
		});
		button_2.setFont(new Font("楷体", Font.BOLD, 18));
		button_2.setBounds(471, 337, 86, 23);
		contentPane.add(button_2);
		
		JLabel label_1 = new JLabel("\u597D\u501F\u597D\u8FD8\uFF0C\u518D\u501F\u4E0D\u96BE");
		label_1.setFont(new Font("华文行楷", Font.BOLD, 23));
		label_1.setBounds(198, 10, 234, 32);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u56FE  \u4E66  \u540D  \u79F0\uFF1A");
		label_2.setFont(new Font("楷体", Font.BOLD, 18));
		label_2.setBounds(48, 129, 155, 32);
		contentPane.add(label_2);
		
		BookNameTxt = new JTextField();
		BookNameTxt.setColumns(10);
		BookNameTxt.setBounds(198, 136, 234, 21);
		contentPane.add(BookNameTxt);
		
		JLabel label_3 = new JLabel(" ---------------\u56FE \u4E66 \u5F52 \u8FD8 \u4FE1 \u606F---------------");
		label_3.setFont(new Font("宋体", Font.BOLD, 18));
		label_3.setBounds(66, 280, 473, 42);
		contentPane.add(label_3);
		
		UserTxt = new JTextField();
		UserTxt.setColumns(10);
		UserTxt.setBounds(145, 339, 209, 21);
		contentPane.add(UserTxt);
		
		JLabel label_4 = new JLabel("\u8BFB\u8005\u8D26\u53F7\uFF1A");
		label_4.setFont(new Font("楷体", Font.BOLD, 18));
		label_4.setBounds(52, 332, 107, 32);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u8BFB  \u8005  \u8D26  \u53F7\uFF1A");
		label_5.setFont(new Font("楷体", Font.BOLD, 18));
		label_5.setBounds(48, 171, 155, 32);
		contentPane.add(label_5);
		
		ReaderTxt = new JTextField();
		ReaderTxt.setColumns(10);
		ReaderTxt.setBounds(198, 178, 234, 21);
		contentPane.add(ReaderTxt);
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		/**
		 * 重置事件处理
		 */
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_3.setFont(new Font("楷体", Font.BOLD, 18));
		button_3.setBounds(106, 239, 86, 23);
		contentPane.add(button_3);
	}
	
	/**
	 * 初始化表格
	 * 
	 * @param reader
	 */
	
		private void BorrowFilled(BorrowAndReturn borrow) {
			DefaultTableModel dtm =  (DefaultTableModel) ReturnBookTable.getModel();
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
	 * 重置事件处理
	 * @param etv
	 */
	private void resetValueActionPerformed(ActionEvent etv) {
		this.BookIDTxt.setText("");
		this.ReaderTxt.setText("");
		this.BookNameTxt.setText("");
		
	}

	private void ReturnSelectionActionPerformed(ActionEvent etv) {
		String userid=this.UserTxt.getText();
		BorrowAndReturn borrow =new BorrowAndReturn();
		borrow.setReaderID(userid);
		this.BorrowFilled(borrow);
		
		
	}

	private void ReturnActionPerformed(ActionEvent etv) {
		
		String bookid =this.BookIDTxt.getText();
		String bookname=this.BookNameTxt.getText();
		String readerid=this.ReaderTxt.getText();
		
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs =bookUtil.LookBookState(con, bookid, bookname);
			String bookstate = "";
			if(rs.next()) {
				bookstate=rs.getString("bookState");
			}
			if(bookstate.equals("0")) {
				int temp1 = bookUtil.ReturnBook(con, bookid,readerid);
				if(temp1!=0)
				{
					int temp2=bookUtil.ReturnUpdateBookState(con, bookid);
					if(temp2!=0) {
						JOptionPane.showMessageDialog(null, "还书成功!");
					}
				}else {
					
					JOptionPane.showMessageDialog(null, "还书失败！");
				}
				dbUtil.closeCon(con);
			}else {
				JOptionPane.showMessageDialog(null, "请输入正确的图书信息或\n请重新选择一本图书，此图书已归还");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "操作错误，请重新输入");
		}
	
	
	}

}
