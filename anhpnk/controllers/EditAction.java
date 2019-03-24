/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhpnk.controllers;

import anhpnk.daos.tbl_RestaurantDAO;
import anhpnk.dtos.tbl_RestaurantDTO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Kim Anh
 */
public class EditAction {
    private String restaurantId;
    private tbl_RestaurantDTO dto;
    
    public EditAction() {
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public tbl_RestaurantDTO getDto() {
        return dto;
    }

    public void setDto(tbl_RestaurantDTO dto) {
        this.dto = dto;
    }
    
    public String execute() throws Exception {
        tbl_RestaurantDAO dao = new tbl_RestaurantDAO();
        System.out.println("ID: " + restaurantId);
        dto = dao.findByRestaurantID(restaurantId);
        if (dto!=null){
            System.out.println("not null");
        } else {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }
//        HttpServletRequest request = ServletActionContext.getRequest();
//        request.setAttribute("EDIT", this.getDto());
        return "success";
    }
    
}
