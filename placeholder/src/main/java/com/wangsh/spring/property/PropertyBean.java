package com.wangsh.spring.property;

import org.springframework.beans.factory.annotation.Value;

public class PropertyBean {


    /**
     * 通过配置文件注入的属性，必须由set方法，否则无法注入
     */
    private String helloWord;

    /**
     * 通过注解@value注入的属性，无须set方法
     */
    @Value("${onlyfun.caterpillar.helloWord2}")
    private String HelloWord2;
    /**
     * 通过注解@value注入的属性，无须set方法
     */
    @Value("${test.other}")
    private String other;


    public void setHelloWord(String helloWord) {
        this.helloWord = helloWord;
    }



    public void print(){
        System.out.println("helloWord="+helloWord);
        System.out.println("HelloWord2="+HelloWord2);
        System.out.println("other="+other);
    }
}
