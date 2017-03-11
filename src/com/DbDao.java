package com;

import java.sql.SQLException;   
import java.sql.Statement;   
import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;   
import java.util.ArrayList;   
import java.util.List;   
   
import com.Qxcno;   
   
public class DbDao {   
       
       
    private Statement stmt = null;   
    
    private PreparedStatement psmt = null;
       
    private  ResultSet rs = null;   
       
    private Connection conn = null;   
       
    public DbDao(){   
        this.getConnection();   
    }   
       
    /**
     * 获得连接
     */
    public void getConnection(){   
        try{   
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();    
            String url="jdbc:oracle:thin:@localhost:1521:orcl"; //orcl为数据库的SID    
            String user="caipiao";    
            String password="newstar";    
            conn= DriverManager.getConnection(url,user,password);    
        }catch (Exception e) {   
            System.out.println(e);   
        }   
    }   
       
    public List<Qxcno> getRes(){   
        List<Qxcno> list = new ArrayList<Qxcno>();    
        try {   
            stmt = conn.createStatement();   
            rs = stmt.executeQuery("select * from Qxcno");   
            while (rs.next()) {   
            	Qxcno t = new Qxcno();   
                t.setId(rs.getString(1));   
                t.setJieGuo(rs.getString(2));   
                list.add(t);   
            }   
        } catch (SQLException e) {   
            list = null ;   
            e.printStackTrace();   
        }finally{   
            this.close(conn, stmt, rs);   
        }   
        return list;   
    }
    
    public int insert(String szNum,String bj) throws SQLException{   
        String sql="insert into qxcno(id,jieguo,biaoji)values(?,?,?)";
    	int number = 0 ;   
        try{   
        	psmt = conn.prepareStatement(sql);   
        	psmt.setString(1, java.util.UUID.randomUUID().toString());
        	psmt.setString(2, szNum);
        	psmt.setString(3, bj);
        	//System.out.println("inserting "+szNum);
            number = psmt.executeUpdate();   
               
            conn.commit();   
        }catch(Exception e){   
            System.out.println(e);   
            conn.rollback();   
            number = 0 ;   
        }finally{   
        	psmt.close();
        	//this.close(conn, stmt, rs);   
        }   
        return number;   
    } 
       
    public int delete(String sql) throws SQLException{   
        int number = 0 ;   
        try{   
            stmt = conn.createStatement();   
               
            number = stmt.executeUpdate(sql);   
               
            conn.commit();   
        }catch(Exception e){   
            System.out.println(e);   
            conn.rollback();   
            number = 0 ;   
        }finally{   
            this.close(conn, stmt, rs);   
        }   
        return number;   
    }   
       
    public void close(Connection conn , Statement stmt, ResultSet rs){   
        try{   
            if(rs != null){   
                rs.close();   
                rs = null ;   
            }   
            if(stmt != null){   
                stmt.close();   
                stmt = null ;   
            }   
            if(conn != null){   
                conn.close();   
                conn = null;   
            }   
               
        }catch(Exception e){   
            System.out.println(e);   
        }   
    }   
    
    public void close(){   
        try{   
            if(rs != null){   
                rs.close();   
                rs = null ;   
            }   
            if(stmt != null){   
                stmt.close();   
                stmt = null ;   
            }   
            if(psmt != null){   
            	psmt.close();   
            	psmt = null ;   
            } 
            if(conn != null){   
                conn.close();   
                conn = null;   
            }   
               
        }catch(Exception e){   
            System.out.println(e);   
        }   
    }  
       
} 
