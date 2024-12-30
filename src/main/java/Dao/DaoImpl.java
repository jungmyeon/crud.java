package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Bean.bean;
import DBUtil.util;

public class DaoImpl implements Dao {
	private static Dao dao = new DaoImpl();
	
	public static Dao getdao() {
		return dao;
	}

	public void addInfo(bean bean1) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = util.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("insert into students (id,name,age,major) \n");
			con.setAutoCommit(false);
			sql.append("values (?,?,?,?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, bean1.getId());
			pstmt.setString(2, bean1.getName());
			pstmt.setInt(3,bean1.getAge());
			pstmt.setString(4, bean1.getMajor());
			if(pstmt.executeUpdate()>0) {
				System.out.println("insert Success!");
				con.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			}catch(Exception e1) {
				
			}finally {
				util.getInstance().close(pstmt,con);
			}
		}
	}

	public List<bean> searchInfo() {
		// TODO Auto-generated method stub
		List<bean>list = new ArrayList<bean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = util.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select id,name,age,major \n");
			sql.append("from students \n").append("order by id desc");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bean be = new bean();
				be.setId(rs.getInt("id"));
				be.setName(rs.getString("name"));
				be.setAge(rs.getInt("age"));
				be.setMajor(rs.getString("major"));
				list.add(be);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.getInstance().close(rs,pstmt,con);
		}
		return list;
	}

	public void modifyInfo(bean bean1) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = util.getInstance().getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder("update students \n");
			sql.append("set name = ?, age = ?, major = ? \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, bean1.getName());
			pstmt.setInt(2, bean1.getAge());
			pstmt.setString(3, bean1.getMajor());
			pstmt.setInt(4,bean1.getId());
			pstmt.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			util.getInstance().close(pstmt,conn);
		}
	}

	public void deleteInfo(int no) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = util.getInstance().getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder("delete from students \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			util.getInstance().close(pstmt,conn);
		}
	}
	
	
	
	
}
