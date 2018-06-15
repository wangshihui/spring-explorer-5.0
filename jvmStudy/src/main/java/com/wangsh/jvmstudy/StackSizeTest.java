package com.wangsh.jvmstudy;

import java.util.HashSet;
import java.util.Set;

/**
 * -Xss 设置线程栈的大小
 * 
 * 
 * -XX:NewRatio 设置新生代和年老区的比例
 * -XX:NewSize和-XX:MaxNewSize 设置新生代的最小值和最大值
 * -XX:SurvivorRatio 设置存活区的比例
 * 
 * 
 * -XX:+HeapDumpOnOutOfMemoryError  让jvm在发生堆内存溢出时，自动生成堆的内存快照
 * -XX:HeapDumpPath                 自动生成堆的内存快照的路径
 * -XX:OnOutOfMemoryError           内存溢出时执行指定命令 XX:OnOutOfMemoryError ="sh ~/cleanup.sh" 
 * 
 * -XX:InitialCodeCacheSize and -XX:ReservedCodeCacheSize 代码缓存 用来存储已编译方法生成的本地代码
 * -XX:+UseCodeCacheFlushing  如果代码缓存不断增长，
 * 							例如，因为热部署引起的内存泄漏，那么提高代码的缓存大小只会延缓其发生溢出。
 * 							为了避免这种情况的发生，我们可以尝试一个有趣的新参数：当代码缓存被填满时让JVM放弃一些编译代码
 *  
 *  -XX:PermSize and -XX:MaxPermSize  JDK8已经禁用
 *   
 *   -MaxMetaspaceSize JDK8的PermSize已经改为MaxMetaspaceSize，如果不设置则会动态调整
 *  -server 
 *  -verbose:gc 
 *  -verbose                 参数是为了获取类型加载和卸载的信息
 *  -XX:+DoEscapeAnalysis 
 *   
 * @author Administrator
 *
 */
public class StackSizeTest {
	
	public static int i=1;
	StackSizeTest(){
		String S=new String("11234567890-98765432123456789876543212345678987654321`23456789765432123456789765432123456");
		i++;
		System.out.println(i);
	}
	
	public static void main(String... s) {
		heapfull();
	}
	
	/**
	 * java -Xms128m -Xmx2g MyApp
	 * 
	 * 会扔出两种类型异常
	 * java.lang.OutOfMemoryError: Java heap space
	 * java.lang.OutOfMemoryError: GC overhead limit exceeded
	 * 
	 * -Xms and -Xmx (or: -XX:InitialHeapSize and -XX:MaxHeapSize)
	 * 
	 * 最大堆内存过小可能会导致 ，GC能执行而抛出 GC overhead limit exceeded,但是这个异常是否抛出会因环境而异
	 * https://blog.csdn.net/renfufei/article/details/77585294
	 */
	public static void heapfull() {
		Set<StackSizeTest> l = new HashSet<>();
		while(true) {
			l.add(new StackSizeTest());
		}
	}
	
//	public static class 
}
