package logic;

import java.util.ArrayList;

public class TrackBoyaca {
	
	private ArrayList<City> cities;
	private ArrayList<Track> tracks;
	private boolean [][] valuesRoute;
	private City cityL;
	private Track trackL;

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
	public City addCityint(int pPosX, int pPosY, String pnombre) {
		if (!(cities.isEmpty())) {
			cityL = new City(pnombre, pPosX, pPosY);
		}
		return cityL;
	}
	
	/**
	 * crea una nueva via a partir de 2 ciudades
	 * @param cInicial
	 * @param cFinal
	 * @return retorna una via
	 */
	public Track agregarVia(City cInicial, City cFinal){
		if (!(tracks.isEmpty())) {
			trackL = new Track(cInicial, cInicial);
		}
		return trackL;
	}
	
	/**
	 * Calcula el recorrido mas corto por distancia o longitud
	 */
	public void calculateRouteLength(){
	}
	
	/**
	 * calcula el recorrido mas corto por tiempo
	 */
	public void calculateRouteTime(){
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
