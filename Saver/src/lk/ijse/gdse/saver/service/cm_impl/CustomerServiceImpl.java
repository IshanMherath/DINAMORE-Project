package lk.ijse.gdse.saver.service.cm_impl;

import lk.ijse.gdse.commen.cm_custome.CustomerSavice;
import lk.ijse.gdse.commen.dto.CommenDTO;
import lk.ijse.gdse.commen.dto.CustomerDTO;
import lk.ijse.gdse.commen.observer.Obsever;
import lk.ijse.gdse.commen.observer.Subject;
import lk.ijse.gdse.saver.Entity.Customer;
import lk.ijse.gdse.saver.bussiness.bo.BoFactory;
import lk.ijse.gdse.saver.bussiness.custom.CustomerBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerSavice {
    private CustomerBO customerBO;
//    private static List<Obsever> observers = new ArrayList<>();

    public CustomerServiceImpl() throws RemoteException {
        customerBO= (CustomerBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.CUSTOMER);
    }

    @Override
    public boolean CustomerSave(CustomerDTO customerDTO) throws Exception {
        boolean b = customerBO.saveBCustomer(customerDTO);


        return b;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        ArrayList<CustomerDTO> customerDTOS=new ArrayList<>();
        ArrayList<CustomerDTO> allCustomerss = customerBO.getAllCustomerss();
        for (CustomerDTO cus: allCustomerss) {
            customerDTOS.add(new CustomerDTO(cus.getId(),cus.getName(),cus.getAddress(),cus.getNic(),cus.getSalary()));
        }
        return customerDTOS;
    }

    @Override
    public boolean DeleteCustomer(String id) throws Exception {
        boolean delete = customerBO.deleteCustomerrs(id);

        return delete;

    }

    @Override
    public boolean saveTransaction(CommenDTO commenDTO) throws Exception {
        boolean b = customerBO.saveTransaction(commenDTO);
        return b;
    }

    @Override
    public boolean saveTransaction2(CommenDTO dto) throws Exception {
        boolean b = customerBO.saveTransaction2(dto);
        return b;
    }

    @Override
    public CustomerDTO searchCustomer(int id) throws Exception {
        CustomerDTO DTO = customerBO.searchCustomer(id);
        CustomerDTO cust=new CustomerDTO(DTO.getId(),DTO.getName(),DTO.getAddress(),DTO.getNic(),DTO.getSalary());
        return cust;

    }

}
