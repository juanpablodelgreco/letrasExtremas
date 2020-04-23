package letrasExtremas;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;

public class LetraExtrema {
	private HashMap<String, Integer> letrasExtremasTotales = new HashMap<String, Integer>();
	private int[] vcMax = new int[2];
	private String path;

	public LetraExtrema(String path) {
		this.path = path;
	}

	public void obtenerLetraExtrema() throws FileNotFoundException {
		String inputPath = "lote_de_pruebas/Inputs/Caso" + path + ".in",
				outputPath = "lote_de_pruebas/Outputs/" + path + ".out";
		LeerEscribir l = new LeerEscribir(inputPath, outputPath);
		Letra palabras = new Letra();
		l.leer(palabras);
		obtenerLetrasExtremas(palabras);
		vcMax = valorMaximoCantmax(letrasExtremasTotales);
		String[] arrayLetrasExtremasMaximas = new String[vcMax[1]];
		letrasExtremas(arrayLetrasExtremasMaximas, vcMax[0]);
		ordenarArray(palabras.getPalabras());
		l.Escribir(arrayLetrasExtremasMaximas, palabras.getPalabras());

	}

	private void ordenarArray(String[] palabras) {
		int size = palabras.length;

		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (palabras[i].compareTo(palabras[j]) > 0) {
					String temp = palabras[i];
					palabras[i] = palabras[j];
					palabras[j] = temp;
				}
			}
		}
	}

	private void obtenerLetrasExtremas(Letra palabras) {
		int longitud;
		String l, li, lf;
		for (int i = 0; i < palabras.getCantPalabras(); i++) {
			l = palabras.getPalabras()[i];
			longitud = l.length();
			li = String.valueOf(l.charAt(0));
			lf = String.valueOf(l.charAt(longitud - 1));
			if (!letrasExtremasTotales.containsKey(li)) {
				letrasExtremasTotales.put(li, 1);
			} else {
				letrasExtremasTotales.put(li, (letrasExtremasTotales.get(li) + 1));
			}

			if (!letrasExtremasTotales.containsKey(lf)) {
				letrasExtremasTotales.put(lf, 1);
			} else {
				letrasExtremasTotales.put(lf, (letrasExtremasTotales.get(lf) + 1));
			}

		}
	}

	private void letrasExtremas(String[] array, int valorMaximo) {
		int i = 0;
		for (Entry<String, Integer> entry : letrasExtremasTotales.entrySet()) {
			if (entry.getValue() == valorMaximo) {
				array[i] = entry.getKey();
				i++;
			}
		}

	}

	private int[] valorMaximoCantmax(HashMap<String, Integer> letras) {
		int valorMax = 0, cantMaxs = 0;
		int vcMax[] = new int[2];
		for (Entry<String, Integer> entry : letras.entrySet()) {
			if (entry.getValue() > valorMax) {
				valorMax = entry.getValue();
				cantMaxs = 1;
			} else if (entry.getValue() == valorMax) {
				cantMaxs++;
			}
		}
		vcMax[0] = valorMax;
		vcMax[1] = cantMaxs;
		return vcMax;
	}

}
