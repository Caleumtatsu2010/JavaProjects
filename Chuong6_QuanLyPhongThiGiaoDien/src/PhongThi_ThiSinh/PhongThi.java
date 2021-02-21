package PhongThi_ThiSinh;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/**
 * B1: chọn tên lớp: Phòng thi
 */
public class PhongThi 
{
    /**
     * Bước 2: đặt tên các thuộc tính và phạm vi riêng tư
     */
    private String msPT;
    private String diachiPT;
    private int luongTS;
    //đối tượng dùng chứa tập các thí sinh
    private ArrayList<ThiSinh> dsTS;
/**
 * Bước 3
 * các hàm constructor: do muốn minh họa cho 1 phòng thi nên 
 * cô tạo 1 hàm có đầy đủ tham số.
 * nếu muốn nhập nhiều phòng thi thì nên xd hàm nhập
 */
    
 public PhongThi(String msPT, String diachiPT, int luongTS) {
    this.msPT = msPT;
    this.diachiPT = diachiPT;
    this.luongTS = luongTS;
    dsTS=new ArrayList<ThiSinh>();
}  
    public PhongThi() {
        dsTS=new ArrayList<ThiSinh>();
    }
/**
 * Bước 3
 * các hàm get/set chưa thấy có yêu cầu quan tâm. tam thời bỏ qua
 */
    public String getMsPT() {
        return msPT;
    }

    public void setMsPT(String msPT) {
        this.msPT = msPT;
    }

    public String getDiachiPT() {
        return diachiPT;
    }

    public void setDiachiPT(String diachiPT) {
        this.diachiPT = diachiPT;
    }

    public int getLuongTS() {
        return luongTS;
    }

    public void setLuongTS(int luongTS) {
        this.luongTS = luongTS;
    }

    public ArrayList<ThiSinh> getDsTS() {
        return dsTS;
    }

    public void setDsTS(ArrayList<ThiSinh> dsTS) {
        this.dsTS = dsTS;
    }   
/**B5:
* Thêm 1 thí sinh vào phòng thi có kiểm tra trùng mã
* @param ts: thí sinh thêm vào
* @return true nếu việc thêm thành công
*/
public boolean themThiSinh(ThiSinh ts) throws Exception {
//Nếu thí sinh đã tồn tại thì không cho thêm
    if(dsTS.contains(ts)) 
        throw new Exception(" thí sinh đã tồn tại");
    
    if(dsTS.size()+1>luongTS)  
       throw new Exception("phòng thi đã hết chỗ"); 
    return 
            dsTS.add(ts);
}

/* * Điều này là hoàn toàn có thể bởi java sẽ kiểm tra chúng dựa trên phương 
 thức equals của đối tượng.
 Với đối tượng của chúng ta thì 2 thí sinh sẽ là 1 nếu chúng có cùng số báo danh
 */
/** Xóa 1 thí sinh khỏi phòng thi
 @param soBD là số báo danh của thí sinh cần xóa
 @return trả về true nếu xóa thành công
*/
public boolean XoaThisinh(String soBD) throws Exception  {
    ThiSinh ts=new ThiSinh(soBD.trim());
    if(!dsTS.contains(ts))    
        return false;
    return dsTS.remove(ts);
}
/** Phương thức cập nhật thông tin thí sinh trong phòng thi
* Sửa thông tin thí sinh
* @param soBD: số DB của thí sinh cần sử thông tin
* @param newTS: thông tin mới cần cập nhật
* @return true nếu sửa chữa thành công
*/
 public boolean SuaThongtinTS(String soBD, ThiSinh newTS)  throws Exception {
    ThiSinh ts=new ThiSinh(soBD);
    if(!dsTS.contains(ts))    
        return false;
    //dsTS.indexOf(ts)- trả lại vị trí ts trong danh sach
    dsTS.set(dsTS.indexOf(ts),newTS);
    return true;
}

/** Phương thức lấy 1 thí sinh ra khỏi danh sách khi biết số báo danh
* Lấy thông tin của 1 thí sinh khi biết số báo danh
* @param soBD số báo danh của ts cần lấy thông tin
* @return null nếu không lấy được
*/
public ThiSinh LayThongtinTS(String soBD) throws Exception{
    ThiSinh ts=new ThiSinh(soBD);
    if(!dsTS.contains(ts))     
        return null;
    ts=dsTS.get(dsTS.indexOf(ts));
    return ts;
}
/**
* Lấy thông tin của 1 thí sinh khi biết
*  số thứ tự của ts đó trong danh sách
* @param index :số thứ tự của ts
* @return null nếu không thành công
* @throws Exception
*/
public ThiSinh LayThongtinTS(int index)throws Exception{
    if(index<0|| index>dsTS.size())     
        return null;
    return dsTS.get(index);
}
// Phương thức lấy số thí sinh thực sự đang có trong phòng
/**
* Lấy số thí sinh thực sự đang có trong phòng thi
* @return
*/
public int SoThisinh() {
    return dsTS.size();
}
/**
 * Sắp xếp cần tạo bộ so sánh Comparator và ghi đè phương thức
 * compare() để so sánh hai đối tượng
 */
public void sapXep()    
{    //Bước 1: tạo bộ so sánh
    Comparator<ThiSinh> c=new Comparator<ThiSinh>() {

        @Override
        public int compare(ThiSinh t, ThiSinh t1) {
            int value=t.getHoTen().compareTo(t.getHoTen());
//            //nếu 2 ho ten trung nhau thi value=0 nguoc lai -1
            if (value!=0) return value;   
            else //kiểm tra tiêu chí so sánh thứ 2
                value=Float.compare(t.getDiemToan(),t1.getDiemToan());
        return value; 
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
//    public int compare(ThiSinh o1, ThiSinh o2) {
//            int value=o1.getHoTen().compareTo(o2.getHoTen());
//            //nếu 2 ho ten trung nhau thi value=0 nguoc lai -1
//            if (value!=0) return value;   
//            else //kiểm tra tiêu chí so sánh thứ 2
//                value=Float.compare(o1.getDiemToan(),o2.getDiemToan());
//        return value;     
//        }
    };    
    //bước 2. gọi sắp xếp
    Collections.sort(dsTS,c);
//    ThiSinh ds[]=new ThiSinh[3];
//    Arrays.sort(ds,c);
//    Collections.sort(, c);
}
    
 public ThiSinh timMin(){
    Comparator<ThiSinh> c1=new Comparator<ThiSinh>() {
    @Override
    public int compare(ThiSinh o1, ThiSinh o2) {
        //return (int) (o1.TongDiem()-o2.TongDiem());
        
        if (o1.TongDiem()>o2.TongDiem())
            return 1;
        else if (o1.TongDiem()<o2.TongDiem()) return -1;
        else return 0;
        }
    };  
    ThiSinh ts=Collections.min(dsTS, c1);
    return ts;
}
 /**
  * tìm thí sinh có tổng điểm lớn nhất
  * @return 
  */
public ThiSinh timMax(){
    Comparator<ThiSinh> c1=new Comparator<ThiSinh>() {
    @Override
    public int compare(ThiSinh o1, ThiSinh o2) {
        if (o1.TongDiem()>o2.TongDiem())
            return 1;
        else if(o1.TongDiem()<o2.TongDiem()) return -1;
        else return 0;
        }
    };       
    ThiSinh ts=Collections.max(dsTS,c1);
    return ts;
}

    @Override
    public String toString() {
        return "PhongThi:  " + msPT + ",  -" + diachiPT +  " - "+ luongTS + " thi sinh";
    }

}

