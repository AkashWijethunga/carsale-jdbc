package com.example.carsale.modle;

import com.example.carsale.db.DBConnection;
import com.example.carsale.dto.Vehicledto;
import com.example.carsale.tm.VehicleTM;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;

public class VehicleModel {

    public static boolean addNewCar(Vehicledto vehicledto) {
        try {
            Connection connection= DBConnection.getDbConnection().getConnection();
            //write sql Quary
            PreparedStatement preparedStatement=connection.prepareStatement("insert into Vehicale (brand,model,qty,price) values(?,?,?,?)");
            preparedStatement.setString(1,vehicledto.getBrand());
            preparedStatement.setString(2,vehicledto.getModel());
            preparedStatement.setInt(3,vehicledto.getQty());
            preparedStatement.setDouble(4, vehicledto.getPrice());

            //execute Quary
            int i=preparedStatement.executeUpdate();

            if(i>0){
                return true;
            }else{
               return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static boolean updateCar(Vehicledto vehicledto,int id) {
        try {
            Connection connection= DBConnection.getDbConnection().getConnection();
            //write sql Quary
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE Vehicale SET brand=?,model=?,qty=?,price=?  where id=?");

            preparedStatement.setString(1, vehicledto.getBrand());
            preparedStatement.setString(2,vehicledto.getModel());
            preparedStatement.setInt(3,vehicledto.getQty());
            preparedStatement.setDouble(4,vehicledto.getPrice());
            preparedStatement.setInt(5,id);

            int i=preparedStatement.executeUpdate();

            if(i>0){
                return true;
            }else {
                return false;
            }

           } catch (ClassNotFoundException | SQLException e) {
                 throw new RuntimeException(e);
        }
        }

        public static boolean deleteCar(int id) {
            try {
                Connection connection= DBConnection.getDbConnection().getConnection();
                //write sql Quary
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Vehicale  where id=?");
                preparedStatement.setInt(1, id);

                int i = preparedStatement.executeUpdate();

                if(i>0){
                    return true;
                }else {
                    return false;
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }


        public static Vehicledto serchCar(int id) {
            try {
                Connection connection= DBConnection.getDbConnection().getConnection();
                //write sql Quary
                PreparedStatement preparedStatement=connection.prepareStatement("select * from Vehicale where id=?");
                preparedStatement.setInt(1,id);

                ResultSet resultSet=preparedStatement.executeQuery();
                if(resultSet.next()) {
                    return (new Vehicledto(resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getDouble(5)));
                }else {
                    return null;
                }


            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public static ArrayList<VehicleTM> getAllCars() {
            ArrayList<VehicleTM> cars = new ArrayList<>();
            try {
                Connection connection=DBConnection.getDbConnection().getConnection();
                PreparedStatement preparedStatement=connection.prepareStatement("select * from Vehicale");
                ResultSet resultSet=preparedStatement.executeQuery();
                while(resultSet.next()) {
                    cars.add(new VehicleTM(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDouble(5)));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return cars;
        }
}
