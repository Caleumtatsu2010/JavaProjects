/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlphongthi;

import java.util.Vector;

/**
 *
 * @author A510
 */
public class PhongThi {
   //các thuộc tính của đối tượng phòng thi
    private String msPT;
    private String diachiPT;
    private int luongTS;
    //--Trần Thị Ngọc Ánh-lưu trữ bằng vecto
    //đối tượng dùng chứa tập các thí sinh
    private Vector<ThiSinh> dsTS;
// dinh nghia cac phuong thuc tao lapconstructors
public PhongThi(String msPT, String diachiPT, int luongTS) {
    this.msPT = msPT;
    this.diachiPT = diachiPT;
    this.luongTS = luongTS;
    dsTS=new Vector<ThiSinh>();
}
 /**
* Thêm 1 thí sinh vào phòng thi có kiểm tra trùng mã
* @param ts: thí sinh thêm vào
* @return true nếu việc thêm thành công
*/
public boolean themThiSinh(ThiSinh ts) {
//Nếu thí sinh đã tồn tại thì không cho thêm
    if(dsTS.contains(ts)) return false;
    if(dsTS.size()+1>luongTS)//nếu đã đủ lượng thí sinh
    {
        System.out.println("đã đủ số lượng thí sinh trong phòng.");
        return false;
    }
    else
    {   dsTS.add(ts);
        return true;
    }
}
/* Xóa 1 thí sinh khỏi phòng thi
* @param soBD là số báo danh của thí sinh cần xóa
* @return trả về true nếu xóa thành công
*/
public boolean xoaThisinh(String soBD) {
    ThiSinh ts=new ThiSinh(soBD);
    if(!dsTS.contains(ts))    return false;
    else
    {   dsTS.remove(ts);
        return true;
    }    
}
/**
* Sửa thông tin thí sinh
* @param soBD: số DB của thí sinh cần sử thông tin
* @param newTS: thông tin mới cần cập nhật
* @return true nếu sửa chữa thành công
*/
 public boolean suaThongtinTS(String soBD, ThiSinh newTS) {
    ThiSinh ts=new ThiSinh(soBD);
    if(!dsTS.contains(ts))    return false;
    dsTS.set(dsTS.indexOf(ts),newTS);
    return true;
}
/**
* Lấy thông tin của 1 thí sinh khi biết số báo danh
* @param soBD số báo danh của ts cần lấy thông tin
* @return null nếu không lấy được
*/
public ThiSinh layThongtinTS(String soBD) {
    ThiSinh ts=new ThiSinh(soBD);
    if(!dsTS.contains(ts))     return null;
    ts=dsTS.get(dsTS.indexOf(ts));
    return ts;
}
/**
* Lấy thông tin của 1 thí sinh khi biết
*  số thứ tự của ts đó trong danh sách
* @param index :số thứ tự của ts
* @return null nếu không thành công

*/
public ThiSinh layThongtinTS(int index){
    if(index<0||index>dsTS.size()) return null;
    return dsTS.get(index);
}
/**
* Lấy số thí sinh thực sự đang có trong phòng thi
* @return
*/
public int soThisinh() {
    return dsTS.size();
} 
}
