/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.TapLuat;
import java.sql.PreparedStatement;
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
    private PreparedStatement preparedStatement;

    /**
     * Tạo kết nối DB
     *
     * @throws Exception
     */
    public TapLuatDAO() throws Exception {
        dataBaseUtils = DataBaseUtils.getInstance();

    }

    public static TapLuatDAO getInstance() throws Exception {
        if (_instance == null) {
            synchronized (TapLuatDAO.class) {
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

    /**
     * Thêm khách hàng mới vào DB
     *
     * @param khachHang
     * @return
     * @throws Exception
     */
    public TapLuat addTapLuat(TapLuat tapLuat) throws Exception {

        String sql = "INSERT INTO rules (content) VALUES (?)";
        String sqlInsertGroup = "INSERT INTO ruleGroups (left1,left2,[right],ruleID) VALUES (?,?,?,?)";
        try {
            int index = -1;
            preparedStatement = dataBaseUtils.excuteQueryWrite(sql, new String[]{"ruleID"});
            preparedStatement.setString(1, tapLuat.getContent());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                index = resultSet.getInt(1);
            }
            dataBaseUtils.commitQuery();
            String rules[];
            String rule = tapLuat.getContent().replaceAll("([a-z]|[A-Z])", "");
            rules = rule.split("\\^|->");

            for (String rulesLoop : rules) {
                System.out.println(rulesLoop);
            }
            System.out.println("length : " + rules.length);
            if (rules.length == 2) {
                preparedStatement = dataBaseUtils.excuteQueryWrite(sqlInsertGroup);
                preparedStatement.setInt(1, Integer.parseInt(rules[0].trim()));
                preparedStatement.setInt(2, Integer.parseInt(rules[0].trim()));
                preparedStatement.setInt(3, Integer.parseInt(rules[rules.length - 1].trim()));
                preparedStatement.setInt(4, index);

                preparedStatement.executeUpdate();
                dataBaseUtils.commitQuery();
            } else {
                for (int i = 0; i < rules.length - 1; i++) {
                    for (int j = 0; j < rules.length - 1; j++) {
                        if (j == i) {
                            continue;
                        }
                        preparedStatement = dataBaseUtils.excuteQueryWrite(sqlInsertGroup);
                        preparedStatement.setInt(1, Integer.parseInt(rules[i].trim()));
                        preparedStatement.setInt(2, Integer.parseInt(rules[j].trim()));
                        preparedStatement.setInt(3, Integer.parseInt(rules[rules.length - 1].trim()));
                        preparedStatement.setInt(4, index);

                        preparedStatement.executeUpdate();
                    }
                    dataBaseUtils.commitQuery();
                }
            }

            return tapLuat;

        } catch (Exception e) {
            dataBaseUtils.rollbackQuery();
            System.out.println(e);
            throw new Exception("Lỗi thêm luật");

        } finally {
            preparedStatement.close();
        }

    }

    public boolean xoaTapLuat(int ruleID) throws Exception {
        String sql = "DELETE FROM rules WHERE ruleID = ?";

        try {
            preparedStatement = dataBaseUtils.excuteQueryWrite(sql);

            preparedStatement.setInt(1, ruleID);

            if (preparedStatement.executeUpdate() > 0) {
                dataBaseUtils.commitQuery();
            }
        } catch (Exception e) {
            dataBaseUtils.rollbackQuery();
            throw new Exception("Lỗi xoá luat");
        } finally {
            preparedStatement.close();
        }

        return false;
    }

    public TapLuat suaTapLuat(TapLuat tapLuat) throws Exception {
        String sql = "UPDATE rules SET "
                + "content = ?"
                + "WHERE ruleID = ?";

        try {
            preparedStatement = dataBaseUtils.excuteQueryWrite(sql);

            preparedStatement.setString(1, tapLuat.getContent());
            preparedStatement.setInt(2, tapLuat.getRuleID());

            if (preparedStatement.executeUpdate() > 0) {
                dataBaseUtils.commitQuery();
                return getTapLuat(tapLuat.getRuleID());
            }
        } catch (Exception e) {
            dataBaseUtils.rollbackQuery();
            throw new Exception("Lỗi cập nhật tap luat");
        } finally {
            preparedStatement.close();
        }

        return null;
    }
}
