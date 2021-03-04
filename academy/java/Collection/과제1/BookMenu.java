package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	
	public void mainMenu() {
		System.out.println("== Welcome KH Library ==");
		
		while(true) {
			System.out.println("\n****** ���� �޴� ******");
			System.out.println("1. �� ���� �߰�");
			System.out.println("2. ���� ��ü ��ȸ");
			System.out.println("3. ���� �˻� ��ȸ");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� �� �������� ����");
			System.out.println("9. ����");
			System.out.print("�޴� ��ȣ ���� : ");
			
			try {
				switch(sc.nextInt()) {
				case 1 : insertBook(); break;
				case 2 : selectList(); break;
				case 3 : searchBook(); break;
				case 4 : deleteBook(); break;
				case 5 : ascBook(); break;
				case 9 : return;
				default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				}
			} catch(InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				sc.nextLine();				
			}
		}
	}
	
	public void insertBook() {
		String title="";
		String author="";
		String category="";
		int price=0;
		
		try {
			System.out.println("\n=== �� ���� �߰� ===");
			System.out.print("������ �Է� : ");
			sc.nextLine();
			title = sc.nextLine();
			System.out.print("���ڸ� �Է� : ");
			author = sc.next();
			System.out.println("= �帣 =");

			
			int input=0;			
			while(true) {
				System.out.println("1.�ι�");
				System.out.println("2.�ڿ�����");
				System.out.println("3.�Ƿ�");
				System.out.println("4.��Ÿ");
				System.out.print("�帣 �Է� : ");
				
				switch(input=sc.nextInt()){
				case 1 : category = "�ι�"; break;
				case 2 : category = "�ڿ�����"; break;
				case 3 : category = "�Ƿ�"; break;
				case 4 : category = "��Ÿ"; break;
				default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				}
				if(input>=1&&input<=4) break;
			}
			System.out.print("���� �Է� : ");
			price = sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			sc.nextLine();	
			return;
		}
		
		Book book = new Book(title, author, category, price);
		bc.insertBook(book);	
	}
	
	public void selectList() {
		System.out.println("\n=== ���� ��ü ��ȸ ===");
		ArrayList<Book> bookList = bc.selectList();
		
		if(bookList.size()==0) 
			System.out.println("�����ϴ� ������ �����ϴ�.");
		else 		
			for(int i=0;i<bookList.size();i++)
				System.out.println(bookList.get(i));		
	}
	
	public void searchBook() {
		System.out.println("\n=== ���� �˻� ��ȸ ===");
		System.out.print("�˻��� ������ : ");
		sc.nextLine();
		String keyword = sc.nextLine();
		ArrayList<Book> searchList = bc.searchBook(keyword);
		
		if(searchList.size()==0) 
			System.out.println("�����ϴ� ������ �����ϴ�.");
		else 		
			for(int i=0;i<searchList.size();i++)
				System.out.println(searchList.get(i));		
	}
	
	public void deleteBook() {
		System.out.println("\n=== ���� ���� ===");
		System.out.print("������ ������ : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("������ ���ڸ� : ");
		String author = sc.next();
		
		Book remove = bc.deleteBook(title, author);
		System.out.println(remove!=null?"���������� �����Ǿ����ϴ�.":"������ ������ ã�� ���߽��ϴ�.");		
	}
	
	public void ascBook() {
		System.out.println(bc.ascBook()==1?"���Ŀ� �����Ͽ����ϴ�.":"���Ŀ� �����Ͽ����ϴ�.");
	}
}
