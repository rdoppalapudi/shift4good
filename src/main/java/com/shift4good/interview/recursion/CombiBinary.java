package com.shift4good.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombiBinary {
	
	private int A[];
	
	public CombiBinary(int n) {
		// TODO Auto-generated constructor stub
		A = new int[n];
	}
	
	public void computeBinaryString(int n){
		if (n<1){
			printArr();
		}else {
			A[n]=0;
			computeBinaryString(n-1);
			A[n]=1;
			computeBinaryString(n-1);
		}
	}
	
	public double div(int a, int b){
		return a * Math.pow(b, -1);
	}
	
	public void printArr(){
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]);
		}
		System.out.println("");
	}
	
	public static void main(String args[]){
		CombiBinary cb = new CombiBinary(4);
		cb.computeBinaryString(3);
		Object obj = new Object();
		obj.getClass();
		System.out.println(cb.div(3,4));
	}
	
	
	public List<Integer> findMissing(List<Integer> list){
		
		List<Integer> retList  = new ArrayList<Integer>();
				
		return retList;
		
	}

}
