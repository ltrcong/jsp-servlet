package ControllerSidebar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;

@WebServlet("/XoaSanPhamController")
public class XoaSanPhamController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;


    public XoaSanPhamController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String idParam = request.getParameter("id_sp");
		int id_sp = Integer.parseInt(idParam);
		SanPhamDAO.XoaSanPham(request,id_sp);
		RequestDispatcher rd = request.getRequestDispatcher("SanPhamForward");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
