package org.sora.fx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sora.fx.beans.ScreensBean;
import org.sora.fx.beans.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 08.09.2016
 * Time: 13:30
 */
public class MainMenuController extends AbstractController {
    private static final Logger log = LoggerFactory.getLogger(MainMenuController.class);

    @Autowired
    @Qualifier("test")
    Test test;

    @Autowired
    ScreensBean mainScreenBean;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize ");

        super.initialize(location, resources);
    }

    public void login(ActionEvent actionEvent) {
        log.debug("login");

        if (test != null)
            log.debug(test.test());
    }

    public void main(ActionEvent actionEvent) {
        log.debug("main");
        mainScreenBean.show("main");
    }

    public void contacts(ActionEvent actionEvent) {
        log.debug("contacts");
        mainScreenBean.show("contacts");
    }

    public void showErrorDialog(ActionEvent actionEvent) {
        log.debug("showErrorDialog");
    }

}
