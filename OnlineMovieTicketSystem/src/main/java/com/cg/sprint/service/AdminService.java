package com.cg.sprint.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.sprint.dao.AdminDao;
import com.cg.sprint.dao.CityDao;
import com.cg.sprint.dao.SeatsDao;
import com.cg.sprint.dao.TheatreDao;
import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.City;
import com.cg.sprint.entity.Seats;
import com.cg.sprint.entity.Theatre;

@SuppressWarnings("unused")
@Service
@Transactional
public class AdminService implements AdminServiceInterface  {

	
	@Autowired
	private CityDao city;
	@Autowired
	private TheatreDao theatre;
	
	
	@SuppressWarnings("unused")
	@Autowired
	private SeatsDao seats;
	

	@Autowired
	private AdminDao admin;
	//Login of an admin  
	public Admin aLogin(String uname, String pass) {
		return admin.aLogin(uname, pass);
	}

	public City save(City c)
    {
   	 return city.save(c);
    }
	public Theatre save(Theatre t)
    {
   	 return theatre.save(t);
    }	
	public List<City> getCityList() {
		return city.getCityList();
	}
	public String updateCity(City c) {
		boolean bool = city.existsById(c.getSno());
		if(bool == true) {
			city.save(c);
			return "cities were updated successfully!!";
		}
		else {
			return "sorry, cities were not updated";
		}
	}
	
	public String updateTheatre(Theatre t) {
		boolean bool = theatre.existsById(t.getTheatre_id());
		if(bool == true) {
			theatre.save(t);
			return "theatres were updated successfully!!";
		}
		else {
			return "theatres were not updated";
		}
	}
    public void removeCity(int sno)
    {
   	  city.deleteById(sno);
    }
    public void removeTheatre(int theatre_id)
    {
   	  theatre.deleteById(theatre_id);
    }
	public List<Theatre> getTheatreList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void removeShow(int sno) {
		// TODO Auto-generated method stub
		
	}

	public void removeMovie(int movie_id) {
		// TODO Auto-generated method stub
		
	}
}