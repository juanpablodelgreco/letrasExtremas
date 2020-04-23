package letrasExtremas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LeerEscribir {
	private String inputPath;
	private String outputPath;

	public LeerEscribir(String inputPath, String outputPath) {
		this.inputPath = inputPath;
		this.outputPath = outputPath;
	}

	public void leer(Letra palabras) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(inputPath));
		palabras.setCantPalabras(sc.nextInt());
		palabras.setPalabras(new String[palabras.getCantPalabras()]);
		for (int i = 0; i < palabras.getCantPalabras(); i++) {
			palabras.getPalabras()[i] = sc.next();
		}
		sc.close();
	}

	public void Escribir(String[] vecLetras, String[] vecPalabras) throws FileNotFoundException {
		int i, j, k;
		PrintWriter pw = new PrintWriter(new File(outputPath));
		for (k = 0; k < vecLetras.length; k++) {
			pw.println(vecLetras[k]);
		}
		int esta = 0;
		for (i = 0; i < vecPalabras.length; i++) {
			j = 0;
			esta = 0;
			while (esta == 0 && j < vecLetras.length) {
				if (tieneLetra(vecLetras[j], vecPalabras[i])) {
					esta = 1;
				} else {
					j++;
				}
			}
			if (esta == 1 && i == 0)
				pw.println(vecPalabras[i]);
			if (i > 0 && esta == 1 && vecPalabras[i].compareTo(vecPalabras[i - 1]) != 0)
				pw.println(vecPalabras[i]);
		}
		pw.close();
		System.out.println(outputPath + " generado con exito!");
	}

	public boolean tieneLetra(String letra, String palabra) {
		if (letra.contentEquals(String.valueOf(palabra.charAt(0))))
			return true;
		if (letra.contentEquals(String.valueOf(palabra.charAt(palabra.length() - 1))))
			return true;
		return false;
	}

}
