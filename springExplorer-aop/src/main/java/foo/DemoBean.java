package foo;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
//@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class DemoBean {
	
//	@Autowired
//	Test test;
	
	public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Run");
//		test.run();
	}
}
