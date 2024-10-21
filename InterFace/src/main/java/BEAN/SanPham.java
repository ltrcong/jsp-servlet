package BEAN;

public class SanPham 
{
	private int id_sp;
	private int id_dm;
	private String ten_sp;
	private String anh_sp;
	private double gia_sp;
	private String baohanh;
	private String phukien;
	private String tinhtrang;
	private String khuyenmai;
	private String trangthai;
	private int dacbiet;
	private String chitiet_sp;
	
	public SanPham() 
	{
	}

	public SanPham(int id_sp, int id_dm, String ten_sp, String anh_sp, double gia_sp, String baohanh, String phukien,
			String tinhtrang, String khuyenmai, String trangthai, int dacbiet, String chitiet_sp) 
	{
		super();
		this.id_sp = id_sp;
		this.id_dm = id_dm;
		this.ten_sp = ten_sp;
		this.anh_sp = anh_sp;
		this.gia_sp = gia_sp;
		this.baohanh = baohanh;
		this.phukien = phukien;
		this.tinhtrang = tinhtrang;
		this.khuyenmai = khuyenmai;
		this.trangthai = trangthai;
		this.dacbiet = dacbiet;
		this.chitiet_sp = chitiet_sp;
	}

	public int getId_sp() 
	{
		return id_sp;
	}

	public void setId_sp(int id_sp) 
	{
		this.id_sp = id_sp;
	}

	public int getId_dm() 
	{
		return id_dm;
	}

	public void setId_dm(int id_dm) 
	{
		this.id_dm = id_dm;
	}

	public String getTen_sp() 
	{
		return ten_sp;
	}

	public void setTen_sp(String ten_sp) 
	{
		this.ten_sp = ten_sp;
	}

	public String getAnh_sp() 
	{
		return anh_sp;
	}

	public void setAnh_sp(String anh_sp) 
	{
		this.anh_sp = anh_sp;
	}

	public double getGia_sp() 
	{
		return gia_sp;
	}

	public void setGia_sp(double gia_sp) 
	{
		this.gia_sp = gia_sp;
	}

	public String getBaohanh() 
	{
		return baohanh;
	}

	public void setBaohanh(String baohanh) 
	{
		this.baohanh = baohanh;
	}

	public String getPhukien() 
	{
		return phukien;
	}

	public void setPhukien(String phukien) 
	{
		this.phukien = phukien;
	}

	public String getTinhtrang() 
	{
		return tinhtrang;
	}

	public void setTinhtrang(String tinhtrang) 
	{
		this.tinhtrang = tinhtrang;
	}

	public String getKhuyenmai() 
	{
		return khuyenmai;
	}

	public void setKhuyenmai(String khuyenmai) 
	{
		this.khuyenmai = khuyenmai;
	}

	public String getTrangthai() 
	{
		return trangthai;
	}

	public void setTrangthai(String trangthai) 
	{
		this.trangthai = trangthai;
	}

	public int getDacbiet() 
	{
		return dacbiet;
	}

	public void setDacbiet(int dacbiet) 
	{
		this.dacbiet = dacbiet;
	}

	public String getChitiet_sp() 
	{
		return chitiet_sp;
	}

	public void setChitiet_sp(String chitiet_sp) 
	{
		this.chitiet_sp = chitiet_sp;
	}
}
