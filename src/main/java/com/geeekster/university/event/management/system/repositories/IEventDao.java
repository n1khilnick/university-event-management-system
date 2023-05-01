package com.geeekster.university.event.management.system.repositories;

import com.geeekster.university.event.management.system.models.Events;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IEventDao extends CrudRepository<Events, Integer> {

    Iterable<Events> findByDate(LocalDate date);

    @Modifying
    @Query(value = "Update Events set EVENT_LOCATION = :eventLocation where EVENT_ID = :eventId ",nativeQuery = true)
    void updateEventDateByID(Integer eventId, String eventLocation);



}
