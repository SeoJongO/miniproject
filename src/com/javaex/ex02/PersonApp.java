package com.javaex.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonApp {

	Scanner sc = new Scanner(System.in);

	List<Person> pList = new ArrayList<Person>();
	
	public void start() {
		System.out.println("*******************************");
		System.out.println("*      전화번호 관리 프로그램      *");
		System.out.println("*******************************");
		System.out.println("");
	}
	
	public void menu() {
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("-------------------------------");
		System.out.print(">메뉴번호: ");
	}

	public void read() throws IOException {
		try {
			Reader fr = new FileReader("C:\\Users\\Hi-PC\\Desktop\\JavaStudy\\file\\PhoneDB_Plus.txt");
			BufferedReader br = new BufferedReader(fr);

			String line = "";

			while (true) {

				line = br.readLine();
				if (line == null) {
					break;
				}

				String[] pInfo = line.split(",");

				String name = pInfo[0];
				String hp = pInfo[1];
				String company = pInfo[2];

				Person person = new Person(name, hp, company);

				pList.add(person);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다");
		}

	}

	public void showList() {
		System.out.println("<1. 리스트>");
		for (int i = 0; i < pList.size(); i++) {
			System.out.println((i + 1) + "." + "\t" + pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t"
					+ pList.get(i).getCompany());
		}
		System.out.println("");

	}

	public void addList() {
		System.out.println("<2. 등록>");

		System.out.print(">이름: ");
		String name = sc.next();
		System.out.print(">휴대전화: ");
		String hp = sc.next();
		System.out.print(">회사전화: ");
		String company = sc.next();

		Person person = new Person(name, hp, company);

		pList.add(person);

		System.out.println("[등록되었습니다]");
		System.out.println("");
	}

	public void removeList() {
		System.out.println("<3. 삭제>");
		System.out.print(">번호 :");
		int lNum = sc.nextInt();

		pList.remove(lNum - 1);
		System.out.println("[삭제되었습니다]");

		System.out.println("");
	}

	public void searchList() {
		System.out.println("<4. 검색>");
		System.out.print(">검색 :");
		String search = sc.next();

		for (int i = 0; i < pList.size(); i++) {
			if ((pList.get(i).getName()).contains(search)) {
				System.out.println((i + 1) + "." + "\t" + pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t"
						+ pList.get(i).getCompany());
			}
		}

		System.out.println("");
	}
	
	public void quitList() {
		System.out.println("");
		System.out.println("*******************************");
		System.out.println("*           감사합니다	      *");
		System.out.println("*******************************");
		System.out.println("");
	}
	
	public void errorList() {
		System.out.println("[다시 입력해주세요]");
		System.out.println("");
	}

	public void write() throws IOException {
		Writer fw = new FileWriter("C:\\Users\\Hi-PC\\Desktop\\JavaStudy\\file\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < pList.size(); i++) {
			bw.write(pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany());
			bw.newLine();
		}
		bw.close();
	}

}
