/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhpnk.controllers;

import anhpnk.daos.tbl_RestaurantDAO;
import anhpnk.dtos.tbl_RestaurantDTO;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Kim Anh
 */
public class InsertAction extends ActionSupport {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private String id, name, address, district;
    private boolean isDelete;

    @Override
    public void validate() {
        if(id.isEmpty()) {
            addFieldError("id", "Restaurant ID must be not null");
        }
        if(name.isEmpty()) {
            addFieldError("name", "Restaurant Name must be not null");
        }
        if(address.isEmpty()) {
            addFieldError("address", "Restaurant Address must be not null");
        }
        if(district.isEmpty()) {
            addFieldError("district", "Restaurant District must be not null");
        }
    }
    
    public InsertAction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    public String execute() throws Exception {
        String result = FAIL;
        tbl_RestaurantDTO dto = new tbl_RestaurantDTO(id, name, address, district, isDelete);
        tbl_RestaurantDAO dao = new tbl_RestaurantDAO();
        boolean inserted = dao.insert(dto);
        if(inserted)
            result = SUCCESS;
        else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("INSERT", "Insert fail!!!");
        }
        return result;
    }
    
}
