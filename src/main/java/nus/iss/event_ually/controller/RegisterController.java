package nus.iss.event_ually.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import nus.iss.event_ually.model.Event;
import nus.iss.event_ually.model.User;
import nus.iss.event_ually.service.EventService;
import nus.iss.event_ually.utils.DateConversion;
import nus.iss.event_ually.utils.FormValidation;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


@Controller
public class RegisterController {

    @Autowired
    private EventService eventServ;

    @PostMapping("/register")
    public String showRegister(Model model,
                                @RequestParam("name") String name,
                                @RequestParam("date") String date) {

        User user = new User();
        user.setRegisteredEvent(name);

        model.addAttribute("user", user);
        model.addAttribute("eventName", name);

        long dateLong = Long.parseLong(date);
        String readableDate = DateConversion.epochMiliToDate(dateLong);

        model.addAttribute("eventDate", readableDate);

        return "RegisterPage";
    }

    @PostMapping("/registered")
    public String processRegistrant(@ModelAttribute @Valid User user, BindingResult results, Model model){

        if (results.hasErrors()){
            return "RegisterPage";
        }

        List<Event> events = eventServ.getAllEvents();

        if (FormValidation.checkExceed(events, user)){
            model.addAttribute("exceed", "exceed");
            return "RegisterPage";
        }

        if (FormValidation.UNDERAGEDETECTOR(user)){
            return "Underage";
        }

        eventServ.increaseCount(events, user);

        return "SuccessRegistration";


    }
    


    
}
