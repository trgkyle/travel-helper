/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import Model.TapSuKien;

/**
 *
 * @author Truong-kyle
 */
public class TapSuKienDAO {

    private static TapSuKienDAO _instance;
    private static DataBaseUtils dataBaseUtils;
    private ResultSet resultSet;

    /**
     * Tạo kết nối DB
     *
     * @throws Exception
     */
    public TapSuKienDAO() throws Exception {
        dataBaseUtils = DataBaseUtils.getInstance();

    }

//    public TapLuat themKhachHang(TapLuat tapLuat) throws Exception {
//        TapLuat thongTinCaNhan = new TapLuat(
//                khachHang.getcMND(),
//                khachHang.getHoTen(),
//                khachHang.isGioiTinh(),
//                khachHang.getSoDienThoai(),
//                khachHang.getDiaChi(),
//                khachHang.getNgaySinh()
//        );
//
//        if (thongTinCaNhanDAO.themThongTinCaNhan(thongTinCaNhan) == null)
//            return null;
//
//        String sql = "INSERT INTO KHACHHANG (MAKH, CMND) VALUES (?,?)";
//        try {
//            preparedStatement = dataBaseUtils.excuteQueryWrite(sql);
//
//            preparedStatement.setString(1, khachHang.getMaKH());
//            preparedStatement.setString(2, khachHang.getcMND());
//
//            if (preparedStatement.executeUpdate() > 0) {
//                dataBaseUtils.commitQuery();
//                return getKhachHang(khachHang.getMaKH());
//            }
//
//        } catch (Exception e) {
//            dataBaseUtils.rollbackQuery();
//            throw new Exception("Lỗi thêm khách hàng");
//        } finally {
//            preparedStatement.close();
//        }
//
//        return null;
//    }
    public static TapSuKienDAO getInstance() throws Exception {
        if (_instance == null) {
            synchronized (KhachHangDAO.class) {
                if (null == _instance) {
                    _instance = new TapSuKienDAO();
                }
            }
        }
        return _instance;
    }

    public TapSuKien getTapSuKien(int eventID) throws Exception {
        TapSuKien tapSuKien = null;
        String sql = String.format("SELECT * FROM events WHERE eventID = '%s'", eventID);

        try {
            System.out.println("Try in su kien");
            resultSet = dataBaseUtils.excuteQueryRead(sql);
            resultSet.next();
            tapSuKien = new TapSuKien(
                    resultSet.getInt("eventID"),
                    resultSet.getInt("eventTypeID"),
                    resultSet.getString("value")
            );

        } catch (Exception e) {
            throw new Exception("Lỗi lấy sự kiện");
        } finally {
            resultSet.close();
        }
        System.out.println("Lấy sự kiện thành công");
        return tapSuKien;
    }

    public ArrayList<TapSuKien> getTapSuKiens() throws Exception {
        ArrayList<TapSuKien> tapSuKiens = new ArrayList<>();
        String sql = String.format("SELECT * FROM events");

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);

            while (resultSet.next()) {
                TapSuKien tapSuKien = new TapSuKien(
                        resultSet.getInt("eventID"),
                        resultSet.getInt("eventTypeID"),
                        resultSet.getString("value")
                );
                tapSuKiens.add(tapSuKien);
            }
            System.out.println("out");
        } catch (Exception e) {
            throw new Exception("Lỗi lấy danh sách tập sự kiện");
        } finally {
            resultSet.close();
        }
        System.out.println("Trả về danh sách sự kiện");
        return tapSuKiens;
    }
}
