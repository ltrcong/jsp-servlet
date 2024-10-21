package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BEAN.KhachHang;
import DB.DBConnection;

public class KhachHangDAO 
{
	public static KhachHang KiemTraKhachHang(String email, String matkhau) {
	    Connection conn = DBConnection.CreateConnection();
	    PreparedStatement ptmt = null;
	    String sql = "select * from khachhang where email_kh = ? and mk_kh = ?";

	    try {
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, email);
	        ptmt.setString(2, matkhau);

	        ResultSet rs = ptmt.executeQuery();

	        if (rs.next()) {
	            
	            int id_kh = rs.getInt("id_kh");
	            String ten_kh = rs.getString("ten_kh");
	            String gioitinh_kh = rs.getString("gioitinh_kh");
	            String email_kh = rs.getString("email_kh");
	            String diachi_kh = rs.getString("diachi_kh");
	            String mk_kh = rs.getString("mk_kh");
	            int sdt_kh = rs.getInt("sdt_kh");
	            
	            KhachHang khachhang = new KhachHang();
	            khachhang.setId_kh(id_kh);
	            khachhang.setTen_kh(ten_kh);
	            khachhang.setGioitinh_kh(gioitinh_kh);
	            khachhang.setEmail_kh(email_kh);
	            khachhang.setDiachi_kh(diachi_kh);
	            khachhang.setMk_kh(mk_kh);
	            khachhang.setSdt_kh(sdt_kh);

	            return khachhang;
	        }
	        ptmt.close();
	        rs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return null;
	}

}

