package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FullPermutation {//ȫ�������
	private int n;
	public FullPermutation ()
	{
		this.n=0;
	}
	public  void listAll(List candidate,String prefix)
	{
		
		if(candidate.isEmpty())
		{
			System.out.println(prefix);
			this.n++;
		}
		for(int i=0;i<candidate.size();i++)
		{
			List temp=new LinkedList(candidate);//ת����linkList,�Ƴ�һ���������ڲ�Ӱ��ԭ�����еĻ����ϵ�
		    String s1=prefix+temp.remove(i);//���ڱ�������������ɵĽ��
			listAll(temp,s1);//ע�⣬����temp��s1����ȫ�µļ��Ϻ��ַ�����������һֱ��һ�����������в���
			
		}
		
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public static void main(String[] args) {
		String []arr={"1","2","3","4"};
		FullPermutation f=new FullPermutation();
		f.listAll(Arrays.asList(arr),"");
		System.out.println("���е����и�����"+f.getN());
	}

}

