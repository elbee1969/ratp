package fr.formation.ratp;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		Line line = buildLine("14");
		System.out.println("Numéro de ligne : " + line.getName());
		String[] names = { "Saint-Lazare", "Madelaine", "Pyramides", "Chatelet", "Gare de Lyon", "Bercy",
				"Cour Saint-Émilion", "BFM", "Olympiades" };
		List<Station> stations = buildStation(line, names);
		int duration = 5;
		List<Journey> journeys = buildJourneys(duration, stations);

		// entrée de la station de départ et d'arrivée
		int dpt = 0;
		int arv = 5;

		computeTravelTime(journeys, dpt, arv);
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
		System.out.println("Stations de la ligne : " + stations);
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

	private static void computeTravelTime(List<Journey> journeys, int dpt, int arv) {


		Station depart = journeys.get(dpt).getDeparture();
		Station arrivee = journeys.get(arv).getArrival();
		int i = 0;
		int a = 0;
		int b = 0;
		boolean way = true;
		int last = 0;
		if (dpt == arv) {
			way = false;
		} else if (dpt < arv) {
			way = true;
		}

		if (!way) {
			System.out.println("Vous êtes sur place !!");
		} else if (way) {
			for (Journey journey : journeys) {

				if (journey.getDeparture().equals(depart)) {

					System.out.println("Départ : " + journey.getDeparture());
					a = i;
				}
				if (journey.getArrival().equals(arrivee)) {

					System.out.println("arrivée : " + journey.getArrival());
					b = i;
				}
				i++;
			}
		} else {
			for (Journey journey : journeys) {

				if (journey.getArrival().equals(arrivee)) {

					System.out.println("Arrivée : " + journey.getDeparture());
					a = i;
				} else if (journey.getDeparture().equals(depart)) {
					System.out.println("Départ : " + journey.getArrival());
					b = i;
				}
				i++;
			}

		}


		for (int j = 0; j < Math.abs((b - a)); j++) {

			last += journeys.get(j).getDuration();
		}
		System.out.println("Temps de trajet : " +  last + " minutes");

	}

}
