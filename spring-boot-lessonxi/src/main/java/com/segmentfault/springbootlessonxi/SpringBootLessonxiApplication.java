package com.segmentfault.springbootlessonxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
public class SpringBootLessonxiApplication {

//	private volatile int i;
//
//	private synchronized void lock(){
//
//		Lock lock = new ReentrantLock();
//		try{
//			lock.tryLock();
//		} finally {
//			lock.unlock();
//		}
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLessonxiApplication.class, args);

//		Integer i1 = new Integer(1);
//		Integer i2 = new Integer(1);
//		System.out.println(i1.hashCode());
//		System.out.println(i2.hashCode());
//
//		System.out.println(System.identityHashCode(i1));
//		System.out.println(System.identityHashCode(i2));
	}
}
