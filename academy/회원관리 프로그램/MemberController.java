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
		view.memberList(search.equals("")?"�Է��� ������ �����ϴ�.":search);
	}
	
	//2. ȸ�� ���
	public void insertMember() {
		Member mem = view.insetMember();
		boolean flag = dao.insertMember(mem);
		view.resultPrint(flag?"ȸ�� ����� �����Ͽ����ϴ�.":"�� �̻� ȸ���� ����� �� �����ϴ�.");
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
	//5. ȸ�� ���� ����
	public void updateMember() {
		Member mem = view.updateMember();
		boolean flag = dao.updateMember(mem);
		view.resultPrint(flag?"ȸ�� ������ �����Ǿ����ϴ�.":"�Է��Ͻ� ȸ���� ã�� �� �����ϴ�.");
	}
	
	//6. ȸ�� ���� ����
		public void removeMember() {
			Member mem = view.removeMember();
			boolean flag = dao.removeMember(mem);
			view.resultPrint(flag?"ȸ�� ������ ���ŵǾ����ϴ�.":"�Է��Ͻ� ȸ���� ã�� �� �����ϴ�.");
		}
}
