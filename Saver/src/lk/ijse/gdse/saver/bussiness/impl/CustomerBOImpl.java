package lk.ijse.gdse.saver.bussiness.impl;

import lk.ijse.gdse.commen.dto.CommenDTO;
import lk.ijse.gdse.commen.dto.CustomerDTO;
import lk.ijse.gdse.commen.dto.PlaceOrderDTO;
import lk.ijse.gdse.saver.Entity.Customer;
import lk.ijse.gdse.saver.Entity.Food;
import lk.ijse.gdse.saver.Entity.Orders;
import lk.ijse.gdse.saver.Entity.PlaceOrder;
import lk.ijse.gdse.saver.bussiness.custom.CustomerBO;
import lk.ijse.gdse.saver.daolayar.custom.CustomerDAO;
import lk.ijse.gdse.saver.daolayar.custom.FoodDAO;
import lk.ijse.gdse.saver.daolayar.custom.OrderDAO;
import lk.ijse.gdse.saver.daolayar.custom.PlaceOrderDAO;
import lk.ijse.gdse.saver.daolayar.dao.DAOFactory;
import lk.ijse.gdse.saver.daolayar.dao.SuperDAO;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    private CustomerDAO customerDAO;
    private FoodDAO foodDAO;
    private PlaceOrderDAO placeOrderDAO;
    private OrderDAO orderDAO;

    public CustomerBOImpl() {

        customerDAO=(CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.CUSTOMER);
        foodDAO= (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.FOOD);
        placeOrderDAO = (PlaceOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.PLACEORDER);
        orderDAO= (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.ORDER);
    }

    @Override
    public boolean saveBCustomer(CustomerDTO customerDTO) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        customerDAO.setConnection(connection);
        Customer customer=new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getNic(),customerDTO.getSalary());
        boolean result = customerDAO.save(customer);
        DBConnection.getInstance().releaseConnection(connection);
        return result;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomerss() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        customerDAO.setConnection(connection);
        ArrayList<CustomerDTO> customerDTOS=new ArrayList<>();
        ArrayList<Customer> allCustomerss = customerDAO.getAllCustomersss();
        for (Customer cus: allCustomerss) {
            customerDTOS.add(new CustomerDTO(cus.getCustomerID(),cus.getCustomer_Name(),cus.getCustomerAddress(),cus.getCustomerNicNO(),cus.getSalary()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return customerDTOS;
    }

    @Override
    public boolean deleteCustomerrs(String id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        customerDAO.setConnection(connection);
        boolean delete = customerDAO.delete(id);
        DBConnection.getInstance().releaseConnection(connection);
        return  delete;
    }

    @Override
    public boolean saveTransaction(CommenDTO commenDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
       // customerDAO.setConnection(connection);
        connection.setAutoCommit(false);
            try {
                boolean add = customerDAO.save(new Customer(
                commenDTO.getCustomerDTO().getId(),
                commenDTO.getCustomerDTO().getName(),
                commenDTO.getCustomerDTO().getAddress(),
                commenDTO.getCustomerDTO().getNic(),
                commenDTO.getCustomerDTO().getSalary()
        ));
        if(!add){
            connection.rollback();
            return false;
        }
                add = orderDAO.saveOrder(new Orders(
                        commenDTO.getOrdersDTO().getItemCode(),
                        commenDTO.getOrdersDTO().getCustomerID(),
                        commenDTO.getOrdersDTO().getReceptionistID(),
                        commenDTO.getOrdersDTO().getOrderDate(),
                        commenDTO.getOrdersDTO().getOrderQty(),
                        commenDTO.getOrdersDTO().getUnitPrice(),
                        commenDTO.getOrdersDTO().getStatus()));
                if (!add){
                    connection.rollback();
                    return false;
                }


                add = placeOrderDAO.save(new PlaceOrder(
                 commenDTO.getPlaceOrderDTO().getOrederID(),
                 commenDTO.getPlaceOrderDTO().getCustomerID(),
                commenDTO.getPlaceOrderDTO().getReceptionistID(),
                 commenDTO.getPlaceOrderDTO().getItemCode(),
                commenDTO.getPlaceOrderDTO().getOrderDate(),
                commenDTO.getPlaceOrderDTO().getOrderTakeTime(),
                commenDTO.getPlaceOrderDTO().getOrderIssuTime(),
                commenDTO.getPlaceOrderDTO().getOrderQty()
        ));

        if(!add){
            connection.rollback();
            return false;
        }
        connection.commit();
        return true;
            }finally {
                connection.setAutoCommit(true);
               // DBConnection.getInstance().releaseConnection(connection);

            }

    }

    @Override
    public CustomerDTO searchCustomer(int id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        customerDAO.setConnection(connection);
        Customer cust = customerDAO.SearchCustomer(id);
        CustomerDTO DTO=new CustomerDTO(cust.getCustomerID(),cust.getCustomer_Name(),cust.getCustomerAddress(),cust.getCustomerNicNO(),cust.getSalary());
        DBConnection.getInstance().releaseConnection(connection);
        return DTO;
    }

    @Override
    public boolean saveTransaction2(CommenDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        customerDAO.setConnection(connection);
        boolean add;
        connection.setAutoCommit(false);
        try {
            add = orderDAO.saveOrder(new Orders(
                    dto.getOrdersDTO().getItemCode(),
                    dto.getOrdersDTO().getCustomerID(),
                    dto.getOrdersDTO().getReceptionistID(),
                    dto.getOrdersDTO().getOrderDate(),
                    dto.getOrdersDTO().getOrderQty(),
                    dto.getOrdersDTO().getUnitPrice(),
                    dto.getOrdersDTO().getStatus()));
            if (!add) {
                connection.rollback();
                return false;
            }
            add = placeOrderDAO.save(new PlaceOrder(
                    dto.getPlaceOrderDTO().getOrederID(),
                    dto.getPlaceOrderDTO().getCustomerID(),
                    dto.getPlaceOrderDTO().getReceptionistID(),
                    dto.getPlaceOrderDTO().getItemCode(),
                    dto.getPlaceOrderDTO().getOrderDate(),
                    dto.getPlaceOrderDTO().getOrderTakeTime(),
                    dto.getPlaceOrderDTO().getOrderIssuTime(),
                    dto.getPlaceOrderDTO().getOrderQty()
            ));

            if (!add) {
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;


        } finally {
        connection.commit();
        DBConnection.getInstance().releaseConnection(connection);
        return true;
        }
    }
}
