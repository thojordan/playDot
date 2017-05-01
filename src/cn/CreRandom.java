package cn;

import java.util.ArrayList;

public class CreRandom {
	
	public String szAll="0123456789";
	/**
	 * 生成7个随机数（0-9）
	 * 使用数字生成
	 */
	public String creRand(){
		String szResult = "";
		java.util.Random random=new java.util.Random();// 定义随机类
		int iRand;
		for(int i=0;i<7;i++){
			iRand = random.nextInt(10);
			szResult +=iRand;
		}
		return szResult;
	}
	
	/**
	 * 生成除去传入参数的随机数
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
		java.util.Random random=new java.util.Random();// 定义随机类
		int iRand;
		for(int i=0;i<7;i++){
			iRand = random.nextInt(iLen);
			szResult +=szRand.charAt(iRand);
		}
		return szResult;
	}
	
	/**
	 * 从数组中随机生成n个数
	 * @param szIn 数组，输入参数
	 * @param szHow 抽取几个数
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
				java.util.Random random=new java.util.Random();// 定义随机类
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
				//1、凑齐到必出的数字，如果涉及m选n，先解决
				//2、再抛去不能有的数字中随机选出剩余的数字（可重复）
				//3、在1、2生成的7位字符串中随机其位置，打乱顺序
				//1、凑齐到必出的数字，如果涉及m选n，先解决
				szInclude += szIn1;
				szInclude +=validStr(szIn2);
				szInclude +=validStr(szIn3);
				szInclude +=validStr(szIn4);
				szInclude +=validStr(szIn5);
				szRandPre = creRand(szInclude.toCharArray(),szHow);
				//2、再抛去不能有的数字中随机选出剩余的数字（可重复）
				String szBack = szAll.replace(szEx1, "").replace(szEx2, "");
				int iRest = 7-szRandPre.length();
				szRandNext = creRand(szBack.toCharArray(),String.valueOf(iRest));
				//3、在1、2生成的7位字符串中随机其位置，打乱顺序
				String szRandRaw = szRandPre+szRandNext;
				szRand = creRand(szRandRaw.toCharArray(),"7");
			}else{			
				szRand = creRand(szEx1,szEx2);
			}
			
			//是否存在某位置不该出现的数字情况
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
			//两个位置数字不能相等
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
	 * 返回有效字符，用于判断页面元素是否为空
	 * @param szInput 输入参数
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