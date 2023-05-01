package com.geeekster.university.event.management.system.controllers;

import com.geeekster.university.event.management.system.models.Events;
import com.geeekster.university.event.management.system.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/events")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping(value = "/createEvents")
    public String createEvents(@Valid @RequestBody List<Events> eventsList){
        eventService.addEvents(eventsList);
        return "Event(s) Created !!";
    }

    @GetMapping(value = "/all")
    public Iterable<Events> getAllEvents(){
        return eventService.fetchAllEvents();
    }

    @GetMapping(value = "/{date}")
    public Iterable<Events> getEventByDate (@PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate date){
        return eventService.fetchEventByDate(date);
    }

    @PutMapping(value = "/update/{eventId}/{eventLocation}")
    public String updateEventDateById(@PathVariable Integer eventId, @PathVariable String eventLocation){
        return eventService.modifyEventDateById(eventId, eventLocation);
    }

    @DeleteMapping(value = "/delete/{eventId}")
    public String deleteEventByID(@PathVariable Integer eventId){
        return eventService.removeEventById(eventId);
    }








}
