/**
 * delegate包，主要演示了java通过注解代理
 */
package delegate;

public class SourceProxy {

	@Delegate(interfaceName="delegate.SourceClass",methodName="hello",policy=DelegatePolicy.Implements)
	public void hello(){
		System.out.println("hello!");
	}
}
