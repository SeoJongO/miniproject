package com.javaex.ex02;

import java.io.IOException;
import java.util.Scanner;

public class PhoneApp_Switch {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		PersonApp Manager = new PersonApp();
		
		Manager.read();
		
		boolean flag = false;
		
		while (true) {
			
			Manager.start();
			
			while (true) {
				
				Manager.menu();
				
				int num = sc.nextInt();
				
				switch (num) {
				
				case 1:
					Manager.showList();
					break;
					
				case 2:
					Manager.addList();
					break;
					
				case 3:
					Manager.removeList();
					break;
					
				case 4:
					Manager.searchList();
					break;
					
				case 5:
					Manager.quitList();
					flag = true;
					break;
					
				default:
					Manager.errorList();
					break;
					
				}
				
				if (flag == true) {
					break;
					
				}
				
			}
			
			break;
		}
		
		Manager.write();
		
		sc.close();
		
	}
	
}
