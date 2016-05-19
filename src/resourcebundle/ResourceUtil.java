package resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;
/**
 * 1.国际化资源文件，将资源文件翻译成不同语言
 * 
 * 2.读取资源属性文件，根据配置文件信息，匹配当前系统的国别语言信息，或相应的文件内容
 * 
 * 3.如果config_zh_CN.properties、config.properties 同时存在则优先使用 config_zh_CN.properties
 * 
 * 4.资源文件必须都是ISO-8859-1编码，对于非西方语言，要先转换为java Unicode escape格式
 * 
 * 5.整个过程中config.properties 没有被读取，因为有config_zh_CN.properties
 * 
 * @author 朱素海
 *
 */
public class ResourceUtil {

	private String resourceName;
	private ResourceBundle bundle;
	
	public ResourceUtil(String name){
		this.resourceName = name;
		bundle = ResourceBundle.getBundle(name);
	}
	
	public ResourceUtil(String name,Locale l){
		this.resourceName = name;
		bundle = ResourceBundle.getBundle(name, l);
	}
	
	public String getString(String name){
		if(name == null){
			return null;
		}else{
			return bundle.getString(name);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceUtil ru = new ResourceUtil("config");//config_zh_CN.properties
		System.out.println(ru.getString("aaa")+","+ru.getString("bbb"));
		
		ResourceUtil ru2 = new ResourceUtil("config",new Locale("zh","CN"));//config_zh_CN.properties
		System.out.println(ru2.getString("aaa")+","+ru2.getString("bbb"));
		
		ResourceUtil ru3 = new ResourceUtil("config",new Locale("en","US"));
		System.out.println(ru3.getString("aaa")+","+ru3.getString("bbb"));
		
		ResourceUtil ru4 = new ResourceUtil("config", Locale.getDefault());//config_zh_CN.properties
		System.out.println(ru4.getString("aaa")+","+ru4.getString("bbb"));
		
	}

}
