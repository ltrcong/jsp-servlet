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
import BEAN.SanPham;
import DAO.DanhMucDAO;
import DAO.SanPhamDAO;

@WebServlet("/ChiTietSanPham")
public class ChiTietSanPham extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public ChiTietSanPham() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//Lấy sản phẩm theo idsp
		String idParam = request.getParameter("id_sp");
		int id_sp = Integer.parseInt(idParam);
		List<SanPham> ds_sp = SanPhamDAO.ChiTietSanPham(request, id_sp);
		//đổ danh sách danh mục sản phẩm vào Attribute
		request.setAttribute("ds_sp", ds_sp);
		
		//Lấy toàn bộ danh mục sản phẩm
		List<DanhMuc> dm_sp = DanhMucDAO.LayDanhMuc(request);
		//đổ danh sách danh mục sản phẩm vào Attribute
		request.setAttribute("dm_sp", dm_sp);
		
		RequestDispatcher rd = request.getRequestDispatcher("/View/InterFace/ChiTietSP.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
