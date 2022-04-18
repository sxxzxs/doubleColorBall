package com.pxs.ball;

import java.util.Random;

public class a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1;i <= 7; i++) {
			int random = 0;
			if(i!=7) {
				 random = new Random().nextInt(3);
				if(random>0) {
					System.out.println(random);
				}
			}else {
				 random = new Random().nextInt(17);
				if(random>0) {
					System.out.println(random);
			}
						 			
		}

	}

}
}
