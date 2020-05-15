package com.cg.sprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.entity.City;
import com.cg.sprint.entity.Seats;
import com.cg.sprint.entity.Theatre;
import com.cg.sprint.service.UserServiceInterface;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
	//controller level exception handling
		@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="controller account is not present")
		@ExceptionHandler({Exception.class})
		public void handleException()
		{	
		}
	@Autowired
	private UserServiceInterface movieservice;
	//Signup Details

	//displaying cities
	@GetMapping("/cities")
	public List<City> cityNames(){
		List<City> list = movieservice.getCityNames();
		return list;
	}
	//displaying theaters
	@GetMapping("/theatres/{city-name}")
	public List<Theatre> theatreNames(@PathVariable("city-name") String name){
		List<Theatre> list = movieservice.theatreNames(name);
		return list;
	}
	//displaying seats
	@GetMapping("/seats")
	public List<Seats> getSeats(){
		List<Seats> list = movieservice.getSeats();
		return list;
	}
	//updating seats
	@PutMapping("/update_seats")
	public String updateSeats(@RequestBody Seats seat) {
		String string = movieservice.updateSeats(seat);
		return string;
	}
	//seats information
	@GetMapping("/seat_details/{seat_type}")
	public Seats seatDetails(@PathVariable("seat_type") String seattype) {
		return movieservice.seatDetails(seattype);
	}
	//updating seats
	@PutMapping("/set_seats")
	public String setSeats(@RequestBody Seats seat) {
		String string = movieservice.setSeats(seat);
		return string;
	}
}