package com.cg.sprint.service;
import java.util.List;
import com.cg.sprint.entity.City;
import com.cg.sprint.entity.Seats;
import com.cg.sprint.entity.Theatre;
public interface UserServiceInterface {
	List<City> getCityNames();
	List<Theatre> theatreNames(String name);
	List<Seats> getSeats();
	String updateSeats(Seats seat_obj);
	Seats seatDetails(String s_type);
	String setSeats(Seats seat);
}
