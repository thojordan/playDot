package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class comAn {
	private int all;
	public comAn()
	{
		this.all=0;
	}
	public int getAll() {
		return all;
	}
	public void setAll(int all) {
		this.all = all;
	}
	public static void main(String[] args) {
		String[] n ={"1","2","3","4"};
		//String[] n ={"0","1","2","3","4","6","7","8","9"};
		comAn m=new comAn();
		List lst = Arrays.asList(n);
        m.take("",3,lst);
        System.out.println(m.getAll());
	}

	public  void take(String s, int total, List lst) {
		for (int i = 0; i < lst.size(); i++) {
			//System.out.println("i="+i);
			List templst=new LinkedList(lst);
			String n =  (String) templst.remove(i);// ȡ����������
			String str = s + n;
			if (total == 1) {
				System.out.println(str);//����� n������ֻȡһ����ֱ�Ӱ�ȡ�����Ľ���������
				//total=all;
				all++;
			
			} else {
				int temp=total-1;//��ͬһ����total�������ܼ�,������ԭ�б����Ļ�����
				take(str, temp, templst);// �����temp�Լ�templst����ȫ�µı����ͼ���
			}
		}
		
	}

}
