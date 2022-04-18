package com.pxs.ball;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		while(true) {
			//写菜单
			System.out.println("----------欢迎进入双色球彩票系统----------------");
			System.out.println("1.购买彩票");
			System.out.println("2.查看开奖");
			System.out.println("3.退出");
			System.out.println("请选择你要完成的功能: ");
			//拿过来一个扫描器
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			//声明一个数组，用来存放7个球的数字
			int[] balls = new int[7];
			switch(choice) {
			 case 1:
				 System.out.println("双色球系统》》》购买彩票");
				 System.out.println("请输入你要买的注数: ");
				 int count = sc.nextInt();//购买的注数
				 for(int i = 1;i <= 7;i++) {
					 if(i != 7) {//录入红色球
						 System.out.println("请录入弟 "+i +" 个球");
						 int redBall = sc.nextInt();
						 balls[i-1] = redBall;
					 }else {//录入蓝色球
						 System.out.println("请录入一个蓝色球: ");
						 int blueBall = sc.nextInt();
						 balls[6] = blueBall;
					 }
				 }
				 //提示完整信息
				 System.out.println("您购买了 " + count+" 注彩票，一共消费了 "+ count*2+" 元钱，您购买的彩票号码为: ");
				 //遍历数组
				 for(int num:balls) {
					 System.out.print(num+"\t");
				 }
				 //换行
				 System.out.println();
				 break;
			 case 2:
				 System.out.println("双色球系统》》》查看开奖");
				 break;
			 case 3:
				 System.out.println("双色球系统》》》退出");
				 return;
			}
		}
	}

}
