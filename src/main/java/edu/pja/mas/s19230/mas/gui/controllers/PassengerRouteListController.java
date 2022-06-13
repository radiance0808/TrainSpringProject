package edu.pja.mas.s19230.mas.gui.controllers;

import edu.pja.mas.s19230.mas.gui.view.PassengerRouteListView;
import edu.pja.mas.s19230.mas.model.PassengerRoute;
import edu.pja.mas.s19230.mas.model.Route;
import edu.pja.mas.s19230.mas.service.PassengerRouteService;
import edu.pja.mas.s19230.mas.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PassengerRouteListController {
    private final PassengerRouteListView view;
    private final PassengerRouteService passengerRouteService;
    private final TicketService ticketService;
    private final TicketListController ticketListController;
    private MainWindowController mainWindowController;
   

    public void showGUI(MainWindowController mainWinContr) {
        mainWindowController = mainWinContr;
        updateRoutesFromDB();
        mainWindowController.showView(view.getMainPanel());

    }

    @PostConstruct
    public void initListeners() {
        view.getPassengerRouteList().addListSelectionListener(e -> {
            if (view.getPassengerRouteList().getSelectedValue() == null) return;
            PassengerRoute selectedValue = (PassengerRoute) view.getPassengerRouteList().getSelectedValue();
            view.getSelectedRouteValue().setText(selectedValue.getRouteNumber());
        });

        view.getShowRouteTickets().addActionListener(e -> {
            if (view.getPassengerRouteList().getSelectedValue() == null) return;
            PassengerRoute selectedValue = (PassengerRoute) view.getPassengerRouteList().getSelectedValue();
            view.getSelectedRouteValue().setText(selectedValue.getRouteNumber());
            ticketListController.showGUI(mainWindowController, ticketService.getTicketsByRouteId(selectedValue.getId()));
        });
    }

    private void updateRoutesFromDB() {
        List<Route> routes = passengerRouteService.getAllRoutes();
        DefaultListModel<Route> model = (DefaultListModel<Route>) view.getPassengerRouteList().getModel();
        model.removeAllElements();
        routes.forEach(model :: addElement);

    }
}
