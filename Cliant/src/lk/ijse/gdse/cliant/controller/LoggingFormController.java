package lk.ijse.gdse.cliant.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoggingFormController implements Initializable {
    @FXML
    private AnchorPane mainPane;

    @FXML
    private JFXRadioButton rReseption;

    @FXML
    private JFXRadioButton rCook;

    @FXML
    private JFXRadioButton rdeliwer;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private JFXButton btnLoging;

    @FXML
    private JFXRadioButton adminSide;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void LogingDashbord(ActionEvent event) throws IOException {
        boolean delever = rdeliwer.isSelected();
        boolean reseption = rReseption.isSelected();
        boolean cook = rCook.isSelected();
        boolean admin=adminSide.isSelected();
        if (delever){
            Parent pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/cliant/view/DeliverApp.fxml"));
            Scene scene=new Scene(pane);
            Stage stage =(Stage) this.mainPane.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        }else if(reseption){
            Parent pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/cliant/view/ReseptionApp.fxml"));
            Scene scene=new Scene(pane);
            Stage stage= (Stage) this.mainPane.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();

        }else if (cook) {
            Parent pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/cliant/view/CookApp.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) this.mainPane.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();

        }else if (admin){
            Parent pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/cliant/view/ManageEmployee.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) this.mainPane.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();


        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Plese Select One Buttone", ButtonType.OK);
            alert.showAndWait();

        }

    }

    @FXML
    void CookAction(ActionEvent event) {
        rdeliwer.setVisible(false);
        rReseption.setVisible(false);
    }

    @FXML
    void DileverAction(ActionEvent event) {
        rCook.setVisible(false);
        rReseption.setVisible(false);
    }

    @FXML
    void ReseptionAction(ActionEvent event) {
        rCook.setVisible(false);
        rdeliwer.setVisible(false);
    }
    @FXML
    void RefreshRedioBtn(ActionEvent event) {
        rdeliwer.setVisible(true);
        rCook.setVisible(true);
        rReseption.setVisible(true);

    }

}