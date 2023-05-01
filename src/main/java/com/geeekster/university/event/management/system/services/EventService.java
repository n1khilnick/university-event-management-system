package com.geeekster.university.event.management.system.services;

import com.geeekster.university.event.management.system.models.Events;
import com.geeekster.university.event.management.system.repositories.IEventDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IEventDao eventDao;

    public void addEvents(List<Events> eventsList) {
        Iterable<Events> addedUsers = eventDao.saveAll(eventsList);
    }

    public Iterable<Events> fetchAllEvents() {
        return eventDao.findAll();
    }

    public Iterable<Events> fetchEventByDate(LocalDate date) {
        if(date == null) return null;
        return eventDao.findByDate(date);
    }


    @Transactional
    public String modifyEventDateById(Integer eventId, String eventLocation) {
        if(eventId == null && eventLocation ==null) return  null;
        else if(eventId != null) {
            eventDao.updateEventDateByID(eventId, eventLocation);
            return "Job with id "+eventId+" is updated !!";
        }
        return "Id "+eventId+" doesn't exists !!";
    }

    public String removeEventById(Integer eventId) {
        if(eventId == null) return null;
        else{
            eventDao.deleteById(eventId);
            return "Job with id "+eventId+" is removed !!";
        }
    }


}
