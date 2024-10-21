package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.ThanhVien;
import DAO.LoginDAO;
import DB.DbConnection;

import java.sql.*;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
        
   
    public LoginController() 
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
		Connection conn = DbConnection.CreateConnection();
		
		String email_tv = request.getParameter("email_tv");
		String mk_tv = request.getParameter("mk_tv"); 
		
		ThanhVien tv = new ThanhVien();
		tv.setEmail_tv(email_tv);
		tv.setMk_tv(mk_tv);
		
		String name = LoginDAO.Export_name_member(request, conn, tv);
		
		String authentication = LoginDAO.AuthenticationMember(request, conn, tv);
		if(authentication.equals("success")) 
		{
			
			HttpSession session = request.getSession(true);
			session.setAttribute("session_name",name);
			
			
			request.setAttribute("msg_login","Chúc Mừng Bạn Đã Đăng Nhập Thành Công");
			RequestDispatcher rd = request.getRequestDispatcher("AdminForward");
			rd.forward(request, response);
		}
		else 
		{
			request.setAttribute("msg_login", "Bạn nhập sai Mật Khẩu hoặc Email Bạn cần nhập lại Mật Khẩu hoặc Email");
			RequestDispatcher rd = request.getRequestDispatcher("LoginForward");
			rd.forward(request, response);
		}
	}

}
