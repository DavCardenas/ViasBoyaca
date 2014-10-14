package logic;

import java.util.ArrayList;

public class ViasBoyaca {
	
	private ArrayList<Ciudad> ciudades;
	private ArrayList<Via> vias;
	private boolean [][] valoresRecorridos;
	private Ciudad ciudadL;
	private Via viaL;

	public ViasBoyaca() {
		ciudades = null;
		vias = null;
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
	public void borrarCiudad(int index){
	}
	public void boorrarVia(Ciudad cInicial, Ciudad cFinal){
	}
	public void calcularRecorridoDistancia(){
	}
	public void calcularRecorridoEstado(){
	}
	public void calcularRecorridoTiempo(){
	}
}
