package com.buddhikajay.controller;

import com.buddhikajay.model.BachitherapyTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOError;
import java.util.Date;

/**
 * Created by buddhika on 4/3/15.
 */
public class BachitherapyController {


    @FXML
    public TableView <BachitherapyTable>bachitherapyTable;
    @FXML
    private TableColumn <BachitherapyTable,Date> dateCol;
    @FXML
    private TableColumn <BachitherapyTable,String> icrCol;
    @FXML
    private TableColumn <BachitherapyTable,String> patientNameCol;
    @FXML
    private TableColumn  <BachitherapyTable,String> clinicNoCol;
    @FXML
    private TableColumn  <BachitherapyTable,String> addressCol;
    @FXML
    private TableColumn  <BachitherapyTable,String> phoneNoCol;
    @FXML
    private TableColumn  <BachitherapyTable,Date> d1Col;
    @FXML
    private TableColumn  <BachitherapyTable,Date> d2Col;
    @FXML
    private TableColumn  <BachitherapyTable,Date> d3Col;
    @FXML
    private TableColumn  <BachitherapyTable,String> remarksCol;


    private ObservableList <BachitherapyTable> bachitherapyTableObservableList = FXCollections.observableArrayList();
    private Main main;


    /**
     * Initializing the table
     */
    public boolean initialize(){
        try {
            dateCol.setCellValueFactory(new PropertyValueFactory<BachitherapyTable, Date>("date"));
            icrCol.setCellValueFactory(new PropertyValueFactory<BachitherapyTable, String>("icrNo"));
            patientNameCol.setCellValueFactory(new PropertyValueFactory<BachitherapyTable, String>("patientName"));
            clinicNoCol.setCellValueFactory(new PropertyValueFactory<BachitherapyTable, String>("clinicNo"));
            addressCol.setCellValueFactory(new PropertyValueFactory<BachitherapyTable, String>("address"));
            phoneNoCol.setCellValueFactory(new PropertyValueFactory<BachitherapyTable, String>("tpNo"));
            d1Col.setCellValueFactory(new PropertyValueFactory<BachitherapyTable, Date>("date1"));
            d2Col.setCellValueFactory(new PropertyValueFactory<BachitherapyTable, Date>("date2"));
            d3Col.setCellValueFactory(new PropertyValueFactory<BachitherapyTable, Date>("date3"));
            remarksCol.setCellValueFactory(new PropertyValueFactory<BachitherapyTable, String>("remarks"));
            return true;
        }
        catch (IOError e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean initTable(){
        try {
            this.bachitherapyTable.setItems(this.bachitherapyTableObservableList);
            return true;
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    public ObservableList<BachitherapyTable> getBachitherapyTableObservableList() {
        return bachitherapyTableObservableList;
    }

    public void setBachitherapyTableObservableList(ObservableList<BachitherapyTable> bachitherapyTableObservableList) {
        this.bachitherapyTableObservableList = bachitherapyTableObservableList;
    }

}


