package LibraryManage.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ReaderView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderView frame = new ReaderView();
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
	public ReaderView() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u4FE1\u606F\u7BA1\u7406");
		/**
		 * 信息管理事件处理
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ReaderInformationView().setVisible(true);
			}
		});
		
		button.setFont(new Font("宋体", Font.BOLD, 18));
		button.setBounds(370, 65, 155, 46);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u56FE\u4E66\u67E5\u8BE2");
		/**
		 * 图书信息查询事件处理
		 * 
		 */
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BookInformationManageView().setVisible(true);
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 18));
		button_1.setBounds(370, 142, 155, 46);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u501F   \u4E66");
		/**
		 * 借书事件处理
		 */
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BorrowView().setVisible(true);
			}
		});
		button_2.setFont(new Font("宋体", Font.BOLD, 18));
		button_2.setBounds(370, 219, 155, 46);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u8FD8    \u4E66");
		/**
		 * 还书按钮事件处理
		 */
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ReturnBookView().setVisible(true);
			}
		});
		button_3.setFont(new Font("宋体", Font.BOLD, 18));
		button_3.setBounds(370, 299, 155, 46);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u9000   \u51FA");
		/**
		 * 退出事件处理
		 */
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_4.setFont(new Font("宋体", Font.BOLD, 18));
		button_4.setBounds(370, 379, 155, 46);
		contentPane.add(button_4);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ReaderView.class.getResource("/image/resizeApi.png")));
		label.setFont(new Font("华文行楷", Font.BOLD, 24));
		label.setBounds(107, 65, 171, 163);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		label_1.setFont(new Font("华文行楷", Font.BOLD, 24));
		label_1.setBounds(117, 238, 116, 32);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u897F\u7535\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label_2.setFont(new Font("华文行楷", Font.BOLD, 24));
		label_2.setBounds(63, 288, 247, 32);
		contentPane.add(label_2);
	}

}
