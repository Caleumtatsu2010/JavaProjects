package PhongThi_ThiSinh;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import PhongThi_ThiSinh.ThiSinh;
/**
 *Data model đảm nhận nhiệm vụ cung cấp dữ liệu hiển thị cho JTable. 
 * Sử dụng data model giúp ứng dụng “MVC” hơn bằng việc tách riêng phần 
 * data và phần UI, tạo ra sự custom tốt hơn cho những bài toán phức tạp.
 Về cơ bản, một data model được cài đặt 9 phương thức do interface TableModel 
 * định nghĩa. Các phương thức đó được liệt kê trong hình dưới đây:
 getRowCout():int
 * getColumnCount():int
 * getValueAt(row, column): object
 * getColumnName(column:int):String
 * getColumnClass(column:int):class
 * isCellEditable(row:int, column:int):boolean
 * addTableModelListener(listener:TableModelListener):void
 * removeTableeModelListener(listener:tablleModelListener):void
 * @author Duong
 */
public class CustomTable extends AbstractTableModel
{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"SBD","Họ tên","Toán","Lý","Hóa"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,Float.class,Float.class,Float.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<ThiSinh> dsThiSinh=new ArrayList<ThiSinh>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTable(ArrayList<ThiSinh> listThiSinh)
   {
       this.dsThiSinh=listThiSinh;
   }
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        return dsThiSinh.size();
    }
    //Lấy số lượng tiêu để của mảng.
    @Override
    public int getColumnCount()
    {
        return name.length;
    }
    //Đưa thông tin của phần tử trong arrayList lên jTable
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        switch(columnIndex)
        {
            //Cột số báo danh
            case 0: return dsThiSinh.get(rowIndex).getSoBD();
            //Cột họ tên
            case 1: return dsThiSinh.get(rowIndex).getHoTen();
            //cột điểm toán
            case 2: return dsThiSinh.get(rowIndex).getDiemToan();
            //cột điểm lý
            case 3: return dsThiSinh.get(rowIndex).getDiemLy();
            //cột điểm hóa
            case 4: return dsThiSinh.get(rowIndex).getDiemHoa();
            default :return null;
        }
    }
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return name[column];
    }
}
