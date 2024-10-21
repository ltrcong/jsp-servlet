package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.sql.*;

import BEAN.DanhMuc;
import DB.DBConnection;

public class DanhMucDAO 
{
	public static List<DanhMuc> LayDanhMuc(HttpServletRequest request) 
	{
		Connection conn = DBConnection.CreateConnection();
		PreparedStatement ptmt = null;
		List<DanhMuc> ds_dm = new ArrayList<DanhMuc>();
		String sql = "select * from danhmuc";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) 
			{
				DanhMuc dm = new DanhMuc();
				//lấy dữ liệu từ Result
				int id_dm = rs.getInt("id_dm");
				String ten_dm = rs.getString("ten_dm");
				
				//thiết lập vào danh mục 
				dm.setId_dm(id_dm);
				dm.setTen_dm(ten_dm);
				
				ds_dm.add(dm);
			}
		} 
		catch (Exception e) 
		{
			request.setAttribute("danhmuc", e.getMessage());
		}
		return ds_dm;
	}
}
