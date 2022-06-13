package edu.pja.mas.s19230.mas.gui.view;

import edu.pja.mas.s19230.mas.model.PassengerRoute;
import edu.pja.mas.s19230.mas.model.Route;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@Data
public class PassengerRouteListView {
    private JPanel mainPanel;
    private JList passengerRouteList;
    private JLabel selectedRouteValue;
    private JButton showRouteTickets;

    private void createUIComponents() {
        passengerRouteList = new JList<Route>();
        passengerRouteList.setCellRenderer(new PassengerRouteListCellRenderer());
        passengerRouteList.setModel(new DefaultListModel<PassengerRoute>());
    }

    private class PassengerRouteListCellRenderer extends JLabel implements ListCellRenderer<PassengerRoute> {

        public PassengerRouteListCellRenderer() {
            setOpaque(true);
        }

        @Override
        public java.awt.Component getListCellRendererComponent(JList<? extends PassengerRoute> list, PassengerRoute value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.getRouteNumber() + " Departure from: " + value.getDepartureFrom() + " at : " + value.getDepartureDate() + " " + value.getDepartureTime() +
                    "; Arrival to: " + value.getArrivalTo() + " at: " + value.getArrivalDate() + " " + value.getArrivalTime());
            if(isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            return this;
        }

    }
}
