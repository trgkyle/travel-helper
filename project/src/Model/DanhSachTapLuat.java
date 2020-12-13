/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.TapLuatDAO;
import java.util.ArrayList;

/**
 *
 * @author Truong-kyle
 */
public class DanhSachTapLuat {
    public static ArrayList<TapLoaiSuKien> tapLoaiSuKien;
    private ArrayList<TapLuat> tapLuats;
    private static TapLuatDAO tapLuatDAO;

    public DanhSachTapLuat() throws Exception {
        tapLuatDAO = TapLuatDAO.getInstance();
        loadData();
    }


    /**
     * Lấy danh sách tập luật
     *
     * @return
     */
    public ArrayList<TapLuat> getAll() {
        return tapLuats;
    }


    /**
     * Load danh sách tập luật từ DB lên
     *
     * @throws Exception
     */
    public void loadData() throws Exception {
        tapLuats = tapLuatDAO.getTapLuats();
    }


    /**
     * Thêm tập luật
     *
     * @param rule
     * @return
     * @throws Exception
     */
    public void them(String rule) throws Exception {
        TapLuat newTapLuat = new TapLuat(1,rule);
        // kiểm tra trùng mã khách hàng
        if (newTapLuat == null || tapLuats.contains(newTapLuat))
            throw new Exception("Đã có tập luật này trên hệ thống");
        tapLuatDAO.addTapLuat(newTapLuat);
        tapLuats = tapLuatDAO.getTapLuats();
    }


    /**
     * Xoá tập luật
     * Xoá tập luật tương ứng trong DB
     *
     * @param maKhachHang
     * @return
     * @throws Exception
     */
    public boolean xoa(int ruleID) throws Exception {
        TapLuat tapLuat = tapLuats.get(tim(ruleID));

        if (tapLuat == null)
            return false;
        return false;
//        return tapLuatDAO.xoa(ruleID) && tapLuats.remove(tapLuat);
    }


    /**
     * Cập nhật thông tin tập luật
     * Cập nhật thông tin tập luật tương ứng trong DB
     *
     * @param tapLuat
     * @return
     * @throws Exception
     */
    public boolean sua(TapLuat tapLuat) throws Exception {
        return tapLuats.set(tim(tapLuat.getRuleID()), tapLuatDAO.suaTapLuat(tapLuat)) != null;
    }


    /**
     * Tìm vị trí của tập luật trong danh sách
     *
     * @param ruleID
     * @return
     */
    public int tim(int ruleID) {
        for (int i = 0; i < tapLuats.size(); i++)
            if (tapLuats.get(i).getRuleID() == ruleID)
                return i;

        return -1;
    }
    
    public void updateLoaiSuKien(ArrayList<TapLoaiSuKien> tapLoaiSuKien){
        DanhSachTapLuat.tapLoaiSuKien = tapLoaiSuKien;
    }
}
