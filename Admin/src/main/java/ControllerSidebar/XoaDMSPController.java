package ControllerSidebar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DMSanPhamDAO;

@WebServlet("/XoaDMSPController")
public class XoaDMSPController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public XoaDMSPController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String idParam = request.getParameter("id_dm");
		int id_dm = Integer.parseInt(idParam);
		DMSanPhamDAO.XoaDMSanPham(request,id_dm);
		RequestDispatcher rd = request.getRequestDispatcher("DanhMucSanPham");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}
