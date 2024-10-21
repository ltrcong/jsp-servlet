package BEAN;

public class HoaDon 
{
	private int id_hoadon;
	private int id_kh;
	private double tongtien;
	
	public HoaDon() 
	{
	}

	public HoaDon(int id_hoadon, String ngaymua, int id_kh, double tongtien) {
		super();
		this.id_hoadon = id_hoadon;
		this.id_kh = id_kh;
		this.tongtien = tongtien;
	}

	public int getId_hoadon() 
	{
		return id_hoadon;
	}

	public void setId_hoadon(int id_hoadon) 
	{
		this.id_hoadon = id_hoadon;
	}

	public int getId_kh() 
	{
		return id_kh;
	}

	public void setId_kh(int id_kh) 
	{
		this.id_kh = id_kh;
	}

	public double getTongtien() 
	{
		return tongtien;
	}

	public void setTongtien(double tongtien) 
	{
		this.tongtien = tongtien;
	}
	
	
}
