package edu.java.ThreadEx;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ThreadEx01 {

	private int myChoice;

	public static void main(String[] args) {

		ThreadRPS myRPS = new ThreadRPS();
		Scanner sc = new Scanner(System.in);
		System.out.println("내가 낼 손 선택 1.가위 2.바위 3.보");
		int select = sc.nextInt();
		myRPS.setMyHand(select);

		myRPS.start();

		System.out.println("바꾸시겠습니까? 1.가위 2.바위 3.보");
		select = sc.nextInt();
		myRPS.setMyHand(select);
		sc.close();
	}



	public int getMyHands() {
		return myChoice;
	}
}

class ThreadRPS extends Thread {
	private final String[] HANDS = { "가위", "바위", "보" };
	int myHand = -1;
	int count = 0;
	int index = (int) (Math.random() * 3); // 스레드를 실행한 순간 이미 정해져있다
	Timer timeSet = new Timer();

	@Override
	public void run() {
		timeSet.schedule(new TimerTask() {
			@Override
			public void run() {

				count++;
				System.out.println(count);
				if(count==2) {
					System.out.println("컴퓨터의 손은? "+HANDS[index]);
				}
				if (count == 3) {
					switch (myHand) {
					case 1: // 가위
						if (index == 0) {
							System.out.println("무승부 입니다");
						} else if (index == 1) {
							System.out.println("졌습니다.");
						} else {
							System.out.println("이겼습니다.");
						}
						break;
					case 2: // 바위
						if (index == 0) {
							System.out.println("이겼습니다");
						} else if (index == 1) {
							System.out.println("비겼습니다");
						} else {
							System.out.println("졌습니다");
						}
						break;
					case 3: // 보
						if (index == 0) {
							System.out.println("졌습니다");
						} else if (index == 1) {
							System.out.println("이겼습니다");
						} else {
							System.out.println("비겼습니다");
						}
						break;
					}
					
					timeSet.cancel();
				}
			}
		}, 0, 1200);
		;
	}

	public int getComputerHand() {
		return index;
	}

	public void setMyHand(int myHand) {
		this.myHand = myHand;
	}
}
