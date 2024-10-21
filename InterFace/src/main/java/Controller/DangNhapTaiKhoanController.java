package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.KhachHang;
import DAO.KhachHangDAO;

@WebServlet("/DangNhapTaiKhoanController")
public class DangNhapTaiKhoanController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public DangNhapTaiKhoanController() 
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
    {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		String email_kh = request.getParameter("email_kh");
		String mk_kh = request.getParameter("mk_kh");
		
		KhachHang khachhang =  KhachHangDAO.KiemTraKhachHang(email_kh,mk_kh);
		
		
		if(khachhang != null)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("taikhoan", khachhang);
			
			request.setAttribute("msg_dangnhap","Chúc Mừng Bạn Đã Đăng Nhập Thành Công");
			RequestDispatcher rd = request.getRequestDispatcher("HomeForward");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msg_dangnhap", "Bạn nhập sai Mật Khẩu hoặc Email Bạn cần nhập lại Mật Khẩu hoặc Email");
			RequestDispatcher rd = request.getRequestDispatcher("DangNhapTaiKhoanForward");
			rd.forward(request, response);
		}
	}

}
