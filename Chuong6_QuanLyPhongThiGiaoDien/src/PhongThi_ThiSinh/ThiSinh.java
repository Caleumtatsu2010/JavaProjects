package PhongThi_ThiSinh;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/**
   Bước 1: Tạo 1 lớp biểu diễn cho đối tượng.
 * tên lớp phải đảm bảo ngắn gọn, rõ ràng và dễ hiểu.
 */
public class ThiSinh implements  Serializable
{/**Bước 2 Ứng vỗi tính chất của đối tượng, khai báo thành 1 thuộc tính
 * trong lớp.  Theo tính chất Encapsulation của oop, 
   ta khai báo các thuộc tính này có visibility modifier là private
    * */
    private String soBD;
    private String hoTen;
    private float diemLy;
    private float diemToan; 
    private float diemHoa;

    public ThiSinh(String soBD, String hoTen, float diemLy, float diemToan, float diemHoa) {
        this.soBD = soBD;
        this.hoTen = hoTen;
        this.diemLy = diemLy;
        this.diemToan = diemToan;
        this.diemHoa = diemHoa;
    }
    
/** bước 3: Ứng với mỗi data instance ở Bước 2, ta tạo các phương 
 * thức setters/getters.
    Cũng theo tính chất Encapsulation, ta phải làm cho việc thay đổi 
* giá trị của  thuộc tính đảm đảo tính toàn vẹn dữ liệu.
 */
public void setSoBD(String soBD) throws Exception{
    if(soBD.trim().equals(""))    
        throw new Exception("Số báo danh không được trống!");
    this.soBD = soBD;
}
public void setHoTen(String hoTen)throws Exception {
    if(hoTen.trim().equals(""))
        throw new Exception("Họ tên không được trống!");
    this.hoTen = hoTen;
}
public void setDiemToan(float diemToan) throws Exception {
    if(diemToan<0||diemToan>10) 
           throw new Exception("Điểm toan không hợp lệ");
    this.diemToan = diemToan;
}
public void setDiemLy(float diemLy) throws Exception{
    if(diemLy<0||diemLy>10) 
        throw new Exception("Điểm ly không hợp lệ");
    this.diemLy = diemLy;
}
public void setDiemHoa(float diemHoa) throws Exception{
    if(diemHoa<0||diemHoa>10) 
        throw new Exception("Điểm hoa không hợp lệ");
    this.diemHoa = diemHoa;
}

    public String getSoBD() {
        return soBD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public float getDiemLy() {
        return diemLy;
    }

    public float getDiemToan() {
        return diemToan;
    }

    public float getDiemHoa() {
        return diemHoa;
    }

/**Bước 4: Nên tạo 2 hàm constructors cho đối tượng
constructor default: là constructor không có tham số, 
* thường dùng để khởi gán các giá trị mặc định cho đối tượng.
constructor copy: 
* constructor có đầy đủ tham số (số tham số của constructor này 
* bằng với số data instance ta đã khai báo). 
* Constructor này thường dùng để khởi tạo 1 đối tượng đầy đủ.
* Tạo thêm 1 mẫu có 1 thuộc tính là sBD để kiểm tra trùng mã
*/
public ThiSinh() {
    soBD="";hoTen="no-name";diemToan=diemLy=diemHoa=0f;
}
public ThiSinh(String soBD) throws Exception {
    setSoBD(soBD);
   }
/**
 *B5: viết hàm nhập thông tin ts, tiếp tục đẩy lỗi ra ngoài
 */
public void nhap()  { 
    Scanner sc=new Scanner(System.in);
    while (true) {
        try {
            System.out.print("\tNhập số báo danh:");
            setSoBD(sc.nextLine());
            break;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    while (true) {
        try {
            System.out.print("\tNhập họ tên thí sinh:");
            setHoTen(sc.nextLine());
            break;
        } catch (Exception ex) {
            System.out.println(ex.toString());
//            Logger.getLogger(ThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    while (true) {        
        try{
            System.out.print("\tNhập điểm toán:");
            setDiemToan(sc.nextFloat());
            
            System.out.print("\tNhập điểm lý:");
            setDiemLy(sc.nextFloat());
            
            System.out.print("\tNhập điểm hóa:");
            setDiemHoa(sc.nextFloat());
            break;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
}
/*
 * Bước 6: Viết các business methods của đối tượng.
Đây là bước quan trọng nhất bởi nó định nghĩa tập các
dịch vụ của đối tượng cung cấp cho bên ngoài.
 */
/**
* Kiểm tra 1 thí sinh có đậu hay không
* @return true nếu sinh viên có tổng số điểm trên 15 và không
* có điểm nào dưới 3.
*/
public boolean CheckPassed() {
    return TongDiem()>15 && diemToan>=3&& diemHoa>=3 && diemLy>=3;
}
/**
* Tổng điểm của thí sinh
* @return: tổng điểm
*/
public float TongDiem() {
    return diemHoa+diemLy+diemToan;
}

   
/**Bước 7: Định nghĩa thuộc tính nhận diện (khóa)cho đối tượng bằng 
    cách viết lại (overrid) 2 phương thức equals và hashCode
    Các phương thức này rất quan trọng trong việc lập trình sau này,
    dùng để phân biệt 2 đối tượng.
    Trong ví dụ này 2 thí sinh phân biệt với nhau nhờ và thuộc tính 
    * số báo danh.
 * Phương thức hashCode dùng như là 1 cách đánh chỉ số (indexing) 
 * trong 1 tập hợp các đối tượng để cho việc truy xuất nó thực 
 * hiện nhanh hơn. 
 * Trong 1 tập hợp các đối tượng thì không có 2 đối tượng cùng index.

* Bạn có thể viết lại hasCode cho gọn hơn như sau:
    public int hashCode() {
        return soBD.hashCode();
    }
    Ở đây @Override là 1 anotaion để chỉ việc đây là phương thức được override lại từ lớp Object. 
 */ 
 @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.soBD);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ThiSinh other = (ThiSinh) obj;
        if (!Objects.equals(this.soBD, other.soBD)) {
            return false;
        }
        return true;
    }    
    
/**
 * Bước 8: Định nghĩa phương thức đặc tả dạng chuỗi của đối tượng 
    (phương thức toString). Đây là phương thức sẽ được tự động 
    gọi khi chúng ta làm việc với việc kết xuất đối tượng ra 
    màn hình hay lên 1 GUI controls nào đó.  
 
 */
    @Override
public String toString() {
    String tsValue;
    tsValue= soBD+"\t"+hoTen+"\t"+diemToan+"\t";
    tsValue=tsValue +diemLy+"\t"+diemHoa+ " \t "+TongDiem();
    return tsValue;
}   
}
