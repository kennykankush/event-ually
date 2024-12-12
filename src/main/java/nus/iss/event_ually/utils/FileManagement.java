package nus.iss.event_ually.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import nus.iss.event_ually.model.Event;

public class FileManagement {

    public static List<Event> readFile(String fileName) throws IOException{

        List<Event> events = new ArrayList<>();

        String directory = "./src/main/resources/json/";

        File file = new File(directory + fileName);

        if (!file.exists()){
            System.out.println("FILE DOES NOT EXIST!!");
        }

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());

        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        
        JsonReader jsonReader = Json.createReader(isr);
        JsonArray eventCollection = jsonReader.readArray();

        for (int i = 0; i < eventCollection.size(); i++){
            JsonObject iEvent = eventCollection.getJsonObject(i);

            Event event = new Event();
            event.setEventId(iEvent.getInt("eventId"));
            event.setEventName(iEvent.getString("eventName"));
            event.setEventSize(iEvent.getInt("eventSize"));
            event.setEventDate(iEvent.getJsonNumber("eventDate").longValue());
            event.setParticipants(iEvent.getInt("participants"));

            events.add(event);

        }

        return events;
        
    }
    
}
