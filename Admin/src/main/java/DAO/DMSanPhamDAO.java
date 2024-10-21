package DAO;

import javax.servlet.http.HttpServletRequest;

import BEAN.DMSanPham;
import DB.DbConnection;

import java.sql.*;
import java.util.*;

public class DMSanPhamDAO 
{
	public static List<DMSanPham> LayToanBoDMSanPham(HttpServletRequest request) 
	{
		
		Connection conn = DbConnection.CreateConnection();
		List<DMSanPham> list_dm_spDAO = new ArrayList<DMSanPham>();
		
		PreparedStatement ptmt = null;
		
        String sql = "SELECT * FROM danhmuc";

        try 
        {
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			//Nếu để cái ở ngoài vong while, khởi tạo này chỉ lấy cái cuối cùng
			//DMSanPham dm_sp = new DMSanPham();
			if(rs.isBeforeFirst())
			{
				while(rs.next()) 
				{
					DMSanPham dm_sp = new DMSanPham();
					//Lấy dữ liệu từ ResultSet và thiết lập các thuộc tính cho đối tượng Danh Mục Sản Phẩm
					int id_dm = rs.getInt("id_dm");
					String ten_dm = rs.getString("ten_dm");
					
					dm_sp.setId_dm(id_dm);
					dm_sp.setTen_dm(ten_dm);
					
					list_dm_spDAO.add(dm_sp);
				}
			}
			else 
			{
				request.setAttribute("msg_DMSP", list_dm_spDAO);
			}
			conn.close();		
			ptmt.close();
			rs.close();
		}
        catch (Exception e) 
        {
			request.setAttribute("msg_DMSP", e.getMessage());
		}
        return list_dm_spDAO;
	}
	//Kiểm tra tên có bị trùng không
		public static boolean KiemTraTenTrung(String ten_dm) 
		{
			Connection conn = DbConnection.CreateConnection();
			
			PreparedStatement ptmt = null;
	        ResultSet rs = null;
	        String sql = "SELECT ten_dm FROM danhmuc WHERE ten_dm = ?";
	        try 
	        {
	        	ptmt = conn.prepareStatement(sql);
	        	ptmt.setString(1, ten_dm);
	            rs = ptmt.executeQuery();
	            if (rs.next()) 
	            {
	                return true; // Đã tồn tại ID danh mục trong cơ sở dữ liệu
	            }
			} 
	        catch (Exception e) 
	        {
	        	
			}
	        return false;
		}
	//Thêm danh mục sản phẩm
	public static boolean ThemDanhMucSanPham(HttpServletRequest request, DMSanPham dmsp) 
	{
	    Connection conn = DbConnection.CreateConnection();
	    PreparedStatement ptmt = null;

	    String sql = "INSERT INTO danhmuc (ten_dm) VALUES (?)";

	    try 
	    {
	        ptmt = conn.prepareStatement(sql);

	        // Lấy dữ liệu từ BEAN
	        String ten_dm = dmsp.getTen_dm();

	        ptmt.setString(1, ten_dm);

	        if (KiemTraTenTrung(ten_dm)) 
	        {
	            request.setAttribute("msg_SuaDMSP", "Tên Sản Phẩm này đã tồn tại trong cơ sở dữ liệu");
	            return false;
	        }

	        int kq = ptmt.executeUpdate();
	        if (kq != 0) 
	        {
	            return true;
	        }
	    } 
	    catch (Exception e) 
	    {
	        request.setAttribute("msg_themDMSP", e.getMessage());
	        // Handle the exception or log it here for debugging
	    }

	    return false;
	}
	//Lấy Danh Mục Sản Phẩm Theo ID
	public static List<DMSanPham> LayToanDMSPTheoID(HttpServletRequest request,int iddm)
	{
		Connection conn = DbConnection.CreateConnection();
		List<DMSanPham> list_dmsp = new ArrayList<DMSanPham>();

        PreparedStatement ptmt = null;

        String sql = "SELECT * FROM danhmuc WHERE id_dm = ?";
        
        try 
		{
        	ptmt = conn.prepareStatement(sql);
        	ptmt.setInt(1, iddm); // Đặt giá trị tìm kiếm vào câu truy vấn
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				DMSanPham dmsp = new DMSanPham();
				//Lấy dữ liệu từ ResultSet và thiết lập các thuộc tính cho đối tượng danh mục sanpham
				
			    int id_dm = rs.getInt("id_dm");
			    String ten_sp = rs.getString("ten_dm");
			    // Thiết lập các thuộc tính cho đối tượng danh mục san pham
			    
			    dmsp.setId_dm(id_dm);
			    dmsp.setTen_dm(ten_sp);

				list_dmsp.add(dmsp);
			}
			conn.close();
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			request.setAttribute("msg_DMSP", e.getMessage());
		}
        return list_dmsp;
	}
	//Sửa Sản Phẩm 
	public static boolean SuaDMSanPham(HttpServletRequest request,int id_dm,String ten_dm)
	{
		Connection conn = DbConnection.CreateConnection();
	    PreparedStatement ptmt = null;

	    String sql = "UPDATE danhmuc SET ten_dm=? WHERE id_dm=?";
	    try 
	    {
	    	ptmt = conn.prepareStatement(sql);
	    	ptmt.setString(1, ten_dm);
	    	ptmt.setInt(2, id_dm);
	    	if (KiemTraTenTrung(ten_dm)) 
	        {
	            request.setAttribute("msg_SuaDMSP", "Tên Sản Phẩm này đã tồn tại trong cơ sở dữ liệu");
	            return false;
	        }

	        int kq = ptmt.executeUpdate();
	        if (kq != 0) 
	        {
	            return true;
	        }
	        conn.close();
			ptmt.close();
		} 
	    catch (Exception e) 
	    {
	    	
		}
	    return false;
	}
	//xóa sản phẩm
	public static void XoaDMSanPham(HttpServletRequest request,int id_dm) 
	{
		Connection conn = DbConnection.CreateConnection();
		PreparedStatement ptmt = null;
		String sql = "DELETE FROM danhmuc WHERE id_dm = " +id_dm;
		    
		try 
		{
		    ptmt = conn.prepareStatement(sql);
		    ptmt.executeUpdate();
		} 
		catch (Exception e) 
		{
		    request.setAttribute("msg_dmsp", e.getMessage());
		}
	}
}
