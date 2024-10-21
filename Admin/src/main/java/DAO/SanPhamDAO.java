package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BEAN.SanPham;
import DB.DbConnection;

public class SanPhamDAO 
{
	//Lấy toàn bộ sản phẩm
	public static List<SanPham> LayToanBoSanPham(HttpServletRequest request, int vtri,int dem) 
	{
		Connection conn = DbConnection.CreateConnection();
		List<SanPham> list_sp = new ArrayList<SanPham>();

        PreparedStatement ptmt = null;

        String sql = "SELECT * FROM sanpham LIMIT "+vtri+", "+dem+"";
		
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				SanPham sanpham = new SanPham();
				
				//Lấy dữ liệu từ ResultSet và thiết lập các thuộc tính cho đối tượng sanpham
			    int id_sp = rs.getInt("id_sp");
			    int id_dm = rs.getInt("id_dm");
			    String ten_sp = rs.getString("ten_sp");
			    String anh_sp = rs.getString("anh_sp");
			    String gia_sp = rs.getString("gia_sp");
			    String baohanh = rs.getString("baohanh");
			    String phukien = rs.getString("phukien");
			    String tinhtrang = rs.getString("tinhtrang");
			    String khuyenmai = rs.getString("khuyenmai");
			    String trangthai = rs.getString("trangthai");
			    int dacbiet = rs.getInt("dacbiet");
			    String chitiet = rs.getString("chitiet_sp");
			    

			    // Thiết lập các thuộc tính cho đối tượng sanpham
			    sanpham.setId_sp(id_sp);
			    sanpham.setId_dm(id_dm);
			    sanpham.setTen_sp(ten_sp);
			    sanpham.setAnh_sp(anh_sp);
			    sanpham.setGia_sp(gia_sp);
			    sanpham.setBaohanh(baohanh);
			    sanpham.setPhukien(phukien);
			    sanpham.setTinhtrang(tinhtrang);
			    sanpham.setKhuyenmai(khuyenmai);
			    sanpham.setTrangthai(trangthai);
			    sanpham.setDacbiet(dacbiet);
			    sanpham.setChitiet_sp(chitiet);
			   
				list_sp.add(sanpham);
			}
			conn.close();
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			request.setAttribute("msg_sp", e.getMessage());
		}
		
		return list_sp;	
	}
	// đến hàng đó có bao nhiêu hàng
	public static int demsoluongbang() 
	{
		Connection conn = DbConnection.CreateConnection();
        PreparedStatement ptmt = null;
		int dem = 0;
		String sql = "SELECT dem(*) FROM sanpham";
		try 
		{
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			dem = rs.getInt(1);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return dem;
	}
	//Kiểm tra tên có bị trùng không
	public static boolean KiemTraTenTrung(String ten_sp) 
	{
		Connection conn = DbConnection.CreateConnection();
		
		PreparedStatement ptmt = null;
        ResultSet rs = null;

        String sql = "SELECT ten_sp FROM sanpham WHERE ten_sp = ?";
        
        try 
        {
        	ptmt = conn.prepareStatement(sql);
        	ptmt.setString(1, ten_sp);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                return true; // Đã tồn tại ID danh mục trong cơ sở dữ liệu
            }
		} 
        catch (Exception e) 
        {
			
		}
        
        return false;
	}
	//up load file 
	public static String Uploadfile(HttpServletRequest request,HttpServletResponse response,int id_sp) 
			throws ServletException, IOException 
	{
		
		String test = "";
		ServletContext context = request.getServletContext();
		final String Address = context.getRealPath("View/AnhUpLoad/");
		final int MaxMemorySize = 1024 * 1024 * 3; //3MB
		final int MaxRequestSize = 1024 * 1024 * 50; //để maximum là 50MB chỉ định để server không bị sập
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (!isMultipart)
		{
			//thiếu file này bên trang jsp enctypr: multipart/form-data
			test = "thieu";
		}
		//tạo vùng nhớ tạm
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//truyền kích thước của vùng nhớ
		factory.setSizeThreshold(MaxMemorySize);
		//truyền vị trí chứa vùng nhớ đó
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// Set overall request size constraint
		upload.setSizeMax(MaxRequestSize);
		try 
		{
			/* List này có tác dụng :
		 	* 	Khi chuyển cái file này tới nơi mình mong muốn
		 	* 	thì ta phải sử dụng 1 cái list,  chứa cái file 
		 	* 	trong 1 cái list và sau đó lấy cái file từ trong 
		 	* 	cái list rồi đổ vào nơi mình muốn chuyển file
			*/
			//parseRequest giúp chuyển file vài cái list và chứa trong FileItem
			List<FileItem> items = upload.parseRequest(request);
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			//hasNext() có tác dụng kiểm tra xem trong list coi có file không 
			//next() chuyển tới file đó
			while (iter.hasNext()) 
			{
				//iter.next(); lấy cái file đó để đưa vào cái FileItem
				//giờ cái FileItem là cái file mình muốn upload
				//vidu: mình có file : text.txt
				//sau đó thì String fileName = item.getName(); lấy file text.txt đó
				// và sau đó FileItem = text.txt
			    FileItem item = iter.next();
				/* yêu cầu để được chuyển file
			 	* 	+ cung cấp cho server: địa chỉ ban đầu của file
			 	* 	+  tên file(text.txt)
			 	* 	+ vậy cái link cấp cho server:text.txt 
			 	*/
			    if (!item.isFormField()) 
			    {
			    	String fileName = item.getName();
			    	//pathFile: vị trí mà chúng ta muốn upload file vào
			    	//gửi cho server
			    	String pathFile = Address + File.separator + fileName;
			    	 
			    	File uploadedFile = new File(pathFile);
			    	boolean kt = uploadedFile.exists();
			    	try 
			    	{
			    		if (kt == true)
			    		{
			    			//file này đã tồn tại
			    			test = "tontai";
			    		}
			    		else
			    		{
			    			//up load thành công
			    			item.write(uploadedFile);
			    			SanPhamDAO.ThemAnhSanPham(request, fileName, id_sp);
			    			test = "success";
			    		}	
					} 
			    	catch (Exception e) 
			    	{
			    		test = e.getMessage();
					} 
			    } 
			    else 
			    {
			    	//upload không thành công
			    	test = "Upload file failed";
			    }
			}
		} 
		catch (FileUploadException e) 
		{
			test = e.getMessage();
		}
		return test;
	}
	//lấy id sản phẩm 
	public static int LayIDSanPham(HttpServletRequest request,SanPham sp) 
	{
		int id_sp = 0;
		PreparedStatement ptmt = null;
		Connection conn = DbConnection.CreateConnection();
		String sql = "select id_sp from sanpham where ten_sp = '"+sp.getTen_sp()+"'";

		try 
		{
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) 
			{
				id_sp = rs.getInt("id_sp");
				
			}
			
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			 request.setAttribute("msg_themanh", e.getMessage());
		}
		return id_sp;
	}
	//thêm sản phẩm
	public static boolean ThemSanPham(HttpServletRequest request,SanPham sp) 
	{
		Connection conn = DbConnection.CreateConnection();
	    PreparedStatement ptmt = null;

	    String sql = "INSERT INTO sanpham (id_dm,ten_sp,gia_sp,baohanh,phukien,tinhtrang,khuyenmai,trangthai,dacbiet,chitiet_sp)"
	    		+ "VALUES (?,?,?,?,?,?,?,?,?,?)";

	    try {
	        ptmt = conn.prepareStatement(sql);
	        // Lấy dữ liệu từ BEAN
	        
	        int id_dm = sp.getId_dm();
	        String ten_sp = sp.getTen_sp();
	        String gia_sp = sp.getGia_sp();
	        String baohanh = sp.getBaohanh();
	        String phukien = sp.getPhukien();
	        String tinhtrang = sp.getTinhtrang();
	        String khuyenmai = sp.getKhuyenmai();
	        String trangthai = sp.getTrangthai();
	        int dacbiet = sp.getDacbiet();
	        String chitiet_sp = sp.getChitiet_sp();

	        ptmt.setInt(1, id_dm);
	        ptmt.setString(2, ten_sp);
	        ptmt.setString(3, gia_sp);
	        ptmt.setString(4, baohanh);
	        ptmt.setString(5, phukien);
	        ptmt.setString(6, tinhtrang);
	        ptmt.setString(7, khuyenmai);
	        ptmt.setString(8, trangthai);
	        ptmt.setInt(9, dacbiet);
	        ptmt.setString(10, chitiet_sp);

	        if (KiemTraTenTrung(ten_sp)) {
	            request.setAttribute("msg_themSP", "Tên Sản Phẩm này đã tồn tại trong cơ sở dữ liệu");
	            return false;
	        }

	        int kq = ptmt.executeUpdate();
	        if (kq != 0) 
	        {
	            return true;
	        }
	    } 
	    catch (Exception e) 
	    {
	        request.setAttribute("msg_themSP", e.getMessage());
	    }
	    return false;
	}
	//thêm ảnh sản phẩm
	static public void ThemAnhSanPham(HttpServletRequest request,String anh_sp,int id_sp)
	{
		Connection conn = DbConnection.CreateConnection();
	    PreparedStatement ptmt = null;

	    String sql = "UPDATE sanpham SET anh_sp = ? WHERE id_sp = "+id_sp;
	    try {
	        ptmt = conn.prepareStatement(sql);
	        
	        // Lấy dữ liệu từ BEAN

	        ptmt.setString(1, anh_sp);
	        
	        ptmt.executeUpdate();
	        ptmt.close();
	    } 
	    catch (Exception e) 
	    {
	        request.setAttribute("msg_themSP", e.getMessage());
	    }
	}
	//tìm kiếm
	public static List<SanPham> TimKiem(HttpServletRequest request,String search)
	{
		Connection conn = DbConnection.CreateConnection();
		List<SanPham> list_sp = new ArrayList<SanPham>();

        PreparedStatement ptmt = null;

        String sql = "SELECT * FROM sanpham WHERE ten_sp LIKE ?";
        try 
		{
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, "%" + search + "%"); // Đặt giá trị tìm kiếm vào câu truy vấn
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				SanPham sanpham = new SanPham();
				
				//Lấy dữ liệu từ ResultSet và thiết lập các thuộc tính cho đối tượng sanpham
			    int id_sp = rs.getInt("id_sp");
			    int id_dm = rs.getInt("id_dm");
			    String ten_sp = rs.getString("ten_sp");
			    String anh_sp = rs.getString("anh_sp");
			    String gia_sp = rs.getString("gia_sp");
			    String baohanh = rs.getString("baohanh");
			    String phukien = rs.getString("phukien");
			    String tinhtrang = rs.getString("tinhtrang");
			    String khuyenmai = rs.getString("khuyenmai");
			    String trangthai = rs.getString("trangthai");
			    int dacbiet = rs.getInt("dacbiet");
			    String chitiet = rs.getString("chitiet_sp");
			    

			    // Thiết lập các thuộc tính cho đối tượng sanpham
			    sanpham.setId_sp(id_sp);
			    sanpham.setId_dm(id_dm);
			    sanpham.setTen_sp(ten_sp);
			    sanpham.setAnh_sp(anh_sp);
			    sanpham.setGia_sp(gia_sp);
			    sanpham.setBaohanh(baohanh);
			    sanpham.setPhukien(phukien);
			    sanpham.setTinhtrang(tinhtrang);
			    sanpham.setKhuyenmai(khuyenmai);
			    sanpham.setTrangthai(trangthai);
			    sanpham.setDacbiet(dacbiet);
			    sanpham.setChitiet_sp(chitiet);
			   
				list_sp.add(sanpham);
			}
			conn.close();
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			request.setAttribute("msg_sp", e.getMessage());
		}
        return list_sp;
	}
	//xóa sản phẩm
	public static void XoaSanPham(HttpServletRequest request,int id_sp) 
	{
		Connection conn = DbConnection.CreateConnection();
	    PreparedStatement ptmt = null;
	    String sql = "DELETE FROM sanpham WHERE id_sp = " +id_sp;
	    
	    try 
	    {
	    	ptmt = conn.prepareStatement(sql);
	    	ptmt.executeUpdate();
		} 
	    catch (Exception e) 
	    {
	    	request.setAttribute("msg_sp", e.getMessage());
	    }
	}
	public static List<SanPham> LayToanSanPhamTheoID(HttpServletRequest request,int idsp)
	{
		Connection conn = DbConnection.CreateConnection();
		List<SanPham> list_sp = new ArrayList<SanPham>();

        PreparedStatement ptmt = null;

        String sql = "SELECT * FROM sanpham WHERE id_sp = ?";
        
        try 
		{
        	ptmt = conn.prepareStatement(sql);
        	ptmt.setInt(1, idsp); // Đặt giá trị tìm kiếm vào câu truy vấn
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				SanPham sanpham = new SanPham();
				
				//Lấy dữ liệu từ ResultSet và thiết lập các thuộc tính cho đối tượng sanpham
			    int id_sp = rs.getInt("id_sp");
			    int id_dm = rs.getInt("id_dm");
			    String ten_sp = rs.getString("ten_sp");
			    String anh_sp = rs.getString("anh_sp");
			    String gia_sp = rs.getString("gia_sp");
			    String baohanh = rs.getString("baohanh");
			    String phukien = rs.getString("phukien");
			    String tinhtrang = rs.getString("tinhtrang");
			    String khuyenmai = rs.getString("khuyenmai");
			    String trangthai = rs.getString("trangthai");
			    int dacbiet = rs.getInt("dacbiet");
			    String chitiet = rs.getString("chitiet_sp");
			    

			    // Thiết lập các thuộc tính cho đối tượng sanpham
			    sanpham.setId_sp(id_sp);
			    sanpham.setId_dm(id_dm);
			    sanpham.setTen_sp(ten_sp);
			    sanpham.setAnh_sp(anh_sp);
			    sanpham.setGia_sp(gia_sp);
			    sanpham.setBaohanh(baohanh);
			    sanpham.setPhukien(phukien);
			    sanpham.setTinhtrang(tinhtrang);
			    sanpham.setKhuyenmai(khuyenmai);
			    sanpham.setTrangthai(trangthai);
			    sanpham.setDacbiet(dacbiet);
			    sanpham.setChitiet_sp(chitiet);
			   
				list_sp.add(sanpham);
			}
			conn.close();
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			request.setAttribute("msg_SP", e.getMessage());
		}
        return list_sp;
	}
	//Sửa Sản Phẩm 
	public static boolean SuaSanPham(HttpServletRequest request,int id_sp,int id_dm,String ten_sp,String gia_sp,String baohanh,
			String phukien,String tinhtrang,String khuyenmai,String trangthai,int dacbiet,String chitiet_sp) 
	{
		Connection conn = DbConnection.CreateConnection();
	    PreparedStatement ptmt = null;

	    String sql = "UPDATE sanpham SET id_dm=?,ten_sp=?,gia_sp=?,baohanh=?,phukien=?,"
	            + "tinhtrang=?,khuyenmai=?,trangthai=?,dacbiet=?,chitiet_sp=? WHERE id_sp=?";

	    try {
	        ptmt = conn.prepareStatement(sql);
	        
	        ptmt.setInt(1, id_dm);
	        ptmt.setString(2, ten_sp);
	        ptmt.setString(3, gia_sp);
	        ptmt.setString(4, baohanh);
	        ptmt.setString(5, phukien);
	        ptmt.setString(6, tinhtrang);
	        ptmt.setString(7, khuyenmai);
	        ptmt.setString(8, trangthai);
	        ptmt.setInt(9, dacbiet);
	        ptmt.setString(10, chitiet_sp);
	        ptmt.setInt(11, id_sp);
	       

	        if (KiemTraTenTrung(ten_sp)) {
	            request.setAttribute("msg_SuaSP", "Tên Sản Phẩm này đã tồn tại trong cơ sở dữ liệu");
	            return false;
	        }

	        int kq = ptmt.executeUpdate();
	        if (kq != 0) 
	        {
	            return true;
	        }
	        conn.close();
			ptmt.close();
	    } 
	    catch (Exception e) 
	    {
	        request.setAttribute("msg_SuaSP", e.getMessage());
	    }
	    return false;
	}
	public static List<SanPham> LayToanBoSanPhamTheoIDDM(HttpServletRequest request,int iddm) 
	{
		Connection conn = DbConnection.CreateConnection();
		List<SanPham> list_sp = new ArrayList<SanPham>();

        PreparedStatement ptmt = null;

        String sql = "SELECT * FROM sanpham WHERE id_dm=?";
        
        try 
		{
        	ptmt = conn.prepareStatement(sql);
        	ptmt.setInt(1, iddm); // Đặt giá trị tìm kiếm vào câu truy vấn
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				SanPham sanpham = new SanPham();
				
				//Lấy dữ liệu từ ResultSet và thiết lập các thuộc tính cho đối tượng sanpham
			    int id_sp = rs.getInt("id_sp");
			    int id_dm = rs.getInt("id_dm");
			    String ten_sp = rs.getString("ten_sp");
			    String anh_sp = rs.getString("anh_sp");
			    String gia_sp = rs.getString("gia_sp");
			    String baohanh = rs.getString("baohanh");
			    String phukien = rs.getString("phukien");
			    String tinhtrang = rs.getString("tinhtrang");
			    String khuyenmai = rs.getString("khuyenmai");
			    String trangthai = rs.getString("trangthai");
			    int dacbiet = rs.getInt("dacbiet");
			    String chitiet = rs.getString("chitiet_sp");
			    

			    // Thiết lập các thuộc tính cho đối tượng sanpham
			    sanpham.setId_sp(id_sp);
			    sanpham.setId_dm(id_dm);
			    sanpham.setTen_sp(ten_sp);
			    sanpham.setAnh_sp(anh_sp);
			    sanpham.setGia_sp(gia_sp);
			    sanpham.setBaohanh(baohanh);
			    sanpham.setPhukien(phukien);
			    sanpham.setTinhtrang(tinhtrang);
			    sanpham.setKhuyenmai(khuyenmai);
			    sanpham.setTrangthai(trangthai);
			    sanpham.setDacbiet(dacbiet);
			    sanpham.setChitiet_sp(chitiet);
			   
				list_sp.add(sanpham);
			}
			conn.close();
			ptmt.close();
			rs.close();
		} 
		catch (Exception e) 
		{
			request.setAttribute("msg_SP", e.getMessage());
		}
        return list_sp;
	}
}
