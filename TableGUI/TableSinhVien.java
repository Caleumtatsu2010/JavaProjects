/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableGUI;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class TableSinhVien extends AbstractTableModel {
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã sv","Họ tên","Tuoi"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class, Integer.class};      
    //Tạo một đối tượng arrayList có tên dsSV.
    ArrayList<SinhVien> dsSV=new ArrayList<SinhVien>();

    public TableSinhVien(ArrayList<SinhVien> ds) {
        dsSV=ds;
    }
    
    @Override
    public int getRowCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dsSV.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return  name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            //Cột mã
            case 0: return dsSV.get(rowIndex).getMaSV(); 
            //Cột họ tên
            case 1: return dsSV.get(rowIndex).getHoTen();
            //Cột tuoi
            case 2: return dsSV.get(rowIndex).getTuoi();
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
