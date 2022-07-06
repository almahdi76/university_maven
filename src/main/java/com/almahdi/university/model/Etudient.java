package com.almahdi.university.model;

import java.util.Date;

public class Etudient {
    private int id;
    private int filiere;
    private String name;
    private String prenom;
    private Date dateEntree;
    private int age;

    public Etudient() {
    }

    public Etudient(int filiere, String name, String prenom, Date dateEntree, int age) {
        this.filiere = filiere;
        this.name = name;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.age = age;
    }

    public Etudient(int id, int filiere, String name, String prenom, Date dateEntree, int age) {
        this.id = id;
        this.filiere = filiere;
        this.name = name;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFiliere() {
        return filiere;
    }

    public void setFiliere(int filiere) {
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Etudient{" +
                "id=" + id +
                ", filiere=" + filiere +
                ", name='" + name + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateEntree=" + dateEntree +
                ", age=" + age +
                '}';
    }
}
