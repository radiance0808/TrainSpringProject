package edu.pja.mas.s19230.mas.gui.controllers;

import edu.pja.mas.s19230.mas.gui.view.TicketListView;
import edu.pja.mas.s19230.mas.model.Ticket;
import edu.pja.mas.s19230.mas.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TicketListController {
    private final TicketListView view;
    private final TicketService ticketService;
    private MainWindowController mainWindowController;

    public void showGUI(MainWindowController mainWindowController, List<Ticket> tickets) {
        updateTicketsByRouteFromDB(tickets);
        mainWindowController.showView(view.getMainPanel());
    }

    public void showGUI(MainWindowController mainWindowController) {
        updateTicketsFromDB();
        mainWindowController.showView(view.getMainPanel());
    }

    @PostConstruct
    public void initListeners() {
        view.getTicketsList().addListSelectionListener(e -> {
            if (view.getTicketsList().getSelectedValue() == null) return;
            Ticket selectedTicket = (Ticket) view.getTicketsList().getSelectedValue();
            view.getSelectedTicketValue().setText(selectedTicket.getTicketNumber());
        });
    }

    private void updateTicketsFromDB() {
        List<Ticket> tickets = ticketService.getAllTickets();
        DefaultListModel<Ticket> model = (DefaultListModel<Ticket>) view.getTicketsList().getModel();
        model.removeAllElements();
        tickets.forEach(model::addElement);
    }

    public void updateTicketsByRouteFromDB(List<Ticket> tickets) {
        DefaultListModel<Ticket> model = (DefaultListModel<Ticket>) view.getTicketsList().getModel();
        model.removeAllElements();
        tickets.forEach(model::addElement);
    }

    }
