package org.sora.fx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sora.fx.beans.MainScreenBean;
import org.sora.fx.beans.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 06.09.2016
 * Time: 14:16
 */
abstract public class AbstractMainMenuController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(AbstractMainMenuController.class);

    @Autowired
    @Qualifier("test")
    Test test;

    @Autowired
    MainScreenBean mainScreenBean;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize ");
    }

    public void login(ActionEvent actionEvent) {
        log.debug("login");

        if (test != null)
            log.debug(test.test());
    }

    public void contacts(ActionEvent actionEvent) {
        log.debug("contacts");
        mainScreenBean.show("contacts");
    }

    public void showErrorDialog(ActionEvent actionEvent) {
        log.debug("showErrorDialog");
    }

}
