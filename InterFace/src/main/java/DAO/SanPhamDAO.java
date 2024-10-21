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

public class SanPhamDAO 
{
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
	//Lấy sản phẩm theo id danh mục
	public static List<SanPham> LaySanPhamTheoIDDanhMuc(HttpServletRequest request, int iddm) 
	{
		Connection conn = DBConnection.CreateConnection();
		List<SanPham> ds_sp = new ArrayList<SanPham>();
		PreparedStatement ptmt = null;
		String sql = "select * from sanpham where id_dm = ?";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, iddm); // Đặt giá trị tìm kiếm vào câu truy vấn
			ResultSet rs = ptmt.executeQuery();
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
	//Chi tiết sản phẩm
	public static List<SanPham> ChiTietSanPham(HttpServletRequest request, int idsp) 
	{
		Connection conn = DBConnection.CreateConnection();
		List<SanPham> ds_sp = new ArrayList<SanPham>();
		PreparedStatement ptmt = null;
		String sql = "select * from sanpham where id_sp = ?";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, idsp);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				SanPham sp = new SanPham();
				
				//lấy dữ liệu từ result
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
				
				//thiết lập giá trị cho Sản Phẩm
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
		} 
		catch (Exception e) 
		{
			request.setAttribute("chitiet", e.getMessage());
		}
		return ds_sp;
	}
	
	public static SanPham LaySanPhamTheoID(int id) 
	{
		Connection conn = DBConnection.CreateConnection();
		PreparedStatement ptmt = null;
		SanPham sp = null;
		String sql = "select * from sanpham where id_sp = ?";
		
		try
		{
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			
			if(rs.next())
			{
				sp = new SanPham();
				
				//lấy dữ liệu từ result
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
				
				//thiết lập giá trị cho Sản Phẩm
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
			}
		}
		catch(Exception e)
		{
			
		}
		return sp;
	}
	public static void ThemHoaDon(KhachHang khachhang, GioHang giohang) {
	    Connection conn = DBConnection.CreateConnection();
	    PreparedStatement ptmt = null;

	    try {
	        // Insert order into the database
	        String sql = "INSERT INTO hoadon(ngaymua, id_kh, tongtien) VALUES (?, ?, ?)";
	        ptmt = conn.prepareStatement(sql);

	        // Set parameters for the order
	        LocalDate curDate = LocalDate.now();
	        String date = curDate.toString();
	        ptmt.setString(1, date);
	        ptmt.setInt(2, khachhang.getId_kh());
	        ptmt.setDouble(3, giohang.TongTien());

	        // Execute the update
	        ptmt.executeUpdate();

	        // Get the ID of the last inserted order
	        String sql1 = "SELECT id_hoadon FROM hoadon ORDER BY id_hoadon DESC LIMIT 1"; // Change the query based on your database
	        PreparedStatement ptmt1 = conn.prepareStatement(sql1);
	        ResultSet rs = ptmt1.executeQuery();
	        
	        if (rs.next()) {
	            int hoadon_id = rs.getInt("id_hoadon");

	            // Insert order details into the database
	            for (Item i : giohang.getItems()) {
	                String sql2 = "INSERT INTO chitiet_hoadon VALUES (?, ?, ?, ?)";
	                PreparedStatement ptmt2 = conn.prepareStatement(sql2);
	                ptmt2.setInt(1, hoadon_id);
	                ptmt2.setInt(2, i.getSanpham().getId_sp());
	                ptmt2.setInt(3, i.getSoluong());
	                ptmt2.setDouble(4, i.getGia());

	                // Execute the update
	                ptmt2.executeUpdate();
	            }

	            // Update product quantities
	            String sql3 = "UPDATE sanpham SET soluong = soluong - ? WHERE id_sp = ?";
	            PreparedStatement ptmt3 = conn.prepareStatement(sql3);
	            for (Item i : giohang.getItems()) {
	                ptmt3.setInt(1, i.getSoluong());
	                ptmt3.setInt(2, i.getSanpham().getId_sp());

	                // Execute the update
	                ptmt3.executeUpdate();
	            }
	        }
	        ptmt.close();
	        ptmt1.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
