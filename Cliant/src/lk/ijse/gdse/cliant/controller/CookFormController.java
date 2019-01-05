package lk.ijse.gdse.cliant.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.gdse.cliant.proxy.ProxyHandler;
import lk.ijse.gdse.cliant.queueHandler.QueueHandler;
import lk.ijse.gdse.commen.cm_custome.DeliverSavice;
import lk.ijse.gdse.commen.cm_custome.OrderQueSavice;
import lk.ijse.gdse.commen.cm_service.SaviceFactory;
import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.commen.dto.*;
import lk.ijse.gdse.commen.observer.Obsever;
import lk.ijse.gdse.commen.observer.Subject;
import lk.ijse.gdse.commen.queue.Queue;
import lk.ijse.gdse.saver.resouse.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class CookFormController implements Initializable, Remote {
   @FXML
    public TextField txtFoodSearch;
   @FXML
   public TableView bikeRiderTable;
    @FXML
    private TableView<OrdersDTO> tableOrder;
    @FXML
    private TableView<OrdersDTO> tableOrderssss;

    @FXML
    private TextField txtFresh;

    @FXML
    private JFXTextField txtCustId;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private AnchorPane cheffPane;

    @FXML
    private JFXTextField txtCustAdress;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private TextField txtOrderID;

    @FXML
    private JFXTextField txtOrderIssueTime;

    @FXML
    private TextField txtQty;

    @FXML
    private JFXTextField txtPrise;

    @FXML
    private TableView<BikeTranserDTO> tblDilever;

    private OrderQueSavice orderQueSavice=null;

    private DeliverSavice deliverSavice;
    public ArrayList<PlaceOrderDTO>Array=new ArrayList<>();
    ArrayList<PlaceOrderDTO> placeOrderDTOS;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblDilever.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("custid"));
        tblDilever.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("custName"));
        tblDilever.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblDilever.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblDilever.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("prise"));


        try {
            UnicastRemoteObject.exportObject(this, 0);
            deliverSavice= (DeliverSavice) ProxyHandler.getIntstance().getSarvice(SaviceFactory.SaviceTypes.DELIVER);
            orderQueSavice = (OrderQueSavice) ProxyHandler.getIntstance().getSarvice(SaviceFactory.SaviceTypes.QUEUE);
            getAllPlaceOrders();
//            getAllPlaceOrders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AddToTable(ActionEvent event) throws Exception {
        int text = Integer.parseInt(txtOrderID.getText());
        orderQueSavice.updateOrders(text);
        BikeTranserDTO bikeTranserDTO=new BikeTranserDTO(
                Integer.parseInt(txtCustId.getText()),
                txtCustomerName.getText(),
                txtCustAdress.getText(),
                txtNic.getText(),
                Integer.parseInt(txtPrise.getText())
        );
        tblDilever.getItems().add(bikeTranserDTO);
        getAllPlaceOrders();

    }
    @FXML
    void sendBikeRider(ActionEvent event) throws Exception {
        int oid=Integer.parseInt(txtOrderID.getText());
        int cid=Integer.parseInt(txtCustId.getText());
        int itemId=Integer.parseInt(txtFoodSearch.getText());
        String issueTime=txtOrderIssueTime.getText();
        int qty=Integer.parseInt(txtQty.getText());
        QueueDTO dto=new QueueDTO(oid,cid,itemId,issueTime,qty);


    }
///    int orederID, int customerID, int itemCode, String orderIssuTime, int orderQty
    public ArrayList<PlaceOrderDTO> getAllOrders() throws Exception {
        ArrayList<PlaceOrderDTO> array=new ArrayList<>();
        array.add(new PlaceOrderDTO(
                Integer.parseInt(txtOrderID.getText()),
                Integer.parseInt(txtCustId.getText()),
                Integer.parseInt(txtFoodSearch.getText()),
                txtOrderIssueTime.getText(),
                Integer.parseInt(txtQty.getText())));
        return array;
    }
    @FXML
    void searchCusomer(ActionEvent event) throws Exception {
        int id=Integer.parseInt(txtCustId.getText());

        CustomerDTO customerDTO = orderQueSavice.searchCustomerr(id);

        if(customerDTO !=null){
            txtCustId.setText(customerDTO.getId()+"");
            txtCustomerName.setText(customerDTO.getName());
            txtCustAdress.setText(customerDTO.getAddress());
            txtNic.setText(customerDTO.getNic());
            txtPrise.setText(""+customerDTO.getSalary());
        }else {
            System.out.println("No Customer");
        }
    }


    void getAllPlaceOrders() throws Exception {
        tableOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tableOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerID"));
        tableOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("receptionistID"));
        tableOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        tableOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
        tableOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tableOrder.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("status"));


        tableOrder.setItems(FXCollections.observableArrayList(orderQueSavice.getAllOrders()));
        tableOrder.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OrdersDTO>() {
            @Override
            public void changed(ObservableValue<? extends OrdersDTO> observable, OrdersDTO oldValue, OrdersDTO newValue) {
                OrdersDTO value = observable.getValue();
                txtCustId.setText(value.getCustomerID()+"");
                txtOrderID.setText(value.getItemCode()+"");

            }
        });
           // tableOrder.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OrdersDTO>() {
//                @Override
//                public void changed(ObservableValue<? extends PlaceOrderDTO> observable, PlaceOrderDTO oldValue, PlaceOrderDTO newValue) {
//                    PlaceOrderDTO value = observable.getValue();
//                    txtOrderID.setText(value.getOrederID()+"");
//                    txtCustId.setText(value.getCustomerID()+"");
//                    int rid=value.getReceptionistID();
//                   txtFoodSearch.setText(value.getItemCode()+"");
//                    String date=value.getOrderDate();
//                    String otTime=value.getOrderTakeTime();
//                    txtOrderIssueTime.setText(value.getOrderIssuTime());
//                    txtQty.setText(value.getOrderQty()+"");
//                }
//            });
    }
    @FXML
    void backAttoHomee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/cliant/view/LoggingForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage= (Stage) this.cheffPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

    }
    @FXML
    void reportBtn(ActionEvent event) throws JRException {
        InputStream is = this.getClass().getResourceAsStream("/lk/ijse/gdse/cliant/report/Customersss.jasper");
        //Connection con = DBConnection.getInstance().getConnection();
        Connection connection= DBConnection.getInstance().getConnection();
        HashMap map = new HashMap();
        JasperPrint fillReport = JasperFillManager.fillReport(is, map,connection);
        JasperViewer.viewReport(fillReport, false);

    }

}
