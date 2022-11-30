
package com.phoneshop.phones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phoneshop.utils.DBUtils;


public class PhoneDAO {
    public List<PhoneDTO> getAllPhone() throws SQLException {
        List<PhoneDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM phoneinfo ";
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
                    
                    list.add(new PhoneDTO(ID, name, description, brand, price, priceDel, createDate, image, typeID, quantity));
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
    
    public List<PhoneDTO> getAllPhoneTop3() throws SQLException {
        List<PhoneDTO> list = new ArrayList<>();
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
                    
                    list.add(new PhoneDTO(ID, name, description, brand, price, priceDel, createDate, image, typeID, quantity));
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
    
    public PhoneDTO getProduct(String ID) throws SQLException {
        PhoneDTO product = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT * "
                            + " FROM phoneinfo "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, ID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    String name = rs.getString("name");
                    String image = rs.getString("img");
                    String brand = rs.getString("brand");
                    int price = Integer.parseInt(rs.getString("price"));
                    int priceDel = Integer.parseInt(rs.getString("priceDel"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    int typeID = Integer.parseInt(rs.getString("typeID"));
                    String description = rs.getString("des");
                    String createDate = rs.getString("ngayNhap");

                    product = new PhoneDTO(ID, name, description, brand, price, priceDel, createDate, image, typeID, quantity);
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
    
    
    
    public List<Type> getType() throws SQLException {
        List<Type> list = new ArrayList<>();
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
                    list.add(new Type(ID, name));
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
    
    public List<Type> getType3() throws SQLException {
        List<Type> list = new ArrayList<>();
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
                    list.add(new Type(ID, name));
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
    
    
    public List<PhoneDTO> getPhoneWithType(int typeID) throws SQLException {
        List<PhoneDTO> list = new ArrayList<>();
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
                    
                    list.add(new PhoneDTO(ID, name, description, brand, price, priceDel, createDate, image, typeID, quantity));
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
    
    public PhoneDTO getProductForCart(String ID) throws SQLException {
        PhoneDTO product = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT *"
                            + " FROM phoneinfo "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, ID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    String name = rs.getString("name");
                    String image = rs.getString("img");
                    String brand = rs.getString("brand");
                    int price = Integer.parseInt(rs.getString("price"));
                    int priceDel = Integer.parseInt(rs.getString("priceDel"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    int typeID = Integer.parseInt(rs.getString("typeID"));
                    String description = rs.getString("des");
                    String createDate = rs.getString("ngayNhap");
                    
                    product = new PhoneDTO(ID, name, description, brand, price, priceDel, createDate, image, typeID, quantity);
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
    
    public List<PhoneAdmin> getAllProduct() throws SQLException {
        List<PhoneAdmin> list = new ArrayList<>();
        PhoneDAO dao = new PhoneDAO();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                String sql = "SELECT *"
                            + " FROM phoneinfo";
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
                    String typeID = dao.convertTypeName(Integer.parseInt(rs.getString("typeID")));
                    String description = rs.getString("des");
                    String createDate = rs.getString("ngayNhap");
                    
                    list.add(new PhoneAdmin(ID, name, description, brand, price, priceDel, createDate, image, typeID, quantity));
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
    
    public boolean insertProduct(PhoneDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            
            if (conn != null) {
                
                String sql = "INSERT INTO phoneinfo(ID, name, img, price, priceDel, quantity, des, typeID, ngayNhap, brand)"
                            + "VALUES(?,?,?,?,?,?,?,?,?, ?)";
                
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getID());
                stm.setString(2, product.getName());
                stm.setString(3, product.getImage());
                stm.setDouble(4, product.getPrice());
                stm.setDouble(5, product.getPriceDel());
                stm.setInt(6, product.getQuantity());
                stm.setString(7, product.getDescription());
                stm.setInt(8, product.getTypeID());
                stm.setString(9, product.getCreateDate());
                stm.setString(10, product.getBrand());
                
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
    
    public boolean updateProduct(PhoneDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE phoneinfo "
                            + " SET name=?, price=?, priceDel=?, des=?, img=?, quantity=?, typeID=?, brand=? "
                            + " WHERE ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(2, product.getName());
                stm.setDouble(3, product.getPrice());
                stm.setDouble(4, product.getPriceDel());
                stm.setString(5, product.getDescription());
                stm.setString(6, product.getImage());
                stm.setInt(7, product.getQuantity());
                stm.setInt(8, product.getTypeID());
                stm.setString(9, product.getBrand());
                stm.setString(10, product.getID());
                
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
