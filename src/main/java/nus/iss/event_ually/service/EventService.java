package nus.iss.event_ually.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.iss.event_ually.model.Event;
import nus.iss.event_ually.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    public void saveEntry(Event event){
        eventRepo.saveEntry(event);
    }

    public void saveEntries(List<Event> events){
        eventRepo.saveEntries(events);
    }

    public List<Event> getAllEvents(){
        return eventRepo.getAllEntries();
    }
    
}
