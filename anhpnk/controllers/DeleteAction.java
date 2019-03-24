/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhpnk.controllers;

import anhpnk.daos.tbl_RestaurantDAO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Kim Anh
 */
public class DeleteAction {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private String id, search;
    
    public DeleteAction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    public String execute() throws Exception {
        String result = FAIL;
        tbl_RestaurantDAO dao = new tbl_RestaurantDAO();
        boolean deleted = dao.delete(id);
        System.out.println(id + "at action");
        if(deleted)
            result = SUCCESS;
        else {
            System.out.println(dao.toString());
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("DELETE", "Delete fail!!!");
        }
        return result;
    }
    
}
