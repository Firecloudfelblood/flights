package com.erivalaxl.flights.repositories;

import com.erivalaxl.flights.models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights, Long> {
     List<Flights>  findByDestination(String destino);
     List<Flights> findAllByDestinationAndDate(String destino, String date);
     Flights findFirstById(Long id);

}
