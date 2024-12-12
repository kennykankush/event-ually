package nus.iss.event_ually.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import nus.iss.event_ually.model.Event;
import nus.iss.event_ually.service.EventService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private EventService eventServ;

    @GetMapping
    public String showHome(Model model) throws IOException {

        List<Event> events = eventServ.getAllEvents();
        
        model.addAttribute("events", events);

        return "EventHome";
    }
    
    
}
