package chess;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ChessBoard extends JFrame {
//	private JPanel contentPanel;
	Board board;
	private JMenuBar upBar;
	private JPanel downBar;
	private JMenu systembutton;
	private JButton restartbutton;
	private JButton backbutton;
	private JButton exitbutton;
	private JMenuItem restart;
	private JMenuItem back;
	private JMenuItem exit;
	
	//�¼�����Ŷ
	private JButton give_in;
	
	public ChessBoard ()
	{
		
		board = new Board();
		
		setTitle("����������");
	//	contentPanel = (JPanel) this.getContentPane();
		upBar = new JMenuBar();
		systembutton = new JMenu("ϵͳ");
		restart = new JMenuItem("���¿�ʼ");
		back = new JMenuItem("����");
		exit = new JMenuItem("�˳�");

		setJMenuBar(upBar);
		systembutton.add(restart);
		systembutton.add(back);
		systembutton.add(exit);
		MyItemListener lis = new MyItemListener();
		exit.addActionListener(lis);
		back.addActionListener(lis);
		restart.addActionListener(lis);
	
		upBar.add(systembutton);
		
		downBar = new JPanel();
		restartbutton = new JButton("���¿�ʼ");
		backbutton = new JButton("����");
		exitbutton = new JButton("�˳�");
		give_in = new JButton("Ͷ��");
		
		exitbutton.addActionListener(lis);
		backbutton.addActionListener(lis);
		restartbutton.addActionListener(lis);
		give_in.addActionListener(lis);
		downBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		downBar.add(restartbutton);
		downBar.add(backbutton);
		downBar.add(exitbutton);
		downBar.add(give_in);
		
		add(downBar, BorderLayout.SOUTH);
		add (board);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 650);
		//pack();
	}
	private class MyItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if (obj == restart || obj == restartbutton)
			{
				System.out.println("���¿�ʼ...");
				board.restartGame();
			}
			else if (obj == exit || obj == exitbutton)
			{
				System.exit(0);
			}
			else if (obj == back || obj == backbutton)
			{
				System.out.println("����...");
				board.goback();
			}
			else if (obj == give_in)
			{
				System.out.println("Ͷ��");
				board.give_in();
				board.restartGame();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChessBoard board = new ChessBoard();
		board.setVisible(true);
	}

}
