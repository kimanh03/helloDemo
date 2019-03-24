/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhpnk.dtos;

import java.io.Serializable;

/**
 *
 * @author Kim Anh
 */
public class tbl_RestaurantDTO implements Serializable {
    private String restauntId, restaurantName, address, district;
    private boolean isDelete;

    public tbl_RestaurantDTO() {
    }

    public tbl_RestaurantDTO(String restauntId, String restaurantName, String address, String district, boolean isDelete) {
        this.restauntId = restauntId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.district = district;
        this.isDelete = isDelete;
    }

    public String getRestauntId() {
        return restauntId;
    }

    public void setRestauntId(String restauntId) {
        this.restauntId = restauntId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
    
}
