/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KhachHang;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * @author minhq
 */
public class KhachHangController {
    private JButton btnAdd;
    private JTextField jtfMaKhachHang;
    private JTextField jtfTenKhachHang;
    private JTextField jtfDiaChi;
    private JTextField jtfSoDienThoai;
    private JCheckBox jcbTinhTrang;

    public KhachHangController(JButton btnAdd, JTextField jtfMaKhachHang, JTextField jtfTenKhachHang, JTextField jtfDiaChi, JTextField jtfSoDienThoai, JCheckBox jcbTinhTrang) {
        this.btnAdd = btnAdd;
        this.jtfMaKhachHang = jtfMaKhachHang;
        this.jtfTenKhachHang = jtfTenKhachHang;
        this.jtfDiaChi = jtfDiaChi;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jcbTinhTrang = jcbTinhTrang;
    }
    
    public void setView(KhachHang khachHang){
        jtfMaKhachHang.setText("#" +khachHang.getMa_khach_hang());
        jtfTenKhachHang.setText("" +khachHang.getTen_khach_hang());
        jtfDiaChi.setText("" +khachHang.getDia_chi());
        jtfSoDienThoai.setText("" +khachHang.getSo_dien_thoai());
        jcbTinhTrang.setSelected(khachHang.isTinh_trang());
    }
}
