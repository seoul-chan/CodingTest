package com.kh.practice.chap02_abstractNInterface.model.vo;

public class GalaxyNote9 extends SmartPhone implements NotePen{
	
	public GalaxyNote9() {super.setMaker("�Ｚ");}

	@Override
	public String makeCall() {return "��ȣ�� ������ ��ȭ��ư�� ����\n";}

	@Override
	public String takeCall() {return "��ȭ�ޱ� ��ư�� ����\n";}
	
	@Override
	public String picture() {return "1300�� ���ī�޶�\n";}
	
	@Override
	public String charge() {return "�������, ��� ���� ����\n";}

	@Override
	public String touch() {return "������, ������ ����\n";}

	@Override
	public boolean bluetoothPen() {return true;}

	@Override
	public String printInfomation() {
		String str = "������ ��Ʈ9�� �Ｚ���� ��������� ������ ������ ����.\n";
		return str+makeCall()+takeCall()+picture()+charge()+touch()+"������� �� ž�� ���� : "+bluetoothPen()+"\n";
	}
	

}
