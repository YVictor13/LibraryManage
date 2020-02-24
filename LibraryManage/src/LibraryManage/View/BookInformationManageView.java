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

import LibraryManage.Model.Administer;
import LibraryManage.Model.Book;
import LibraryManageUtil.BookUtil;
import LibraryManageUtil.DbUtil;
import LibraryManageUtil.StringUtil;

public class BookInformationManageView extends JFrame {

	private JPanel contentPane;
	private JTextField BookNameTxt;
	private JTable BookInformationTable;
	private DbUtil dbUtil=new DbUtil();
	private BookUtil bookUtil=new BookUtil();
	/**
	 * Launch the application.
	 * 	
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInformationManageView frame = new BookInformationManageView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookInformationManageView() {
		setTitle("\u8BFB  \u8005");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u56FE \u4E66 \u540D \u79F0\uFF1A");
		label.setFont(new Font("楷体", Font.BOLD, 18));
		label.setBounds(43, 140, 147, 33);
		contentPane.add(label);
		
		BookNameTxt = new JTextField();
		BookNameTxt.setBounds(200, 147, 169, 21);
		contentPane.add(BookNameTxt);
		BookNameTxt.setColumns(10);
		
		JButton SelectButton = new JButton("\u67E5\u8BE2");
		/**
		 * 查询按钮事件处理
		 */
		SelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSelectActionPerformed(e);
			}
		});
		SelectButton.setFont(new Font("楷体", Font.BOLD, 18));
		SelectButton.setBounds(390, 145, 97, 23);
		contentPane.add(SelectButton);
		
		JButton BorrowButton = new JButton("\u501F\u4E66");
		/**
		 * 返回事件处理
		 */
		BorrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BorrowView().setVisible(true);
			}
		});
		BorrowButton.setFont(new Font("楷体", Font.BOLD, 18));
		BorrowButton.setBounds(497, 145, 97, 23);
		contentPane.add(BorrowButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 228, 631, 226);
		contentPane.add(scrollPane);
		
		BookInformationTable = new JTable();
		BookInformationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u5206\u7C7B\u76EE\u5F55\u53F7", "ISBN\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u6570\u91CF", "\u5269\u4F59\u6570\u91CF", "\u5907\u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BookInformationTable.getColumnModel().getColumn(0).setPreferredWidth(112);
		BookInformationTable.getColumnModel().getColumn(1).setPreferredWidth(77);
		BookInformationTable.getColumnModel().getColumn(2).setPreferredWidth(82);
		BookInformationTable.getColumnModel().getColumn(3).setPreferredWidth(74);
		BookInformationTable.getColumnModel().getColumn(4).setPreferredWidth(74);
		BookInformationTable.getColumnModel().getColumn(5).setPreferredWidth(76);
		BookInformationTable.getColumnModel().getColumn(6).setPreferredWidth(73);
		BookInformationTable.getColumnModel().getColumn(7).setPreferredWidth(107);
		scrollPane.setViewportView(BookInformationTable);
		
		JLabel label_1 = new JLabel("\u4F60\u67E5\u5BFB\u7684\u662F\u4E66\uFF0C\u51FA\u6765\u7684\u5374\u662F\u77E5\u8BC6");
		label_1.setFont(new Font("华文行楷", Font.BOLD, 20));
		label_1.setBounds(72, 30, 297, 40);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("- - - - -\u897F\u7535\u56FE\u4E66");
		label_2.setFont(new Font("华文隶书", Font.BOLD, 18));
		label_2.setBounds(354, 74, 147, 33);
		contentPane.add(label_2);
		
		
	}
	
	/**
	 * 初始化表格
	 * 
	 * @param reader
	 */
	
		private void BookInformationfillTable(Book book) {
			DefaultTableModel dtm =  (DefaultTableModel) BookInformationTable.getModel();
			dtm.setRowCount(0);
			Connection con =null;
			try {
				
				con=dbUtil.getCon();
				ResultSet rs=bookUtil.Booklist(con, book);
				int temp=0;
				String isDelete="";
				ResultSet ls=bookUtil.DeleteBookState(con,book.getBookID());
				if(ls.next()) {
					isDelete=ls.getString("IsDelete");
				}
				
				if(isDelete.equals("0")) {
					JOptionPane.showMessageDialog(null, "此书已被删除");
					return ;
				}
				
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

		String bookname=this.BookNameTxt.getText();
		

		if(StringUtil.isEmpty(bookname)) {
			JOptionPane.showMessageDialog(null, "查询时，书名不能为空！！！");
			return;
		}
		Book book=new Book();
		book.setBookName(bookname);
		this.BookInformationfillTable(book);
		
	}
}
