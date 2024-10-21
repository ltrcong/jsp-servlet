package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.GioHang;
import BEAN.KhachHang;
import DAO.SanPhamDAO;

@WebServlet("/ThanhToanController")
public class ThanhToanController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public ThanhToanController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		GioHang giohang = null;

		Object obj = session.getAttribute("giohang");

		if (obj != null) 
		{
		    giohang = (GioHang) obj;
		} 
		else 
		{
		    giohang = new GioHang();
		}
		session.setAttribute("giohang", giohang);
		//Lấy đăng nhập của người dùng
		KhachHang khachhang = (KhachHang) session.getAttribute("taikhoan");

		if (khachhang != null) 
		{
		    try 
		    {
		        SanPhamDAO.ThemHoaDon(khachhang, giohang);
		        giohang = new GioHang();
		        session.setAttribute("giohang", giohang);
		        response.sendRedirect("HomeForward");
		    } catch (Exception e) {
		        e.printStackTrace(); 
		    }
		} 
		else 
		{
		    response.sendRedirect("HienThiGioHang");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
    }
}
