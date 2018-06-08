package com.wangsh.spring.beans.lookupmethod;

public class AsyncCommand extends Command{
	public AsyncCommand() {
		System.out.println(String.format("new AsyncCommand create"));
	}
	
	public static AsyncCommand createCommand() {
		System.out.println(String.format("new AsyncCommand create in static method"));
		return new AsyncCommand();
	}
}
