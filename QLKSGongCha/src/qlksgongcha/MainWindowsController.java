/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlksgongcha;

import Database.DBConfig;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author Sony Vaio
 */
public class MainWindowsController implements Initializable {

    @FXML
    private Pane mainPane;
    DBConfig db = new DBConfig();
    AnchorPane listRoom, priceRoom, customer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            db.dbConnect();
             listRoom = FXMLLoader.load(getClass().getResource("ListRoom.fxml"));
             priceRoom = FXMLLoader.load(getClass().getResource("PriceRoom.fxml"));
             customer = FXMLLoader.load(getClass().getResource("Customer.fxml"));
             setNode(listRoom);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindowsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainWindowsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindowsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Set selected node to a content holder

    private void setNode(Node node) {
        mainPane.getChildren().clear();
        mainPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void switchListRoom(ActionEvent event) {
        setNode(listRoom);
    }

    @FXML
    private void switchPriceRoom(ActionEvent event) {      
        setNode(priceRoom);
    }
    @FXML
    private void switchCustomer(ActionEvent event) {      
        setNode(customer);
    }
}
