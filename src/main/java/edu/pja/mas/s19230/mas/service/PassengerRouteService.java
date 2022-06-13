package edu.pja.mas.s19230.mas.service;

import edu.pja.mas.s19230.mas.model.PassengerRoute;
import edu.pja.mas.s19230.mas.model.Route;
import edu.pja.mas.s19230.mas.repository.PassengerRepository;
import edu.pja.mas.s19230.mas.repository.PassengerRouteRepository;
import edu.pja.mas.s19230.mas.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerRouteService {
    private final PassengerRouteRepository passengerRouteRepository;

    public List<Route> getAllRoutes() {
        Iterable<PassengerRoute> all = passengerRouteRepository.findAll();
        List<Route> res = new ArrayList<>();
        all.forEach(res :: add);
        return res;
    }
}
