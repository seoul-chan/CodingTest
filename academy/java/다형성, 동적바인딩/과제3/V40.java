package com.kh.practice.chap02_abstractNInterface.model.vo;

public class V40 extends SmartPhone implements NotePen{
	
	public V40() {super.setMaker("LG");}

	@Override
	public String makeCall() {return "��ȣ�� ������ ��ȭ��ư�� ����\n";	}

	@Override
	public String takeCall() {return "��ȭ�ޱ� ��ư�� ����\n";}
	
	@Override
	public String picture() {return "1200��, 1600�� ȭ�� Ʈ���� ī�޶�\n";}
	
	@Override
	public String charge() {return "�������, ��� ���� ����\n";}

	@Override
	public String touch() {return "������\n";}

	@Override
	public boolean bluetoothPen() {return false;}

	@Override
	public String printInfomation() {
		String str = "V40�� LG���� ��������� ������ ������ ����.\n";
		return str+makeCall()+takeCall()+picture()+charge()+touch()+"������� �� ž�� ���� : "+bluetoothPen();
	}
}
