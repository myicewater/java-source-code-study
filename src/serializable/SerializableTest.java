package serializable;

public class SerializableTest {

	
	
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("�ļ�҅����������");
		
		SerializableUtil.writeObject(p);
		Person pp = (Person)SerializableUtil.readObject();
		
		System.out.println(pp.getName());
	}
}
