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

import LibraryManage.Model.ReadUser;
import LibraryManageUtil.DbUtil;
import LibraryManageUtil.StringUtil;
import LibraryManageUtil.UserUtil;

public class ReaderInformationView extends JFrame {

	private JPanel contentPane;
	private JTable ReaderTable;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField DepartmentTxt;
	private JTextField AddressTxt;
	private JTextField PhoneTxt;
	private JButton UpdateButton;
	private JLabel lblNewLabel;
	private JTextField PasswordTxt;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField ReaderIDTxt;
	private JLabel label_1;
	private UserUtil userUtil = new UserUtil();
	private DbUtil dbUtil = new DbUtil();
	/**
	 * Launch the application.
	 * 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderInformationView frame = new ReaderInformationView();
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
	public ReaderInformationView() {
		setResizable(false);
		setTitle("\u8BFB\u8005\u4FE1\u606F\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton SlelectButton = new JButton("\u67E5\u8BE2");
		/**
		 * 查询事件处理
		 */
		SlelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectActionPerformed(e);
			}
		});
		SlelectButton.setFont(new Font("楷体", Font.BOLD, 18));
		SlelectButton.setBounds(507, 131, 97, 23);
		contentPane.add(SlelectButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 180, 604, 83);
		contentPane.add(scrollPane);
		
		ReaderTable = new JTable();
		ReaderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFB\u8005\u7F16\u53F7", "\u8BFB\u8005\u59D3\u540D", "\u8BFB\u8005\u5BC6\u7801", "\u8BFB\u8005\u5355\u4F4D", "\u8BFB\u8005\u5730\u5740", "\u8054\u7CFB\u65B9\u5F0F", "\u5728\u501F\u56FE\u4E66\u6570\u91CF", "\u5907  \u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ReaderTable.getColumnModel().getColumn(0).setResizable(false);
		ReaderTable.getColumnModel().getColumn(0).setPreferredWidth(87);
		ReaderTable.getColumnModel().getColumn(1).setResizable(false);
		ReaderTable.getColumnModel().getColumn(1).setPreferredWidth(88);
		ReaderTable.getColumnModel().getColumn(3).setResizable(false);
		ReaderTable.getColumnModel().getColumn(3).setPreferredWidth(78);
		ReaderTable.getColumnModel().getColumn(4).setResizable(false);
		ReaderTable.getColumnModel().getColumn(4).setPreferredWidth(84);
		ReaderTable.getColumnModel().getColumn(5).setResizable(false);
		ReaderTable.getColumnModel().getColumn(5).setPreferredWidth(90);
		ReaderTable.getColumnModel().getColumn(6).setResizable(false);
		ReaderTable.getColumnModel().getColumn(6).setPreferredWidth(104);
		scrollPane.setViewportView(ReaderTable);
		
		JButton ReturnButton = new JButton("\u8FD4\u56DE");
		/**
		 * 返回事件处理
		 */
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ReaderView().setVisible(true);
			}
		});
		ReturnButton.setFont(new Font("楷体", Font.BOLD, 18));
		ReturnButton.setBounds(118, 562, 97, 23);
		contentPane.add(ReturnButton);
		
		label_2 = new JLabel("\u8BFB \u8005 \u5355 \u4F4D\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 18));
		label_2.setBounds(118, 392, 126, 22);
		contentPane.add(label_2);
		
		label_3 = new JLabel("\u8BFB \u8005 \u5730 \u5740\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 18));
		label_3.setBounds(118, 445, 126, 22);
		contentPane.add(label_3);
		
		label_4 = new JLabel("\u8054 \u7CFB \u65B9 \u5F0F\uFF1A");
		label_4.setFont(new Font("宋体", Font.BOLD, 18));
		label_4.setBounds(118, 492, 126, 22);
		contentPane.add(label_4);
		
		DepartmentTxt = new JTextField();
		DepartmentTxt.setColumns(10);
		DepartmentTxt.setBounds(254, 394, 246, 21);
		contentPane.add(DepartmentTxt);
		
		AddressTxt = new JTextField();
		AddressTxt.setColumns(10);
		AddressTxt.setBounds(254, 447, 246, 21);
		contentPane.add(AddressTxt);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setColumns(10);
		PhoneTxt.setBounds(254, 494, 246, 21);
		contentPane.add(PhoneTxt);
		
		UpdateButton = new JButton("\u4FEE\u6539");
		/**
		 * 修改操作按钮事件处理
		 */
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterActionPerformed(e);
			}
		});
		UpdateButton.setFont(new Font("宋体", Font.BOLD, 18));
		UpdateButton.setBounds(440, 562, 97, 23);
		contentPane.add(UpdateButton);
		
		lblNewLabel = new JLabel("     ---------------------\u4FEE  \u6539  \u5185  \u5BB9--------------------");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel.setBounds(41, 293, 592, 29);
		contentPane.add(lblNewLabel);
		
		PasswordTxt = new JTextField();
		PasswordTxt.setColumns(10);
		PasswordTxt.setBounds(254, 343, 246, 21);
		contentPane.add(PasswordTxt);
		
		label_5 = new JLabel("\u8BFB \u8005 \u5BC6 \u7801\uFF1A");
		label_5.setFont(new Font("宋体", Font.BOLD, 18));
		label_5.setBounds(118, 341, 126, 22);
		contentPane.add(label_5);
		
		label_6 = new JLabel("\u8D26  \u53F7\uFF1A");
		label_6.setFont(new Font("宋体", Font.BOLD, 18));
		label_6.setBounds(70, 131, 74, 22);
		contentPane.add(label_6);
		
		ReaderIDTxt = new JTextField();
		ReaderIDTxt.setColumns(10);
		ReaderIDTxt.setBounds(154, 133, 333, 21);
		contentPane.add(ReaderIDTxt);
		
		JLabel label = new JLabel("\u4E0D\u662F\u4F60\u4E0D\u592A\u597D\uFF0C\u800C\u662F\u56FE\u4E66\u592A\u8FC7\u4E8E\u8FF7\u4EBA");
		label.setFont(new Font("华文行楷", Font.BOLD, 24));
		label.setBounds(65, 10, 434, 54);
		contentPane.add(label);
		
		label_1 = new JLabel("- - - - \u897F\u7535\u56FE\u4E66");
		label_1.setFont(new Font("华文行楷", Font.BOLD, 18));
		label_1.setBounds(422, 60, 140, 29);
		contentPane.add(label_1);
		
	}
