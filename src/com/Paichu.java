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
	 * 全奇数
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
	 * 遍历新增全奇、偶数据
	 * @param szOb 奇数或偶数
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
	 * 3位顺子
	 */
	public void dealShunziDemo(){
		int iLen = ALLNUM.length();
		//例如012
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
	 * 循环位移
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
	 * 循环位移
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
	 * 4位顺子
	 */
	public void dealShunzi(String szShun,int iSeq){
		int iLen = ALLNUM.length();
		
		//例如0123
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
	 * 7个位置全循环
	 * @param szShun
	 * @param iSeq
	 */
	public void dealAllLoop(String szZu,String szFlag){
		int iLen = szZu.length();
		
		//例如0123
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
	 * 奇顺
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
	 * 奇顺
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
	 * 从n个数中抽取m个数
	 */
	public  void mTakeN(String s, int total, List lst) {
		for (int i = 0; i < lst.size(); i++) {
			//System.out.println("i="+i);
			List templst=new LinkedList(lst);
			String n =  (String) templst.remove(i);// 取出来的数字
			String str = s + n;
			if (total == 1) {
				System.out.println(str);//以最极端 n个里面只取一个，直接把取出来的结果输出即可
				dealAllLoop(str,"8");			
			} else {
				int temp=total-1;//在同一层中total总量不能减,不能再原有变量的基础上
				mTakeN(str, temp, templst);// 这里的temp以及templst都是全新的变量和集合
			}
		}
		
	}
	
	/**
	 * 处理全部数据
	 */
	public void allData(){
		//删除数据
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
			System.out.println("全小 01234...");
			dealList(Little,"4");
			System.out.println("全大 56789...");
			dealList(Big,"5");
			System.out.println("全质 12357...");
			dealList(Zhi,"6");
			System.out.println("全合 04689...");
			dealList(He,"7");
			System.out.println("奇顺 13579...");
			dealEvenShun();
			System.out.println("偶顺 02468...");
			dealOddShun();
			//7个数中出现3种及以下数（7个数中至少4种数）
			System.out.println("7位出3种数...");
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
//System.out.println("全部："+lAll);
////奇数、偶数
//long lEven = new Double(Math.pow(5,7)).intValue();
//System.out.println("全奇数："+lEven);
//long lOdd = new Double(Math.pow(5,7)).intValue();
//System.out.println("全偶数："+lOdd);
//long lRest = lAll - lEven - lOdd;
//System.out.println("去除全奇数、偶数："+lRest);
////豹子9个
//long lBao=10;
////顺子5个以上
////01234,12345,23456,34567,45678,56789...还有倒着顺
////其中一组计算
//long lSingleShunzi = 10*10*10*10;
//long lShunzi = lSingleShunzi*14;
//lRest = lRest - lBao-lShunzi;
//System.out.println("再去除豹子、顺子："+lRest);
	Paichu pc = new Paichu();
	//pc.allData();
	
//	System.out.println("odd data...");
//	pc.dealList(ODDNUM,"2");
//	pc.addLoopShunzi();
//	System.out.println("全小 01234...");
//	pc.dealList(Little,"4");
//	System.out.println("全大 56789...");
//	pc.dealList(Big,"5");
//	System.out.println("全质 12357...");
//	pc.dealList(Zhi,"6");
//	System.out.println("全合 04689...");
//	pc.dealList(He,"7");
//	System.out.println("奇顺 13579...");
//	pc.dealEvenShun();
//	System.out.println("偶顺 02468...");
//	pc.dealOddShun();
	System.out.println("7位出3种数...");
	String[] arrAll ={"0","1","2","3","4","6","7","8","9"};
	List lst = Arrays.asList(arrAll);
	pc.mTakeN("",3,lst);
//	List<Qxcno> lTmp = pc.getJieguo();
//	System.out.println("testDb:"+lTmp.get(0).getJieGuo());
//	System.out.println(java.util.UUID.randomUUID().toString());
}

}