package edu.pja.mas.s19230.mas;

import edu.pja.mas.s19230.mas.gui.controllers.MainWindowController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class MasApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MasApplication.class, args);
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MasApplication.class).headless(false)
                .run(args);

        SwingUtilities.invokeLater(() -> {
            ctx.getBean(MainWindowController.class).showGUI();
        });
    }

}
