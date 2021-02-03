package com.member.controller;

import com.member.model.dao.MemberDao;
import com.member.model.view.MainView;
import com.member.model.vo.Member;

public class MemberController {
	
	MainView view = new MainView();
	MemberDao dao = new MemberDao();
	
	public void mainMenu() {
		view.mainMenu(this);
	}
	
	//1. ��üȸ�� ��ȸ
	public void serchAll() {
		String search = dao.serchAll();
		view.resultPrint(search.equals("")?"�Է��� ������ �����ϴ�.":search);
	}
	
	//2. ȸ�� ���
	public void insertMember() {
		Member mem = view.insetMember();
		boolean flag = dao.insertMember(mem);
		view.resultPrint(flag?"��� ����":"��� ����");
	}
	
	//3. ���̵�� ȸ�� ��ȸ
	public void serchId() {
		String id = view.serchId();
		String flag = dao.serchId(id);
		
		view.resultPrint(flag.equals("")?"�Է��� ������ �����ϴ�.":flag);
	}
	
	//4. �̸����� ȸ�� ��ȸ
	public void serchName() {
		String name = view.serchName();
		String flag = dao.serchName(name);
		
		view.resultPrint(flag.equals("")?"�Է��� ������ �����ϴ�.":flag);
	}
}