private void AlterActionPerformed(ActionEvent etv) {
	String readerID=this.ReaderIDTxt.getText();
	String readerpassword=this.PasswordTxt.getText();
	String readerdepartment=this.DepartmentTxt.getText();
	String readeraddress=this.AddressTxt.getText();
	String readerphone=this.PhoneTxt.getText();

	if(StringUtil.isEmpty(readerID)) {
		JOptionPane.showMessageDialog(null, "修改时，账号不能为空！！！");
		return;
	}
	if(!StringUtil.isNotEmpty(readerpassword)&&!StringUtil.isNotEmpty(readerdepartment)&&!StringUtil.isNotEmpty(readeraddress)&&!StringUtil.isNotEmpty(readerphone)) {
		
		ReadUser reader=new ReadUser(readerID,null,readerpassword,readerdepartment,readeraddress,readerphone);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=userUtil.ReaderInformanationUpdate(con, reader);
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
	}else if(!StringUtil.isNotEmpty(readerpassword)&&StringUtil.isNotEmpty(readerdepartment)&&StringUtil.isNotEmpty(readeraddress)&&StringUtil.isNotEmpty(readerphone) ) {
		ReadUser reader=new ReadUser(readerID,null,readerpassword,null,null,null);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=userUtil.ReaderPasswordUpdate(con, reader);
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
	}else if(StringUtil.isNotEmpty(readerpassword)&&!StringUtil.isNotEmpty(readerdepartment)&&!StringUtil.isNotEmpty(readeraddress)&&!StringUtil.isNotEmpty(readerphone) ) {
		ReadUser reader=new ReadUser(readerID,null,null,readerdepartment,readeraddress,readerphone);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=userUtil.ReaderDAPUpdate(con, reader);
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
	}else if(StringUtil.isNotEmpty(readerpassword)&&!StringUtil.isNotEmpty(readerdepartment)&&StringUtil.isNotEmpty(readeraddress)&&StringUtil.isNotEmpty(readerphone)) {
		ReadUser reader=new ReadUser(readerID,null,null,readerdepartment,null,null);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=userUtil.ReaderDepartmentUpdate(con, reader);
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
	}else if(StringUtil.isNotEmpty(readerpassword)&&StringUtil.isNotEmpty(readerdepartment)&&!StringUtil.isNotEmpty(readeraddress)&&StringUtil.isNotEmpty(readerphone)) {
		ReadUser reader=new ReadUser(readerID,null,null,null,readeraddress,null);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=userUtil.ReaderAddressUpdate(con, reader);
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
	}else if(StringUtil.isNotEmpty(readerpassword)&&StringUtil.isNotEmpty(readerdepartment)&&StringUtil.isNotEmpty(readeraddress)&&!StringUtil.isNotEmpty(readerphone)) {
		ReadUser reader=new ReadUser(readerID,null,null,null,null,readerphone);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=userUtil.ReaderPhoneUpdate(con, reader);
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
	}else if(StringUtil.isNotEmpty(readerpassword)&&StringUtil.isNotEmpty(readerdepartment)&&!StringUtil.isNotEmpty(readeraddress)&&!StringUtil.isNotEmpty(readerphone)) {
		ReadUser reader=new ReadUser(readerID,null,null,null,readeraddress,readerphone);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=userUtil.ReaderAPUpdate(con, reader);
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
	}else if(StringUtil.isNotEmpty(readerpassword)&&!StringUtil.isNotEmpty(readerdepartment)&&StringUtil.isNotEmpty(readeraddress)&&!StringUtil.isNotEmpty(readerphone)) {
		ReadUser reader=new ReadUser(readerID,null,null,readerdepartment,null,readerphone);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=userUtil.ReaderDPUpdate(con, reader);
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
	private void fillTable(ReadUser reader) {
		DefaultTableModel dtm =  (DefaultTableModel) ReaderTable.getModel();
		dtm.setRowCount(0);
		Connection con =null;
		try {
			
			con=dbUtil.getCon();
			ResultSet rs=userUtil.readlist(con, reader);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("readID"));
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
	 * 查询操作方法
	 * @param e
	 */
	private void SelectActionPerformed(ActionEvent e) {
		String readerID=this.ReaderIDTxt.getText();
		ReadUser reader=new ReadUser();
		reader.setReaderid(readerID);
		this.fillTable(reader);
	}
}
