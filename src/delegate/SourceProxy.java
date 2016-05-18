package delegate;

public class SourceProxy {

	@Delegate(interfaceName="delegate.SourceClass",methodName="hello",policy=DelegatePolicy.Implements)
	public void hello(){
		System.out.println("hello!");
	}
}
