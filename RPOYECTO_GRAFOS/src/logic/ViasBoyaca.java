package logic;

import java.util.ArrayList;

public class ViasBoyaca {
	
	private ArrayList<Ciudad> ciudades;
	private ArrayList<Via> vias;
	private boolean [][] valoresRecorridos;
	private Ciudad ciudadL;
	private Via viaL;

	public ViasBoyaca() {
		ciudades = new ArrayList<Ciudad>();;
		vias = new ArrayList<Via>();
		ciudadL = null;
		viaL = null;
		valoresRecorridos = null;
	}
	public Ciudad agregarCiudad(int pPosX, int pPosY, String pnombre) {
		if (!(ciudades.isEmpty())) {
			ciudadL = new Ciudad(pnombre, pPosX, pPosY);
		}
		return ciudadL;
	}
	public Via agregarVia(Ciudad cInicial, Ciudad cFinal){
		if (!(vias.isEmpty())) {
			viaL = new Via(cInicial, cInicial);
		}
		return viaL;
	}
	public void calcularRecorridoDistancia(){
	}
	public void calcularRecorridoEstado(){
	}
	public void calcularRecorridoTiempo(){
	}
	public ArrayList<Ciudad> getCiudades() {
		return ciudades;
	}
	public void setCiudades(ArrayList<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	public ArrayList<Via> getVias() {
		return vias;
	}
	public void setVias(ArrayList<Via> vias) {
		this.vias = vias;
	}
	
	
}
