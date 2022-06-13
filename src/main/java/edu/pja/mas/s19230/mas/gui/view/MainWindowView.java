package edu.pja.mas.s19230.mas.gui.view;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Data
@Component
public class MainWindowView extends JFrame {
    private JMenuItem menuItemRouteList;
    private JMenuItem menuItemTicketList;

    public MainWindowView() {
        setTitle("GUI Spring");
        setSize(1024,768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initMenuBar();
    }

    private void initMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu menuRoutes = new JMenu("Routes");
        bar.add(menuRoutes);

        JMenu menuTickets = new JMenu("Tickets");
        bar.add(menuTickets);

        menuItemRouteList = new JMenuItem("Show route list");
        menuRoutes.add(menuItemRouteList);

        menuItemTicketList = new JMenuItem("Show ticket list");
        menuTickets.add(menuItemTicketList);

        this.setJMenuBar(bar);
    }
}
