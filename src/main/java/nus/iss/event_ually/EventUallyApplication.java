package nus.iss.event_ually;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nus.iss.event_ually.model.Event;
import nus.iss.event_ually.service.EventService;
import nus.iss.event_ually.utils.FileManagement;

@SpringBootApplication
public class EventUallyApplication implements CommandLineRunner{

	@Autowired
    private EventService eventServ;

	public static void main(String[] args) {
		SpringApplication.run(EventUallyApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
			List<Event> events = eventServ.getAllEvents();

			if (events.isEmpty()){
				System.out.println("Event List is empty, fetching...");
				events = FileManagement.readFile("events.json");
				eventServ.saveEntries(events);

			} else {
				System.out.println("Event List is not empty, will fetch from cache");
			}

    }

}
