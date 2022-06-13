package edu.pja.mas.s19230.mas;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {





    @EventListener
    public void atStart(ContextRefreshedEvent ev) {

    }



}
