package delegate;

/**
 * 通过代理继承 打印出 hello
 * 
 * 感觉绕到了月球
 * 
 * 然而还是比较有成就感的
 * @author 朱素海
 *
 */
public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SourceClass s = DelegateConsole.bind(SourceClass.class, new SourceProxy());
		StringBuffer f;
		s.hello();
	}

}
