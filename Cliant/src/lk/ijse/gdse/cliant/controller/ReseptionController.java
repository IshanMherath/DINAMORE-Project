package lk.ijse.gdse.cliant.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.gdse.cliant.proxy.ProxyHandler;
import lk.ijse.gdse.commen.cm_custome.CustomerSavice;
import lk.ijse.gdse.commen.cm_custome.FoodSavice;
import lk.ijse.gdse.commen.cm_custome.OrderQueSavice;
import lk.ijse.gdse.commen.cm_custome.ReceptionistService;
import lk.ijse.gdse.commen.cm_service.SaviceFactory;
import lk.ijse.gdse.commen.dto.*;
import lk.ijse.gdse.commen.observer.Obsever;
import lk.ijse.gdse.commen.observer.Subject;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReseptionController implements Initializable, Remote{
    @FXML
    private AnchorPane reseptionPaane;

    @FXML
    private JFXTextField txtCustName;

    @FXML
    private TextField txtCusid;

    @FXML
    private JFXTextField txtCustAddress;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtStatuse;

    @FXML
    private TextField txtOrderDate;

    @FXML
    private TextField txtOrderTakeTime;

    @FXML
    private TextField txtPrise;

    @FXML
    private TextField txtCustTeli;

    @FXML
    private TableView<CustomerDTO> txtOrderTable;

    @FXML
    private JFXRadioButton radioNewCust;

    @FXML
    private ToggleGroup customerGroup;

    @FXML
    private JFXRadioButton radioOldCus;

    @FXML
    private JFXComboBox<Integer> cmbItemCode;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtItemDescription;

    @FXML
    private TextField txtOrderIssuTime;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtPrise2;

    @FXML
    private TextField txtOrderQty;

    @FXML
    private CheckBox Satatuse22;

    @FXML
    private TableView<?> tblOrderDetailsTable;

    @FXML
    private Label lblCust;

    @FXML
    private JFXTextField txtResepID;

    @FXML
    private JFXTextField cmbItemCode2;

    @FXML
    private ComboBox<Integer> cmbReceptionId;

    @FXML
    private RadioButton Radiosattus;


    @FXML
    private ComboBox<Integer> comboCustomer;
    private CustomerSavice customerSavice=null;
    private OrderQueSavice orderQueSavice;
    private ReceptionistService  receptionistService;
    private FoodSavice foodSavice;
    private ArrayList<ReseptionDTO> dtos=new ArrayList<>();
    private ArrayList<FoodDTO> dtoss=new ArrayList<>();
    private ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboCustomer.setVisible(false);
        try {
            UnicastRemoteObject.exportObject(this, 0);
            receptionistService= (ReceptionistService) ProxyHandler.getIntstance().getSarvice(SaviceFactory.SaviceTypes.RECEPTIONIST);
            customerSavice= (CustomerSavice) ProxyHandler.getIntstance().getSarvice(SaviceFactory.SaviceTypes.CUSTOMER);
            foodSavice = (FoodSavice) ProxyHandler.getIntstance().getSarvice(SaviceFactory.SaviceTypes.FOOD);
            getComboLoard();
            getLordCombo();
            getCustomer();
            loardGetAllCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loardGetAllCustomer() {
        txtOrderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        txtOrderTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        txtOrderTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        txtOrderTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("nic"));
        txtOrderTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("salary"));

        try {
            txtOrderTable.setItems(FXCollections.observableArrayList(customerSavice.getAllCustomer()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void getCustomer() throws Exception {

        customerDTOS = customerSavice.getAllCustomer();
        ObservableList<Integer> ids = FXCollections.observableArrayList();
        for (CustomerDTO dto:customerDTOS) {
            ids.add(dto.getId());
        }
        comboCustomer.setItems(ids);
    }
    void getComboLoard() throws Exception {
        dtos = receptionistService.getAllReceptionss();
        ObservableList<Integer> ids = FXCollections.observableArrayList();
        for (ReseptionDTO dto:dtos) {
            ids.add(dto.getReceptionistID());
        }
        cmbReceptionId.setItems(ids);
    }

    @FXML
    void searchComboCustomer(ActionEvent event) {
        comboCustomer.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                Integer id = comboCustomer.getValue();
                CustomerDTO customerDTO = null;
                try {
                    customerDTO = customerSavice.searchCustomer(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (customerDTO !=null){
                    txtCustName.setText(customerDTO.getName());
                    txtCustAddress.setText(customerDTO.getAddress());
                    txtPrise.setText(customerDTO.getNic());
                    txtCustTeli.setText(customerDTO.getSalary()+"");
                }
            }
        });
    }

    @FXML
    void searchFoodCombo(ActionEvent event) {
        cmbItemCode.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
              //  foodSavice.

            }
        });
    }


    void getLordCombo() throws Exception {
        dtoss = foodSavice.loardFoodIds();
        ObservableList<Integer> ids = FXCollections.observableArrayList();
        for (FoodDTO dto : dtoss){
            ids.add(dto.getItemCode());
        }
        cmbItemCode.setItems(ids);
    }
