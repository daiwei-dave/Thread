package com.imooc.concurrent.base;
/**
 * 军队线程
	模拟作战双方的行为
 * @author daiwei
 *
 */
public class ArmyRunnable implements Runnable{
	//用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最新的值。
	volatile boolean keepRunning = true;

	@Override
	public void run() {
		while(keepRunning){
			//发动5连击
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]次");
				//暂停当前正在执行的线程对象即ArmyRunnable对象，并执行其他线程,其他线程也有可能是当前线程。
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"结束了战斗！");
	}
}
