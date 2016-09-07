package org.sora.fx;

import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sora.fx.beans.ScreensBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "org.sora.fx.*")
public class Application extends javafx.application.Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private static String[] args;

    // App start
    public static void main(String[] args) {
        log.info("BEGIN main.");
        Application.args = args;

        launch(args);
        log.info("END main.");
    }

    // Javafx runner
    @Override
    public void start(Stage primaryStage) throws Exception {
        log.info("BEGIN start.");

        // Start Spring container
        ApplicationContext context = SpringApplication.run(Application.class, args);
        log.info("Spring context load ok.");

        // start JavaFX spring configuration
        ScreensBean screensBean = context.getBean(ScreensBean.class);
        screensBean.setPrimaryStage(primaryStage);
        screensBean.show("main");

        log.info("END start.");
    }

}
