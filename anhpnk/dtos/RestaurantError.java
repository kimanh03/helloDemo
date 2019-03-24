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
public class RestaurantError implements Serializable {
    private String restaurantIdError, restaurantNameError, addressError, districtError;

    public RestaurantError() {
    }

    public String getRestaurantIdError() {
        return restaurantIdError;
    }

    public void setRestaurantIdError(String restaurantIdError) {
        this.restaurantIdError = restaurantIdError;
    }

    public String getRestaurantNameError() {
        return restaurantNameError;
    }

    public void setRestaurantNameError(String restaurantNameError) {
        this.restaurantNameError = restaurantNameError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getDistrictError() {
        return districtError;
    }

    public void setDistrictError(String districtError) {
        this.districtError = districtError;
    }
    
}
