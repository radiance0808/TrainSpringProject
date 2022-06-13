package edu.pja.mas.s19230.mas.service;

import edu.pja.mas.s19230.mas.model.Ticket;
import edu.pja.mas.s19230.mas.model.Train;
import edu.pja.mas.s19230.mas.repository.TicketRepository;
import edu.pja.mas.s19230.mas.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;

    public List<Train> getAllTrains() {
        Iterable<Train> all = trainRepository.findAll();
        List<Train> res = new ArrayList<>();
        all.forEach(res :: add);
        return res;
    }
}
