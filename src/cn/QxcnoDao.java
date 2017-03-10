package cn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QxcnoDao implements QxcnoIn{
	@Override 
	public ArrayList<QxcnoBean> findByPage(int page){
	        DBBean db = new DBBean();
	        int iNum=10;
	        int begin = (page-1) * iNum;
	        int end = begin+iNum;
	        //String sql = "select * from (select rownum rown,a.* from qxcno a where rownum <= "+end+") where rown>"+begin;
	        String sql = "select * from qxcno limit "+begin+","+end;
	        ResultSet rs = db.executeQuery(sql,null);
	        ArrayList<QxcnoBean> list = new ArrayList<QxcnoBean>();
	        try {
	            while(rs.next()){
	            	QxcnoBean st = new QxcnoBean();
	                st.setJieguo(rs.getString("jieguo"));
	                st.setZhushi(rs.getString("zhushi"));	                
	                list.add(st);
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        db.close();
	        return list;
	    }
	    @Override 
	    public int userCount(){
	        DBBean db = new DBBean();
	        String sql = "select count(*) from qxcno";
	        ResultSet rs = db.executeQuery(sql, null);
	        int count = 0;
	        try {
	            rs.next();
	            count = rs.getInt(1);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        db.close();
	        return count;
	    }
	    
	    /**
	     * ÊÇ·ñ´æÔÚ
	     * @param szRand
	     * @return
	     */
	    public int existCount(String szRand){
	        DBBean db = new DBBean();
	        String sql = "select count(*) from qxcno where jieguo='"+szRand+"'";
	        ResultSet rs = db.executeQuery(sql, null);
	        int count = 0;
	        try {
	            rs.next();
	            count = rs.getInt(1);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        db.close();
	        return count;
	    }
	}
