/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhpnk.controllers;

import anhpnk.daos.tbl_RestaurantDAO;
import anhpnk.dtos.tbl_RestaurantDTO;
import java.util.List;

/**
 *
 * @author Kim Anh
 */
public class SearchAction {
    private String search;
    private List<tbl_RestaurantDTO> list;
    
    public SearchAction() {
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<tbl_RestaurantDTO> getList() {
        return list;
    }
    
    public String execute() throws Exception {
        if(!search.isEmpty()) {
            tbl_RestaurantDAO dao = new tbl_RestaurantDAO();
            list = dao.findByDistrict(search);
        }
        
        return "success";
    }
    
}
