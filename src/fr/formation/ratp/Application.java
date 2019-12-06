package fr.formation.ratp;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		Line line = buildLine("14");
		System.out.println("Num�ro de ligne : " + line.getName());
		String[] names = { "Saint-Lazare", "Madelaine", "Pyramides", "Chatelet", "Gare de Lyon", "Bercy",
				"Cour Saint-�milion", "BFM", "Olympiades" };
		List<Station> stations = buildStation(line, names);
		int duration = 5;
		List<Journey> journeys = buildJourneys(duration, stations);

		// entr�e de la station de d�part et d'arriv�e
		int dpt = 0;
		int arv = 0;

		computeTravelTime(journeys, dpt, arv);

		// entr�e de la station de d�part et d'arriv�e
		dpt = 1;
		arv = 3;

		computeTravelTime(journeys, dpt, arv);

		// entr�e de la station de d�part et d'arriv�e
		dpt = 7;
		arv = 2;

		computeTravelTime(journeys, dpt, arv);
	}

	private static Line buildLine(String name) {

		return new Line(name);
	}

	// var args String... permet d'entrer directement la liste dans buildStation
	// private static List<Station> buildStation(Line line, String... names)

	private static List<Station> buildStation(Line line, String[] names) {

		List<Station> stations = new ArrayList<>();
		for (String name : names) {
			Station station = new Station(name, line);
			stations.add(station);
		}
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
			System.out.println("Vous �tes sur place !!");
		} else if (way) {
			for (Journey journey : journeys) {

				if (journey.getDeparture().equals(depart)) {

					System.out.println("D�part : " + journey.getDeparture());
					a = i;
				}
				if (journey.getArrival().equals(arrivee)) {

					System.out.println("arriv�e : " + journey.getArrival());
					b = i;
				}
				i++;
			}
		} else {
			for (Journey journey : journeys) {

				if (journey.getArrival().equals(arrivee)) {

					System.out.println("Arriv�e : " + journey.getDeparture());
					a = i;
				} else if (journey.getDeparture().equals(depart)) {
					System.out.println("D�part : " + journey.getArrival());
					b = i;
				}
				i++;
			}

		}

		for (int j = 0; j < Math.abs((b - a)); j++) {

			last += journeys.get(j).getDuration();
		}
		System.out.println("Vous allez parcourir " + Math.abs(b - a) + " station(s)");
		System.out.println("Temps de trajet : " + last + " minutes");

	}

}
