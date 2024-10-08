package com.mark.autostock.service;


import java.util.List;

public interface CrudServiceI<T, ID> {
    List<T> getAll();
    T getById(ID id);
    T add(T automobile);
    T change(ID id, T auto);
}
