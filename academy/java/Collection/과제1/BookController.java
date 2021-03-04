package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.library.model.vo.Book;

public class BookController {
	private List<Book> list = new ArrayList<Book>();
	ArrayList<Book> bookList = new ArrayList<Book>();
	
	public BookController() { 		
		bookList.add(new Book("�ڹ��� ����","���ü�","��Ÿ",20000));
		bookList.add(new Book("���� ���� �˰���","������","��Ÿ",15000));
		bookList.add(new Book("��ȭ�� ���","������","�ι�",17500));
		bookList.add(new Book("�� ������","�ڽſ�","�Ƿ�",21000));
	}
	public void insertBook(Book bk) {
		bookList.add(bk);
	}
	
	public ArrayList<Book> selectList() {
		return bookList;
	}
	
	public ArrayList<Book> searchBook(String keyword) {
		ArrayList<Book> searchList = new ArrayList<Book>();
		
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getTitle().contains(keyword))
				searchList.add(bookList.get(i)); //���� ����??
		}
		return searchList;
	}
	
	public Book deleteBook(String title, String author) {
		Book removeBook = null;
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getTitle().equals(title)
					&& bookList.get(i).getAuthor().equals(author)) {
				removeBook=bookList.get(i);
				bookList.remove(i);
//				bookList.set(i, null);
				return removeBook;
			}
		}
		return null;
	}
	
	public int ascBook() {
		Collections.sort(bookList);
		return 1;
	}
}
