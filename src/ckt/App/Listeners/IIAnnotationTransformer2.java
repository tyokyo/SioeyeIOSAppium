package ckt.App.Listeners;

import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by qiang.zhang on 2017/1/7.
 * IAnnotationTransformer2 监听器是用来在运行时修改除 @Test 以外的 TestNG 的注释
 */
public class IIAnnotationTransformer2 implements IAnnotationTransformer2 {
    @Override
    public void transform(IConfigurationAnnotation iConfigurationAnnotation, Class aClass, Constructor constructor, Method method) {

    }

    @Override
    public void transform(IDataProviderAnnotation iDataProviderAnnotation, Method method) {

    }

    @Override
    public void transform(IFactoryAnnotation iFactoryAnnotation, Method method) {

    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {

    }
}
