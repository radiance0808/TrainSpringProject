package edu.pja.mas.s19230.mas.gui.view;

import edu.pja.mas.s19230.mas.model.PassengerRoute;
import edu.pja.mas.s19230.mas.model.Ticket;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

@org.springframework.stereotype.Component
@Data
public class TicketListView {
    private JPanel MainPanel;
    private JList ticketsList;
    private JLabel selectedTicketValue;

    private void createUIComponents() {
        ticketsList = new JList<Ticket>();
        ticketsList.setCellRenderer(new TicketListCellRenderer());
        ticketsList.setModel(new DefaultListModel<Ticket>());
    }

    private static class TicketListCellRenderer extends JLabel implements ListCellRenderer<Ticket> {

        public TicketListCellRenderer() {
            setOpaque(true);
        }

        @Override
        public java.awt.Component getListCellRendererComponent(JList<? extends Ticket> list, Ticket value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.getTicketNumber() + " " + value.getHasTicket().getFirstName() + " " + value.getHasTicket().getLastName());

            if (isSelected) {
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
