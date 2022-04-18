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
			switch(choice) {
			 case 1:
				 System.out.println("双色球系统》》》购买彩票");
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
