package com;

import java.sql.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Paichu {
	
	public static final String ALLNUM ="0123456789";
	String[] arrAll ={"0","1","2","3","4","6","7","8","9"};
	public static final String EVENNUM ="13579";
	public static final String ODDNUM ="02468";
	public static final String Little = "01234";
	public static final String Big = "56789";
	public static final String Zhi = "12357";
	public static final String He = "04689";
	public static DbDao dao = new DbDao();
		
	/**
	 * ȫ����
	 */
	public void listAllEven(){
		String s1,s2,s3,s4,s5,s6,s7;
		for(int j1=0;j1<5;j1++){
			s1= String.valueOf(EVENNUM.charAt(j1));
			for(int j2=0;j2<5;j2++){
				s2= String.valueOf(EVENNUM.charAt(j2));
				for(int j3=0;j3<5;j3++){
					s3= String.valueOf(EVENNUM.charAt(j3));
					for(int j4=0;j4<5;j4++){
						s4= String.valueOf(EVENNUM.charAt(j4));
						for(int j5=0;j5<5;j5++){
							s5= String.valueOf(EVENNUM.charAt(j5));
							for(int j6=0;j6<5;j6++){
								s6= String.valueOf(EVENNUM.charAt(j6));
								for(int j7=0;j7<5;j7++){
									s7= String.valueOf(EVENNUM.charAt(j7));
									//insert
									System.out.println(s1+s2+s3+s4+s5+s6+s7+" num:"+j1+j2+j3+j4+j5+j6+j7);
								}
							}
						}
					}
				}
			}
		}
		//System.out.println(sRt.toString());
	}
	
	/**
	 * ��������ȫ�桢ż����
	 * @param szOb ������ż��
	 */
	public void dealList(String szOb,String bj){
		int iLen = szOb.length();
		String s1,s2,s3,s4,s5,s6,s7;
		String sTmp;
		for(int j1=0;j1<iLen;j1++){
			s1= String.valueOf(szOb.charAt(j1));
			for(int j2=0;j2<iLen;j2++){
				s2= String.valueOf(szOb.charAt(j2));
				for(int j3=0;j3<iLen;j3++){
					s3= String.valueOf(szOb.charAt(j3));
					for(int j4=0;j4<iLen;j4++){
						s4= String.valueOf(szOb.charAt(j4));
						for(int j5=0;j5<iLen;j5++){
							s5= String.valueOf(szOb.charAt(j5));
							for(int j6=0;j6<iLen;j6++){
								s6= String.valueOf(szOb.charAt(j6));
								for(int j7=0;j7<iLen;j7++){
									s7= String.valueOf(szOb.charAt(j7));
									//insert
									sTmp = s1+s2+s3+s4+s5+s6+s7;
									try{
										dao.insert(sTmp,bj);
									}catch(Exception e){
										System.out.println(e.toString());
									}
									//System.out.println(s1+s2+s3+s4+s5+s6+s7+" num:"+j1+j2+j3+j4+j5+j6+j7);
								}
							}
						}
					}
				}
			}
		}
		dao.close();
		
	}
	
	/**
	 * 3λ˳��
	 */
	public void dealShunziDemo(){
		int iLen = ALLNUM.length();
		//����012
		String s1,s2,s3,s4,s5,s6,s7;
		String sTmp;
		for(int j1=0;j1<iLen;j1++){
			s1= String.valueOf(ALLNUM.charAt(j1));
			for(int j2=0;j2<iLen;j2++){
				s2= String.valueOf(ALLNUM.charAt(j2));
				for(int j3=0;j3<iLen;j3++){
					s3= String.valueOf(ALLNUM.charAt(j3));
					for(int j4=0;j4<iLen;j4++){
						s4= String.valueOf(ALLNUM.charAt(j4));
						sTmp = "012"+s1+s2+s3+s4;
						try{
							dao.insert(sTmp,"3");
						}catch(Exception e){
							System.out.println(e.toString());
							continue;
						}
					}
				}
			}
		}
	}
	
	/**
	 * ѭ��λ��
	 * @param szShun
	 */
	public void addLoopShunzi(){
		String szShun="0123";
		int iShun=Integer.parseInt(szShun);
		while(iShun<=6789){
			loopShunzi(szShun);
			iShun = iShun+1111;
			szShun = String.valueOf(iShun);
		}
		
	}
	
	/**
	 * ѭ��λ��
	 * @param szShun
	 */
	public void loopShunzi(String szShun){
		int iShunLen = szShun.length();
		int iCi = 7-iShunLen+1;
		for(int i=1;i<iCi;i++){
			dealShunzi(szShun,i);
		}
	}
	
	/**
	 * 4λ˳��
	 */
	public void dealShunzi(String szShun,int iSeq){
		int iLen = ALLNUM.length();
		
		//����0123
		String s1,s2,s3,s4,s5,s6,s7;
		String sTmp;
		for(int j1=0;j1<iLen;j1++){
			s1= String.valueOf(ALLNUM.charAt(j1));
			for(int j2=0;j2<iLen;j2++){
				s2= String.valueOf(ALLNUM.charAt(j2));
				for(int j3=0;j3<iLen;j3++){
					s3= String.valueOf(ALLNUM.charAt(j3));						
						switch(iSeq){
							case 1:sTmp = szShun+s1+s2+s3;break;
							case 2:sTmp = s1+szShun+s2+s3;break;
							case 3:sTmp = s1+s2+szShun+s3;break;
							case 4:sTmp = s1+s2+s3+szShun;break;
							case 5:sTmp = s1+s2+s3+szShun;break;
							default:sTmp="";break;
						}
						try{
							dao.insert(sTmp,"3");
						}catch(Exception e){
							System.out.println(e.toString());
							continue;
						}
					
				}
			}
		}
	}
	
	/**
	 * 7��λ��ȫѭ��
	 * @param szShun
	 * @param iSeq
	 */
	public void dealAllLoop(String szZu,String szFlag){
		int iLen = szZu.length();
		
		//����0123
		String s1,s2,s3,s4,s5,s6,s7;
		String sTmp;
		for(int j1=0;j1<iLen;j1++){
			s1= String.valueOf(szZu.charAt(j1));
			for(int j2=0;j2<iLen;j2++){
				s2= String.valueOf(szZu.charAt(j2));
				for(int j3=0;j3<iLen;j3++){
					s3= String.valueOf(szZu.charAt(j3));
					for(int j4=0;j4<iLen;j4++){
						s4= String.valueOf(szZu.charAt(j4));
						for(int j5=0;j5<iLen;j5++){
							s5= String.valueOf(szZu.charAt(j5));
							for(int j6=0;j6<iLen;j6++){
								s6= String.valueOf(szZu.charAt(j6));
								for(int j7=0;j7<iLen;j7++){
									s7= String.valueOf(szZu.charAt(j7));
									sTmp = s1+s2+s3+s4+s5+s6+s7;										
										try{
											dao.insert(sTmp,szFlag);
										}catch(Exception e){
											System.out.println(e.toString());
											continue;
										}
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * ��˳
	 * 1357
	 */
	public void dealEvenShun(){
		String szShun="1357";
		int iShun=Integer.parseInt(szShun);
		while(iShun<=3579){
			loopShunzi(szShun);
			iShun = iShun+2222;
			szShun = String.valueOf(iShun);
		}
	}
	
	/**
	 * ��˳
	 * 0246
	 */
	public void dealOddShun(){
		String szShun="0246";
		int iShun=Integer.parseInt(szShun);
		while(iShun<=2468){
			loopShunzi(szShun);
			iShun = iShun+2222;
			szShun = String.valueOf(iShun);
		}
	}
	
	/**
	 * ��n�����г�ȡm����
	 */
	public  void mTakeN(String s, int total, List lst) {
		for (int i = 0; i < lst.size(); i++) {
			//System.out.println("i="+i);
			List templst=new LinkedList(lst);
			String n =  (String) templst.remove(i);// ȡ����������
			String str = s + n;
			if (total == 1) {
				System.out.println(str);//����� n������ֻȡһ����ֱ�Ӱ�ȡ�����Ľ���������
				dealAllLoop(str,"8");			
			} else {
				int temp=total-1;//��ͬһ����total�������ܼ�,������ԭ�б����Ļ�����
				mTakeN(str, temp, templst);// �����temp�Լ�templst����ȫ�µı����ͼ���
			}
		}
		
	}
	
	/**
	 * ����ȫ������
	 */
	public void allData(){
		//ɾ������
		String sDel = "delete from qxcno";
		try{
			System.out.println("start...");
//			System.out.println("deleting data...");
//			dao.delete(sDel);
//			System.out.println("even data...");
//			dealList(EVENNUM,"1");
//			System.out.println("odd data...");
//			dealList(ODDNUM,"2");
//			System.out.println("shunzi data...");
//			addLoopShunzi();
			System.out.println("ȫС 01234...");
			dealList(Little,"4");
			System.out.println("ȫ�� 56789...");
			dealList(Big,"5");
			System.out.println("ȫ�� 12357...");
			dealList(Zhi,"6");
			System.out.println("ȫ�� 04689...");
			dealList(He,"7");
			System.out.println("��˳ 13579...");
			dealEvenShun();
			System.out.println("ż˳ 02468...");
			dealOddShun();
			//7�����г���3�ּ���������7����������4������
			System.out.println("7λ��3����...");
			List lst = Arrays.asList(arrAll);
			mTakeN("",3,lst);
			//Todo
			//
			System.out.println("end!");
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public List<Qxcno> getJieguo(){
		List<Qxcno> lRes = dao.getRes();
		return lRes;
	}

/**
 * @param args
 */
public static void main(String[] args) {
// TODO Auto-generated method stub

//double dAll=Math.pow(10, 7);
//long lAll = new Double(dAll).intValue();
//System.out.println("ȫ����"+lAll);
////������ż��
//long lEven = new Double(Math.pow(5,7)).intValue();
//System.out.println("ȫ������"+lEven);
//long lOdd = new Double(Math.pow(5,7)).intValue();
//System.out.println("ȫż����"+lOdd);
//long lRest = lAll - lEven - lOdd;
//System.out.println("ȥ��ȫ������ż����"+lRest);
////����9��
//long lBao=10;
////˳��5������
////01234,12345,23456,34567,45678,56789...���е���˳
////����һ�����
//long lSingleShunzi = 10*10*10*10;
//long lShunzi = lSingleShunzi*14;
//lRest = lRest - lBao-lShunzi;
//System.out.println("��ȥ�����ӡ�˳�ӣ�"+lRest);
	Paichu pc = new Paichu();
	//pc.allData();
	
//	System.out.println("odd data...");
//	pc.dealList(ODDNUM,"2");
//	pc.addLoopShunzi();
//	System.out.println("ȫС 01234...");
//	pc.dealList(Little,"4");
//	System.out.println("ȫ�� 56789...");
//	pc.dealList(Big,"5");
//	System.out.println("ȫ�� 12357...");
//	pc.dealList(Zhi,"6");
//	System.out.println("ȫ�� 04689...");
//	pc.dealList(He,"7");
//	System.out.println("��˳ 13579...");
//	pc.dealEvenShun();
//	System.out.println("ż˳ 02468...");
//	pc.dealOddShun();
	System.out.println("7λ��3����...");
	String[] arrAll ={"0","1","2","3","4","6","7","8","9"};
	List lst = Arrays.asList(arrAll);
	pc.mTakeN("",3,lst);
//	List<Qxcno> lTmp = pc.getJieguo();
//	System.out.println("testDb:"+lTmp.get(0).getJieGuo());
//	System.out.println(java.util.UUID.randomUUID().toString());
}

}