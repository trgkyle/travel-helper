/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Truong-kyle
 */
public class TapSuKienDAO {
    private static TapSuKienDAO _instance;
    private static DataBaseUtils dataBaseUtils;
    
    
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
            synchronized (KhachHangDAO.class) {
                if (null == _instance) {
                    _instance = new TapSuKienDAO();
                }
            }
        }
        return _instance;
    }
}
