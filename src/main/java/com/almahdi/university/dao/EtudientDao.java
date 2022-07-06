package com.almahdi.university.dao;

import com.almahdi.university.model.Etudient;

import java.util.List;

public interface EtudientDao {
    List<Etudient> findAll();
    Etudient findById(int id);
    void save(Etudient employee);
    void deleteById(int id);
}
