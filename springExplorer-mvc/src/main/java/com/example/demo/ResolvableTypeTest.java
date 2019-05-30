package com.example.demo;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Type;
import java.util.Arrays;

public class ResolvableTypeTest {
    public static void main(String... s){
        c c0=new c();
        ResolvableType type= ResolvableType.forClass(c.class).as(a.class);

        Type[] types = c0.getClass().getGenericInterfaces();
    }
    interface a<T>{

    }
    interface b<E>{

    }
    public static class c implements a<String>,b<Integer>{

    }
}
