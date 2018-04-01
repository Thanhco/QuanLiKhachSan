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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Sony Vaio
 */
public class PriceRoomController implements Initializable {

    DBConfig db = new DBConfig();
    Connection m_Connection = null;
    Statement m_Statement = null;
    ResultSet m_ResultSet = null;
    //Floor 1
    @FXML
    private Label tt101;
    @FXML
    private Label tt102;
    @FXML
    private Label tt103;
    @FXML
    private Label tt104;
    @FXML
    private Label tt105;
    @FXML
    private Label lbl101D;
    @FXML
    private Label lbl102D;
    @FXML
    private Label lbl103D;
    @FXML
    private Label lbl104D;
    @FXML
    private Label lbl105D;
    @FXML
    private Label lbl101H;
    @FXML
    private Label lbl102H;
    @FXML
    private Label lbl103H;
    @FXML
    private Label lbl104H;
    @FXML
    private Label lbl105H;
    private final String[] title1 = new String[5];
    private final String[] floor1 = {"101", "102", "103", "104", "105"};
    private final String[] priceD1 = new String[5];
    private final String[] priceH1 = new String[5];
    //Floor 2
     @FXML
    private Label tt201;
    @FXML
    private Label tt202;
    @FXML
    private Label tt203;
    @FXML
    private Label tt204;
    @FXML
    private Label tt205;
    @FXML
    private Label lbl201D;
    @FXML
    private Label lbl202D;
    @FXML
    private Label lbl203D;
    @FXML
    private Label lbl204D;
    @FXML
    private Label lbl205D;
    @FXML
    private Label lbl201H;
    @FXML
    private Label lbl202H;
    @FXML
    private Label lbl203H;
    @FXML
    private Label lbl204H;
    @FXML
    private Label lbl205H;
    private final String[] title2 = new String[5];
    private final String[] floor2 = {"201", "202", "203", "204", "205"};
    private final String[] priceD2 = new String[5];
    private final String[] priceH2 = new String[5];
    //Floor 3
     @FXML
    private Label tt301;
    @FXML
    private Label tt302;
    @FXML
    private Label tt303;
    @FXML
    private Label tt304;
    @FXML
    private Label tt305;
    @FXML
    private Label lbl301D;
    @FXML
    private Label lbl302D;
    @FXML
    private Label lbl303D;
    @FXML
    private Label lbl304D;
    @FXML
    private Label lbl305D;
    @FXML
    private Label lbl301H;
    @FXML
    private Label lbl302H;
    @FXML
    private Label lbl303H;
    @FXML
    private Label lbl304H;
    @FXML
    private Label lbl305H;
    private final String[] title3 = new String[5];
    private final String[] floor3 = {"301", "302", "303", "304", "305"};
    private final String[] priceD3 = new String[5];
    private final String[] priceH3 = new String[5];
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            db.dbConnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PriceRoomController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PriceRoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
        UpdatePriceRoom();
    }

    private void UpdatePriceRoom() {
        m_Connection = db.getCon();
        try {
            m_Statement = m_Connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PriceRoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "SELECT * FROM Phong";
        try {
            m_ResultSet = m_Statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(PriceRoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (m_ResultSet.next()) {              
                for (int i = 0; i < floor1.length; i++) {
                    if (floor1[i].equals(m_ResultSet.getString(1))) {  
                        title1[i] = String.format("%s-%s-%s", 
                                m_ResultSet.getString(1), 
                                m_ResultSet.getString(7).replace(" ", ""),
                                m_ResultSet.getString(8));
                        priceH1[i] = String.format("Giờ: %s VNĐ", 
                                m_ResultSet.getString(4).replace(".0", ""));
                        priceD1[i] = String.format("Ngày: %s VNĐ", 
                                m_ResultSet.getString(5).replace(".0", ""));
                    }
                    else if (floor2[i].equals(m_ResultSet.getString(1))) {
                        title2[i] = String.format("%s-%s-%s", 
                                m_ResultSet.getString(1), 
                                m_ResultSet.getString(7).replace(" ", ""),
                                m_ResultSet.getString(8));
                        priceH2[i] = String.format("Giờ: %s VNĐ", 
                                m_ResultSet.getString(4)
                                .replace(".0", ""));
                        priceD2[i] = String.format("Ngày: %s VNĐ", 
                                m_ResultSet.getString(5).replace(".0", ""));
                    }
                    else if (floor3[i].equals(m_ResultSet.getString(1))) {
                        title3[i] = String.format("%s-%s-%s", 
                                m_ResultSet.getString(1), 
                                m_ResultSet.getString(7).replace(" ", ""),
                                m_ResultSet.getString(8));
                        priceH3[i] = String.format("Giờ: %s VNĐ", 
                                m_ResultSet.getString(4).replace(".0", ""));
                        priceD3[i] = String.format("Ngày: %s VNĐ", 
                                m_ResultSet.getString(5).replace(".0", ""));
                    }
                }
                 //Floor 1  
                tt101.setText(title1[0]);
                tt102.setText(title1[1]);
                tt103.setText(title1[2]);
                tt104.setText(title1[3]);
                tt105.setText(title1[4]);
                lbl101D.setText(priceD1[0]);
                lbl102D.setText(priceD1[1]);
                lbl103D.setText(priceD1[2]);
                lbl104D.setText(priceD1[3]);
                lbl105D.setText(priceD1[4]);
                lbl101H.setText(priceH1[0]);
                lbl102H.setText(priceH1[1]);
                lbl103H.setText(priceH1[2]);
                lbl104H.setText(priceH1[3]);
                lbl105H.setText(priceH1[4]);
                //Floor 2   
                tt201.setText(title2[0]);
                tt202.setText(title2[1]);
                tt203.setText(title2[2]);
                tt204.setText(title2[3]);
                tt205.setText(title2[4]);
                lbl201D.setText(priceD2[0]);
                lbl202D.setText(priceD2[1]);
                lbl203D.setText(priceD2[2]);
                lbl204D.setText(priceD2[3]);
                lbl205D.setText(priceD2[4]);
                lbl201H.setText(priceH2[0]);
                lbl202H.setText(priceH2[1]);
                lbl203H.setText(priceH2[2]);
                lbl204H.setText(priceH2[3]);
                lbl205H.setText(priceH2[4]);
                //Floor 3  
                tt301.setText(title3[0]);
                tt302.setText(title3[1]);
                tt303.setText(title3[2]);
                tt304.setText(title3[3]);
                tt305.setText(title3[4]);
                lbl301D.setText(priceD3[0]);
                lbl302D.setText(priceD3[1]);
                lbl303D.setText(priceD3[2]);
                lbl304D.setText(priceD3[3]);
                lbl305D.setText(priceD3[4]);
                lbl301H.setText(priceH3[0]);
                lbl302H.setText(priceH3[1]);
                lbl303H.setText(priceH3[2]);
                lbl304H.setText(priceH3[3]);
                lbl305H.setText(priceH3[4]);
//                System.out.println(m_ResultSet.getString(1) + ", " + m_ResultSet.getString(2) + ", "
//                        + m_ResultSet.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PriceRoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            m_Connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PriceRoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
