/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhpnk.daos;

import anhpnk.connection.MyConnection;
import anhpnk.dtos.tbl_RestaurantDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kim Anh
 */
public class tbl_RestaurantDAO implements Serializable {
    private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;

    public tbl_RestaurantDAO() {
    }
    
    private void closeConnection() throws Exception {
        if(rs != null)
            rs.close();
        if(stm != null)
            stm.close();
        if(conn != null)
            conn.close();
    }
    
    public List<tbl_RestaurantDTO> findByDistrict(String search) throws Exception {
        List<tbl_RestaurantDTO> result = null;
        try {
            String sql = "SELECT RestaurantID, RestaurantName, Address, District, isDelete FROM tbl_Restaurant WHERE District LIKE ? AND isDelete='false'";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()) {
                String id = rs.getString("RestaurantID");
                String name = rs.getString("RestaurantName");
                String address = rs.getString("Address");
                String district = rs.getString("District");
                boolean isDelete = rs.getBoolean("isDelete");
                tbl_RestaurantDTO dto = new tbl_RestaurantDTO(id, name, address, district, isDelete);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean insert(tbl_RestaurantDTO dto) throws Exception {
        boolean result = false;
        try {
            String sql = "INSERT INTO tbl_Restaurant(RestaurantID, RestaurantName, Address, District, isDelete) VALUES(?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getRestauntId());
            stm.setString(2, dto.getRestaurantName());
            stm.setString(3, dto.getAddress());
            stm.setString(4, dto.getDistrict());
            stm.setBoolean(5, dto.isIsDelete());
            result = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean delete(String id) throws Exception {
        System.out.println("i can do it");
        boolean result = false;
        try {
            String sql = "DELETE FROM tbl_Restaurant WHERE RestaurantID=?";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            System.out.println(id);
            result = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean update(tbl_RestaurantDTO dto) throws Exception {
        boolean result = false;
        try {
            String sql = "UPDATE tbl_Restaurant SET RestaurantName=?, Address=?, District=?, isDelete=? WHERE RestaurantID=?";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getRestaurantName());
            stm.setString(2, dto.getAddress());
            stm.setString(3, dto.getDistrict());
            stm.setBoolean(4, dto.isIsDelete());
            stm.setString(5, dto.getRestauntId());
            result = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public tbl_RestaurantDTO findByRestaurantID(String id) throws Exception {
        tbl_RestaurantDTO dto = null;
        try {
            String sql = "SELECT RestaurantID, RestaurantName, Address, District, isDelete FROM tbl_Restaurant WHERE RestaurantID=?";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            if(rs.next()) {
                String name = rs.getString("RestaurantName");
                String address = rs.getString("Address");
                String district = rs.getString("District");
                boolean isDelete = rs.getBoolean("isDelete");
                dto = new tbl_RestaurantDTO(id, name, address, district, isDelete);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
