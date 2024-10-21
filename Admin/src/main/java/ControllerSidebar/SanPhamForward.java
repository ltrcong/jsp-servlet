package ControllerSidebar;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;
import BEAN.SanPham;

@WebServlet("/SanPhamForward")
public class SanPhamForward extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public SanPhamForward() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String pageidstr = request.getParameter("pageid");
		int pageid = Integer.parseInt(pageidstr);
		int dem = 3;
		// nếu pageid = 1 thì sẽ không phân trang
		// nếu pageid != 1 thì sẽ phân trang
		if(pageid == 1) 
		{
			
		}
		else 
		{
			pageid = pageid -1;
			pageid = pageid * dem +1;
		}
		List<SanPham> list_sp = SanPhamDAO.LayToanBoSanPham(request, pageid-1, dem);
		
		int tonghang = SanPhamDAO.demsoluongbang();
		int maxpageid = tonghang / dem + 1;
		
		
		//đổ vào 1 cái setAtr
		request.setAttribute("list_sp", list_sp);
		request.setAttribute("maxpageid", maxpageid);
		request.setAttribute("numberpageid", Integer.parseInt(pageidstr));
		RequestDispatcher rd = request.getRequestDispatcher("/View/Admin/Sidebar/SanPham.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
