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
import LibraryManage.Model.ReadUser;
import LibraryManageUtil.DbUtil;
import LibraryManageUtil.StringUtil;
import LibraryManageUtil.UserUtil;

public class AdminsterInformanageView extends JFrame {

	private JPanel contentPane;
	private JTextField AdministerID;
	private JTable AdministerTable;
	private JTextField PasswordTxt;
	private JTextField DepartmentTxt;
	private JTextField AddressTxt;
	private JTextField PhoneTxt;
	private UserUtil userUtil = new UserUtil();
	private DbUtil dbUtil = new DbUtil();
	/**
	 * Launch the application.
	 * 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminsterInformanageView frame = new AdminsterInformanageView();
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
	public AdminsterInformanageView() {
		setResizable(false);
		setTitle("\u7CFB\u7EDF\u7BA1\u7406\u5458\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 103, 607, 122);
		contentPane.add(scrollPane);
		
		AdministerTable = new JTable();
		AdministerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u5BC6\u7801", "\u5355\u4F4D", "\u5730\u5740", "\u8054\u7CFB\u65B9\u5F0F", "\u5907  \u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		AdministerTable.getColumnModel().getColumn(0).setPreferredWidth(79);
		AdministerTable.getColumnModel().getColumn(1).setPreferredWidth(79);
		AdministerTable.getColumnModel().getColumn(2).setPreferredWidth(82);
		scrollPane.setViewportView(AdministerTable);
		
		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 18));
		label.setBounds(83, 50, 58, 22);
		contentPane.add(label);
		
		AdministerID = new JTextField();
		AdministerID.setColumns(10);
		AdministerID.setBounds(165, 52, 279, 21);
		contentPane.add(AdministerID);
		
		JButton SelectButton = new JButton("\u67E5\u8BE2");
		/**
		 * 查询按钮事件处理
		 */
		SelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectActonPerformed(e);
			}
		});
		SelectButton.setFont(new Font("楷体", Font.BOLD, 18));
		SelectButton.setBounds(474, 50, 97, 23);
		contentPane.add(SelectButton);
		
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
		button_1.setBounds(83, 606, 97, 23);
		contentPane.add(button_1);
		
		JLabel label_1 = new JLabel("     ---------------------\u4FEE  \u6539  \u5185  \u5BB9--------------------");
		label_1.setFont(new Font("宋体", Font.BOLD, 18));
		label_1.setBounds(37, 251, 592, 29);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel(" \u5BC6   \u7801\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 18));
		label_3.setBounds(98, 357, 126, 22);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel(" \u5355   \u4F4D\uFF1A");
		label_4.setFont(new Font("宋体", Font.BOLD, 18));
		label_4.setBounds(98, 412, 126, 22);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(" \u5730   \u5740\uFF1A");
		label_5.setFont(new Font("宋体", Font.BOLD, 18));
		label_5.setBounds(98, 466, 126, 22);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u8054 \u7CFB \u65B9 \u5F0F\uFF1A");
		label_6.setFont(new Font("宋体", Font.BOLD, 18));
		label_6.setBounds(98, 526, 126, 22);
		contentPane.add(label_6);
		
		PasswordTxt = new JTextField();
		PasswordTxt.setColumns(10);
		PasswordTxt.setBounds(240, 359, 246, 21);
		contentPane.add(PasswordTxt);
		
		DepartmentTxt = new JTextField();
		DepartmentTxt.setColumns(10);
		DepartmentTxt.setBounds(240, 414, 246, 21);
		contentPane.add(DepartmentTxt);
		
		AddressTxt = new JTextField();
		AddressTxt.setColumns(10);
		AddressTxt.setBounds(240, 468, 246, 21);
		contentPane.add(AddressTxt);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setColumns(10);
		PhoneTxt.setBounds(240, 528, 246, 21);
		contentPane.add(PhoneTxt);
		
		JButton UpdateButton = new JButton("\u4FEE\u6539");
		/**
		 * 系统管理员信息更改操作按钮事件处理
		 */
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtlerActionPerformed(e);
			}
		});
		UpdateButton.setFont(new Font("宋体", Font.BOLD, 18));
		UpdateButton.setBounds(416, 607, 97, 23);
		contentPane.add(UpdateButton);
		
	}
	
	private void AtlerActionPerformed(ActionEvent etv) {
		String administerID=this.AdministerID.getText();
		String administerpassword=this.PasswordTxt.getText();
		String administerdepartment=this.DepartmentTxt.getText();
		String administeraddress=this.AddressTxt.getText();
		String administerphone=this.PhoneTxt.getText();

		if(StringUtil.isEmpty(administerID)) {
			JOptionPane.showMessageDialog(null, "修改时，账号不能为空！！！");
			return;
		}
		if(!StringUtil.isNotEmpty(administerpassword)&&!StringUtil.isNotEmpty(administerdepartment)&&!StringUtil.isNotEmpty(administeraddress)&&!StringUtil.isNotEmpty(administerphone)) {
			
			Administer administer=new Administer(administerID,null,administerpassword,administerdepartment,administeraddress,administerphone);
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int n=userUtil.AdministerInformanationUpdate(con, administer);
				if(n==1){
					JOptionPane.showMessageDialog(null, "信息修改成功！");
				}else{
					JOptionPane.showMessageDialog(null, "信息修改失败！");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "信息修改失败！");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(!StringUtil.isNotEmpty(administerpassword)&&StringUtil.isNotEmpty(administerdepartment)&&StringUtil.isNotEmpty(administeraddress)&&StringUtil.isNotEmpty(administerphone) ) {
			Administer reader=new Administer(administerID,null,administerpassword,null,null,null);
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int n=userUtil.AdministerPasswordUpdate(con, reader);
				if(n==1){
					JOptionPane.showMessageDialog(null, "信息修改成功！");
				}else{
					JOptionPane.showMessageDialog(null, "信息修改失败！");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "信息修改失败！");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(StringUtil.isNotEmpty(administerpassword)&&!StringUtil.isNotEmpty(administerdepartment)&&!StringUtil.isNotEmpty(administeraddress)&&!StringUtil.isNotEmpty(administerphone) ) {
			Administer reader=new Administer(administerID,null,null,administerdepartment,administeraddress,administerphone);
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int n=userUtil.AdministerDAPUpdate(con, reader);
				if(n==1){
					JOptionPane.showMessageDialog(null, "信息修改成功！");
				}else{
					JOptionPane.showMessageDialog(null, "信息修改失败！");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "信息修改失败！");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(StringUtil.isNotEmpty(administerpassword)&&!StringUtil.isNotEmpty(administerdepartment)&&StringUtil.isNotEmpty(administeraddress)&&StringUtil.isNotEmpty(administerphone)) {
			Administer reader=new Administer(administerID,null,null,administerdepartment,null,null);
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int n=userUtil.AdministerDepartmentUpdate(con, reader);
				if(n==1){
					JOptionPane.showMessageDialog(null, "信息修改成功！");
				}else{
					JOptionPane.showMessageDialog(null, "信息修改失败！");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "信息修改失败！");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(StringUtil.isNotEmpty(administerpassword)&&StringUtil.isNotEmpty(administerdepartment)&&!StringUtil.isNotEmpty(administeraddress)&&StringUtil.isNotEmpty(administerphone)) {
			Administer reader=new Administer(administerID,null,null,null,administeraddress,null);
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int n=userUtil.AdministerAddressUpdate(con, reader);
				if(n==1){
					JOptionPane.showMessageDialog(null, "信息修改成功！");
				}else{
					JOptionPane.showMessageDialog(null, "信息修改失败！");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "信息修改失败！");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(StringUtil.isNotEmpty(administerpassword)&&StringUtil.isNotEmpty(administerdepartment)&&StringUtil.isNotEmpty(administeraddress)&&!StringUtil.isNotEmpty(administerphone)) {
			Administer reader=new Administer(administerID,null,null,null,null,administerphone);
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int n=userUtil.AdministerPhoneUpdate(con, reader);
				if(n==1){
					JOptionPane.showMessageDialog(null, "信息修改成功！");
				}else{
					JOptionPane.showMessageDialog(null, "信息修改失败！");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "信息修改失败！");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(StringUtil.isNotEmpty(administerpassword)&&StringUtil.isNotEmpty(administerdepartment)&&!StringUtil.isNotEmpty(administeraddress)&&!StringUtil.isNotEmpty(administerphone)) {
			Administer reader=new Administer(administerID,null,null,null,administeraddress,administerphone);
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int n=userUtil.AdministerAPUpdate(con, reader);
				if(n==1){
					JOptionPane.showMessageDialog(null, "信息修改成功！");
				}else{
					JOptionPane.showMessageDialog(null, "信息修改失败！");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "信息修改失败！");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(StringUtil.isNotEmpty(administerpassword)&&!StringUtil.isNotEmpty(administerdepartment)&&StringUtil.isNotEmpty(administeraddress)&&!StringUtil.isNotEmpty(administerphone)) {
			Administer reader=new Administer(administerID,null,null,administerdepartment,null,administerphone);
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int n=userUtil.AdministerDPUpdate(con, reader);
				if(n==1){
					JOptionPane.showMessageDialog(null, "信息修改成功！");
				}else{
					JOptionPane.showMessageDialog(null, "信息修改失败！");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "信息修改失败！");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "信息修改失败！");
		}
		
				
		
		
	}

	/**
	 * 初始化表格
	 * 
	 * @param reader
	 */
	
		private void AdministerfillTable(Administer administer) {
			DefaultTableModel dtm =  (DefaultTableModel) AdministerTable.getModel();
			dtm.setRowCount(0);
			Connection con =null;
			try {
				
				con=dbUtil.getCon();
				ResultSet rs=userUtil.administerlist(con, administer);
				while(rs.next()) {
					Vector v = new Vector();
					v.add(rs.getString("administerID"));
					v.add(rs.getString("userName"));
					v.add(rs.getString("password"));
					v.add(rs.getString("department"));
					v.add(rs.getString("address"));
					v.add(rs.getString("phone"));
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
 * 系统管理员信息查询操作
 * @param etv
 */
	
	private void SelectActonPerformed(ActionEvent etv) {
		String administerID=this.AdministerID.getText();
		Administer administer=new Administer();
		administer.setID(administerID);
		this.AdministerfillTable(administer);
		
	}

}
