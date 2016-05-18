package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableUtil {
	private static final String FILE_NAME = "D:/obj.obj";
	public  static void writeObject(Serializable s){
		try {
			ObjectOutputStream  os = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			os.writeObject(s);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public static Object readObject(){
		try {
			ObjectInputStream  ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
			Object  o = ois.readObject();
			ois.close();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
