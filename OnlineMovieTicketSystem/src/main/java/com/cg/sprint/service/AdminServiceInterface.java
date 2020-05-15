package com.cg.sprint.service;

import java.util.List;
import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.City;
import com.cg.sprint.entity.Seats;
import com.cg.sprint.entity.Theatre;
public interface AdminServiceInterface {
	Admin aLogin(String uname, String pass);
	City save(City c);
	Theatre save(Theatre t);
	List<City> getCityList();
	List<Theatre> getTheatreList();
	String updateCity(City c);
	String updateTheatre(Theatre t);
    void removeCity(int sno);
    void removeTheatre(int theatre_id);
}
