package app;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class App extends JFrame{
    public ArrayList<Student> t;
    private JTable jtable = new JTable();
    private DefaultTableModel tableModel = new DefaultTableModel();
    public Scanner in =  new Scanner(System.in);
    

    
    public App(){
        Nhap();
        jtable.setModel(tableModel);    // kết nối jtable với tableModel 2
        jtable.setRowHeight(30);        // Thay doi chieu rong cua cot
        initComponent();    // Khởi tạo các components trên JFrame
    }
    public void Nhap(){
        String []colsName = {"Name", "Age"};
        tableModel.setColumnIdentifiers(colsName); 
        System.out.println("Nhap so luong sinh vien ");
        int n = in.nextInt();
        in.nextLine();
        t = new ArrayList<Student>();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + i);
            Student a = new Student();
            System.out.println("Nhap ten sinh vien :");
            String name = in.nextLine();
            System.out.println("Nhap tuoi sinh vien : ");
            int age = in.nextInt();
            in.nextLine();
            a.setName(name);
            a.setAge(age);
            
            t.add(a);
            
        }
        Insert();
        
    }
    public void Insert(){
        for(int i =0;i<t.size();i++){
            Student b = t.get(i);
            
            tableModel.addRow(new Object[]{
                b.getName(),b.getAge()
            });  
        }
        tableModel.setValueAt("Quang12345", 0, 0);  // thay doi gia tri tai row[0]column[0]
    }
    
    public void initComponent(){
        this.setSize(800, 400);
        // Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có thanh cuộn ngang và doc để xem dữ liệu)
        JScrollPane scroll = JTable.createScrollPaneForTable(jtable);   
        this.add(scroll); // Đưa thanh cuộn vào Frame (hiện thanh cuộn trên frame)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {// TODO code application logic here
       new App();
    }
    
}