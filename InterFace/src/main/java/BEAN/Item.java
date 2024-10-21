package BEAN;

public class Item 
{
	private SanPham sanpham;
	private int soluong;
	private double gia;
	public Item() 
	{
	}
	
	public Item(SanPham sanpham, int soluong, double gia) 
	{	
		this.sanpham = sanpham;
		this.soluong = soluong;
		this.gia = gia;
	}
	
	public SanPham getSanpham() 
	{
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) 
	{
		this.sanpham = sanpham;
	}
	public int getSoluong() 
	{
		return soluong;
	}
	public void setSoluong(int soluong) 
	{
		this.soluong = soluong;
	}
	public double getGia() 
	{
		return gia;
	}
	public void setGia(double gia) 
	{
		this.gia = gia;
	}

}
