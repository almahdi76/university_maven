package com.almahdi.university;

import com.almahdi.university.dao.Etudient;
import com.almahdi.university.dao.EtudientDao;
import com.almahdi.university.dao.EtudientDaoImp;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EtudientDao etudientDao=new EtudientDaoImp();
        //(int id, int filiere, String name, String prenom, Date dateEntree, int age)
//        Etudient etudient=new Etudient(0,1,"alaa","ali",new Date(),35);
//        et.save(etudient);
//        System.out.println("save");
        etudientDao.findAll().forEach(etd -> System.out.println(etd));
        Etudient et=etudientDao.findById(5);
        System.out.println(et);
        etudientDao.deleteById(4);
        etudientDao.findAll().forEach(etd -> System.out.println(etd));



    }
}
