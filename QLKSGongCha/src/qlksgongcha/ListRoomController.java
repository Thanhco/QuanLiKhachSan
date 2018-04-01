/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlksgongcha;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author Sony Vaio
 */
public class ListRoomController implements Initializable {

    @FXML
    private Button btnBook;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
   
    
}
////    @FXML
////    private Label lblD101, lblD102, lblD103, lblD104, lblD105;
////    @FXML
////    private Label lblD201, lblD202, lblD203, lblD204, lblD205;
////    @FXML
////    private Label lblD301, lblD302, lblD303, lblD304, lblD305;
////    @FXML
////    private Label lblH101, lblH102, lblH103, lblH104, lblH105;
////    @FXML
////    private Label lblH201, lblH202, lblH203, lblH204, lblH205;
////    @FXML
////    private Label lblH301, lblH302, lblH303, lblH304, lblH305;
////    private String[] listRooms = {"101", "102", "102", "102"};
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            db.dbConnect();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MainWindowsController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MainWindowsController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            listRoom = FXMLLoader.load(getClass().getResource("ListRoom.fxml"));
//            priceRoom = FXMLLoader.load(getClass().getResource("PriceRoom.fxml"));
////             pricing = FXMLLoader.load(getClass().getResource("Pricing.fxml"));
////             profiles = FXMLLoader.load(getClass().getResource("Profiles.fxml"));
////             widgets = FXMLLoader.load(getClass().getResource("Widgets.fxml"));
////             controls = FXMLLoader.load(getClass().getResource("Controls.fxml"));
//            setNode(listRoom);
//        } catch (IOException ex) {
//            Logger.getLogger(MainWindowsController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    //Set selected node to a content holder
//    private void setNode(Node node) {
//        mainPane.getChildren().clear();
//        mainPane.getChildren().add((Node) node);
//
//        FadeTransition ft = new FadeTransition(Duration.millis(1500));
//        ft.setNode(node);
//        ft.setFromValue(0.1);
//        ft.setToValue(1);
//        ft.setCycleCount(1);
//        ft.setAutoReverse(false);
//        ft.play();
//    }
//
//    @FXML
//    private void switchListRoom(ActionEvent event) {
//        setNode(listRoom);
//    }
//
//    @FXML
//    private void switchPriceRoom(ActionEvent event) {
//        m_Connection = db.getCon();
//        try {
//            m_Statement = m_Connection.createStatement();
//        } catch (SQLException ex) {
//            Logger.getLogger(PriceRoomController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String query = "SELECT * FROM Phong";
//        try {
//            m_ResultSet = m_Statement.executeQuery(query);
//        } catch (SQLException ex) {
//            Logger.getLogger(PriceRoomController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            while (m_ResultSet.next()) {
////                for (int i = 0; i < 2; i++) {
////                    for (int j = 0; j < 5; j++) {
////                        String num = i + "0" + j;
////                        if (m_ResultSet.getString(1) == num) {
////                            lblD101, lblD102, lblD103, lblD104, lblD105
////                        }
////                    }
////                }
////                if (m_ResultSet.getString(1) == "101") {
////                    lblD101.setText("Giá Ngày: " + m_ResultSet.getString(5) + " Đ");
////                }
//
//                System.out.println(m_ResultSet.getString(1) + ", " + m_ResultSet.getString(2) + ", "
//                        + m_ResultSet.getString(3));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PriceRoomController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        setNode(priceRoom);
//    }
//
////    @FXML
////    private void switchContacts(ActionEvent event) {
////        setNode(contacts);
////    }
//}
