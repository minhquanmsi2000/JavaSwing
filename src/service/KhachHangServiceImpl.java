/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.KhachHang;
import dao.KhachHangDao;
import dao.KhachHangDaoImpl;
import java.util.List;

/**
 *
 * @author minhq
 */
public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangDao khachHangDao  = null;
    
    public KhachHangServiceImpl(){
        khachHangDao = new KhachHangDaoImpl();
    }
    @Override
    public List<KhachHang> getList() {
        return khachHangDao.getList();
    }
    
    
}
