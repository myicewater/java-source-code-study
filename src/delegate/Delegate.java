/**
 * delegate包，主要演示了java通过注解代理
 */
package delegate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Delegate{
	String interfaceName();
	String methodName();
	DelegatePolicy policy();
	int paramNum() default 0;
}