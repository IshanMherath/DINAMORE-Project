package lk.ijse.gdse.saver.daolayar.impl;

import lk.ijse.gdse.commen.dto.CommenDTO;
import lk.ijse.gdse.saver.Entity.Customer;
import lk.ijse.gdse.saver.daolayar.custom.CustomerDAO;
import lk.ijse.gdse.saver.daolayar.dao.CrudUtil;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class  CustomerDAOImpl implements CustomerDAO {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }
    @Override
    public boolean save(Customer ID) throws Exception {
        String sql="INSERT INTO customer values (?,?,?,?,?)";
        PreparedStatement pptm=connection.prepareStatement(sql);
        pptm.setObject(1,ID.getCustomerID());
        pptm.setObject(2,ID.getCustomer_Name());
        pptm.setObject(3,ID.getCustomerAddress());
        pptm.setObject(4,ID.getCustomer_Name());
        pptm.setObject(5,ID.getCustomerNicNO());

        System.out.println("Customer DTO    : "+ID.getCustomerID()+" : "+ID.getCustomer_Name()+" : "+ID.getCustomerAddress()+" : "+ID.getCustomerNicNO()+" : "+ID.getSalary());

        return pptm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql="DELETE FROM customer WHERE customerID = ?";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,id);
        return preparedStatement.executeUpdate()>0;



    }

    @Override
    public ArrayList<Customer> getAllCustomersss() throws Exception {
     ArrayList<Customer> customers=new ArrayList<>();
        ResultSet set = CrudUtil.executeQuery("Select * from Customer");
        while (set.next()){
            customers.add(new Customer(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getInt(5)));
        }
        return customers;
    }

    @Override
    public Customer SearchCustomer(int id) throws Exception {
        String sql="Select * from customer where customerID=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);
        ResultSet set = pstm.executeQuery();
       Customer customer=null;
        while (set.next()){
             customer= new Customer(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getInt(5));

        }
        return customer;
    }

}
