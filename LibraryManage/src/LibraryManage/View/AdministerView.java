package LibraryManage.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class AdministerView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministerView frame = new AdministerView();
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
	public AdministerView() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
		/**
		 * 读者信息管理事件处理
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminsterInformanageView().setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 18));
		button.setBounds(360, 77, 155, 46);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u56FE\u4E66\u4FE1\u606F\u67E5\u8BE2");
		/**
		 * 图书管理按键事件处理
		 */
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BookInformanageView().setVisible(true);
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 18));
		button_1.setBounds(360, 159, 155, 46);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u56FE\u4E66\u5165\u5E93");
		/**
		 * 图书添加按钮事件处理
		 */
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AddBookView().setVisible(true);
			}
		});
		button_2.setFont(new Font("宋体", Font.BOLD, 18));
		button_2.setBounds(360, 241, 155, 46);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u6CE8\u9500\u56FE\u4E66");
		/**
		 *注销按钮事件处理
		 */
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CancallationBookView().setVisible(true);
			}
		});
		button_3.setFont(new Font("宋体", Font.BOLD, 18));
		button_3.setBounds(360, 317, 155, 46);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u9000    \u51FA");
		/**
		 * 退出事件处理
		 */
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_4.setFont(new Font("宋体", Font.BOLD, 18));
		button_4.setBounds(360, 404, 155, 46);
		contentPane.add(button_4);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("华文行楷", Font.BOLD, 24));
		label_1.setIcon(new ImageIcon(AdministerView.class.getResource("/image/resizeApi.png")));
		label_1.setBounds(87, 77, 171, 163);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("\u897F\u7535\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("华文行楷", Font.BOLD, 24));
		label.setBounds(60, 322, 247, 32);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		label_2.setFont(new Font("华文行楷", Font.BOLD, 24));
		label_2.setBounds(109, 275, 116, 32);
		contentPane.add(label_2);
	}
}
