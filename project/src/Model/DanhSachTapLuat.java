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
    private ArrayList<TapLuat> tapLuats;
    private static TapLuatDAO tapLuatDAO;

    public DanhSachTapLuat() throws Exception {
        tapLuatDAO = TapLuatDAO.getInstance();
        loadData();
    }


    /**
     * Lấy danh sách khách hàng
     *
     * @return
     */
    public ArrayList<TapLuat> getAll() {
        return tapLuats;
    }


    /**
     * Load danh sách khách hàng từ DB lên
     *
     * @throws Exception
     */
    public void loadData() throws Exception {
        tapLuats = tapLuatDAO.getTapLuats();
    }


    /**
     * Thêm khách hàng mới (không cho thêm trùng mã khách hàng + CMND)
     * Lưu khách hàng vào DB
     *
     * @param khachHang
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
     * Xoá khách hàng
     * Xoá khách hàng tương ứng trong DB
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
     * Cập nhật thông tin khách hàng
     * Cập nhật thông tin khách hàng tương ứng trong DB
     *
     * @param khachHang
     * @return
     * @throws Exception
     */
    public boolean sua(TapLuat tapLuat) throws Exception {
        return tapLuats.set(tim(tapLuat.getRuleID()), tapLuatDAO.suaTapLuat(tapLuat)) != null;
    }


    /**
     * Tìm vị trí của khách hàng trong danh sách
     *
     * @param maKhachHang
     * @return
     */
    public int tim(int ruleID) {
        for (int i = 0; i < tapLuats.size(); i++)
            if (tapLuats.get(i).getRuleID() == ruleID)
                return i;

        return -1;
    }
}
