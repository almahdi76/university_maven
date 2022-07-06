package com.almahdi.university.dao;

import com.almahdi.university.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EtudientDaoImp implements EtudientDao {


    @Override
    public List<Etudient> findAll() {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return null;
        }

        String query = "SELECT * FROM etudient;";
        List<Etudient> ListEtudients = new LinkedList<>();
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Etudient etudient = new Etudient(resultSet.getInt("id"),
                        resultSet.getInt("filiere"),
                        resultSet.getString("name"),
                        resultSet.getString("prenom"),
                        resultSet.getDate("date_entree"),
                        resultSet.getInt("age"));
                        ListEtudients.add(etudient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return ListEtudients;
    }

    @Override
    public Etudient findById(int id) {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return null;
        }
        String query = "SELECT * FROM etudient WHERE id=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Etudient etudient = new Etudient(resultSet.getInt("id"),
                        resultSet.getInt("filiere"),
                        resultSet.getString("name"),
                        resultSet.getString("prenom"),
                        resultSet.getDate("date_entree"),
                        resultSet.getInt("age"));
                return etudient;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public  void save(Etudient etudient) {
        Connection con = DBconnection.getConnection();
        if(con==null){
            return;
        }else{
            if(etudient.getId()>0){ //update
                String query="UPDATE  etudient SET filiere=?, name=?, prenom=?, date_entree=?, age=?  WHERE id=?;";

                try(PreparedStatement preparedStatement=con.prepareStatement(query)) {
                    //  PreparedStatement preparedStatement=con.prepareStatement(query); pour bien closed
                    //preparedStatement.setInt(1,employ.getId());
                    preparedStatement.setInt(1, etudient.getFiliere());
                    preparedStatement.setString(2,etudient.getName());
                    preparedStatement.setString(3,etudient.getPrenom());
                    preparedStatement.setDate(4, Utils.getSqlDate(etudient.getDateEntree()));
                    preparedStatement.setInt(5,etudient.getAge());

                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }else{
                //String query="UPDATE  etudient SET filiere=?, name=?, prenom=?, date_entree=?, age=?  WHERE id=?;";
                String query="INSERT INTO etudient(filiere,name,prenom,date_entree,age) VALUES (?,?,?,?,?);";
                // String query="INSERT INTO emps(id_e,nom,prenom) VALUES (?,?,?);";
                try(PreparedStatement preparedStatement=con.prepareStatement(query)) {
                    //  PreparedStatement preparedStatement=con.prepareStatement(query); pour bien closed
                    //preparedStatement.setInt(1,employ.getId());
                    preparedStatement.setInt(1, etudient.getFiliere());
                    preparedStatement.setString(2,etudient.getName());
                    preparedStatement.setString(3,etudient.getPrenom());
                    preparedStatement.setDate(4, Utils.getSqlDate(etudient.getDateEntree()));
                    preparedStatement.setInt(5,etudient.getAge());

                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }



    }

    @Override
    public void deleteById(int id) {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return;
        }
        String query = "DELETE  FROM etudient WHERE id=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return;
    }


}
