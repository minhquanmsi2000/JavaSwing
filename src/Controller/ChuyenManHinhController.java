/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Bean.DanhMucBean;
import View.GioHangJPanel;
import View.HoaDonJPanel;
import View.KhachHangJPanel;
import View.ThongKeJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author minhq
 */
public class ChuyenManHinhController {
    
    private JPanel root;
    private String kindSelected= "";

    private List<DanhMucBean> listItem = null;
            
    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected= "KhachHang";
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new KhachHangJPanel());
        root.validate();
        root.repaint();
    }
    
    
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
         for(DanhMucBean item : listItem){
             item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
         }
    }
    class LabelEvent implements MouseListener{

         private JPanel node;
         private String kind;
         
         private JPanel jpnItem;
         private JLabel jlbItem; 

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
         
         
         
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "KhachHang":
                        node = new KhachHangJPanel();
                        break;
                case "GioHang":
                        node = new GioHangJPanel();
                        break;
                case "HoaDon":
                        node = new HoaDonJPanel();
                        break;
                case "ThongKe":
                        node = new ThongKeJPanel();
                        break;     
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }
 
        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(76,175,80));
                jlbItem.setBackground(new Color(76,175,80));
            }
        }
        
    }
    
    private void setChangeBackgroud(String kind ){
        for(DanhMucBean item: listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96,100,191));
                item.getJlb().setBackground(new Color(96,100,191));
            }else{
                item.getJpn().setBackground(new Color(76,175,80));
                item.getJlb().setBackground(new Color(76,175,80));
            }
    }
    }
}
