package edu.java.ThreadGUIEx01;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RPS {

	private JFrame frame;
	private int count = 0;
	private int myChoice= -1;
	private JLabel lblNewLabel;
	private final String[] HANDS = {"가위","바위","보"};
	private JButton btnNewButton;
	private JButton btnNewButton_1; 
	private JButton btnNewButton_2;
	private JButton fake;
	private JButton fake2;
	private JButton fake3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPS window = new RPS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public RPS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("컴퓨터의 손 :");
		lblNewLabel.setBounds(118, 33, 190, 37);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("가위");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myChoice= 1;
				startGame();
			}
		});
		btnNewButton.setBounds(35, 167, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("바위");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myChoice=2;
				startGame();
			}
		});
		btnNewButton_1.setBounds(177, 167, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("보");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myChoice=3;
				startGame();
			}
		});
		btnNewButton_2.setBounds(307, 167, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		fake = new JButton("가위");
		fake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myChoice=1;
			}
		});
		fake.setVisible(false);
		fake.setBounds(35, 167, 97, 23);
		frame.getContentPane().add(fake);
		
		fake2 = new JButton("바위");
		fake2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myChoice=2;
			}
		});
		fake2.setVisible(false);
		fake2.setBounds(177, 167, 97, 23);
		frame.getContentPane().add(fake2);
		
		fake3 = new JButton("보");
		fake3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myChoice=3;
			}
		});
		fake3.setVisible(false);
		fake3.setBounds(307, 167, 97, 23);
		frame.getContentPane().add(fake3);
	}

	private void startGame() {
		Timer time = new Timer();
		int comChoice = (int)(Math.random()*3);
		btnNewButton.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				count++;
				if(count<=2) {
					lblNewLabel.setText(Integer.toString(count));
				}else if(count==3) {
					lblNewLabel.setText("컴퓨터의 손 : "+HANDS[comChoice]);
					btnNewButton.setVisible(false);
					btnNewButton_1.setVisible(false);
					btnNewButton_2.setVisible(false);
					fake.setVisible(true);
					fake2.setVisible(true);
					fake3.setVisible(true);
				}else if (count == 4) {
					switch(myChoice) {
					case 1: // 가위
						if (comChoice == 0) {
							System.out.println("무승부 입니다");
						} else if (comChoice == 1) {
							System.out.println("졌습니다.");
						} else {
							System.out.println("이겼습니다.");
						}
						break;
					case 2: // 바위
						if (comChoice == 0) {
							System.out.println("이겼습니다");
						} else if (comChoice == 1) {
							System.out.println("비겼습니다");
						} else {
							System.out.println("졌습니다");
						}
						break;
					case 3: // 보
						if (comChoice == 0) {
							System.out.println("졌습니다");
						} else if (comChoice == 1) {
							System.out.println("이겼습니다");
						} else {
							System.out.println("비겼습니다");
						}
						break;
					
					}
					System.out.println("내선택 :"+myChoice);
					time.cancel();
				}
				
			}
		},0,1200);
			

		}
		
		
	
}
