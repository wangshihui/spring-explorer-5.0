package com.wangsh.spring.propertyTest;

import com.wangsh.spring.property.PropertyBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from "classpath:/app-config.xml"
@ContextConfiguration("/beans-config.xml")
@ActiveProfiles("dev")
public class HelloBeanTest {
    @Autowired
    PropertyBean helloBean;

    @Test
    public void print(){
        helloBean.print();
    }
}

