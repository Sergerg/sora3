package org.sora.fx.beans;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sora.fx.controllers.ContactsController;
import org.sora.fx.controllers.MainController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 25.08.2016
 * Time: 14:20
 */
@Configuration
@Lazy
public class ScreensBean {

    private static final Logger log = LoggerFactory.getLogger(ScreensBean.class);

    @Value("${ui.main.title:JavaFX application}")
    private String windowTitle;

    @Value("${spring.messages.basename}") // Явно брать из настроек Spring!
    private String mainResource;

    public String nameCssConverter(String part) {
        return "/css/"+part+".css";
    }

    public String nameFxmlConverter(String part) {
        return "/fxml/"+part+".fxml";
    }

    void closeRequest(WindowEvent event) {
        log.debug("primaryStage.setOnCloseRequest");

        ResourceBundle lngBndl = ResourceBundle.getBundle(mainResource);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        try {
            a.setTitle(lngBndl.getString("exitconfirmation.title"));
            a.setHeaderText(lngBndl.getString("exitconfirmation.text"));
        } catch (MissingResourceException e) {
            log.warn("Resource not found: " + e.getMessage());
            a.setTitle("Confirmation");
            a.setHeaderText("Do you really want to leave?");
        }
        a.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Platform.exit();
            } else {
                event.consume();
            }
        });
    }

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        log.debug("setPrimaryStage = " + primaryStage);
        this.primaryStage = primaryStage;
        primaryStage.setOnCloseRequest(event -> closeRequest(event));
    }

    @Bean(name = "contacts")
    @Scope("prototype")
    ContactsController getContactsController() {
        log.debug("getContactsController");
        return new ContactsController();
    }

    @Bean(name = "main")
    @Scope("prototype")
    MainController getMainController() {
        log.debug("getMainController");
        return new MainController();
    }

    // TODO - factory
//    //@Bean
//    Object getController(String name) {
//        if (name.equals("contacts"))
//            return new ContactsController();
//        //if (name.equals("main"))
//            return new MainController();
//    }

    public void show(String name) {
        log.info("show, " + name);
        Scene scene;
        try {
            URL fxmlUrl = getClass().getResource(nameFxmlConverter(name));
            FXMLLoader loader = new FXMLLoader(fxmlUrl, ResourceBundle.getBundle(mainResource));
            if (name.equals("main")) {
                loader.setControllerFactory(aClass -> getMainController());  // TODO - factory
            }
            if (name.equals("contacts")) {
                loader.setControllerFactory(aClass -> getContactsController());  // TODO - factory
            }
            log.debug("1");
            Parent view = loader.load();
            log.debug("2");

            scene = new Scene(view);
            scene.getStylesheets().add(getClass().getResource(nameCssConverter(name)).toExternalForm());
        } catch (IOException e) {
            log.error("Can't load resource", e);
            throw new RuntimeException(e);
        }

        primaryStage.setTitle(windowTitle);
        if (scene != null)
            primaryStage.setScene(scene);
        primaryStage.show();
    }
}
