package cn;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QxcExistDao {
	
	public int userCount(String szRand){
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
        return count;
    }
}
