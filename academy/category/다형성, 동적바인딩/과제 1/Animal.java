package practice3.model.vo;

abstract public class Animal {
	private String name;
	private String kinds;
	
	protected Animal() {}
	protected Animal(String name, String kinds) {
		this.name=name;
		this.kinds=kinds;
	}
	@Override
	public String toString() {
		return "���� �̸��� "+name+"�̰�, ������ "+kinds+"�Դϴ�.";
	}
	abstract public void speak();
}
