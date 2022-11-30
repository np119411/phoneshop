
package com.phoneshop.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.phoneshop.utils.DBUtils;

public class OrderDAO {
    public boolean insertOrder(Order order) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            String orderID = order.getOrderID();
            double totalPrice = order.getTotalPrice();
            String createDate = order.getCreateDate();
            
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "INSERT INTO tblorder(orderID, totalPrice, createDate) "
                            + " VALUES(?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, orderID);
                stm.setDouble(3, totalPrice);
                stm.setString(4, createDate);
                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();;
            }
            if (conn != null) {
                conn.close();;
            }
        }
        
        return check;
    }
    
    public boolean insertOrderDetail(OrderDetail orderDetail) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            String detailID = orderDetail.getDetailID();
            String orderID = orderDetail.getOrderID();
            String productID = orderDetail.getProductID();
            double detailPrice = orderDetail.getDetailPrice();
            int quantity = orderDetail.getQuantity();
            
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "INSERT INTO orderDetail(detailID, orderID, phoneID, detailPrice, quantity) "
                            + " VALUES(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, detailID);
                stm.setString(2, orderID);
                stm.setString(3, productID);
                stm.setDouble(4, detailPrice);
                stm.setInt(5, quantity);
                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();;
            }
            if (conn != null) {
                conn.close();;
            }
        }
        
        return check;
    }
}
