package logic;

public class Via {

	private int longitud;
	private boolean sentido;
	private int tiempo;
	private int [] velocidad;
	private Ciudad ciudadInicial;
	private Ciudad ciudadFinal;

	public Via() {
		longitud = 0;
		sentido = false;
		tiempo = 0;
		velocidad = new int [2];
		ciudadInicial = null;
		ciudadFinal = null;
	}
	public Via(Ciudad pCInicial, Ciudad pCFinal) {
		this.ciudadInicial = pCInicial;
		this.ciudadFinal = pCFinal;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public boolean isSentido() {
		return sentido;
	}
	public void setSentido(boolean sentido) {
		this.sentido = sentido;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public int[] getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int[] velocidad) {
		this.velocidad = velocidad;
	}
	public Ciudad getCiudadInicial() {
		return ciudadInicial;
	}
	public void setCiudadInicial(Ciudad ciudadInicial) {
		this.ciudadInicial = ciudadInicial;
	}
	public Ciudad getCiudadFinal() {
		return ciudadFinal;
	}
	public void setCiudadFinal(Ciudad ciudadFinal) {
		this.ciudadFinal = ciudadFinal;
	}
}
