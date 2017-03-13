package ckt.App.Listeners;

import java.util.ArrayList;  
import java.util.HashSet;  
import java.util.List;  
import java.util.Set;  

import org.testng.IMethodInstance;  
import org.testng.IMethodInterceptor;  
import org.testng.ITestContext;  
import org.testng.annotations.Test;  
/**
 * Created by qiang.zhang on 2017/1/7.
 * TestNG 启动之后，第一件要做的事情是将所有的测试方法分成两类：一类是顺序运行的测试方法；一类是没有特定运行顺序的测试方法。
 TestNG 通过 @Test 注释中的 dependsOnGroups 和 dependsOnMethods 使用户能够定义测试方法之间的依赖关系。
 这种依赖关系也就决定这些测试方法必须按着怎样的顺序运行，这就是第一类。
 除此以外的便是第二类。对于第二类中的测试方法，尽管默认 TestNG 会尝试用类名将它们分组，
 但是理论上，它们的运行顺序是随机的，甚至每次运行的顺序都可能不同。
 因此为了使用户拥有对第二类测试方法更大的控制权，IMethodInterceptor 监听器产生了
 intercept 方法在所有测试方法被分类后以及所有测试方法被执行前被调用。所有的测试方法将按照 intercept 返回值列表中的顺序被执行。
 因此，用户在 intercept 方法中可以对列表进行修改，比如重新排序，甚至增加或者减少测试方法
 */
public class IIMethodInterceptor implements IMethodInterceptor {  

	@Override  
	public List<IMethodInstance> intercept(List<IMethodInstance> methods,  
			ITestContext context) {  
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();  

		for (IMethodInstance m : methods) {  
			Test test = m.getMethod().getConstructorOrMethod().getMethod()  
					.getAnnotation(Test.class);  
			Set<String> groups = new HashSet<String>();  
			for (String group : test.groups()) {  
				groups.add(group);  
			}  
			System.out.println("groups +"+groups );  
			if (groups.contains("fast")) {  
				result.add(0, m);  
			} else {  
				result.add(m);  
			}  
		}  
		return result;  
	}  
}  
