package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quang
 */
public class SuDungArrayList extends JFrame {
 
    
    private JTable jtable = new JTable();
    
    
    private DefaultTableModel tableModel = new DefaultTableModel();
 
     
    public SuDungArrayList(){
        String []colsName = {"Mã hàng", "Tên hàng"};
        tableModel.setColumnIdentifiers(colsName);  // đặt tiêu đề cột cho tableModel
        
        
        jtable.setModel(tableModel);    // kết nối jtable với tableModel
         
        initComponent();    // Khởi tạo các components trên JFrame
        updateData(); // gọi hàm view để truy suất dữ liệu sau đó truyền cho hàm updateData để đưa dữ liệu vào tableModel và hiện lên Jtable trong Frame
    }
     
    public void updateData(){
        String []colsName = {"Mã hàng", "Tên hàng"};
        tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName
 
        String rows[] = new String[2];
        String rows1[] = new String[2];
        String rows2[] = new String[2];
        String rows3[] = new String[2];
        String rows4[] = new String[2];
        rows[0] = "1"; // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
        rows[1] = "Đây là data dong 1"; // lấy dữ liệu tai cột số 2 ứng với tên hàng
        rows1[0] = "2";
        rows1[1] = "Đây là data dong 2";
        rows2[0] = "3";
        rows2[1] = "Đây là data dong 3";
        rows3[0] = "4";
        rows3[1] = "Đây là data dong 4";
        rows4[0] = "5";
        rows4[1] = "Đây là data dong 5";
        
        tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
        tableModel.addRow(rows1);
        tableModel.addRow(rows2);
        tableModel.addRow(rows3);
        tableModel.addRow(rows4);
 
    }
    public void initComponent(){
        this.setSize(400, 200);
        // Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có thanh cuộn ngang và doc để xem dữ liệu)
        JScrollPane scroll = JTable.createScrollPaneForTable(jtable);   
        this.add(scroll); // Đưa thanh cuộn vào Frame (hiện thanh cuộn trên frame)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
     
    
     
   
     
    public static void main(String[] args) {
        new SuDungArrayList();
    }
 
}