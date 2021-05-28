/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.KhachHang;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minhq
 */
public class KhachHangDaoImpl implements KhachHangDao{

    @Override
    public List<KhachHang> getList() {
        try {
            Connection cons= DBConnect.getConnection();
            String sql= "Select * from KhachHang";
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang khachHang = new KhachHang();
                khachHang.setMa_khach_hang(rs.getInt("User_id"));
                khachHang.setTen_khach_hang(rs.getString("Name"));
                khachHang.setDia_chi(rs.getString("Address"));
                khachHang.setSo_dien_thoai(rs.getString("Phone"));
                khachHang.setTinh_trang(rs.getBoolean("Status"));
                list.add(khachHang);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    public static void main(String[] args) {
        KhachHangDao khachHangDao = new KhachHangDaoImpl();
        System.out.println(khachHangDao.getList());
    }
}
