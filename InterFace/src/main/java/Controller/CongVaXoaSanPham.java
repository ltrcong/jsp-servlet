package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.GioHang;
import BEAN.Item;
import BEAN.SanPham;
import DAO.SanPhamDAO;

@WebServlet("/CongVaXoaSanPham")
public class CongVaXoaSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CongVaXoaSanPham() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHang giohang = null;
		Object obj = session.getAttribute("giohang");
		if(obj != null) 
		{
			giohang = (GioHang) obj;
		}
		else 
		{
			giohang = new GioHang();
		}
		
		String idParam = request.getParameter("id_sp");
		int id_sp = Integer.parseInt(idParam);
		String quanly = request.getParameter("qly");
		int sl_sp = 1;
		try 
		{
			if (quanly.equals("tru")) 
			{
			    giohang.TruSanPhamTrongGioHang(id_sp);
			} 
			else if (quanly.equals("cong")) 
			{
			    SanPhamDAO sanphamDAO = new SanPhamDAO();
			    SanPham sanpham = sanphamDAO.LaySanPhamTheoID(id_sp);
			    double giasp = sanpham.getGia_sp();
			    Item item = new Item(sanpham, sl_sp, giasp);
			    giohang.ThemVaoGioHang(item);
			}
		} 
		catch (Exception e) 
		{
		}
		session.setAttribute("giohang", giohang);
		RequestDispatcher rd = request.getRequestDispatcher("HomeForward");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
