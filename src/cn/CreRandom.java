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
	 * ���������������n����
	 * @param szIn ���飬�������
	 * @param szHow ��ȡ������
	 * @return
	 */
	public String creRand(char[] szIn,String szHow){
		String szResult = "",szRand="";
		szRand = new String(szIn);
		if(szHow!=null && szHow.length()>0){
			if(Integer.parseInt(szHow)>=szIn.length){
				return szRand;
			}else{
				int iLen,iHow;
				iHow = Integer.parseInt(szHow);
				java.util.Random random=new java.util.Random();// ���������
				int iRand;
				String oneChar="";
				for(int i=0;i<iHow;i++){
					iLen = szRand.length();
					iRand = random.nextInt(iLen);
					oneChar = String.valueOf(szRand.charAt(iRand));
					szResult +=oneChar;
					szRand = szRand.substring(0, iRand)+szRand.substring(iRand+1);
				}
				return szResult;
			}
		}else{
			return szRand;
		}
		
		
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
			String szRand = "",szRandPre="",szRandNext="";
			String szInclude ="";
			if(szIn1!=null && szIn1.length()>0){
				//1�����뵽�س������֣�����漰mѡn���Ƚ��
				//2������ȥ�����е����������ѡ��ʣ������֣����ظ���
				//3����1��2���ɵ�7λ�ַ����������λ�ã�����˳��
				//1�����뵽�س������֣�����漰mѡn���Ƚ��
				szInclude += szIn1;
				szInclude +=validStr(szIn2);
				szInclude +=validStr(szIn3);
				szInclude +=validStr(szIn4);
				szInclude +=validStr(szIn5);
				szRandPre = creRand(szInclude.toCharArray(),szHow);
				//2������ȥ�����е����������ѡ��ʣ������֣����ظ���
				String szBack = szAll.replace(szEx1, "").replace(szEx2, "");
				int iRest = 7-szRandPre.length();
				szRandNext = creRand(szBack.toCharArray(),String.valueOf(iRest));
				//3����1��2���ɵ�7λ�ַ����������λ�ã�����˳��
				String szRandRaw = szRandPre+szRandNext;
				szRand = creRand(szRandRaw.toCharArray(),"7");
			}else{			
				szRand = creRand(szEx1,szEx2);
			}
			
			//�Ƿ����ĳλ�ò��ó��ֵ��������
			if(szNo1!=null && szNo1.length()>0){
				if(szNo1.equals(String.valueOf(szRand.charAt(0)))){
					iCnt--;
					continue;
				}
			}
			if(szNo2!=null && szNo2.length()>0){
				if(szNo2.equals(String.valueOf(szRand.charAt(1)))){
					iCnt--;
					continue;
				}
			}
			if(szNo3!=null && szNo3.length()>0){
				if(szNo3.equals(String.valueOf(szRand.charAt(2)))){
					iCnt--;
					continue;
				}
			}
			if(szNo4!=null && szNo4.length()>0){
				if(szNo4.equals(String.valueOf(szRand.charAt(3)))){
					iCnt--;
					continue;
				}
			}
			if(szNo5!=null && szNo5.length()>0){
				if(szNo5.equals(String.valueOf(szRand.charAt(4)))){
					iCnt--;
					continue;
				}
			}
			if(szNo6!=null && szNo6.length()>0){
				if(szNo6.equals(String.valueOf(szRand.charAt(5)))){
					iCnt--;
					continue;
				}
			}
			if(szNo7!=null && szNo7.length()>0){
				if(szNo7.equals(String.valueOf(szRand.charAt(6)))){
					iCnt--;
					continue;
				}
			}
			//����λ�����ֲ������
			if(szPos1!=null && szPos1.length()>0 && szPos2!=null && szPos2.length()>0){
				String szFirst = String.valueOf(szRand.charAt(Integer.parseInt(szPos1)-1));
				String szSecond = String.valueOf(szRand.charAt(Integer.parseInt(szPos2)-1));
				if(szFirst.equals(szSecond)){
					iCnt--;
					continue;
				}
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
	
	/**
	 * ������Ч�ַ��������ж�ҳ��Ԫ���Ƿ�Ϊ��
	 * @param szInput �������
	 * @return
	 */
	public String validStr(String szInput){
		if(szInput!=null && szInput.length()>0){
			return szInput;
		}else{
			return "";
		}
	}
}