package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.ThanhVien;
import DAO.RegisterDAO;
import DB.DbConnection;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public RegisterController() 
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
		
		if(request.getCharacterEncoding()==null) {	
			request.setCharacterEncoding("UTF-8");
		}
		Connection conn = DbConnection.CreateConnection();
		
		//lấy dữ liệu từ form
		String name = request.getParameter("name");
		String giotinh = request.getParameter("gioitinh");
		String email = request.getParameter("email");
		String matkhau = request.getParameter("matkhau");
		String nhaplai_matkhau = request.getParameter("nhaplai_matkhau");
		
			
		
		ThanhVien  thanhvien = new ThanhVien();
		
		thanhvien.setTen_tv(name);
		thanhvien.setGioitinh_tv(giotinh);
		thanhvien.setEmail_tv(email);
		thanhvien.setMk_tv(matkhau);
		
		
		
		if(matkhau != null && matkhau.equals(nhaplai_matkhau)) 
		{
			boolean test = RegisterDAO.InsertAccount(request, conn, thanhvien);
			if(test) 
			{
				request.setAttribute("msg_register","Chúc Mừng Bạn Đã Đăng Ký Thành Công");
				RequestDispatcher rd = request.getRequestDispatcher("RegisterForward");
				rd.forward(request, response);
			} 
			else
			{
				request.setAttribute("msg_register", "Bạn Đăng Ký Không Thành Công");
				RequestDispatcher rd = request.getRequestDispatcher("RegisterForward");
				rd.forward(request, response);
			}
			
		}
		else 
		{
			request.setAttribute("msg_register", "Bạn Nhập Mật Khẩu và Nhập Lại Mật Khẩu Trùng Nhau hoặc Không Được Để Trống");
			RequestDispatcher rd = request.getRequestDispatcher("RegisterForward");
			rd.forward(request, response);
		}
		
	}
}
