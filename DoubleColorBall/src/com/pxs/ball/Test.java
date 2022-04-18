package com.pxs.ball;

import java.util.Random;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		//定义一个变量，用来设定是否购买彩票
		boolean isBuy = false;//默认没买
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
			int count = 0;//购买的注数
			switch(choice) {
			 case 1:
				 System.out.println("双色球系统》》》购买彩票");
				 System.out.println("请输入你要买的注数（一注2元）: ");
				 count = sc.nextInt();//购买的注数
				 for(int i = 1;i <= 7;i++) {
					 if(i != 7) {//录入红色球
						 System.out.println("请录入第"+i +" 个红球(选择范围1-33 ): ");
						 int redBall = sc.nextInt();
						 balls[i-1] = redBall;
					 }else {//录入蓝色球
						 System.out.println("请录入一个蓝色球(选择范围1-16): ");
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
				 isBuy = true;
				 break;
			 case 2:
				 if(isBuy) {
					//1.购买号码-->balls
					 //2.中奖号码
					 int[] luckyBall = getLuckBall();
					//输出开奖号码
				    System.out.print("开奖号码为:  ");
					for(int i = 1;i <=7 ;i++) {
						System.out.print(luckyBall[i-1]+"\t");
					}
					System.out.println();			
					 //3.将两组号码进行比对
					 int level = getLevel(balls, luckyBall);
					 //4.根据level的结果执行后面的逻辑
					 switch(level){
						 case 1:
							 System.out.println("恭喜你，中了一等奖，1注奖金500万，您一共获得: "+count*500+"万元");
							 break;
						 case 2:
							 System.out.println("恭喜你，中了二等奖，1注奖金100万，您一共获得: "+count*100+"万元");
							 break;
						 case 3:
							 System.out.println("恭喜你，中了三等奖，1注奖金30万，您一共获得: "+count*30+"万元");
							 break;
						 case 4:
							 System.out.println("恭喜你，中了四等奖，1注奖金5万，您一共获得: "+count*5+"万元");
							 break;
						 case 5:
							 System.out.println("恭喜你，中了五等奖，1注奖金2000元，您一共获得: "+count*2+"千元");
							 break;
						 case 6:
							 System.out.println("恭喜你，中了六等奖，1注奖金5块，您一共获得: "+count*5+"元");
							 break;
						
					 }
					 System.out.println("双色球系统》》》查看开奖");
				 }else {
					 System.out.println("对不起，请先购买彩票！！");
				 }
				 break;
			 case 3:
				 System.out.println("双色球系统》》》退出");
				 return;
			}
		}
	}
	//定义一个方法，专门用来生成中奖号码
	public static int[] getLuckBall() {
		int[] luckyBall = new int[7];
		//红球：1-33  篮球：1-16
		for(int i = 1;i <= 7; i++) {
			int random = 0;
			if(i!=7) {
				random = new Random().nextInt(34);//返回0-33之间的整数
				if(random > 0) {
					luckyBall[i-1] = random;
				}
			}else {
				random = new Random().nextInt(17);
				if(random > 0) {
					luckyBall[6] = random;
				}
			}
							 			
		}
		
		return luckyBall;
	}
	
	//定义一个方法，专门用来比对购买号码和中奖号码
	public static int getLevel(int[] balls,int[] luckyBall) {
		int level = 0;
		//计数器:用来计红球有几个相等:
		int redCount = 0;
		//计数器:用来计篮球有几个相等
		int blueCount = 0;
		
		//遍历我购买的号码
		for(int i = 0;i <= 6;i++) {
			if(i!=6) {//比对红球
				for(int j = 0;j<=5;j++) {
					if(balls[i]==luckyBall[j]) {
						redCount++;						
					}
				}
			}else {//比对篮球
				if(balls[6]==luckyBall[6]) {
					blueCount++;
				}
			}
		}
		//输出比对结果
		System.out.println("红球有" + redCount+"个相等");
		System.out.println("蓝球有" + blueCount+"个相等");
		
		//根据红球和篮球的相等数量得到level的具体结果：
		if(redCount==6&&blueCount==1) {
			level = 1;
		}else if(redCount==6) {
			level = 2;
		}else if(redCount==5&&blueCount==1) {
			level = 3;
		}
		else if(redCount==5||(redCount==4&&blueCount==1)) {
			level = 4;
		}
		else if(redCount==4||(redCount==3&&blueCount==1)) {
			level = 5;
		}else {
			level = 6;
		}
		return level;
		
	}

}
