package lk.ijse.gdse.saver.daolayar.custom;

import lk.ijse.gdse.saver.Entity.Orders;
import lk.ijse.gdse.saver.daolayar.dao.SuperDAO;

public interface OrderDAO extends SuperDAO {
    boolean saveOrder(Orders orders)throws Exception;
}
