package lk.ijse.gdse.saver.bussiness.impl;

import lk.ijse.gdse.commen.dto.ChefDTO;
import lk.ijse.gdse.saver.Entity.Chef;
import lk.ijse.gdse.saver.bussiness.custom.CheffBO;
import lk.ijse.gdse.saver.daolayar.custom.CheffDAO;
import lk.ijse.gdse.saver.daolayar.dao.DAOFactory;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public class CheffBOImpl implements CheffBO {
    private CheffDAO cheffDAO;
    public CheffBOImpl() {
        cheffDAO= (CheffDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.CHEFF);
    }

    @Override
    public boolean addOrder() throws Exception {
        return false;
    }

    @Override
    public boolean addCheff(ChefDTO dto) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        cheffDAO.setConnection(connection);
        boolean b = cheffDAO.addCheff(new Chef(dto.getChefID(), dto.getChefF_Name(), dto.getChefAddress(), dto.getChefTel(), dto.getAge()));
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }

    @Override
    public boolean deleteCheff(int id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        cheffDAO.setConnection(connection);
        boolean b = cheffDAO.deleteCheff(id);
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }

    @Override
    public ChefDTO searchCheff(int id) throws Exception {
       Connection connection=DBConnection.getInstance().getConnection();
        cheffDAO.setConnection(connection);
        Chef chef = cheffDAO.searchCheff(id);
        ChefDTO chefDTO= new ChefDTO(chef.getChefID(),chef.getChefF_Name(),chef.getChefAddress(),chef.getChefTel(),chef.getAge());
        DBConnection.getInstance().releaseConnection(connection);
        return chefDTO;
    }

    @Override
    public boolean updateCheff(ChefDTO dto) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        cheffDAO.setConnection(connection);
        boolean b = cheffDAO.updateCheff(new Chef(dto.getChefID(), dto.getChefF_Name(), dto.getChefAddress(), dto.getChefTel(), dto.getAge()));
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }

    @Override
    public ArrayList<ChefDTO> getAllCheff() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        cheffDAO.setConnection(connection);
        ArrayList<ChefDTO> dto=new ArrayList<>();
        ArrayList<Chef> all = cheffDAO.getAllCheff();
        for (Chef dto1:all) {
            dto.add(new ChefDTO(dto1.getChefID(),dto1.getChefF_Name(),dto1.getChefAddress(),dto1.getChefTel(),dto1.getAge()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return dto;
    }
}
