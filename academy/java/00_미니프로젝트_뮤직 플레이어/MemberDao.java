package music.play.list.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberDao {
	ArrayList<Member> m = new ArrayList<Member>();	// ��ü ȸ�� ����Ʈ
	Member logedMem=null;	// ���� �α��� ���� ��ü ���� ����
	
	public boolean logIn(String id, String password) {
		boolean flag = false;
		
		for(int i=0;i<m.size();i++) {	//id, pw��ġ ��ü �ִ� ��� �ش� ��ü �α��� ���� ����
			if(m.get(i)!=null && m.get(i).getId().equals(id)
					&& m.get(i).getPassword().equals(password)) {
				logedMem=m.get(i);
				return true;
			}
		}
		return flag;
	}
	
	//���� �α��� ���� Ȯ��
	public boolean logedIn() {
		return logedMem!=null;
	}

	public void logOut() {
		this.logedMem=null;
	}
	
	// �ߺ� ID üũ
	public boolean dupliId(String id) {
		for(int i=0;i<m.size();i++) {
			if(m.get(i)!=null && m.get(i).getId().equals(id))
					return true;
		}
		return false; 
	}
	
	// ���� �α��ε� ȸ�� ���� Ȯ��
	public Member myInfo() {
		return logedMem;
	}
	
	// ȸ�� ���� ����
	public boolean updateMember(Member mem) {
		boolean flag = false;
		for(int i=0;i<m.size();i++) {
			if(m.get(i)!=null&&m.get(i).equals(logedMem)) {
				if(mem.getId()!=null) m.get(i).setId(mem.getId());
				if(mem.getPassword()!=null) m.get(i).setPassword(mem.getPassword());
				if(mem.getPhone()!=null) m.get(i).setPhone(mem.getPhone());
				if(mem.getAddress()!=null) m.get(i).setAddress(mem.getAddress());	
				logedMem = m.get(i);
				saveMember();
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	// ȸ�� ����
	public boolean signUp(Member mem) {
		m.add(mem);
		saveMember();
		return true;
	}

	// ȸ�� Ż��	
	public void signOut() {
		m.remove(logedMem);  //ȸ�� ��Ͽ��� ���� �� ȸ�� ��� ����
		this.logedMem=null;
		saveMember();
	}
	
	// ���α׷� ���� ��, ȸ�� ���� �� ȸ�� ���� ����
	// ����� ���α׷������� �α����� ���� DB���� ����
	public void saveMember() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Member.dat"));){
			oos.writeObject(m);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//ȸ�� ���� �ҷ�����
	public void loadMember() {
		File file = new File("Member.dat");
		if(file.exists()) { //������ ������ ��쿡 �ҷ����� ����
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Member.dat"))){
				this.m = (ArrayList<Member>) ois.readObject();
			}catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
