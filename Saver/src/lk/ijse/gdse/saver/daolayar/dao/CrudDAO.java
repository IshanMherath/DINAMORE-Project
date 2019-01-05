package lk.ijse.gdse.saver.daolayar.dao;

public interface CrudDAO<T, ID> extends SuperDAO {
    public boolean save(T ID)throws Exception;
    public boolean delete(String id)throws Exception;
}
