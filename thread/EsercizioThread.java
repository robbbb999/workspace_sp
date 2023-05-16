package com.esercizio.thread;

import java.util.ArrayList;
import java.util.List;

public class EsercizioThread {

	public static void main(String[] args) {
		P1 piuno = new P1('A');
		P2 pidue = new P2('B');
		Thread T1 = new Thread(piuno);
		Thread T2 = new Thread(pidue);
		List<Integer> lista1 =new ArrayList<>();
		List<Integer> lista2 =new ArrayList<>();
		
		long a=System.currentTimeMillis();
		for(int i=0; i<1000000;i++) {
			lista1.add(i+1);
			//System.out.println(lista1.get(i));
			
		}
		
		for(int i=0; i<1000000;i++) {
			lista2.add(i+1);
			//System.out.println(lista2.get(i));
			
		}
		long b=System.currentTimeMillis();
		System.out.println(b-a);
		long c=System.currentTimeMillis();
		T1.start();
		T2.start();
		//System.out.println("Thread A e B startati");
		
		try {
			T1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				T2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		long d=System.currentTimeMillis();
		System.out.println((d-c));
		
		
		

	}
	
	static class P1 implements Runnable{
		private char ch;
		private List<Integer> li;
		public P1(char c) {
			this.ch=c;
		}
	
		@Override
		public void run() {
			li=new ArrayList<Integer>();
			for(int i=0; i<1000000;i++) {
				li.add(i+1);
				//System.out.println("thread corrente A: "+ Thread.currentThread()+" elemento "+ li.get(i));
			}
			
		}
	}
	
	static class P2 implements Runnable{
		private char ch;
		private List<Integer> li;
		
		public P2(char c) {
			this.ch=c;
		}
		@Override
		public void run() {
			
			li=new ArrayList<Integer>();
			for(int i=0; i<1000000;i++) {
				li.add(i+1);
				//System.out.println("thread corrente B: "+ Thread.currentThread()+" elemento "+ li.get(i));
			}
			
		}
	}

}
