package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BEAN.GioHang;
import BEAN.HoaDon;
import BEAN.Item;
import BEAN.KhachHang;
import BEAN.SanPham;
import DB.DBConnection;

public class GioHangDAO 
{
	public static String KiemTraKhachHang(HttpServletRequest request, KhachHang khachhang)
	{
		Connection conn = DBConnection.CreateConnection();
		String test="fail";
		PreparedStatement ptmt = null;
        String sql = "select * from khachhang ";
        try 
        {
        	ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				while(rs.next()) 
				{ 
					String email_kh = rs.getString("email_tv");
					String mk_kh = rs.getString("mk_tv");
					
					if(khachhang.getEmail_kh().equals(email_kh) && khachhang.getMk_kh().equals(mk_kh)) 
					{
						test="success";
					}
				}
				
				ptmt.close();
			}
			
		} 
        catch (Exception e) 
        {
			
		}
		return test;
	}
	public static String XuatTenKhachHang(HttpServletRequest request,KhachHang khachhang) 
	{
		Connection conn = DBConnection.CreateConnection();
		PreparedStatement ptmt = null;
		String sql = "select ten_kh from thanhvien where email_kh = '"+khachhang.getEmail_kh()+"' and mk_kh ='"+khachhang.getMk_kh()+"'";
		String name = "";
		 
		try 
		{
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) 
			{
				name = rs.getString("ten_kh");
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
	public static void ThemHoaDon(HoaDon hoadon,GioHang giohang) 
	{
		//Lấy ngày hiện thời
		LocalDate curDate = LocalDate.now();
		String date = curDate.toString();
		
		Connection conn = DBConnection.CreateConnection();
		PreparedStatement ptmt = null;
		String sql = "insert into hoadon(id_hoadon,ngaymua,id_kh,tongtien) value (?,?,?,?)";
		
		try 
		{
			//Thêm hóa đơn vào database 
			ptmt = conn.prepareStatement(sql);
			
			int id_hoadon = hoadon.getId_hoadon();
			int id_kh = hoadon.getId_kh();
			double tongtien = hoadon.getTongtien();
			
			ptmt.setInt(1, id_hoadon);
			ptmt.setString(2, date);
			ptmt.setInt(3, id_kh);
			ptmt.setDouble(4, tongtien);
			
			ptmt.executeUpdate();
			
			//Lấy id hóa đơn vừa thêm vào 
			String sql1 = "select top 1 id_hoadon from hoadon order id_hoadon desc";
			PreparedStatement ptmt1 = conn.prepareStatement(sql1);
			ResultSet rs = ptmt1.executeQuery();
			//Thêm vào bảng chi tiết hóa đơn
			if(rs.next())
			{
				int hoadon_id = rs.getInt(1);
				for(Item i:giohang.getItems())
				{
					String sql2 = "insert into chitiet_hoadon value(?,?,?,?)";
					PreparedStatement ptmt2 = conn.prepareStatement(sql2);
					ptmt2.setInt(1, hoadon_id);
					ptmt2.setInt(2, i.getSanpham().getId_sp());
					ptmt2.setInt(3, i.getSoluong());
					ptmt2.setDouble(4, i.getGia());
				}
			}
			//Cập nhật lại số lượng sản phẩm
			String sql3 = "update sanpham set soluong = soluong-? where id_sp = ?";
			PreparedStatement ptmt3 = conn.prepareStatement(sql3);
			for(Item i:giohang.getItems())
			{
				ptmt3.setInt(1, i.getSoluong());
				ptmt3.setInt(2, i.getSanpham().getId_sp());
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
	}
	//Lấy toàn bộ sản phẩm 
	public static List<SanPham> LaySanPham(HttpServletRequest request) 
	{
		Connection conn = DBConnection.CreateConnection();
		List<SanPham> ds_sp = new ArrayList<SanPham>();
		PreparedStatement ptmt = null;
		String sql = "select * from sanpham";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery(sql);
			
			while (rs.next()) 
			{
				SanPham sp = new SanPham();
				
				//Lấy dữ liệu từ Result và thiết lập nó vào lớp Sản Phẩm Bean
				int id_sp = rs.getInt("id_sp");
				int id_dm = rs.getInt("id_dm");
				String ten_sp = rs.getString("ten_sp");
				String anh_sp = rs.getString("anh_sp");
				double gia_sp = rs.getDouble("gia_sp");
				String baohanh = rs.getString("baohanh");
				String phukien = rs.getString("phukien");
				String tinhtrang = rs.getString("tinhtrang");
				String khuyenmai = rs.getString("khuyenmai");
				String trangthai = rs.getString("trangthai");
				int dacbiet = rs.getInt("dacbiet");
				String chitiet_sp = rs.getString("chitiet_sp");
				
				//Thiết lập thuộc tính cho sản phẩm 
				sp.setId_sp(id_sp);
				sp.setId_dm(id_dm);
				sp.setTen_sp(ten_sp);
				sp.setAnh_sp(anh_sp);
				sp.setGia_sp(gia_sp);
				sp.setBaohanh(baohanh);
				sp.setPhukien(phukien);
				sp.setTinhtrang(tinhtrang);
				sp.setKhuyenmai(khuyenmai);
				sp.setTrangthai(trangthai);
				sp.setDacbiet(dacbiet);
				sp.setChitiet_sp(chitiet_sp);
				
				ds_sp.add(sp);
			}
			conn.close();
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			request.setAttribute("lay_sp",e.getMessage());
		}
		return ds_sp;
	}
}
