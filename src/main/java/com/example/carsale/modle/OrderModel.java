package com.example.carsale.modle;

import com.example.carsale.db.DBConnection;
import com.example.carsale.dto.OrderDetailDto;
import com.example.carsale.dto.OrderDto;

import java.sql.*;

public class OrderModel {
    public static boolean placeOrder(OrderDto order) throws SQLException, ClassNotFoundException {
        Connection connection =DBConnection.getDbConnection().getConnection();
        //disable auto commit feature
        connection.setAutoCommit(false);

        //insert data to order table
        PreparedStatement stm1 =connection.prepareStatement("insert into orders(order_date,amount) values(?,?)", Statement.RETURN_GENERATED_KEYS);

        stm1.setObject(1,order.getOrderDate());
        stm1.setObject(2,order.getTotalPrice());

        int orderSave=stm1.executeUpdate();

        if(orderSave>0){
            //get order id from generated keys
            ResultSet generatedKeys = stm1.getGeneratedKeys();

            if(generatedKeys.next()){
                int orderId = generatedKeys.getInt(1);

                //save --->order details
                for(OrderDetailDto orderDetailDto :order.getOrderDetailDtos()){

                    PreparedStatement stm2=connection.prepareStatement("insert into order_details(oid,vid,qty,price) values(?,?,?,?)");
                    stm2.setObject(1,orderId);
                    stm2.setObject(2,orderDetailDto.getVehicleId());
                    stm2.setObject(3,orderDetailDto.getQty());
                    stm2.setObject(4,orderDetailDto.getPrice());

                    int orderDetailSave=stm2.executeUpdate();

                    if(orderDetailSave>0){
                    PreparedStatement stm3=connection.prepareStatement("UPDATE  vehicale set qty=qty-? where id=?");
                    stm3.setObject(1,orderDetailDto.getQty());
                    stm3.setObject(2,orderDetailDto.getVehicleId());

                    int vehicaleQtyUpdate=stm3.executeUpdate();

                    if(vehicaleQtyUpdate<=0){
                        connection.rollback();
                        connection.setAutoCommit(true);
                        return false;
                    }

                    }else {
                        connection.rollback();
                        connection.setAutoCommit(true);
                        return false;
                    }
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

    }
}
