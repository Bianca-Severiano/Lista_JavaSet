package bilbioteca.fila.dinamica.set.generica.model;

public class NoListaSet <T> {

	T dado;
	NoListaSet proximo;
	
	@Override
	public String toString() {
		return "NoLista [dado=" + dado + ", proximo=" + proximo + "]";
	}
	

}
