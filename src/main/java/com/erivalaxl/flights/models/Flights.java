package com.erivalaxl.flights.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
public class Flights {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private String destination;
    private String origin;
    private int capacity;
    private LocalTime time;

    public Flights(String date, String destination, String origin, int capacity, String time) throws ParseException {
        this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        this.destination = destination;
        this.origin = origin;
        this.capacity = capacity;
        this.time = LocalTime.parse(time);
    }
}
