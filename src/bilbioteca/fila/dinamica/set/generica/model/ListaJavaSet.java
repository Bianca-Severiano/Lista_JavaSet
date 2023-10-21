package bilbioteca.fila.dinamica.set.generica.model;

public class ListaJavaSet<T> {

	NoListaSet<T> primeiro;

	public ListaJavaSet() {
		primeiro = null;
	}

	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}

	}

	public boolean repet(T dado) {
		if (isEmpty()) {
			return false;
		} else {
			int tamanho = size();
			for (int i = 0; i < tamanho; i++) {
				T valor;
				try {
					valor = get(i);
					if (valor == dado) {
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;

	}

	public int size() {
		int cont = 0;

		if (!isEmpty()) {
			NoListaSet<T> aux = primeiro;

			while (aux != null) {
				cont++;
				aux = aux.proximo;
			}
		}
		return cont;
	}

	private NoListaSet<T> getNo(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		int tamanho = size();
		if (index < 0 || index > tamanho - 1) {
			throw new Exception("Index inválido");
		}

		int i = 0;
		NoListaSet<T> aux = primeiro;

		while (i < index) {
			aux = aux.proximo;
			i++;
		}

		return aux;
	}

	public void addFirst(T dado) {
		if (repet(dado)) {
			System.err.println("Valor repetido: " + dado);
		} else {
			NoListaSet<T> aux = new NoListaSet<>();
			aux.dado = dado;
			aux.proximo = primeiro;
			primeiro = aux;

		}
	}

	public void addLast(T dado) throws Exception {
		if (isEmpty()) {
			addFirst(dado);
			throw new Exception("Lista vazia, adicionando na primeira posição");
		}

		if (repet(dado)) {
			System.err.println("Valor repetido: " + dado);
		} else {
			int tamanho = size();
			NoListaSet<T> no = new NoListaSet<>();
			NoListaSet<T> ultimo = new NoListaSet<>();

			ultimo = getNo(tamanho - 1);
			no.dado = dado;
			no.proximo = null;
			ultimo.proximo = no;
		}
	}

	public void addNo(T dado, int index) throws Exception {
		if (repet(dado)) {
			System.err.println("Valor repetido: " + dado);
		} else {
			int tamanho = size();
			if (index < 0 || index > tamanho) {
				throw new Exception("Index inválido");
			}

			if (index == 0) {
				addFirst(dado);
			} else if (index == tamanho) {
				addLast(dado);
			} else {
				NoListaSet<T> no = new NoListaSet<>();
				NoListaSet<T> ultimo = new NoListaSet<>();
				no.dado = dado;
				no.proximo = ultimo.proximo;
				ultimo.proximo = no;
			}

		}
	}

	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		primeiro = primeiro.proximo;
	}

	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else {

			NoListaSet<T> ultimo = new NoListaSet<>();
			ultimo = getNo(tamanho - 2);
			ultimo.proximo = null;
		}
	}

	public void remove(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		NoListaSet<T> anterior = new NoListaSet<>();
		NoListaSet<T> no = new NoListaSet<>();
		no = getNo(index);
		anterior = getNo(index - 1);
		anterior.proximo = no.proximo;
	}

	public T get(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		int tamanho = size();
		if (index < 0 || index > tamanho - 1) {
			throw new Exception("Index inválido");
		}

		NoListaSet<T> no = getNo(index);
		return no.dado;

	}
}
