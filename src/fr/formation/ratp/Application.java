package fr.formation.ratp;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dpt = 0;
		int arv = 7;

		buildTravelTime(dpt, arv);
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

	public static List<Journey> buildJourneys(int duration, List<Station> stations) {

		List<Journey> journeys = new ArrayList<Journey>();
		for (int i = 0; i < stations.size() - 1; i++) {
			Journey journey = new Journey(duration, stations.get(i), stations.get(i + 1));
			journeys.add(journey);

		}
		return journeys;
	}

	public static void buildTravelTime(int dpt, int arv) {
		int duration = 5;
		Line line = buildLine("14");
		String[] names = { "Saint-Lazare", "Madelaine", "Pyramides", "Chatelet", "Gare de Lyon", "Bercy",
				"Cour Saint-Émilion", "BFM", "Olympiades" };
		List<Station> stations = buildStation(line, names);
		List<Journey> journeys = buildJourneys(duration, stations);

		System.out.println("obtenir tous les éléments de ArrayList");
		for (int i = 0; i < journeys.size(); i++) {

			System.out.println("index : " + i + " " + journeys.get(i));
		}

		System.out.println("taille de journeys : " + journeys.size());

		// System.out.println("B - SE : " + journeys.get(5).getDeparture());
		Station depart = journeys.get(dpt).getDeparture();
		Station arrivee = journeys.get(arv).getArrival();
		int i = 0;
		int a = 0;
		int b = 0;
		if (dpt == arv) {
			System.out.println("Vous êtes sur place !!");
		} else if (dpt < arv) {
			for (Journey journey : journeys) {

				if (journey.getDeparture().equals(depart)) {

					System.out.println("Départ : " + journey.getDeparture() + " index " + i);
					a = i;
				}
				if (journey.getArrival().equals(arrivee)) {

					System.out.println("arrivée : " + journey.getArrival() + " index " + i);
					b = i;
				}
				i++;
			}
		} else {
			for (Journey journey : journeys) {

				if (journey.getDeparture().equals(depart)) {

					System.out.println("Départ : " + journey.getArrival() + " index " + i);
					b = i;
				} else if (journey.getArrival().equals(arrivee)) {

					System.out.println("Arrivée : " + journey.getDeparture() + " index " + i);
					a = i;
				}
				i++;
			}

		}
		System.out.println("Temps de trajet : " + Math.abs((b - a) * 5) + " minutes");
	}

}
