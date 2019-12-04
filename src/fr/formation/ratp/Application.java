package fr.formation.ratp;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

public class Application {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Line line = buildLine("14");
		System.out.println(line);
		String[] names = { "Saint-Lazare", "Madelaine", "Pyramides","Chatelet","Gare de Lyon","Bercy", "Cour Saint-Émilion", "BFM", "Olympiades" };
		List<Station> stations = buildStation(line, names);
		System.out.println("Stations : " + stations);
		int duration = 5;
		List<Journey> journeys = buildJourneys(duration , stations);

		System.out.println("obtenir tous les éléments de ArrayList");
	     for(int i = 0; i<journeys.size();i++)
	        System.out.println("index : "+ i + " " + journeys.get(i));
	  

	}

	private static Line buildLine(String name) {

		return new Line(name);
	}

	// var args String... permet d'entrer directement la liste dans buildStation
	// private static List<Station> buildStation(Line line, String... names)
	private static List<Station> buildStation(Line line, String[] names) {

		// but : retourner des stations

		// declarer une liste
		List<Station> stations = new ArrayList<>();
		// iterer sur les names
		// recuperer un name
		for (String name : names) {
			// construire une station avec son name et sa line
			Station station = new Station(name, line);
			// ajoute dans la liste
			stations.add(station);
		}

		// return list

		return stations;

	}
	public static List<Journey> buildJourneys(int duration, List<Station> stations){
		
		List<Journey> journeys = new ArrayList<Journey>();
		for (int i = 0; i < stations.size() - 1; i++) {
			Journey journey = new Journey(duration, stations.get(i),stations.get(i+1));
			journeys.add(journey);
			
		}
		return journeys;
	}

}
