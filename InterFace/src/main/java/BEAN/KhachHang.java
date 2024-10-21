package BEAN;

public class KhachHang 
{
	private int id_kh;
	private String ten_kh;
	private String gioitinh_kh;
	private String email_kh;
	private String diachi_kh;
	private String mk_kh;
	private int sdt_kh;

	
	public KhachHang() 
	{
	}

	public KhachHang(int id_kh, String ten_kh, String gioitinh_kh, String email_kh, String diachi_kh, String mk_kh,
			int sdt_kh) {
		super();
		this.id_kh = id_kh;
		this.ten_kh = ten_kh;
		this.gioitinh_kh = gioitinh_kh;
		this.email_kh = email_kh;
		this.diachi_kh = diachi_kh;
		this.mk_kh = mk_kh;
		this.sdt_kh = sdt_kh;

	}

	public int getId_kh() 
	{
		return id_kh;
	}
	public void setId_kh(int id_kh) 
	{
		this.id_kh = id_kh;
	}
	public String getTen_kh() {
		return ten_kh;
	}
	public void setTen_kh(String ten_kh) 
	{
		this.ten_kh = ten_kh;
	}
	public String getGioitinh_kh() 
	{
		return gioitinh_kh;
	}
	public void setGioitinh_kh(String gioitinh_kh) 
	{
		this.gioitinh_kh = gioitinh_kh;
	}
	public String getEmail_kh() {
		return email_kh;
	}
	public void setEmail_kh(String email_kh) 
	{
		this.email_kh = email_kh;
	}
	public String getDiachi_kh() 
	{
		return diachi_kh;
	}
	public void setDiachi_kh(String diachi_kh) 
	{
		this.diachi_kh = diachi_kh;
	}
	public String getMk_kh() 
	{
		return mk_kh;
	}
	public void setMk_kh(String mk_kh) 
	{
		this.mk_kh = mk_kh;
	}
	public int getSdt_kh() 
	{
		return sdt_kh;
	}
	public void setSdt_kh(int sdt_kh) 
	{
		this.sdt_kh = sdt_kh;
	}
}
