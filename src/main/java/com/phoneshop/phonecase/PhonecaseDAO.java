
package com.phoneshop.phonecase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phoneshop.utils.DBUtils;


public class PhonecaseDAO {
    public List<PhonecaseDTO> getAllPhonecase(String ID) throws SQLException {
        List<PhonecaseDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM phonecase"
                            + " WHERE phoneID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, ID);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String ID1 = rs.getString("phoneCaseID");
                    String color = rs.getString("colorID");
                    String image = rs.getString("imgPC");    
                    int price = Integer.parseInt(rs.getString("price"));
                    list.add(new PhonecaseDTO(ID, ID1, color, image, price));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public PhonecaseDTO getAllPhonecasebyID(String ID) throws SQLException {
        PhonecaseDTO pcase = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM phonecase"
                            + " WHERE phoneCaseID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, ID);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String ID1 = rs.getString("phoneCaseID");
                    String color = rs.getString("colorID");
                    String image = rs.getString("imgPC");    
                    int price = Integer.parseInt(rs.getString("price"));
                    pcase = new PhonecaseDTO(ID, ID1, color, image, price);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return pcase;
    }
    
    public List<PhonecaseDTO> getAllPhoneTop3() throws SQLException {
        List<PhonecaseDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM phoneinfo "
                            + " statistic";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    String name = rs.getString("name");
                    String image = rs.getString("img");
                    String brand = rs.getString("brand");
                    int price = Integer.parseInt(rs.getString("price"));
                    int priceDel = Integer.parseInt(rs.getString("priceDel"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    int typeID = Integer.parseInt(rs.getString("typeID"));
                    String description = rs.getString("des");
                    String createDate = rs.getString("ngayNhap");
                    
                    list.add(new PhonecaseDTO(ID, name, description, createDate, typeID));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public PhonecaseDTO getProduct(String ID) throws SQLException {
        PhonecaseDTO product = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM phonecase "
                            + " WHERE phoneCaseID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, ID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                	String ID1 = rs.getString("phoneCaseID");
                	String phoneID1 = rs.getString("phoneID");
                    String color = rs.getString("colorID");
                    String image = rs.getString("imgPC");
                    int price = Integer.parseInt(rs.getString("price"));
                    product = new PhonecaseDTO(ID1, phoneID1, color, image, price);
                }
                
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return product;
    }
    
    
    
    public List<PhonecaseType> getType() throws SQLException {
        List<PhonecaseType> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM type ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    int ID = Integer.parseInt(rs.getString("typeID"));
                    String name = rs.getString("name");
                    list.add(new PhonecaseType(ID, name));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public List<PhonecaseType> getType3() throws SQLException {
        List<PhonecaseType> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM type "
                            + " statistic";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    int ID = Integer.parseInt(rs.getString("typeID"));
                    String name = rs.getString("name");   
                    list.add(new PhonecaseType(ID, name));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    
    public List<PhonecaseDTO> getPhoneWithType(int typeID) throws SQLException {
        List<PhonecaseDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM phoneinfo "
                            + " WHERE typeID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, typeID);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    String name = rs.getString("name");
                    String image = rs.getString("img");
                    String brand = rs.getString("brand");
                    int price = Integer.parseInt(rs.getString("price"));
                    int priceDel = Integer.parseInt(rs.getString("priceDel"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String description = rs.getString("des");
                    String createDate = rs.getString("ngayNhap");
                    
                    list.add(new PhonecaseDTO(ID, name, description, createDate, quantity));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
    public PhonecaseDTO getProductForCart(String ID) throws SQLException {
        PhonecaseDTO product = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT *"
                            + " FROM phonecase "
                            + " WHERE phoneCaseID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, ID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                	String phoneID1 = rs.getString("phoneID");
                    String color = rs.getString("colorID");
                    String image = rs.getString("imgPC");    
                    int price = Integer.parseInt(rs.getString("price"));
                    product = new PhonecaseDTO(phoneID1, ID, color, image, price);
                }
                
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return product;
    }
    
    public boolean minusProduct(String productID, int quantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "UPDATE phoneinfor"
                            + " SET quantity = ? "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, getProductQuantity(productID) - quantity);
                stm.setString(2, productID);
                check = stm.executeUpdate() > 0;
                
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return check;
    }
    
    public int getProductQuantity(String productID) throws SQLException {
        int quantity = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT quantity"
                            + " FROM phoneinfo "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    quantity = Integer.parseInt(rs.getString("quantity"));
                }
                
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return quantity;
    }
    
    public List<PhonecaseDTO> getAllProduct() throws SQLException {
        List<PhonecaseDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT *"
                            + " FROM phonecase";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                	String ID = rs.getString("phoneCaseID");
                	String phoneID1 = rs.getString("phoneID");
                    String color = rs.getString("colorID");
                    String image = rs.getString("imgPC");        
                    int price = Integer.parseInt(rs.getString("price"));
                    list.add(new PhonecaseDTO(ID, phoneID1, color, image, price));
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return list;
    }
    
   
    public String convertTypeName(int typeID) throws SQLException {
        String typeName = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT name"
                            + " FROM type "
                            + " WHERE typeID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, typeID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    typeName = rs.getString("name");
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        }
        
        return typeName;
    }
    
    public boolean insertProduct(PhonecaseDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                
                String sql = "INSERT INTO phonecase(phoneCaseID, phoneID, colorID, imgPC, price)"
                            + "VALUES(?,?,?,?,?)";
                
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getPcID());
                stm.setString(2, product.getPhoneID());
                stm.setString(3, product.getColor());
                stm.setString(4, product.getImage());
                stm.setInt(5, product.getPrice());

                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean updateProduct(PhonecaseDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE phonecase "
                            + " SET phoneCaseID =?, phoneID =?, colorID=?, imgPC=?"
                            + " WHERE phoneCaseID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getPcID());
                stm.setString(2, product.getPhoneID());
                stm.setString(3, product.getColor());
                stm.setString(4, product.getImage());
                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return check;
    }
    
    public boolean deleteProduct(String productId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "DELETE FROM phoneinfo WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productId);
                
                check = stm.executeUpdate() > 0;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return check;
    }
    
}
