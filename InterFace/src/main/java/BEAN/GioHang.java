package BEAN;

import java.util.ArrayList;
import java.util.List;

public class GioHang 
{
	private List<Item> items;
	
	public GioHang()
	{
		items = new ArrayList<Item>();
	}
	
	public GioHang( List<Item> items)
	{
		this.items = items;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	private Item LayItemTheoID(int id_sp) 
	{
	    for (Item i : items) {
	        if (i.getSanpham().getId_sp() == id_sp) {
	            return i;
	        }
	    }
	    return null;
	}
	
	private Item LayItemTrongGioHang(int id_sp)
	{
		for(Item i:items)
		{
			if(i.getSanpham().getId_sp() == id_sp)
			{
				return i;
			}
		}
		return null;
	}
	//Số lượng của sản phẩm khi đẩy và giỏ hàng
	public int LaySoluongTheoID(int id_sp) 
	{
		return LayItemTrongGioHang(id_sp).getSoluong();
	}

	//Thêm vào giỏ hàng 
	public void ThemVaoGioHang(Item soluongmoi) 
	{
		//TH1 : Có ở trong giỏ rồi
		if(LayItemTheoID(soluongmoi.getSanpham().getId_sp()) != null)
		{
			Item soluongcu =  LayItemTheoID(soluongmoi.getSanpham().getId_sp());
			soluongcu.setSoluong(soluongcu.getSoluong()+soluongmoi.getSoluong());
		}
		else 
		{
			//TH2: Chưa có sản phẩm trong giỏ
			items.add(soluongmoi);
		}
	}
	
	//Xóa sản phẩm trong giỏ hàng
	public void BoDiSanPhamTrongGioHang(int id_sp) 
	{
	    Item itemToRemove = LayItemTheoID(id_sp);
	    if (itemToRemove != null) 
	    {
	        items.remove(itemToRemove);
	    }
	}
	public void TruSanPhamTrongGioHang(int id_sp) 
	{
	    Item item = LayItemTheoID(id_sp);
	    if (item != null) 
	    {
	        int currentQuantity = item.getSoluong();
	        
	        // Check if the current quantity is greater than 1 before decrementing.
	        if (currentQuantity > 1) {
	            item.setSoluong(currentQuantity - 1);
	        } else {
	            // If the quantity is 1, remove the item from the cart.
	            items.remove(item);
	        }
	    }
	}
	//Toàn bộ tiền của giỏ hàng
	public double TongTien() 
	{
		double tongtien = 0;
		for(Item i:items)
		{
			tongtien += (i.getSoluong() * i.getGia());
		}
		return tongtien;
	}
}
