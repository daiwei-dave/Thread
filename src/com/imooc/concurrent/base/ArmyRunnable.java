package com.imooc.concurrent.base;
/**
 * �����߳�
	ģ����ս˫������Ϊ
 * @author daiwei
 *
 */
public class ArmyRunnable implements Runnable{
	//��volatile���εı������߳���ÿ��ʹ�ñ�����ʱ�򣬶����ȡ�����޸ĺ�����µ�ֵ��
	volatile boolean keepRunning = true;

	@Override
	public void run() {
		while(keepRunning){
			//����5����
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"�����Է�["+i+"]��");
				//��ͣ��ǰ����ִ�е��̶߳���ArmyRunnable���󣬲�ִ�������߳�,�����߳�Ҳ�п����ǵ�ǰ�̡߳�
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"������ս����");
	}
}
