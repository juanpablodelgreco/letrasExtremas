package letrasExtremas;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		int numeroPath = 1;
		String inputPath = "lote_de_pruebas/Inputs/Caso"+numeroPath+".in", outputPath = "lote_de_pruebas/Outputs/"+numeroPath+".out";
		Letra palabras = new Letra();
		LeerEscribir.Leer(inputPath, palabras);
		HashMap<String, Integer> letrasExtremasTotales = new HashMap<String, Integer>();
		int []vcMax = new int[2];
		obtenerLetrasExtremas(palabras, letrasExtremasTotales);
		vcMax = valorMaximoCantmax(letrasExtremasTotales);
		String[] arrayLetrasExtremasMaximas = new String[vcMax[1]];
		letrasExtremas(letrasExtremasTotales, arrayLetrasExtremasMaximas, vcMax[0]);
		ordenarArray(palabras.palabras);
		LeerEscribir.Escribir(outputPath, arrayLetrasExtremasMaximas, palabras.palabras);

	}

	private static void ordenarArray(String[] palabras) {
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

	private static void obtenerLetrasExtremas(Letra palabras, HashMap<String, Integer> letras) {
		int longitud;
		String l, li, lf;
		for (int i = 0; i < palabras.cantPalabras; i++) {
			l = palabras.palabras[i];
			longitud = l.length();
			li = String.valueOf(l.charAt(0));
			lf = String.valueOf(l.charAt(longitud - 1));
			if (!letras.containsKey(li)) {
				letras.put(li, 1);
			} else {
				letras.put(li, (letras.get(li) + 1));
			}

			if (!letras.containsKey(lf)) {
				letras.put(lf, 1);
			} else {
				letras.put(lf, (letras.get(lf) + 1));
			}
			
		}
	}

	private static void letrasExtremas(HashMap<String, Integer> letras, String[] array, int valorMaximo) {
		int i = 0;
		for (Entry<String, Integer> entry : letras.entrySet()) {
			if (entry.getValue() == valorMaximo) {
				array[i] = entry.getKey();
				i++;
			}
		}

	}

	private static int[] valorMaximoCantmax(HashMap<String, Integer> letras) {
		int valorMax = 0,
			cantMaxs = 0;
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
		vcMax[1]=cantMaxs;
		return vcMax;
	}
	

	
}
