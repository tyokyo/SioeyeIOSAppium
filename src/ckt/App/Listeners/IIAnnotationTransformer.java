package ckt.App.Listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by qiang.zhang on 2017/1/7.
 * 大多数情况下，在运行时我们不需要改动源代码中定义的注释，但有时需要这样做
 * IAnnotationTransformer 只能用来修改 @Test 注释，
 * 如果需要修改其他 TestNG 的注释（比如，@DataProvider, @Factory 以及 @Configuration），
 * 需要使用 IAnnotationTransformer2 监听器。IAnnotationTransformer 要求实现 transform 方法
 */
public class IIAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setEnabled(false);
    }
}
