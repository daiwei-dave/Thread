package com.imooc.concurrent.base;

public class Stage extends Thread{
	public void run(){
		System.out.println("��ӭ�ۿ���������");
		//�ù����ǰ���Ƭ�̣��ȴ���Ϸ����
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��Ļ��������");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("��˵�峯ĩ�꣬�����ũ�������ɱ�û���ڵ�...");
		//�������Ӷ���
		ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		//ʹ��Runnable�ӿڴ����߳�
		Thread  armyOfSuiDynasty=new Thread(armyTaskOfSuiDynasty, "���");
		Thread  armyOfRevolt = new Thread(armyTaskOfRevolt,"ũ�������");
		//�����̣߳��þ��ӿ�ʼ��ս
		armyOfSuiDynasty.start();
		
		armyOfRevolt.start();
		//��̨�̣߳������̣߳����ߣ�����ʹ��sleep������ĳЩ�߳����run������ûʱ��ִ��,
		//������sleep��������ɱ�֤��һ������ִ�е��߳�����ʱ��һ���̻߳���ִ��
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("����˫����ս��������·ɱ���˸���ҧ��");
		//�����ؼ�����
		Thread  mrCheng=new KeyPersonThread();
		//���߳�����
		mrCheng.setName("��ҧ��");
		System.out.println("��ҧ���������ǽ���ս����ʹ���հ�����ҵ��");
		//ֹͣ������ս
		//ֹͣ�̵߳ķ���
		armyTaskOfSuiDynasty.keepRunning=false;
		armyTaskOfRevolt.keepRunning=false;
		//��ս�������
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ؼ�������run������ʼִ�У���ΪarmyOfSuiDynasty��armyOfRevolty�����̶߳��ѽ�����java�����ʵ��ִ�е���mrCheng�ĵ��߳�
		mrCheng.start();
		//�ȴ����߳���ֹ�� ��ֻ�и��߳�ִ�����Ż�ִ����̨�̣߳������̣߳�����ĳ���
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ս�����������񰲾���ҵ��������ʵ���˻������������룬Ϊ���������˹��ף�");
		System.out.println("лл�ۿ��������壬�ټ���");
	}
	public static void main(String[] args) {
		new Stage().start();
	}
}
