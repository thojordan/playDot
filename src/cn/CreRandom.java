package cn;

import java.util.ArrayList;

public class CreRandom {
	
	public String szAll="0123456789";
	/**
	 * ����7���������0-9��
	 * ʹ����������
	 */
	public String creRand(){
		String szResult = "";
		java.util.Random random=new java.util.Random();// ���������
		int iRand;
		for(int i=0;i<7;i++){
			iRand = random.nextInt(10);
			szResult +=iRand;
		}
		return szResult;
	}
	
	/**
	 * ���ɳ�ȥ��������������
	 * @param szEx1
	 * @param szEx2
	 * @return
	 */
	public String creRand(String szEx1,String szEx2){
		String szResult = "",szRand="";
		szRand = new String(szAll);
		int iLen;
		if(szEx1!=null &&!szEx1.equalsIgnoreCase("")){
		    szRand = szRand.replace(szEx1, "");
		}
		if(szEx2!=null &&!szEx2.equalsIgnoreCase("")){
		    szRand = szRand.replace(szEx2, "");
		}
		iLen = szRand.length();
		java.util.Random random=new java.util.Random();// ���������
		int iRand;
		for(int i=0;i<7;i++){
			iRand = random.nextInt(iLen);
			szResult +=szRand.charAt(iRand);
		}
		return szResult;
	}
	
	/**
	 * ȥ�����֣���������
	 * @param szEx1
	 * @param szEx2
	 * @param szIn1
	 * @param szIn2
	 * @param szIn3
	 * @param szIn4
	 * @param szIn5
	 * @return
	 */
	public String creRand(String szEx1,String szEx2,String szIn1,String szIn2,String szIn3,String szIn4,String szIn5,String szHow){
		String szResult = "",szRand="";
		if(szHow!=null && szHow.equalsIgnoreCase("")){
			
		}else{
			
		}
		szRand = new String(szAll);
		int iLen;
		if(szEx1!=null &&!szEx1.equalsIgnoreCase("")){
		    szRand = szRand.replace(szEx1, "");
		}
		if(szEx2!=null &&!szEx2.equalsIgnoreCase("")){
		    szRand = szRand.replace(szEx2, "");
		}
		iLen = szRand.length();
		java.util.Random random=new java.util.Random();// ���������
		int iRand;
		for(int i=0;i<7;i++){
			iRand = random.nextInt(iLen);
			szResult +=szRand.charAt(iRand);
		}
		return szResult;
	}
	
	public ArrayList availNum(){
		ArrayList list = new ArrayList();
		QxcnoDao qxcnoDao = new QxcnoDao();
		QxchisDao qxchisDao = new QxchisDao();
		int iNo,iHis,iEx,iIn,iList;
		while(list.size()<6){
			String szRand = creRand();
			iNo = qxcnoDao.existCount(szRand);
			iHis = qxchisDao.existCount(szRand);
			if(iNo==0&&iHis==0){
				QxcnoBean st = new QxcnoBean();
                st.setJieguo(szRand);
                st.setZhushi("jieke");
				list.add(st);
				iList = list.size();
			}
		}
		return list;
	}
	
	public ArrayList availNum(String szEx1,String szEx2,String szIn1,String szIn2,String szIn3,String szIn4,String szIn5,String szHow,String szNo1,String szNo2,String szNo3,String szNo4,String szNo5,String szNo6,String szNo7,String szPos1,String szPos2){
		ArrayList list = new ArrayList();
		QxcnoDao qxcnoDao = new QxcnoDao();
		QxchisDao qxchisDao = new QxchisDao();
		int iNo,iHis,iEx1,iEx2,iIn1,iIn2,iList;
		int iCnt=0;
		while(list.size()<6){
			iCnt++;
			if(iCnt>100){
				//flow out
				break;
			}
			String szRand = "";
			String szInclude = "";
			if(szIn1!=null && szIn1.equalsIgnoreCase("")){
				//1�����뵽�س������֣�����漰mѡn���Ƚ��
				//2������ȥ�����е����������ѡ��ʣ������֣����ظ���
				//3����1��2���ɵ�7λ�ַ����������λ�ã�����˳��
				szInclude += szIn1;
			}else{			
				szRand = creRand(szEx1,szEx2);
//				if(szIn1!=null &&!szIn1.equalsIgnoreCase("")){
//					iIn1 = szRand.indexOf(szIn1);
//					if(iIn1<0){
//						continue;
//					}
//				}else{
//					iIn1 = 1;
//				}
//				if(szIn2!=null &&!szIn2.equalsIgnoreCase("")){
//					iIn2 = szRand.indexOf(szIn2);
//					if(iIn2<0){
//						continue;
//					}
//				}else{
//					iIn2 = 1;
//				}
			}
			iNo = qxcnoDao.existCount(szRand);
			if(iNo>0){
				continue;
			}
			iHis = qxchisDao.existCount(szRand);
			if(iHis>0){
				continue;
			}
			if(iNo==0&&iHis==0){
				QxcnoBean st = new QxcnoBean();
                st.setJieguo(szRand);
                st.setZhushi("jieke");
				list.add(st);
				iList = list.size();
			}
		}
		return list;
	}
}