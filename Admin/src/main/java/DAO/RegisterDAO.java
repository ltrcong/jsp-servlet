package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import BEAN.ThanhVien;

public class RegisterDAO 
{
    public static boolean IsEmailExist(Connection conn, String email) 
    {
        PreparedStatement ptmt = null;
        ResultSet rs = null;

        String sql = "SELECT email_tv FROM thanhvien WHERE email_tv = ?";
        try 
        {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, email);
            rs = ptmt.executeQuery();
            if (rs.next()) 
            {
                return true; // Đã tồn tại email trong cơ sở dữ liệu
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        return false;
    }

    public static boolean InsertAccount(HttpServletRequest request, Connection conn, ThanhVien thanhvien) 
    {
        PreparedStatement ptmt = null;

        String sql = "insert into thanhvien (ten_tv, gioitinh_tv, email_tv, mk_tv) value (?, ?, ?, ?)";
        try 
        {
            ptmt = conn.prepareStatement(sql);

            String ten_tv = thanhvien.getTen_tv();
            String gioitinh_tv = thanhvien.getGioitinh_tv();
            String email_tv = thanhvien.getEmail_tv();
            String mk_tv = thanhvien.getMk_tv();

            ptmt.setString(1, ten_tv);
            ptmt.setString(2, gioitinh_tv);
            ptmt.setString(3, email_tv);
            ptmt.setString(4, mk_tv);

            if (IsEmailExist(conn, email_tv)) 
            {
                request.setAttribute("msg_register", "Email đã tồn tại trong cơ sở dữ liệu");
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
            request.setAttribute("msg_register", e.getMessage());
        }

        return false;
    }
}
