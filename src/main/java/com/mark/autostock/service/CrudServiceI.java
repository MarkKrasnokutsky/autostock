package com.mark.autostock.service;


import java.util.List;

public interface CrudServiceI<REQ, RES, ID> {
    List<RES> getAll();
    RES getById(ID id);
    RES add(REQ obj);
    void delete(ID id);
    RES change(ID id, REQ obj);
}
