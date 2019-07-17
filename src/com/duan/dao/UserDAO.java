package com.duan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.duan.helper.JDBCHelper;
import com.duan.model.User;

public class UserDAO 
{
    public ArrayList<User> getAllUser() throws SQLException
    {
        ArrayList<User> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.executeQuery("SELECT * FROM USER");

        while (rs.next())
        {
        	User e = readFromResultSet(rs);
        	list.add(e);
        }
        return list;

    }
    
    public boolean insert(User user ) throws SQLException
    {
        String sql = "INSERT INTO USER Values(?, ?, ?, ?, ?, ?)";

        PreparedStatement pre = JDBCHelper.createPreparedStatement(sql,
									        		user.getUsername(), 
									        		user.getPassword(),
									        		user.getFullname(), 
									        		user.getDateOfBirth(),
									        		user.getEmail(),
									        		user.getPhoneNumber());
        
         int count = pre.executeUpdate();
         
         return count > 0;
    }
    
    public boolean update(User user , int id) throws SQLException
    {
        String sql = "UPDATE USER SET username=?, password=?, fullname=?,"
                + "date_of_birth=?, email=?, phone_number=? Where id=?";

        PreparedStatement pre = JDBCHelper.createPreparedStatement(sql, 
								        		user.getUsername(), 
								        		user.getPassword(), 
								        		user.getFullname(), 
								        		user.getDateOfBirth(),
								        		user.getEmail(), 
								        		user.getPhoneNumber());
        int count = pre.executeUpdate();
        return count > 0;
    }
    
    public boolean delete(int id) throws SQLException
    {
        String sql = "DELETE FROM USER Where id = ?";
        PreparedStatement pre;
        
        pre = JDBCHelper.createPreparedStatement(sql, id);
        int count = pre.executeUpdate();
        
        return count > 0;
    }
    
    public User findByID(int id) throws SQLException
    {
        String sql = "SELECT * FROM User where id = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, id);
        
        if (rs.next())
        {
        	return readFromResultSet(rs);
        }
        return null;
    }
    
    public User readFromResultSet(ResultSet rs) throws SQLException
    {
    	int id = rs.getInt(1);
    	String use = rs.getString(2);
    	String password = rs.getString(3);
    	String fullname = rs.getString(4);
    	Date dateOfBirth = rs.getDate(5);
    	String email = rs.getString(6);
    	String phoneNumber = rs.getString(7);
    	
    	return new User(id, use, password, fullname, dateOfBirth, email, phoneNumber);
    }
}
