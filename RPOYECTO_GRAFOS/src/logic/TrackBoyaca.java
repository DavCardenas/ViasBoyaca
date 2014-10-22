package logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JOptionPane;

public class TrackBoyaca {
	
	private ArrayList<City> cities;
	private ArrayList<Track> tracks;
	private int [][] valuesRoute;
	private City cityL;
	private Track trackL;
	private int lenghtShort;
	private List listCity;

	public TrackBoyaca() {
		cities = new ArrayList<City>();;
		tracks = new ArrayList<Track>();
		cityL = null;
		trackL = null;
		valuesRoute = null;
	}
	
	/**
	 * crea una nueva ciudad a partir de un nombres y una posicion
	 * @param pPosX
	 * @param pPosY
	 * @param pnombre
	 * @return retorna una ciudad
	 */
	public City addCityint(int pPosX, int pPosY, String pnombre, int id) {
			cityL = new City(pnombre, pPosX, pPosY, id);
		return cityL;
	}
	
	/**
	 * crea una nueva via a partir de 2 ciudades
	 * @param cInicial
	 * @param cFinal
	 * @return retorna una via
	 */
	public Track addTrack(City cInicial, City cFinal){
			trackL = new Track(cInicial, cFinal);
		return trackL;
	}
	
	/**
	 * Calcula el recorrido mas corto por distancia o longitud
	 * a partir de dos ciudades
	 */
	public void calculateRouteLength(int idInitial, int idEnd){
		valuesRoute = null;
		valuesRoute = new int[cities.size()][cities.size()];
		fillValuesRoute('l');
		searchRouteMin(idInitial);
		
		City aux = new City();
		aux.setId(idEnd);
		if(!listCity.contains(aux)) {
            System.out.println("Error, nodo no alcanzable");
            return;
        }
        aux = (City) listCity.get(listCity.indexOf(aux));
        int lenght = aux.getLenght();  
        // crea una pila para almacenar la ruta desde el nodo final al origen
        Stack<City> stack = new Stack<City>();
        while(aux != null) {
            stack.add(aux);
            aux = aux.getAfter();
        }
        String ruta = "";
        // recorre la pila para armar la ruta en el orden correcto
        while(!stack.isEmpty()) ruta+=(stack.pop().getId() + " ");
        System.out.println(lenght + ": " + ruta);
		
	}
	
	/**
	 * calcula la ruta mas corta a partir del nodo inicial hacia
	 * todos los demas
	 * @param idInitial
	 */
	public void searchRouteMin(int idInitial) {
		Queue<City> queue = new PriorityQueue<City>();
		City auxC = new City();
		auxC.setId(idInitial);
		
		listCity = new LinkedList<City>();
		queue.add(auxC);
		
		while (!queue.isEmpty()) {
			City temp = queue.poll();
			listCity.add(temp);
			
			int pos = searchPosition(temp.getId());
			
			for (int i = 0; i < valuesRoute[pos].length; i++) {
				if(valuesRoute[pos][i]==0) continue;
				if(isTerminated(i)) continue;
				City auxCity = new City();
				auxCity.setId(cities.get(i).getId());
				auxCity.setLenght(temp.getLenght()+valuesRoute[pos][i]);
				auxCity.setAfter(temp);
				
				if (!queue.contains(auxCity)) {
					queue.add(auxCity);
					continue;
				}
				
				for (City city : queue) {
					if (city.getId()==auxCity.getId() && city.getLenght() > auxCity.getLenght()) {
						queue.remove(city);
						queue.add(auxCity);
						break;
					}
				}
			}
			
		}
	}
	
	public boolean isTerminated(int i) {
		City temp = new City();
		temp.setId(cities.get(i).getId());
		return listCity.contains(temp);
	}
	
	/**
	 * llena la matriz con longitudes o tiempos
	 * dependiendo del caracter que le ingresan pos parametro
	 */
	public void fillValuesRoute(char route) {
		int initial = 0;
		int end = 0;
		if (route == 'l') {
			if (valuesRoute != null && !tracks.isEmpty()) {
				for (Track track : tracks) {
					initial = searchPosition(track.getCityInitial().getId());
					end = searchPosition(track.getCityEnd().getId());
					valuesRoute[initial][end] = track.getLength();
					valuesRoute[end][initial] = track.getLength();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Algo anda mal");
			}
		}
		if (route == 't') {
			if (valuesRoute != null && !tracks.isEmpty()) {
				for (Track track : tracks) {
					initial = searchPosition(track.getCityInitial().getId());
					end = searchPosition(track.getCityEnd().getId());
					valuesRoute[initial][end] = track.getTime();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Algo anda mal");
			}
		}
	}
	
	/**
	 * busca la posicion de una ciudad en un arraylist de ciudades
	 */
	public int searchPosition(int id) {
		for (City city : cities) {
			if (city.getId() == id) {
				return city.getId();
			}
		}
		return -1;
	}
	
	/**
	 * calcula el recorrido mas corto por tiempo
	 */
	public void calculateRouteTime(int idInitial, int idEnd){
		valuesRoute = null;
		valuesRoute = new int[cities.size()][cities.size()];
		fillValuesRoute('t');
		searchRouteMin(idInitial);
		
		City aux = new City();
		aux.setId(idEnd);
		if(!listCity.contains(aux)) {
            System.out.println("Error, nodo no alcanzable");
            return;
        }
        aux = (City) listCity.get(listCity.indexOf(aux));
        int lenght = aux.getLenght();  
        // crea una pila para almacenar la ruta desde el nodo final al origen
        Stack<City> stack = new Stack<City>();
        while(aux != null) {
            stack.add(aux);
            aux = aux.getAfter();
        }
        String ruta = "";
        // recorre la pila para armar la ruta en el orden correcto
        while(!stack.isEmpty()) ruta+=(stack.pop().getId() + " ");
        System.out.println(lenght + ": " + ruta);
	}
	
	public ArrayList<City> getCities() {
		return cities;
	}
	public void setCities(ArrayList<City> pCity) {
		this.cities = pCity;
	}
	public ArrayList<Track> getTrack() {
		return tracks;
	}
	public void setTrack(ArrayList<Track> pTrack) {
		this.tracks = pTrack;
	}
	
	
}
