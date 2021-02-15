package com.kh.practice.chap01_poly.model.controller;

import com.kh.practice.chap01_poly.model.vo.*;

public class LibraryController {
	private Member mem = null;
	private Book[] bList = new Book[5];
	
	{
		bList[0] = new CookBook("�������� ����","������", "tvN", true);
		bList[1] = new AniBook("�ѹ� �� �ؿ�","��Ƽ ", "�����", 19);
		bList[2] = new AniBook("������ ���ǽ�","���� ", "jepan", 12);
		bList[3] = new CookBook("�������� �󸶳� ���ְԿ�","������ ", "����", false);
		bList[4] = new CookBook("������ �� �����غ�","������","�ұ�å",true);
	}
	
	public void insertMember(Member mem) {this.mem=mem;}
	
	public Member myinfo() {return mem;}
	
	public Book[] selectAll() {return bList;}
	
	public Book[] searchBook(String keyword) {
		Book[] List = new Book[5];
		int count=0;
		
		for(int i=0;i<bList.length;i++) {
			if(bList[i].getTitle().contains(keyword))
				List[count++]=bList[i];
		}	
		return List;
	}
	
	public int rentBook(int index) {
		int result = 0;
		
		if(bList[index] instanceof AniBook) {
			AniBook a = (AniBook)bList[index];
			if(a.getAccessAge()>mem.getAge()) result=1;
			
		} else if (bList[index] instanceof CookBook) {
			CookBook c = (CookBook)bList[index];
			if(c.getCoupon()==true) {
				int k = mem.getCouponCount();
				mem.setCouponCount(++k);
				result=2;
			}
		}
		return result;
	}
	
}
