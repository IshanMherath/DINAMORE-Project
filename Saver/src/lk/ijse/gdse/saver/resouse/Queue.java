package lk.ijse.gdse.saver.resouse;

import lk.ijse.gdse.commen.dto.PlaceOrderDTO;

import java.util.ArrayList;

public class Queue {
    private static Queue queue;

private ArrayList<PlaceOrderDTO> queList;

private Queue(){
        queList=new ArrayList<>();
    }
public static Queue getInstance(){
        if (queue==null){
            queue=new Queue();
        }
        return queue;
    }
public ArrayList getQueue(){
        return queList;
    }
}
