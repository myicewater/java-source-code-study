package reflect;

public class Student {
	
	static{
		System.out.println("Load Student class.");
	}
	
	private String name;
	
	private int age;
	
	public String address;
	
	public void intruductSelf(String emotion){
		System.out.println("My name is :"+name+" with an "+emotion+" emotion.");
	}
	
	public Student(String name){
		this.name = name;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
