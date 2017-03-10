package cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBBean {
    private Connection con;

    private PreparedStatement pstmt;
    private ResultSet rs;
    //oracle
    private String dbName ="XE";
    private String dbuser = "caipiao";
    private String dbpass ="newstar";
    //mysql
    private String dbscema ="lottery";
    private String mysqluser = "root";
    private String mysqlpass ="$newstar123";
    
    static{
        try{
            //Class.forName("oracle.jdbc.driver.OracleDriver");
        	Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
    }
    
    public void prepareConnection(){
        try{
            //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:"+dbName,dbuser,dbpass);
        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbscema+"?user="+mysqluser+"&password="+mysqlpass+"&useUnicode=true&characterEncoding=UTF8");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    //关闭连接
    public void close(){
            try {
                if(con!=null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            con = null;
            try {
                if(pstmt!=null)
                    pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pstmt = null;
    }
    //设置参数
    private void setParems(String[] parems){
        if(parems!=null){
            for(int i=0;i<parems.length;i++){
                try {
                    pstmt.setString(i+1, parems[i]);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    public ResultSet executeQuery(String sql,String[] parems){
        ResultSet res = null;
        prepareConnection();
        try {
            pstmt = con.prepareStatement(sql);
            setParems(parems);
            res = pstmt.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
        	
        }
        return res;
    }
}
