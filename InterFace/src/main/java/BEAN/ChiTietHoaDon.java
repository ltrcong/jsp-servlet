package BEAN;

public class ChiTietHoaDon 
{
	private int id_hoadon;
	private int id_sp;
	private int soluong;
	private double gia_sp;
	public ChiTietHoaDon() 
	{	
	}
	
	public ChiTietHoaDon(int id_hoadon, int id_sp, int soluong, double gia_sp) {
		super();
		this.id_hoadon = id_hoadon;
		this.id_sp = id_sp;
		this.soluong = soluong;
		this.gia_sp = gia_sp;
	}

	public int getId_hoadon() 
	{
		return id_hoadon;
	}
	public void setId_hoadon(int id_hoadon) 
	{
		this.id_hoadon = id_hoadon;
	}
	public int getId_sp() 
	{
		return id_sp;
	}
	public void setId_sp(int id_sp) 
	{
		this.id_sp = id_sp;
	}
	public int getSoluong() 
	{
		return soluong;
	}
	public void setSoluong(int soluong) 
	{
		this.soluong = soluong;
	}
	public double getGia_sp() 
	{
		return gia_sp;
	}
	public void setGia_sp(double gia_sp) 
	{
		this.gia_sp = gia_sp;
	}
	
	
}
