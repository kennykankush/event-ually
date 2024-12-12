package nus.iss.event_ually.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import nus.iss.event_ually.model.Event;

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
}
