package org.sora.fx.controllers;

import javafx.fxml.FXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 25.08.2016
 * Time: 14:31
 */
public class MainController extends AbstractMainMenuController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

//    @FXML
//    AbstractMainMenuController abstractMainMenuController;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize() ");

        super.initialize(location,resources);
    }
}
