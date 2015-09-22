package leetcode;

public class Singleton {
	String name = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Singleton(){
		
	}
	private static class LazyHolder{
		private static Singleton single= new Singleton();
	}
	public static Singleton getInstance(){
		return LazyHolder.single;
	}
	public void printInfo(){
		System.out.println("the name is "+ name);
	}
}
