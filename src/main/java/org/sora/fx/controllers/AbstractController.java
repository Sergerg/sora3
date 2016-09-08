package org.sora.fx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 06.09.2016
 * Time: 14:16
 */
abstract public class AbstractController implements Initializable {
    private static final Logger log = LoggerFactory.getLogger(AbstractController.class);

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize ");
    }
}
