/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.TapLuat;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Truong-kyle
 */
public class TapLuatDAO {

    private static TapLuatDAO _instance;
    private static DataBaseUtils dataBaseUtils;
    private ResultSet resultSet;

    /**
     * Tạo kết nối DB
     *
     * @throws Exception
     */
    public TapLuatDAO() throws Exception {
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

    public static TapLuatDAO getInstance() throws Exception {
        if (_instance == null) {
            synchronized (KhachHangDAO.class) {
                if (null == _instance) {
                    _instance = new TapLuatDAO();
                }
            }
        }
        return _instance;
    }

    public TapLuat getTapLuat(int ruleID) throws Exception {
        TapLuat tapLuat = null;
        String sql = String.format("SELECT * FROM rules WHERE ruleID = '%s'", ruleID);

        try {
            System.out.println("Try in luat");
            resultSet = dataBaseUtils.excuteQueryRead(sql);
            resultSet.next();
            tapLuat = new TapLuat(
                    resultSet.getInt("ruleID"),
                    resultSet.getInt("ruleGroupID"),
                    resultSet.getString("content")
            );

        } catch (Exception e) {
            throw new Exception("Lỗi lấy luật");
        } finally {
            resultSet.close();
        }
        System.out.println("Lấy luật thành công");
        return tapLuat;
    }

    public ArrayList<TapLuat> getTapLuats() throws Exception {
        ArrayList<TapLuat> tapLuats = new ArrayList<>();
        String sql = String.format("SELECT * FROM rules");

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);

            while (resultSet.next()) {
                TapLuat tapLuat = new TapLuat(
                        resultSet.getInt("ruleID"),
                        resultSet.getInt("ruleGroupID"),
                        resultSet.getString("content")
                );
                tapLuats.add(tapLuat);
            }
            System.out.println("out");
        } catch (Exception e) {
            throw new Exception("Lỗi lấy danh sách tập luật");
        } finally {
            resultSet.close();
        }
        System.out.println("Trả về danh sách tập luật");
        return tapLuats;
    }
}
