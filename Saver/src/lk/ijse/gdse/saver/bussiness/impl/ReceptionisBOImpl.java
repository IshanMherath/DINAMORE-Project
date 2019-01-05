package lk.ijse.gdse.saver.bussiness.impl;

import lk.ijse.gdse.commen.dto.ReseptionDTO;
import lk.ijse.gdse.saver.Entity.Receptionis;
import lk.ijse.gdse.saver.bussiness.custom.ReceptionisBO;
import lk.ijse.gdse.saver.daolayar.custom.ReceptionisDAO;
import lk.ijse.gdse.saver.daolayar.dao.DAOFactory;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public class ReceptionisBOImpl implements ReceptionisBO {
    private ReceptionisDAO receptionisDAO;
    public ReceptionisBOImpl() {
        receptionisDAO= (ReceptionisDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.RECEPTIONIST);
    }

    @Override
    public boolean addReception(ReseptionDTO dto) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        receptionisDAO.setConnection(connection);
        boolean b = receptionisDAO.addReception(new Receptionis(dto.getReceptionistID(),
                dto.getReceptionistF_Name(), dto.getReceptionistAddress(), dto.getReceptionistTel(), dto.getAge(),
                dto.getCity()));
    DBConnection.getInstance().releaseConnection(connection);
    return b;
    }

    @Override
    public boolean deleteReception(int id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        receptionisDAO.setConnection(connection);
        boolean b = receptionisDAO.deleteReception(id);
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }

    @Override
    public ReseptionDTO serchCustomer(int id) throws Exception {
        Connection  connection=DBConnection.getInstance().getConnection();
        receptionisDAO.setConnection(connection);
        Receptionis rec = receptionisDAO.searchCustomer(id);
        ReseptionDTO receptionis=new ReseptionDTO(rec.getReceptionistID(),rec.getReceptionistF_Name(),rec.getReceptionistAddress(),rec.getReceptionistTel(),rec.getAge(),rec.getCity());
        DBConnection.getInstance().releaseConnection(connection);
        return receptionis;
    }

    @Override
    public boolean UpdateReception(ReseptionDTO dto) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        receptionisDAO.setConnection(connection);
        boolean b = receptionisDAO.updateRecption(new Receptionis(dto.getReceptionistID(),
                dto.getReceptionistF_Name(), dto.getReceptionistAddress(), dto.getReceptionistTel(), dto.getAge(),
                dto.getCity()));
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }

    @Override
    public ArrayList<ReseptionDTO> getAllReceptionss() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        receptionisDAO.setConnection(connection);
        ArrayList<ReseptionDTO> bos=new ArrayList<>();
        ArrayList<Receptionis> dto = receptionisDAO.getAllReceptionss();
        for (Receptionis dtos :dto) {
            bos.add(new ReseptionDTO(dtos.getReceptionistID(),dtos.getReceptionistF_Name(),dtos.getReceptionistAddress(),dtos.getReceptionistTel(),dtos.getAge(),dtos.getCity()));
        }
        DBConnection.getInstance().releaseConnection(connection);
return bos;
    }
}
