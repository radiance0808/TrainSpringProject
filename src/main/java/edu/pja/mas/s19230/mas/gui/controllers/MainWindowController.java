package edu.pja.mas.s19230.mas.gui.controllers;

import edu.pja.mas.s19230.mas.gui.view.MainWindowView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Controller
@RequiredArgsConstructor
public class MainWindowController {
    private final MainWindowView view;
    private final PassengerRouteListController passengerRouteListController;
    private final TicketListController ticketListController;


    public void showGUI() {
        view.setVisible(true);
    }

    @PostConstruct
    private void initMenuListeners() {
        view.getMenuItemRouteList().addActionListener( e -> {
            passengerRouteListController.showGUI(this);
        });
        view.getMenuItemTicketList().addActionListener(e -> {
            ticketListController.showGUI(this);
        });
    }

    public void showView(JPanel viewToShow) {
        view.getContentPane().removeAll();
        view.getContentPane().add(viewToShow);
        view.revalidate();
    }
}

