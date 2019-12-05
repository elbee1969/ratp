package fr.formation.ratp;

import java.util.List;

public class Journey {

	public Journey(int duration, Station departure, Station arrival) {
		this.duration = duration;
		this.departure = departure;
		this.arrival = arrival;
	}
	public Journey() {
		
	};

	public Journey(int duration, List<Station> stations) {
		// TODO Auto-generated constructor stub
	}

	private int duration;
	private Station departure;
	private Station arrival;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Station getDeparture() {
		return departure;
	}

	public void setDeparture(Station departure) {
		this.departure = departure;
	}

	public Station getArrival() {
		return arrival;
	}

	public void setArrival(Station arrival) {
		this.arrival = arrival;
	}

	@Override
	public String toString() {
		return "Journey [duration=" + duration + ", departure=" + departure + ", arrival=" + arrival + "]";
	}
	public String size() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
