package com.example.uas_1972008_adrian_octavius;

import com.example.uas_1972008_adrian_octavius.DAO.Fe_memberDao;
import com.example.uas_1972008_adrian_octavius.DAO.Fe_pointDao;
import com.example.uas_1972008_adrian_octavius.DAO.Fe_transactionDao;
import com.example.uas_1972008_adrian_octavius.Model.FeMemberEntity;
import com.example.uas_1972008_adrian_octavius.Model.FePointEntity;
import com.example.uas_1972008_adrian_octavius.Model.FeTransactionEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button btnSave;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnUpdate;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtNominal;
    @FXML
    private TextArea txtAddress;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtBday;
    @FXML
    private TableView<FeMemberEntity> tableMember;
    @FXML
    private TableView<FeTransactionEntity> tableTransaction;
    @FXML
    private TableView<FePointEntity> tablePoint;
    @FXML
    private TableColumn<FeMemberEntity, String> colId;
    @FXML
    private TableColumn<FeMemberEntity, String> colName;
    @FXML
    private TableColumn<FeMemberEntity, String> colPhone;
    @FXML
    private TableColumn<FePointEntity, String> colPointId;
    @FXML
    private TableColumn<FePointEntity, String> colPoint;
    @FXML
    private TableColumn<FeTransactionEntity, String> colTransDate;
    @FXML
    private TableColumn<FeTransactionEntity, String> colNominal;
    @FXML
    private TableColumn<FeMemberEntity, String> colBday;

    private ObservableList<FeMemberEntity> members;
    private ObservableList<FePointEntity> points;
    private ObservableList<FeTransactionEntity> transactions;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnSave.setDisable(false);
        Fe_memberDao memberDao = new Fe_memberDao();
        Fe_pointDao pointDao = new Fe_pointDao();
        Fe_transactionDao transactionDao = new Fe_transactionDao();

        members =(ObservableList<FeMemberEntity>)memberDao.showData();
        points = (ObservableList<FePointEntity>)pointDao.showData();
        transactions = (ObservableList<FeTransactionEntity>)transactionDao.showData();

        tableMember.setItems(members);
        tableTransaction.setItems(transactions);
        tablePoint.setItems(points);

        colId.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getCitizenId())));
        colName.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getName()));
        colPhone.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getPhone()));
        colBday.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getBirthdate())));

        colTransDate.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getTransDate())));
        colNominal.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getNominal())));

        colPointId.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getFeMemberByMemberCitizenId().getCitizenId()));
        colPointId.setCellValueFactory(data-> new SimpleStringProperty(String.valueOf(data.getValue().getValue())));
    }

    public void saveMemberAction(ActionEvent actionEvent) {
        FeMemberEntity memberEntity = new FeMemberEntity();
        memberEntity.setCitizenId(txtId.getText());
        memberEntity.setName(txtName.getText());

        memberEntity.setPhone(txtPhone.getText());

        memberEntity.setBirthdate(Date.valueOf(txtBday.getText()));
    }

    public void resetAction(ActionEvent actionEvent) {

    }

    public void updateAction(ActionEvent actionEvent) {
        FeMemberEntity selected;

        selected = tableMember.getSelectionModel().getSelectedItem();

        selected.setCitizenId(txtId.getText());
        selected.setName(txtName.getText());
        selected.setPhone(txtPhone.getText());
        selected.setBirthdate(Date.valueOf(txtBday.getText()));
    }

    public void saveTransAction(ActionEvent actionEvent) {
        FeTransactionEntity feTransactionEntity  = new FeTransactionEntity();
        feTransactionEntity.setTransDate(Date.valueOf(txtBday.getText()));
        feTransactionEntity.setNominal(Long.parseLong(txtNominal.getText()));


    }
}