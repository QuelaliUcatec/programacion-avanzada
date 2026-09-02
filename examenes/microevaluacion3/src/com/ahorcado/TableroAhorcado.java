package com.ahorcado;

public class TableroAhorcado {

    private String palabraSecreta;
    private boolean[] descubiertas;
    private int errores;
    private final int maxErrores = 6;

    public TableroAhorcado(String palabra) {
        palabraSecreta = palabra.toUpperCase();
        descubiertas = new boolean[palabraSecreta.length()];
    }

    public boolean adivinarLetra(char letra) {

        letra = Character.toUpperCase(letra);
        boolean acierto = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {

            if (palabraSecreta.charAt(i) == letra) {
                descubiertas[i] = true;
                acierto = true;
            }
        }

        if (!acierto) {
            errores++;
        }

        return acierto;
    }

    public boolean arriesgarPalabra(String palabra) {

        if (palabraSecreta.equalsIgnoreCase(palabra)) {

            for (int i = 0; i < descubiertas.length; i++) {
                descubiertas[i] = true;
            }

            return true;
        }

        errores++;
        return false;
    }

    public String mostrarEstado() {

        StringBuilder estado = new StringBuilder();

        for (int i = 0; i < palabraSecreta.length(); i++) {

            if (descubiertas[i]) {
                estado.append(palabraSecreta.charAt(i));
            } else {
                estado.append("_");
            }

            estado.append(" ");
        }

        return estado.toString();
    }

    public boolean estaCompleto() {

        for (boolean letra : descubiertas) {

            if (!letra) {
                return false;
            }
        }

        return true;
    }

    public boolean estaPerdido() {
        return errores >= maxErrores;
    }

    public int getErrores() {
        return errores;
    }

    public int getMaxErrores() {
        return maxErrores;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}