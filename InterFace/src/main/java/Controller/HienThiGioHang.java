package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.DanhMuc;
import DAO.DanhMucDAO;

@WebServlet("/HienThiGioHang")
public class HienThiGioHang extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public HienThiGioHang() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//Lấy toàn bộ danh mục sản phẩm
		List<DanhMuc> dm_sp = DanhMucDAO.LayDanhMuc(request);
		//đổ danh sách danh mục sản phẩm vào Attribute
		request.setAttribute("dm_sp", dm_sp);
				
		RequestDispatcher rd = request.getRequestDispatcher("View/InterFace/GioHang.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
