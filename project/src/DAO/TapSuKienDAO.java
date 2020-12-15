/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.DanhSachTapSuKien;
import Model.TapLoaiSuKien;
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

    public static TapSuKienDAO getInstance() throws Exception {
        if (_instance == null) {
            synchronized (TapSuKienDAO.class) {
                if (null == _instance) {
                    _instance = new TapSuKienDAO();
                }
            }
        }
        return _instance;
    }

    public TapSuKien getTapSuKien(int eventID) throws Exception {
        TapSuKien tapSuKien = null;
        String sql = String.format("SELECT * FROM events INNER JOIN eventTypes ON events.eventTypeID = eventTypes.eventTypeID WHERE eventID = '%s'", eventID);

        try {
            System.out.println("Try in su kien");
            resultSet = dataBaseUtils.excuteQueryRead(sql);
            resultSet.next();
            tapSuKien = new TapSuKien(
                    resultSet.getInt("eventID"),
                    resultSet.getInt("eventTypeID"),
                    resultSet.getString("value"),
                    resultSet.getString("name")
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
        String sql = String.format("SELECT * FROM events INNER JOIN eventTypes ON events.eventTypeID = eventTypes.eventTypeID");

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);

            while (resultSet.next()) {
                TapSuKien tapSuKien = new TapSuKien(
                        resultSet.getInt("eventID"),
                        resultSet.getInt("eventTypeID"),
                        resultSet.getString("value"),
                        resultSet.getString("name")
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
    
    public ArrayList<TapLoaiSuKien> getTapLoaiSuKiens() throws Exception {
        ArrayList<TapLoaiSuKien> tapNhomSuKiens = new ArrayList<>();
        String sql = String.format("SELECT * FROM eventTypes");
        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);

            while (resultSet.next()) {
                TapLoaiSuKien tapLoaiSuKien = new TapLoaiSuKien(
                        resultSet.getInt("eventTypeID"),
                        resultSet.getString("name")
                );
                tapNhomSuKiens.add(tapLoaiSuKien);
            }
            System.out.println("out");
        } catch (Exception e) {
            throw new Exception("Lỗi lấy danh sách tập loại sự kiện");
        } finally {
            resultSet.close();
        }
        System.out.println("tra ve tap loai su kien");
        return tapNhomSuKiens;
    }
}
