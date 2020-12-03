/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.TapSuKienDAO;
import java.util.ArrayList;

/**
 *
 * @author Truong-kyle
 */

public class DanhSachTapSuKien {
    private ArrayList<TapSuKien> tapSuKiens;
    private static TapSuKienDAO tapSuKienDAO;

    public DanhSachTapSuKien() throws Exception {
        tapSuKienDAO = TapSuKienDAO.getInstance();
        loadData();
    }


    /**
     * Lấy danh sách khách hàng
     *
     * @return
     */
    public ArrayList<TapSuKien> getAll() {
        return tapSuKiens;
    }


    /**
     * Load danh sách khách hàng từ DB lên
     *
     * @throws Exception
     */
    public void loadData() throws Exception {
        tapSuKiens = tapSuKienDAO.getTapSuKiens();
    }


    /**
     * Thêm khách hàng mới (không cho thêm trùng mã khách hàng + CMND)
     * Lưu khách hàng vào DB
     *
     * @param khachHang
     * @return
     * @throws Exception
     */
    public void them(TapSuKien tapSuKien) throws Exception {
        // kiểm tra trùng mã khách hàng
        if (tapSuKien == null || tapSuKiens.contains(tapSuKien))
            throw new Exception("Đã có khách hàng này trong hệ thống");

        tapSuKiens.add(tapSuKienDAO.themKhachHang(khachHang));
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
        TapSuKien tapSuKien = tapSuKiens.get(tim(ruleID));

        if (tapSuKien == null)
            return false;

        return tapSuKienDAO.xoaKhachHang(ruleID) && tapSuKiens.remove(tapSuKien);
    }


    /**
     * Cập nhật thông tin khách hàng
     * Cập nhật thông tin khách hàng tương ứng trong DB
     *
     * @param khachHang
     * @return
     * @throws Exception
     */
    public boolean sua(KhachHang khachHang) throws Exception {
        return tapSuKiens.set(tim(khachHang.getMaKH()), khachHangDAO.suaKhachHang(khachHang)) != null;
    }


    /**
     * Tìm vị trí của khách hàng trong danh sách
     *
     * @param maKhachHang
     * @return
     */
    public int tim(int ruleID) {
        for (int i = 0; i < tapSuKiens.size(); i++)
            if (tapSuKiens.get(i).getEventID() == ruleID)
                return i;

        return -1;
    }
}
