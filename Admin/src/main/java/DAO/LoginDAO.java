package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import BEAN.ThanhVien;

public class LoginDAO 
{
	public static String AuthenticationMember(HttpServletRequest request, Connection conn,ThanhVien thanhvien)
	{
		 PreparedStatement ptmt = null;
		 String test="fail";
		 String sql = "select email_tv,mk_tv from thanhvien";
		 
		 try 
		 {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) 
			{ 
				String email_tv = rs.getString("email_tv");
				String mk_tv = rs.getString("mk_tv");
				
				if(thanhvien.getEmail_tv().equals(email_tv) && thanhvien.getMk_tv().equals(mk_tv)) 
				{
					test="success";
				}
			}
			
			ptmt.close();
			rs.close();
		 } 
		 catch (Exception e) 
		 {
			 request.setAttribute("msg_login", e.getMessage());
		 }
		 return test;
	}
	
	public static String Export_name_member(HttpServletRequest request, Connection conn,ThanhVien thanhvien) 
	{
		PreparedStatement ptmt = null;
		 
		 String sql = "select ten_tv from thanhvien where email_tv = '"+thanhvien.getEmail_tv()+"' and mk_tv ='"+thanhvien.getMk_tv()+"'";
		 String name = "";
		 
		 try 
		 {
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) 
			{
				name = rs.getString("ten_tv");
			}
			
			ptmt.close();
			rs.close();
		 } 
		 catch (Exception e) 
		 {
			 request.setAttribute("msg_login", e.getMessage());
		 }
		 return name;
	}
}
