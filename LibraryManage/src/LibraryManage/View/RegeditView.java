package LibraryManage.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import LibraryManage.Model.Administer;
import LibraryManage.Model.ReadUser;
import LibraryManageUtil.DbUtil;
import LibraryManageUtil.Regedit;
import LibraryManageUtil.StringUtil;

public class RegeditView extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameTxt;
	private JTextField DepartmentTXT;
	private JTextField AddressTxt;
	private JTextField PhoneTxt;
	private JTextField PasswordTxt_1;
	private JTextField PasswordTxt_2;
	private JRadioButton ReaderRadioButton;
	private JRadioButton AdministerRadioButton;
	private DbUtil dbUtil = new DbUtil();
	private Regedit regedit =new Regedit();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 * 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegeditView frame = new RegeditView();
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
	public RegeditView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegeditView.class.getResource("/image/resizeApi (2).png")));
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u897F\u7535\u56FE\u4E66\u9986");
		label.setFont(new Font("华文行楷", Font.BOLD, 24));
		label.setBounds(207, 79, 124, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6709\u4F60\u6240\u6709\uFF0C\u6709\u4F60\u6CA1\u6709");
		label_1.setFont(new Font("华文行楷", Font.BOLD, 20));
		label_1.setBounds(167, 120, 225, 35);
		contentPane.add(label_1);
		
		UserNameTxt = new JTextField();
		UserNameTxt.setBounds(173, 187, 189, 21);
		contentPane.add(UserNameTxt);
		UserNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7528 \u6237 \u540D");
		label_2.setFont(new Font("宋体", Font.BOLD, 18));
		label_2.setBounds(83, 187, 74, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8D26\u6237\u7C7B\u578B");
		label_3.setFont(new Font("宋体", Font.BOLD, 18));
		label_3.setBounds(83, 225, 74, 31);
		contentPane.add(label_3);
		
		ReaderRadioButton = new JRadioButton("\u8BFB\u8005");
		buttonGroup.add(ReaderRadioButton);
		ReaderRadioButton.setSelected(true);
		ReaderRadioButton.setFont(new Font("宋体", Font.BOLD, 18));
		ReaderRadioButton.setBounds(171, 229, 127, 23);
		contentPane.add(ReaderRadioButton);
		
		AdministerRadioButton = new JRadioButton("\u7CFB\u7EDF\u7BA1\u7406\u5458");
		buttonGroup.add(AdministerRadioButton);
		AdministerRadioButton.setFont(new Font("宋体", Font.BOLD, 18));
		AdministerRadioButton.setBounds(308, 229, 127, 23);
		contentPane.add(AdministerRadioButton);
		
		JLabel label_4 = new JLabel("\u5BC6   \u7801");
		label_4.setFont(new Font("宋体", Font.BOLD, 18));
		label_4.setBounds(83, 421, 74, 31);
		contentPane.add(label_4);
		
		DepartmentTXT = new JTextField();
		DepartmentTXT.setBounds(173, 284, 189, 21);
		contentPane.add(DepartmentTXT);
		DepartmentTXT.setColumns(10);
		
		JLabel label_5 = new JLabel("\u786E\u5B9A\u5BC6\u7801");
		label_5.setFont(new Font("宋体", Font.BOLD, 18));
		label_5.setBounds(83, 462, 74, 34);
		contentPane.add(label_5);
		
		AddressTxt = new JTextField();
		AddressTxt.setBounds(173, 332, 189, 21);
		contentPane.add(AddressTxt);
		AddressTxt.setColumns(10);
		
		JButton ExitButton = new JButton("\u9000\u51FA");
		/**
		 * 退出事件处理
		 */
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LogOnView().setVisible(true);
			}
		});
		ExitButton.setFont(new Font("宋体", Font.BOLD, 18));
		ExitButton.setBounds(47, 545, 97, 23);
		contentPane.add(ExitButton);
		
		JButton EnsureButton = new JButton("\u786E\u5B9A");
		/**
		 * 注册事件处理
		 */
		EnsureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnsureActionPerformed(e);
			}
		});
		EnsureButton.setFont(new Font("宋体", Font.BOLD, 18));
		EnsureButton.setBounds(306, 545, 97, 23);
		contentPane.add(EnsureButton);
		
		JLabel label_6 = new JLabel("\u5355   \u4F4D");
		label_6.setFont(new Font("宋体", Font.BOLD, 18));
		label_6.setBounds(83, 278, 74, 31);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u5730   \u5740");
		label_7.setFont(new Font("宋体", Font.BOLD, 18));
		label_7.setBounds(83, 331, 74, 21);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		label_8.setFont(new Font("宋体", Font.BOLD, 18));
		label_8.setBounds(83, 370, 74, 27);
		contentPane.add(label_8);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setColumns(10);
		PhoneTxt.setBounds(173, 374, 189, 21);
		contentPane.add(PhoneTxt);
		
		PasswordTxt_1 = new JTextField();
		PasswordTxt_1.setColumns(10);
		PasswordTxt_1.setBounds(173, 427, 189, 21);
		contentPane.add(PasswordTxt_1);
		
		PasswordTxt_2 = new JTextField();
		PasswordTxt_2.setColumns(10);
		PasswordTxt_2.setBounds(173, 470, 189, 21);
		contentPane.add(PasswordTxt_2);
	}

	private void EnsureActionPerformed(ActionEvent etv) {
		String username = this.UserNameTxt.getText();
		String department=this.DepartmentTXT.getText();
		String address = this.AddressTxt.getText();
		String phone =this.PhoneTxt.getText();
		String password1 = this.PasswordTxt_1.getText();
		String password2 = this.PasswordTxt_2.getText();
		
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！"); 
			return ;
		}
		if(StringUtil.isEmpty(department)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return ;
		}
		
		if(StringUtil.isEmpty(address)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！"); 
			return ;
		}
		if(StringUtil.isEmpty(phone)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return ;
		}
		
		if(!password1.equals(password2)) {
			JOptionPane.showMessageDialog(null, "两次密码输入不一致\n请重新输入"); 
			return ;
		}
		if(AdministerRadioButton.isSelected()) {
			Administer administer = new Administer(null,username,password1,department, address, phone);
			Connection con = null;
			try {
				con=dbUtil.getCon();
				int currentUser = regedit.regeditAdminister(con, administer);
				String sql="select administerID from administer where userName=? and password=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password1);
				ResultSet rs=pstmt.executeQuery();
				JLabel Output = new JLabel();
				String id = " ";
				if(rs.next()) {
					id = rs.getString("administerID");
				}
				
				if(currentUser==1)
				{
					//加入成功显示操作
					JOptionPane.showMessageDialog(null, "注册成功\n账号： "+id+"\n密码："+password1);
				}else {
					JOptionPane.showConfirmDialog(null, "注册失败！");
				}
				dbUtil.closeCon(con);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "用户名太受欢迎了\n请重新输入");
				e.printStackTrace();
			}
			
		}else if(ReaderRadioButton.isSelected()) {
			System.out.println("选择读者");
			ReadUser reader = new ReadUser(null,username,password1,department, address, phone);
			Connection con = null;
			try {
				con=dbUtil.getCon();
				int currentUser = regedit.regeditReader(con, reader);
				String sql="select readID from reader where userName=? and password=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password1);
				ResultSet rs=pstmt.executeQuery();
				JLabel Output = new JLabel();
				String id = " ";
				if(rs.next()) {
					id = rs.getString("readID");
				}
				
				if(currentUser==1)
				{
					//加入成功显示操作
					JOptionPane.showMessageDialog(null, "注册成功\n账号： "+id+"\n密码："+password1);
				}else {
					JOptionPane.showConfirmDialog(null, "注册失败！");
				}
				dbUtil.closeCon(con);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "用户名太受欢迎了\n请重新输入");
				e.printStackTrace();
			}
			
		}
		
		
	}
}
