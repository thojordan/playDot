package cn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QxchisDao implements QxchisIn{
		
	@Override 
	public ArrayList<QxchisBean> findByPage(int page){
	        DBBean db = new DBBean();
	        int iNum=10;
	        int begin = (page-1) * iNum;
	        int end = begin+iNum;
	        //String sql = "select * from (select rownum rown,a.* from qxchis a where rownum <= "+end+") where rown>"+begin;
	        String sql = "select * from qxchis limit "+begin+","+end;
	        ResultSet rs = db.executeQuery(sql,null);
	        ArrayList<QxchisBean> list = new ArrayList<QxchisBean>();
	        try {
	            while(rs.next()){
	            	QxchisBean st = new QxchisBean();
	            	st.setQs(rs.getString("qs"));
	                st.setJieguo(rs.getString("jieguo"));
	                st.setBeizhu(rs.getString("beizhu"));	                
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
	        String sql = "select count(*) from qxchis";
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
	        String sql = "select count(*) from qxchis where jieguo='"+szRand+"'";
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

