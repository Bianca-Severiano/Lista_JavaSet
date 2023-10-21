package view;

import bilbioteca.fila.dinamica.set.generica.model.ListaJavaSet;

public class Principal {

	public static void main(String[] args) throws Exception {
		ListaJavaSet<Integer> l = new ListaJavaSet<Integer>();
		
		l.addFirst(1);
		l.addFirst(2);
		l.addLast(3);
		l.addLast(6);
		l.addFirst(1);
		l.addNo(2, 0);
		l.addNo(3, 3);

	int tamanho = l.size();
	for (int i = 0; i<tamanho; i++) {
			int a = l.get(i);
			System.out.print(a + " ");
	}

	}

}
