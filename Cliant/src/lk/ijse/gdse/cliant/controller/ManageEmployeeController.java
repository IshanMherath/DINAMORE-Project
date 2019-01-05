package lk.ijse.gdse.cliant.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse.cliant.proxy.ProxyHandler;
import lk.ijse.gdse.commen.cm_custome.CheffService;
import lk.ijse.gdse.commen.cm_custome.DeliverSavice;
import lk.ijse.gdse.commen.cm_custome.ReceptionistService;
import lk.ijse.gdse.commen.cm_service.SaviceFactory;
import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.commen.dto.ChefDTO;
import lk.ijse.gdse.commen.dto.DeliverDTO;
import lk.ijse.gdse.commen.dto.ReseptionDTO;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class ManageEmployeeController implements Initializable {
    @FXML
    private JFXTextField resName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXTextField txtChefName;

    @FXML
    private JFXTextField txtCheffAddress;

    @FXML
    private TextField txtChefId;

    @FXML
    private TextField txtCheffContact;

    @FXML
    private TextField txtAge;

    @FXML
    private JFXTextField txtDeName;

    @FXML
    private JFXTextField txtDeliAdddress;

    @FXML
    private TextField txtContNo;

    @FXML
    private TextField txtAge1;

    @FXML
    private TextField txtRid;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtChefAge;

    @FXML
    private TextField txtDeleId;

    @FXML
    private TableView<DeliverDTO> tblDiliver;

    @FXML
    private TableView<ChefDTO> tblCook;

    @FXML
    private TableView<ReseptionDTO> tblReception;

    private ReceptionistService receptionistService;
    private CheffService cheffService;
    private DeliverSavice deliverSavice;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            receptionistService= (ReceptionistService) ProxyHandler.getIntstance().getSarvice(SaviceFactory.SaviceTypes.RECEPTIONIST);
            cheffService= (CheffService) ProxyHandler.getIntstance().getSarvice(SaviceFactory.SaviceTypes.CHEFF);
            deliverSavice = (DeliverSavice) ProxyHandler.getIntstance().getSarvice(SaviceFactory.SaviceTypes.DELIVER);
            getAllCheff();
            getAllDelivers();
            getAllReception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addReception(ActionEvent event) throws Exception {
          int rid=Integer.parseInt(txtRid.getText());
          String name=resName.getText();
          String address=txtAddress.getText();
          int coNu=Integer.parseInt(txtContactNo.getText());
          int age=Integer.parseInt(txtAge.getText());
          String city=txtCity.getText();
        ReseptionDTO dto=new ReseptionDTO(rid,name,address,coNu,age,city);
        boolean add = receptionistService.addReception(dto);

        if(add){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added Sucsess", ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added not Sucsess",ButtonType.OK);
            alert.showAndWait();
        }

    }
    @FXML
    void deleteReception(ActionEvent event) throws Exception {
        int id = Integer.parseInt(txtRid.getText());
        boolean isDelete = receptionistService.deleteReception(id);

        if(isDelete){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete Sucsess", ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete not Sucsess",ButtonType.OK);
            alert.showAndWait();
        }

    }
    @FXML
    void SearchReception(ActionEvent event) throws Exception {
        int id=Integer.parseInt(txtRid.getText());
        ReseptionDTO search = receptionistService.searchReceptioin(id);
        if(search!=null){
            txtRid.setText(search.getReceptionistID()+"");
            resName.setText(search.getReceptionistF_Name());
            txtAddress.setText(search.getReceptionistAddress());
            txtContactNo.setText(""+search.getReceptionistTel());
            txtAge.setText(search.getAge()+"");
            txtCity.setText(search.getCity());
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"No one Reception ",ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void cheffAdd(ActionEvent event) throws Exception {
        int id = Integer.parseInt(txtChefId.getText());
        String name=txtChefName.getText();
        String address=txtCheffAddress.getText();
        int tele=Integer.parseInt(txtCheffContact.getText());
        int age=Integer.parseInt(txtChefAge.getText());

        ChefDTO dto=new ChefDTO(id,name,address,tele,age);
        boolean isAddCheff = cheffService.addCheff(dto);

        if(isAddCheff){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added Cheff Sucsess Full ",ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added Unsucsessfull Cheff ",ButtonType.OK);
            alert.showAndWait();
        }

    }

    @FXML
    void cheffDelete(ActionEvent event) throws Exception {
        int id = Integer.parseInt(txtChefId.getText());
        boolean IsDelete = cheffService.deleteCheff(id);
        if(IsDelete){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete Cheff Sucsess Full ",ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete Unsucsessfull Cheff ",ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void cheffSearch(ActionEvent event) throws Exception {
        int id=Integer.parseInt(txtChefId.getText());
        ChefDTO dto = cheffService.searchCheff(id);
        if(dto!=null){
            txtChefId.setText(dto.getChefID()+"");
            txtChefName.setText(dto.getChefF_Name());
            txtCheffAddress.setText(dto.getChefAddress());
            txtCheffContact.setText(dto.getChefTel()+"");
            txtChefAge.setText(dto.getAge()+"");
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"No such Cheff thi id...",ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void deleteDeliver(ActionEvent event) throws Exception {
        int id =Integer.parseInt(txtDeleId.getText());
        boolean isDelete = deliverSavice.DeleteDelever(id);
        if(isDelete){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete Delever Sucsess Full ",ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete Unsucsessfull Delever ",ButtonType.OK);
            alert.showAndWait();
        }
    }
    @FXML
    void addDeliver(ActionEvent event) throws Exception {
        int id=Integer.parseInt(txtDeleId.getText());
        String name=txtDeName.getText();
        String address=txtDeliAdddress.getText();
        int contact=Integer.parseInt(txtContNo.getText());
        int age=Integer.parseInt(txtAge1.getText());
        DeliverDTO dto=new DeliverDTO(id,name,address,contact,age);

        boolean idAdded = deliverSavice.addDelevers(dto);
        if(idAdded){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added Delever Sucsess Full ",ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added Unsucsessfull Delever ",ButtonType.OK);
            alert.showAndWait();
        }
    }
    @FXML
    void searchDelever(ActionEvent event) throws Exception {
        int id = Integer.parseInt(txtDeleId.getText());
        DeliverDTO search = deliverSavice.searchDelevers(id);
        if (search!=null){
            txtDeleId.setText(search.getDeleverId()+"");
            txtDeName.setText(search.getDeleverName());
            txtDeliAdddress.setText(search.getDeleverAddress());
            txtContNo.setText(search.getBikeRider_Tel()+"");
            txtAge1.setText(search.getAge()+"");
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"No Such Customer in thi id... Try Again ",ButtonType.OK);
            alert.showAndWait();
        }
    }
    @FXML
    void OnUpdateReception(ActionEvent event) throws Exception {
        int id=Integer.parseInt(txtDeleId.getText());
        String name=txtDeName.getText();
        String address=txtDeliAdddress.getText();
        int contact=Integer.parseInt(txtContNo.getText());
        int age=Integer.parseInt(txtAge1.getText());
        DeliverDTO dto=new DeliverDTO(id,name,address,contact,age);
        boolean isUpdate = deliverSavice.deleverUpdate(dto);
        if(isUpdate){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Update Sucsess", ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Update not Sucsess",ButtonType.OK);
            alert.showAndWait();
        }

    }
    @FXML
    void UpdateReceptionnn(ActionEvent event) throws Exception {
        ReseptionDTO dto=new ReseptionDTO(Integer.parseInt(txtRid.getText()),resName.getText(),
                txtAddress.getText(),
                Integer.parseInt(txtContactNo.getText()),
                Integer.parseInt(txtAge.getText()),txtCity.getText());
        boolean isUpdate = receptionistService.updateReception(dto);

        if(isUpdate){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Update Reception Sucsess", ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Not Updated Reception",ButtonType.OK);
            alert.showAndWait();
        }

    }
    @FXML
    void updateCheffff(ActionEvent event) throws Exception {
        ChefDTO dto=new ChefDTO(Integer.parseInt(txtChefId.getText()),
                txtChefName.getText(),txtCheffAddress.getText(),
                Integer.parseInt(txtCheffContact.getText()),
                Integer.parseInt(txtChefAge.getText()));
        boolean isUpdate = cheffService.updateChef(dto);
        if(isUpdate){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Reception Update Sucsess", ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Not Updated Reception",ButtonType.OK);
            alert.showAndWait();
        }

    }
    void getAllReception() throws Exception {
        tblReception.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("receptionistID"));
        tblReception.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("receptionistF_Name"));
        tblReception.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("receptionistTel"));
        tblReception.setItems(FXCollections.observableArrayList(receptionistService.getAllReceptionss()));
        tblReception.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ReseptionDTO>() {
            @Override
            public void changed(ObservableValue<? extends ReseptionDTO> observable, ReseptionDTO oldValue, ReseptionDTO newValue) {
                ReseptionDTO value = observable.getValue();
                txtRid.setText(value.getReceptionistID()+"");
                resName.setText(value.getReceptionistF_Name());
                txtAddress.setText(value.getReceptionistAddress());
                txtContactNo.setText(value.getReceptionistTel()+"");
                txtAge.setText(value.getAge()+"");
                txtCity.setText(value.getCity());
            }
        });


    }
    void getAllCheff() throws Exception {
        tblCook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("chefID"));
        tblCook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("chefF_Name"));
        tblCook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("chefTel"));
        tblCook.setItems(FXCollections.observableArrayList(cheffService.getAllCheff()));
        tblCook.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ChefDTO>() {
            @Override
            public void changed(ObservableValue<? extends ChefDTO> observable, ChefDTO oldValue, ChefDTO newValue) {
                ChefDTO value = observable.getValue();
                txtChefId.setText(value.getChefID()+"");
                txtChefName.setText(value.getChefF_Name());
                txtCheffAddress.setText(value.getChefAddress());
                txtCheffContact.setText(value.getChefTel()+"");
                txtChefAge.setText(value.getAge()+"");
            }
        });
    }
    void getAllDelivers() throws Exception {
            tblDiliver.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("deleverId"));
            tblDiliver.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("deleverName"));
            tblDiliver.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bikeRider_Tel"));
            tblDiliver.setItems(FXCollections.observableArrayList(deliverSavice.getAllDeleverss()));

            tblDiliver.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<DeliverDTO>() {
                @Override
                public void changed(ObservableValue<? extends DeliverDTO> observable, DeliverDTO oldValue, DeliverDTO newValue) {
                    DeliverDTO value = observable.getValue();
                    txtDeleId.setText(value.getDeleverId()+"");
                    txtDeName.setText(value.getDeleverName());
                    txtDeliAdddress.setText(value.getDeleverAddress());
                    txtContNo.setText(value.getBikeRider_Tel()+"");
                    txtAge1.setText(value.getAge()+"");
                }
            });
    }
}
