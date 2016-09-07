package org.sora.fx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.sora.fx.entity.Contact;
//import org.sora.fx.services.ContactService;
import org.sora.fx.entity.Contact;
import org.sora.fx.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 19.08.2016
 * Time: 7:56
 */
public class ContactsController extends AbstractMainMenuController {

    private static final Logger log = LoggerFactory.getLogger(ContactsController.class);

    @Autowired
    @Qualifier("contactService")
    private ContactService contactService;

    @FXML
    private TableView<Contact> tableClient;

    /**
     * Del
     */
    @PostConstruct
    public void init() {
        log.debug("init");
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize() ");

        super.initialize(location,resources);

        log.debug("tableClient = " + tableClient);
        // TODO AutoCreating by Contact?!
        if (tableClient != null) {
            tableClient.getColumns().clear();
            TableColumn nickCol = new TableColumn("Nick");
            nickCol.setCellValueFactory(
                    new PropertyValueFactory<Contact,String>("nick")
            );
            TableColumn nameCol = new TableColumn("Name");
            nameCol.setCellValueFactory(
                    new PropertyValueFactory<Contact,String>("name")
            );
            TableColumn emailCol = new TableColumn("Email");
            emailCol.setCellValueFactory(
                    new PropertyValueFactory<Contact,String>("email")
            );
            TableColumn phoneCol = new TableColumn("Phone");
            phoneCol.setCellValueFactory(
                    new PropertyValueFactory<Contact,String>("phone")
            );
            tableClient.getColumns().addAll(nickCol, nameCol, emailCol, phoneCol);
        }

        // TODO: bind!
        log.debug("contactService = " + contactService);
        if (contactService != null) {
            contactService.loadData();
            if (tableClient != null)
                tableClient.setItems(contactService.getData());
        }
    }

    public void addPerson(ActionEvent actionEvent) {
        log.info("addPerson");
    }

    public void editPerson(ActionEvent actionEvent) {
        log.info("editPerson");
    }

    public void delPerson(ActionEvent actionEvent) {
        log.info("delPerson");
    }

    public void refresh(ActionEvent actionEvent) {
        ;
    }
}
