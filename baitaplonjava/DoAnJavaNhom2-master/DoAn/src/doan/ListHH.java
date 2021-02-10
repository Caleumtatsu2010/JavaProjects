/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doan;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ListHH {
        private ArrayList<HangHoa> list;

    public ListHH() {
        list = new ArrayList<>();
    }

    public ArrayList<HangHoa> getList() {
        return list;
    }

    public void setList(ArrayList<HangHoa> list) {
        this.list = list;
    }

    public ListHH(ArrayList<HangHoa> list) {
        this.list = list;
    }
    public void insert(HangHoa st) {
        list.add(st);
    }
    public void update(HangHoa hh) {
        for (HangHoa clhh : list) {
            if (clhh.getMa().equals(hh.getMa())) {
                clhh.setTenH(hh.getTenH());
                clhh.setSL(hh.getSL());
                clhh.setGiaNhap(hh.getGiaNhap());
                clhh.setGiaBan(hh.getGiaBan());
                clhh.setDaBan(hh.getDaBan());
            }
        }
    }
    public ArrayList<HangHoa> show() {
        return list;
    }
}
