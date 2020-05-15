package com.cg.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.City;
//import com.cg.sprint.entity.Movies;
//import com.cg.sprint.entity.Shows;
import com.cg.sprint.entity.Theatre;
import com.cg.sprint.service.AdminServiceInterface;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {	
	@Autowired
	private AdminServiceInterface adminservice;
	//Admin Details
	@GetMapping("/admin-validation/{username}/{password}")
	public ResponseEntity<Admin> aLogin(@PathVariable("username") String uname, @PathVariable("password") String pwd) {
		Admin auth = adminservice.aLogin(uname, pwd);
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(auth,HttpStatus.OK);
		return response;
	}
	@PostMapping("/addcity")
    public City addCity(@Valid @RequestBody City c)
    {
   	 return adminservice.save(c);
   	
    }
	@PostMapping("/addtheatre")
    public Theatre addTheatre(@Valid @RequestBody Theatre t)
    {
   	 return adminservice.save(t);
   	
    }
	//@PostMapping("/addmovie")
    //public Movies addMovie(@Valid @RequestBody Movies m)
    //{
   	// return adminservice.save(m);
   	
    //}
	@GetMapping("/cityList")
	public List<City> cityList(){
		List<City> list = adminservice.getCityList();
		return list;
	}
	@GetMapping("/theatreList")
	public List<Theatre> theatreList(){
		List<Theatre> list = adminservice.getTheatreList();
		return list;
	}
	//displaying movies
	/*@GetMapping("/moviesList")
	public List<Movies> movieList(){
		List<Movies> list = adminservice.getMovieList();
		return list;
	}*/
	
	@PutMapping("/update_cities")
	public String updateCity(@RequestBody City c) {
		String string = adminservice.updateCity(c);
		return string;
	}
	@PutMapping("/update_theatres")
	public String updateTheatre(@RequestBody Theatre t) {
		String string = adminservice.updateTheatre(t);
		return string;
	}
	//@PutMapping("/update_movies")
	//public String updateMovies(@RequestBody Movies m) {
		//String string = adminservice.updateMovies(m);
		//return string;
	//}
	
	@DeleteMapping("/removeCity/{sno}")
    public String removeCity(@PathVariable int sno)
    {
   	 adminservice.removeCity(sno);
   	 return "City Details Removed";
    }
	@DeleteMapping("/removeTheatre/{theatre_id}")
    public String removeTheatre(@PathVariable int theatre_id)
    {
   	 adminservice.removeTheatre(theatre_id);
   	 return "Theatre Details Removed";
    }
}