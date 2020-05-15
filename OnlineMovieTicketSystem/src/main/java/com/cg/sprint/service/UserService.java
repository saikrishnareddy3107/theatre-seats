package com.cg.sprint.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.sprint.dao.CityDao;
import com.cg.sprint.dao.SeatsDao;
import com.cg.sprint.dao.TheatreDao;
import com.cg.sprint.entity.City;
import com.cg.sprint.entity.Seats;
import com.cg.sprint.entity.Theatre;

@Service
@Transactional
public class UserService implements UserServiceInterface  {

	
	@Autowired
	private CityDao city;
	@Autowired
	private TheatreDao theatre;
	@Autowired
	private SeatsDao seats;
	@Autowired 
	//Displaying City Names
	public List<City> getCityNames() {
		return city.getCityNames();
	}
	//Displaying theatre names
	public List<Theatre> theatreNames(String name) {
	List<Theatre> list = theatre.theatreNames(name);
	return list;
	}
	//Displaying seats
	public List<Seats> getSeats() {
		List<Seats> list = seats.findAll();
		return list;
	}
	//Updating seats
	public String updateSeats(Seats seat_obj) {
		boolean bool = seats.existsById(seat_obj.getSno());
		if(bool == true) {
			seats.save(seat_obj);
			return "seats were updated successfully!!";
		}
		else {
			return "sorry, seats were not updated";
		}
	}
	public Seats seatDetails(String s_type) {
		return seats.seatDetails(s_type);
	}
	public String setSeats(Seats seat) {
		boolean bool = seats.existsById(seat.getSno());
		if(bool == true) {
			seats.save(seat);
			return "seats updated successfully!!";
		}
		else {
			return "Sorry!!seats were not updated.";
		}
	}

	
}