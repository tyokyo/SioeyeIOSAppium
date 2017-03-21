package ckt.App.Listeners;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

/**
 * Created by qiang.zhang on 2017/1/7.
 * 如果用户希望有不同格式的测试报表，就需要使用 IReporter 监听器
 * 该方法在所有测试方法执行结束后被调用，通过遍历 xmlSuites 和 suites 能够获取所有测试方法的信息以及测试结果。
 * outputDirectory 是默认的测试报表生成路径，当然你可以指定其他路径生成报表
 */
public class IIReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {

    }
}
