package com.erivalaxl.flights.controls;

import com.erivalaxl.flights.models.Flights;
import com.erivalaxl.flights.repositories.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FlightControl {
    @Autowired
    private FlightsRepository flightsRepository;

    @PostMapping("/insertar")
    public ResponseEntity<Flights> insertFlights(@RequestBody Flights f){
        flightsRepository.save(f);
        return new ResponseEntity<Flights>(f, HttpStatus.CREATED);
    }
    @GetMapping("/all")
        public ResponseEntity<List<Flights>> getAllFlights(){
        List<Flights> vuelos = flightsRepository.findAll();
        return new ResponseEntity<List<Flights>>(vuelos, HttpStatus.OK);
        }

    @GetMapping("/byDestino")
    public ResponseEntity<List<Flights>> getFlightsByDestiny(@RequestParam String destino){
        List<Flights> flights = flightsRepository.findByDestination(destino);
        return new ResponseEntity<List<Flights>>(flights, HttpStatus.OK);
    }

    @GetMapping("/byDestinoAndDate")
    public ResponseEntity<List<Flights>> getFlightsByDestinyAndDate(@RequestParam String destino, String date){
        List<Flights> flights = flightsRepository.findAllByDestinationAndDate(destino, date);
        return  new ResponseEntity<List<Flights>>(flights, HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Flights> updateFlight(@RequestBody Flights f){
        ResponseEntity<Flights> response;
        if(f.getId() !=0 ){
            Flights flight = flightsRepository.findFirstById(f.getId());
            if (flight != null){
                flightsRepository.save(f);
                response = new ResponseEntity<Flights>(f,HttpStatus.ACCEPTED);
            }else{
                response = new ResponseEntity<>(f, HttpStatus.NOT_FOUND);
            }

        }
        else{
            response = new ResponseEntity<Flights>(f, HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
