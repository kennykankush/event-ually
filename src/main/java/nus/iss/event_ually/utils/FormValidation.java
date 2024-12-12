package nus.iss.event_ually.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import nus.iss.event_ually.model.Event;
import nus.iss.event_ually.model.User;

public class FormValidation {
    
    public static boolean checkExceed(List<Event> events, User user){

        for (int i = 0; i < events.size(); i++){
            Event event = events.get(i);

            String eventObjName = event.getEventName();
            String userRegisteredEvent = user.getRegisteredEvent();

            Integer eventParticipants = event.getParticipants();
            Integer eventSize = event.getEventSize();
            Integer userAdmissionQty = user.getTickets();

            if (eventObjName.equals(userRegisteredEvent)){
                
                if (userAdmissionQty + eventParticipants > eventSize){
                   return true;

                } 

            }
            
        }

        return false;

    }

    public static boolean UNDERAGEDETECTOR(User user){
        LocalDate userBirthday = user.getBirthday();

        int age = Period.between(userBirthday, LocalDate.now()).getYears();

        return age < 21;
    
    }

    
    
}
