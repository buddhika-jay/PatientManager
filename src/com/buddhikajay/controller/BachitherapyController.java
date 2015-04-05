package com.buddhikajay.controller;

import com.buddhikajay.SqliteDatabase;
import com.buddhikajay.model.BachitherapyEntity;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.event.ChangeListener;
import java.io.IOError;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by buddhika on 4/3/15.
 */
public class BachitherapyController {


    @FXML
    public TableView <BachitherapyEntity>bachitherapyTable;


    @FXML
    private TableColumn <BachitherapyEntity,Date> dateCol;
    @FXML
    private TableColumn <BachitherapyEntity,String> icrCol;
    @FXML
    private TableColumn <BachitherapyEntity,String> patientNameCol;
    @FXML
    public TableColumn <BachitherapyController,Integer>ageCol;
    @FXML
    private TableColumn  <BachitherapyEntity,String> clinicNoCol;
    @FXML
    private TableColumn  <BachitherapyEntity,String> addressCol;
    @FXML
    private TableColumn  <BachitherapyEntity,String> phoneNoCol;
    @FXML
    private TableColumn  <BachitherapyEntity,Date> d1Col;
    @FXML
    private TableColumn  <BachitherapyEntity,Date> d2Col;
    @FXML
    private TableColumn  <BachitherapyEntity,Date> d3Col;
    @FXML
    private TableColumn  <BachitherapyEntity,String> remarksCol;
    //in bottom anchorpane
    @FXML
    public TextField dateTextField;
    @FXML
    public TextField icrNoTextField;
    @FXML
    public TextField nameTextField;
    @FXML
    public TextArea remarksTextArea;
    @FXML
    public TextField clinicNoTextField;
    @FXML
    public TextField ageTextField;
    @FXML
    public TextField phoneNoTextField;
    @FXML
    public TextArea addressTextArea;
    @FXML
    public TextField date1TextField;
    @FXML
    public TextField date2TextField;
    @FXML
    public TextField date3TextField;

    private final String GET_BACHITHERAPY = "SELECT * FROM bachitherapy NATURAL JOIN patient";
    private ObservableList <BachitherapyEntity> bachitherapyEntityObservableList = FXCollections.observableArrayList();
    private Main main;
    private SqliteDatabase database;


    @FXML
    public void initialize(){
        try {
            dateCol.setCellValueFactory(new PropertyValueFactory<BachitherapyEntity, Date>("date"));
            icrCol.setCellValueFactory(new PropertyValueFactory<BachitherapyEntity, String>("icrNo"));
            patientNameCol.setCellValueFactory(new PropertyValueFactory<BachitherapyEntity, String>("name"));
            ageCol.setCellValueFactory(new PropertyValueFactory<BachitherapyController, Integer>("age"));
            clinicNoCol.setCellValueFactory(new PropertyValueFactory<BachitherapyEntity, String>("clinicNo"));
            addressCol.setCellValueFactory(new PropertyValueFactory<BachitherapyEntity, String>("address"));
            phoneNoCol.setCellValueFactory(new PropertyValueFactory<BachitherapyEntity, String>("phoneNo"));
            d1Col.setCellValueFactory(new PropertyValueFactory<BachitherapyEntity, Date>("date1"));
            d2Col.setCellValueFactory(new PropertyValueFactory<BachitherapyEntity, Date>("date2"));
            d3Col.setCellValueFactory(new PropertyValueFactory<BachitherapyEntity, Date>("date3"));
            remarksCol.setCellValueFactory(new PropertyValueFactory<BachitherapyEntity, String>("remarks"));

            bachitherapyTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            bachitherapyTable.getSelectionModel().selectedItemProperty().addListener(new javafx.beans.value.ChangeListener<BachitherapyEntity>() {
                @Override
                public void changed(ObservableValue<? extends BachitherapyEntity> observable, BachitherapyEntity oldValue, BachitherapyEntity newValue) {
                    displaySelectedItemDetails(newValue);
                }
            });


        }
        catch (IOError e){
            e.printStackTrace();
        }
    }

    /**
     * this method should be called after calling setBachitherapyFromDatabase()
     * @return
     */
    public boolean initTable(){
        try {
            this.bachitherapyTable.setItems(this.bachitherapyEntityObservableList);
            return true;
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }


    public boolean setBachitherapyFromDatabase(){
        ResultSet resultSet;
        try {
                database.connect();
                resultSet = database.query(GET_BACHITHERAPY);
                while (resultSet.next()){
                    //tempery variable to store details
                    BachitherapyEntity tempBachitheraypyEntity = new BachitherapyEntity();

                    tempBachitheraypyEntity.setDate(new SimpleDateFormat(resultSet.getDate("date").toString()));
                    tempBachitheraypyEntity.setIcrNo(resultSet.getInt("icrNo"));
                    tempBachitheraypyEntity.setName(resultSet.getString("name"));
                    tempBachitheraypyEntity.setAge(resultSet.getInt("age"));
                    tempBachitheraypyEntity.setClinicNo(resultSet.getString("clinicNo"));
                    tempBachitheraypyEntity.setAddress(resultSet.getString("address"));
                    tempBachitheraypyEntity.setPhoneNo(resultSet.getInt("phoneNo"));
                    tempBachitheraypyEntity.setRemarks(resultSet.getString("remarks"));

                    tempBachitheraypyEntity.setDate1(new SimpleDateFormat(resultSet.getDate("d1").toString()));
                    tempBachitheraypyEntity.setDate2(new SimpleDateFormat(resultSet.getDate("d2").toString()));
                    tempBachitheraypyEntity.setDate3(new SimpleDateFormat(resultSet.getDate("d3").toString()));


                    bachitherapyEntityObservableList.add(tempBachitheraypyEntity);
                }
                return true;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean displaySelectedItemDetails(BachitherapyEntity bachitherapyEntity){
        try {
            //display selected item in text fields
            dateTextField.setText(bachitherapyEntity.getDate().toString());
            icrNoTextField.setText(Integer.toString(bachitherapyEntity.getIcrNo()));
            nameTextField.setText(bachitherapyEntity.getName());
            ageTextField.setText(Integer.toString(bachitherapyEntity.getAge()));
            clinicNoTextField.setText(bachitherapyEntity.getClinicNo());
            addressTextArea.setText(bachitherapyEntity.getAddress());
            phoneNoTextField.setText(Integer.toString(bachitherapyEntity.getPhoneNo()));
            remarksTextArea.setText(bachitherapyEntity.getRemarks());
            date1TextField.setText(bachitherapyEntity.getDate1().toString());
            date2TextField.setText(bachitherapyEntity.getDate2().toString());
            date3TextField.setText(bachitherapyEntity.getDate3().toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public ObservableList<BachitherapyEntity> getBachitherapyEntityObservableList() {
        return bachitherapyEntityObservableList;
    }

    public void setBachitherapyEntityObservableList(ObservableList<BachitherapyEntity> bachitherapyEntityObservableList) {
        this.bachitherapyEntityObservableList = bachitherapyEntityObservableList;
    }

    /**
     * This should be the first method to be called from BachitherapyController object
     * @param main Main appication
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Second method to be called from BachitherapyController object
     * @param database
     */
    public void setDatabase(SqliteDatabase database) {
        this.database = database;
    }
}