//    public static Subject getSubjectCustomer() throws Exception {
//        return (Subject) ProxyHandler.getIntstance().getSarvice(SaviceFactory.SaviceTypes.CUSTOMER);
//    }


    @FXML
    void AddOrder(ActionEvent event) throws Exception {
        boolean newCustomer = radioNewCust.isSelected();
        boolean oldCustomer = radioOldCus.isSelected();
        if (newCustomer){
            int Custid=Integer.parseInt(txtCusid.getText());
            String name=txtCustName.getText();
            String address=txtCustAddress.getText();
            String nic=txtCustTeli.getText();
            int salary=Integer.parseInt(txtPrise.getText());
            CustomerDTO customerDTO=new CustomerDTO(Custid,name,address,nic,salary);

            int oItemID=Integer.parseInt(txtOrderId.getText());
            int selectedItem = cmbReceptionId.getSelectionModel().getSelectedItem();
            String OrderDate = txtOrderDate.getText();
            int orderQty= Integer.parseInt(txtOrderQty.getText());
            double unitPrise=Double.parseDouble(txtPrise2.getText());
            String state = txtStatuse.getText();
            OrdersDTO ordersDTO=new OrdersDTO(oItemID,Custid,selectedItem,OrderDate,orderQty,unitPrise,state);

            int orderId=Integer.parseInt(txtOrderId.getText());
            String takeTime=txtOrderTakeTime.getText();
            String issuTime=txtOrderIssuTime.getText();

            PlaceOrderDTO placeOrderDTO=new PlaceOrderDTO(orderId,Custid,oItemID,selectedItem,OrderDate,takeTime,issuTime,orderQty);

            CommenDTO dto=new CommenDTO(customerDTO,placeOrderDTO,ordersDTO);
            boolean isAddedd = customerSavice.saveTransaction(dto);

            if(isAddedd){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Save Transaction sucsessFull",ButtonType.OK);
                alert.showAndWait();
            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Save UnsucsessFull",ButtonType.OK);
                alert.showAndWait();
            }

        }else if(oldCustomer){
            comboCustomer.setVisible(true);
            txtCusid.setVisible(false);
            lblCust.setVisible(false);
            Integer custId = comboCustomer.getSelectionModel().getSelectedItem();
            int orderId=Integer.parseInt(txtOrderId.getText());
            String takeTime=txtOrderTakeTime.getText();
            String issuTime=txtOrderIssuTime.getText();
            int oItemID=Integer.parseInt(txtOrderId.getText());
            int selectedItem = cmbReceptionId.getSelectionModel().getSelectedItem();
            System.out.println(selectedItem);
            int orderQty= Integer.parseInt(txtOrderQty.getText());
            String OrderDate = txtOrderDate.getText();
            double unitPrise=Double.parseDouble(txtPrise2.getText());
            String state = txtStatuse.getText();
            PlaceOrderDTO placeOrderDTO=new PlaceOrderDTO(orderId,custId,oItemID,selectedItem,OrderDate,takeTime,issuTime,orderQty);

            OrdersDTO ordersDTO=new OrdersDTO(oItemID,custId,selectedItem,OrderDate,orderQty,unitPrise,state);
            CommenDTO dto=new CommenDTO(placeOrderDTO,ordersDTO);
            boolean isAdded = customerSavice.saveTransaction2(dto);

            if(isAdded){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Save Transaction",ButtonType.OK);
                alert.showAndWait();
            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Save UnsucsessFull",ButtonType.OK);
                alert.showAndWait();
            }
        }
    }
    @FXML
    void radioAction(ActionEvent event) {
        comboCustomer.setVisible(true);
        txtCusid.setVisible(false);
        lblCust.setVisible(false);

    }

    @FXML
    void radioAction2(ActionEvent event) {
        comboCustomer.setVisible(false);
        txtCusid.setVisible(true);
        lblCust.setVisible(true);

    }

    @FXML
    void OrderDelete(ActionEvent event) throws Exception {
        String id=txtCusid.getText();
        boolean IsDelete = customerSavice.DeleteCustomer(id);
        if (IsDelete){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete Sucsess",ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete Unsucsess",ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void OrderUpdate(ActionEvent event) {

    }

    @FXML
    void RefreshTable(ActionEvent event) {

    }

    @FXML
    void serchOrder(ActionEvent event) throws Exception {
       int id=Integer.parseInt(txtCusid.getText());
        CustomerDTO search = customerSavice.searchCustomer(id);
        if (search!=null){
            txtCusid.setText(search.getId()+"");
            txtCustName.setText(search.getName());
            txtCustAddress.setText(search.getAddress());
            txtPrise.setText(search.getNic());
            txtCustTeli.setText(search.getSalary()+"");

        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"No customer in thi id : "+id+" pleace Try Again",ButtonType.OK);
            alert.showAndWait();
        }
    }
    @FXML
    void LoardHomePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/cliant/view/LoggingForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage= (Stage) this.reseptionPaane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void OrderAddToTable(ActionEvent event) {

    }
}

