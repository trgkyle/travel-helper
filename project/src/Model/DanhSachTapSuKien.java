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

    private ArrayList<TapLoaiSuKien> tapLoaiSuKien;
    private ArrayList<TapSuKien> tapSuKiens;
    private static TapSuKienDAO tapSuKienDAO;

    public DanhSachTapSuKien() throws Exception {
        tapSuKienDAO = TapSuKienDAO.getInstance();
        loadData();
    }

    /**
     * Lấy danh sách tập sự kiện
     *
     * @return
     */
    public ArrayList<TapSuKien> getAll() {
        return tapSuKiens;
    }

    public ArrayList<TapLoaiSuKien> getAllLoaiSuKien() {
        return tapLoaiSuKien;
    }

    /**
     * Load danh sách tập sự kiện từ DB lên
     *
     * @throws Exception
     */
    public void loadData() throws Exception {
        tapLoaiSuKien = tapSuKienDAO.getTapLoaiSuKiens();
        tapSuKiens = tapSuKienDAO.getTapSuKiens();
    }

    /**
     * Thêm tập sự kiện mới (không cho thêm trùng mã tập sự kiện + CMND) Lưu tập
     * sự kiện vào DB
     *
     * @param tapSuKien
     * @return
     * @throws Exception
     */
    public void them(int eventTypeID, String event) throws Exception {
        TapSuKien newTapSuKien = new TapSuKien(-1, eventTypeID, event, "");
        // kiểm tra trùng mã khách hàng
        if (newTapSuKien == null || tapSuKiens.contains(newTapSuKien)) {
            throw new Exception("Đã có tập luật này trên hệ thống");
        }
        tapSuKienDAO.addSuKien(newTapSuKien);
        tapSuKiens = tapSuKienDAO.getTapSuKiens();

    }

    /**
     * Xoá khách hàng Xoá tập sự kiện tương ứng trong DB
     *
     * @param ruleID
     * @return
     * @throws Exception
     */
    public boolean xoa(int ruleID) throws Exception {
        TapSuKien tapSuKien = tapSuKiens.get(tim(ruleID));

        if (tapSuKien == null) {
            return false;
        }
        return false;
    }

    /**
     * Cập nhật thông tin tập sự kiện Cập nhật thông tin tập sự kiện tương ứng
     * trong DB
     *
     * @param tapSuKien
     * @return
     * @throws Exception
     */
    public boolean sua(TapSuKien tapSuKien) throws Exception {
        return false;
    }

    /**
     * Tìm vị trí của tập sự kiện trong danh sách
     *
     * @param ruleID
     * @return
     */
    public int tim(int ruleID) {
        for (int i = 0; i < tapSuKiens.size(); i++) {
            if (tapSuKiens.get(i).getEventID() == ruleID) {
                return i;
            }
        }

        return -1;
    }
}
