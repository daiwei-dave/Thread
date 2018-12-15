package com.imooc.concurrent.base;
/**
 * �����߳�
	ģ����ս˫������Ϊ
 * @author daiwei
 *
 */
public class ArmyRunnable implements Runnable{
	// ��volatile���εı������߳���ÿ��ʹ�ñ�����ʱ�򣬶����ȡ�����޸ĺ�����µ�ֵ(����֤�˿ɼ���)��
	volatile boolean keepRunning = true;
	private final Object lockObj = new Object();

//	@Override
//	public void run() {
//		while(keepRunning){
//			//����5����
//			for(int i=0;i<5;i++){
//				System.out.println(Thread.currentThread().getName()+"�����Է�["+i+"]��");
//				//��ͣ��ǰ����ִ�е��̶߳���ArmyRunnable���󣬲�ִ�������߳�,�����߳�Ҳ�п����ǵ�ǰ�̡߳�
//				Thread.yield();
//			}
//		}
//		System.out.println(Thread.currentThread().getName()+"������ս����");
//	}

	/**
	 * ����ͬ����synchronized (ArmyRunnable.class)����סArmyRunnable�����(�������еĶ���ͬһ����)
	 * ��ʹ��������ͬ������߳�Ҳ���ڵ��ô���ʱ�����̻߳���
	 */
//	@Override
//	public void run() {
//		/**
//		 * ֻ��һ���̻߳�ִ��
//		 */
//		synchronized (ArmyRunnable.class){
//			while(keepRunning){
//				//����5����
//				for(int i=0;i<5;i++){
//					System.out.println(Thread.currentThread().getName()+"�����Է�["+i+"]��");
//				}
//			}
//		}
//		System.out.println(Thread.currentThread().getName()+"������ս����");
//	}


	/**
	 * ��ס������ֻ�������߳�Ϊһ������Żụ��
	 */
//	@Override
//	public synchronized void run() {
//		while(keepRunning){
//			//����5����
//			for(int i=0;i<5;i++){
//				System.out.println(Thread.currentThread().getName()+"�����Է�["+i+"]��");
//				//��ͣ��ǰ����ִ�е��̶߳���ArmyRunnable���󣬲�ִ�������߳�,�����߳�Ҳ�п����ǵ�ǰ�̡߳�
//				Thread.yield();
//			}
//		}
//		System.out.println(Thread.currentThread().getName()+"������ս����");
//	}


	/**
	 * synchronized (this)��ס���Ƕ���ֻ�������߳�Ϊһ������Żụ��
	 */
	@Override
	public void run() {
		synchronized (this){
			while(keepRunning){
				//����5����
				for(int i=0;i<5;i++){
					System.out.println(Thread.currentThread().getName()+"�����Է�["+i+"]��");
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+"������ս����");
	}



}
