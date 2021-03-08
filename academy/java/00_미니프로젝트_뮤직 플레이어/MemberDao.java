package music.play.list.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberDao {
	ArrayList<Member> m = new ArrayList<Member>();
	Member logedMem = new Member();
	
	public boolean logIn(String id, String password) {
		boolean flag = false;
		
		for(int i=0;i<m.size();i++) {
			if(m.get(i)!=null && m.get(i).getId().equals(id)
					&& m.get(i).getPassword().equals(password)) {
				logedMem=m.get(i);
				return true;
			}
		}
		return flag;
	}

	public void logOut() {
		this.logedMem=null;
	}
	
	public boolean updateMember(Member mem) {
		boolean flag = false;
		for(int i=0;i<m.size();i++) {
			if(m.get(i)!=null&&m.get(i).getName().equals(mem.getName())) {
				if(mem.getAddress()!=null)m.get(i).setAddress(mem.getAddress());
				if(mem.getId()!=null)m.get(i).setId(mem.getId());
				if(mem.getPassword()!=null)m.get(i).setPassword(mem.getPassword());
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public boolean signUp(Member mem) {
		boolean flag = false;
		
		for(int i=0;i<m.size();i++) {
			if(m.get(i)==null) {
				m.add(mem);
				flag=true;
				break;
			}	
		}
		return flag;
	}
	
	public void signOut() {
		if(m.remove(logedMem))
			this.logedMem=null;
	}
	
	// ���α׷� ���� �� ȸ�� ���� ����
	// ����� ���α׷������� �α����� ���� DB���� ����
	public void saveMember() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Member.dat"));){
			oos.writeObject(m);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//ȸ�� ���� �ҷ�����
	public ArrayList<Member> loadMember() {
		File file = new File("Member.dat");
		if(file.exists()) { //������ ������ ��쿡 �ҷ����� ����
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
				m = (ArrayList<Member>)ois.readObject();
			}catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
}
