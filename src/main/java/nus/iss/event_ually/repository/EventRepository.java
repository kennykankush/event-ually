package nus.iss.event_ually.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import nus.iss.event_ually.model.Event;
import nus.iss.event_ually.model.User;

@Repository
public class EventRepository {

    @Autowired
    @Qualifier("jsonTemplate")
    private RedisTemplate<String,Object> template;

    private String redisKey = "events";

    public void saveEntry(Event event){
        template.opsForList().rightPush(redisKey, event);
    }

    public void saveEntries(List<Event> events){
        for (Event event: events){
            saveEntry(event);
        }
    }

    public List<Event> getAllEntries(){
        List<Object> events = template.opsForList().range(redisKey, 0, -1);

        if (events == null) {
            events = List.of();
        }

        return events.stream()
        .map(obj -> (Event) obj)
        .collect(Collectors.toList());
        
    }

    public int getNumberOfEvents(){
        List<Event> events = getAllEntries();
        return events.size();
    }
    
    public Event getEvent(Integer index){
        List<Event> events = getAllEntries();
        return events.get(index);
    }

    public void deleteEvent(Event event) {
        template.opsForList().remove(redisKey, 0, event);
    }

    public void updateEvent(List<Event> events, Event event) {

        for (int i = 0; i < events.size(); i++){

            Event redisEvent = events.get(i);
            String redisEventName = redisEvent.getEventName();
            String toUpdate = event.getEventName();

            if (redisEventName.equals(toUpdate)){
                template.opsForList().set(redisKey, i, event);
                break;
            }
        }

    }

    public void increaseCount(List<Event> events, User user){

        int ticketQty = user.getTickets();

        for (int i = 0; i < events.size(); i++){
            Event event = events.get(i);
            String eventName = event.getEventName();

            if (eventName.equals(user.getRegisteredEvent())){
                int sum = event.getParticipants() + ticketQty;
                event.setParticipants(sum);
                updateEvent(events, event);
                break;
            }
        }
        
    }
}
