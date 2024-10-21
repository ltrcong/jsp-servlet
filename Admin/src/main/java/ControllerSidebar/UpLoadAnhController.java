package ControllerSidebar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;

@WebServlet("/UpLoadAnhController")
public class UpLoadAnhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UpLoadAnhController() 
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
		
		String idsp = request.getParameter("id_sp");
		int id_sp = Integer.parseInt(idsp);

		String test = SanPhamDAO.Uploadfile(request, response,id_sp);
		if(test.equals("success"))
		{
			request.setAttribute("msg_themSP","Thêm Ảnh Thành Công");
			request.setAttribute("id_sp", id_sp);
			/*mỗi khi reload lại trang thì phải cập nhật lại cái request.setAttribute("id_sp", id_sp); 
			 * nếu không set thì bị mất giá trị và bị lỗi null
			 * */
			RequestDispatcher rd = request.getRequestDispatcher("ThemSanPhamForward");
			rd.forward(request, response);
		}
		else if(test.equals("tontai"))
		{
			request.setAttribute("msg_UpLoad","Thêm Ảnh Thất Bại,Ảnh Này Đã Tồn Tại");
			request.setAttribute("id_sp", id_sp);
			/*mỗi khi reload lại trang thì phải cập nhật lại cái request.setAttribute("id_sp", id_sp); 
			 * nếu không set thì bị mất giá trị và bị lỗi null
			 * */
			RequestDispatcher rd = request.getRequestDispatcher("UpLoadAnhForward");
			rd.forward(request, response);
		}
		else if(test.equals("thieu"))
		{
			request.setAttribute("msg_UpLoad","Bạn Thiếu enctypr: multipart/form-data , Cần Thêm Vào Bên JSP");
			request.setAttribute("id_sp", id_sp);
			/*mỗi khi reload lại trang thì phải cập nhật lại cái request.setAttribute("id_sp", id_sp); 
			 * nếu không set thì bị mất giá trị và bị lỗi null
			 * */
			RequestDispatcher rd = request.getRequestDispatcher("UpLoadAnhForward");
			rd.forward(request, response);
		}
		else 
		{
			request.setAttribute("msg_UpLoad","Thêm Ảnh Thất Bại");
			request.setAttribute("id_sp", id_sp);
			/*mỗi khi reload lại trang thì phải cập nhật lại cái request.setAttribute("id_sp", id_sp); 
			 * nếu không set thì bị mất giá trị và bị lỗi null
			 * */
			RequestDispatcher rd = request.getRequestDispatcher("UpLoadAnhForward");
			rd.forward(request, response);
		}
	}

}
