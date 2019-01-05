package lk.ijse.gdse.cliant.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.gdse.cliant.proxy.ProxyHandler;
import lk.ijse.gdse.cliant.queueHandler.QueueHandler;
import lk.ijse.gdse.commen.cm_custome.DeliverSavice;
import lk.ijse.gdse.commen.cm_service.SaviceFactory;
import lk.ijse.gdse.commen.dto.*;
import lk.ijse.gdse.commen.queue.Queue;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DeliverFormController implements Initializable {

    @FXML
    private AnchorPane DeliverPane;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private ComboBox<Integer> combDelever;
    @FXML
    private TableView<OrdersDTO> tblCustomerOrderDetails;

    @FXML
    private TableView<PaymentDTO> tblPayment;

    @FXML
    private JFXTextField txtPaymentId;

    @FXML
    private JFXTextField txtCustAddress;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtPrise;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXTextField txtDileverFree;

    @FXML
    private ImageView loginIcon;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtcustName;

    @FXML
    private TextField txtSearch;

    private DeliverSavice deliverSavice;
    private ArrayList<DeliverDTO> dtos=new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            deliverSavice= (DeliverSavice) ProxyHandler.getIntstance().getSarvice(SaviceFactory.SaviceTypes.DELIVER);
            getAllOverOrderOrder();
            PaymentTblesss();
            loardComboIds();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loardComboIds() throws Exception {
        dtos = deliverSavice.getAllDeleversIds();
        ObservableList<Integer> ids = FXCollections.observableArrayList();
        for (DeliverDTO dto:dtos) {
            ids.add(dto.getDeleverId());
        }
        combDelever.setItems(ids);
    }
    @FXML
    void moveToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/cliant/view/LoggingForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage= (Stage) this.DeliverPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    void paymentTables(ActionEvent event) throws Exception {

        int id=Integer.parseInt(txtOrderId.getText());
        boolean isPayed = deliverSavice.updatOrderPayment(id);
        if(isPayed){
            //getAllOverOrderOrder();
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Payment Sucsessfuly...",ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Payment is not SucsessFuly...",ButtonType.OK);
            alert.showAndWait();
        }
    }



    @FXML
    void serchCustomer(ActionEvent event) throws Exception {
        int id=Integer.parseInt(txtSearch.getText());
        CustomerDTO cust = deliverSavice.serchCustomerInDelever(id);
        if(cust!=null){
            txtCustomerId.setText(cust.getId()+"");
            txtcustName.setText(cust.getName());
            txtCustAddress.setText(cust.getAddress());
            String nic=cust.getNic();
            txtPrise.setText(cust.getSalary()+"");
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"No Such customer", ButtonType.OK);
            alert.showAndWait();
        }
    }
    @FXML
    void saveQueDTo(ActionEvent event) throws Exception {
double priise=Integer.parseInt(txtPrise.getText())*Integer.parseInt(txtQty.getText());

        PaymentDTO dto=new PaymentDTO(
                Integer.parseInt(txtPaymentId.getText()),
                combDelever.getSelectionModel().getSelectedItem(),
                Integer.parseInt(txtCustomerId.getText()),
                Double.parseDouble(txtDileverFree.getText()),
                Double.parseDouble(txtDiscount.getText()),
                priise);

        tblPayment.getItems().add(dto);


    }
    void PaymentTblesss(){
        tblPayment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("pay_id"));
        tblPayment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("deliver_id"));
        tblPayment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("customerID"));
        tblPayment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("deliverfee"));
        tblPayment.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("discount"));
        tblPayment.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("total_Price"));
    }
    @FXML
    void deletereception(ActionEvent event) {

    }
    void getAllOverOrderOrder() throws Exception {
        tblCustomerOrderDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblCustomerOrderDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerID"));
        tblCustomerOrderDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("receptionistID"));
        tblCustomerOrderDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        tblCustomerOrderDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
        tblCustomerOrderDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblCustomerOrderDetails.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("status"));

        tblCustomerOrderDetails.setItems(FXCollections.observableArrayList(deliverSavice.getAllDeleverOrder()));

        tblCustomerOrderDetails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OrdersDTO>() {
            @Override
            public void changed(ObservableValue<? extends OrdersDTO> observable, OrdersDTO oldValue, OrdersDTO newValue) {
                OrdersDTO value = observable.getValue();
                txtCustomerId.setText(value.getCustomerID()+"");
                txtQty.setText(value.getOrderQty()+"");
                txtPrise.setText(value.getUnitPrice()+"");
                txtSearch.setText(value.getCustomerID()+"");
                txtOrderId.setText(value.getItemCode()+"");

            }
        });
    }
}

