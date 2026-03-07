package com.daw1a;

import java.util.ArrayList;

public class Test {
    
    private ArrayList<Pregunta> pregunta = new ArrayList<>();
    private int[] respostes;

    private int numPreguntaActual;

    public Test(ArrayList<Pregunta> preguntes) {
        this.pregunta = preguntes;
        this.respostes = new int[pregunta.size()];
        for(int i = 0; i < respostes.length; i++){
            respostes[i] = -1;
        }
        this.numPreguntaActual = 0;
    }

    public String getEnunciatPreguntaActual() {
        if (numPreguntaActual >= 0 && numPreguntaActual < pregunta.size()) {
            Pregunta p = pregunta.get(numPreguntaActual);
            return p.getEnunciat();
        }
        return "";
    }

    public String[] getRespostesPreguntaActual() {
        if (numPreguntaActual >= 0 && numPreguntaActual < pregunta.size()) {
            return pregunta.get(numPreguntaActual).getRespostes();
        }
        return new String[0];
    }

    public int getNumeroPregunta() {
        return numPreguntaActual;
    }

    public void respondre(int resposta) {
        if (numPreguntaActual >= 0 && numPreguntaActual < respostes.length) {
            respostes[numPreguntaActual] = resposta;
        }
    }

    public boolean anarEndavant() {
        if (numPreguntaActual < pregunta.size() - 1) {
            numPreguntaActual++;
            return true;
        }
        return false;
    }

    public boolean anarEndarrera() {
        if (numPreguntaActual > 0) {
            numPreguntaActual--;
            return true;
        }
        return false;
    }

    public double solucionarTest() {
        double puntuacio = 0;
        double puntsPerPregunta = 10.0 / pregunta.size();

        for (int i = 0; i < pregunta.size(); i++) {
            int respostaUsuari = respostes[i];

            Pregunta p = pregunta.get(i);
            int respostaCorrecta = p.getCorrecta();
            int numPossiblesRespostes = p.getRespostes().length;

            if (respostaUsuari == -1) {
            } else if (respostaUsuari == respostaCorrecta) {
                puntuacio = puntuacio + puntsPerPregunta;
            } else {
                double penalitzacio = puntsPerPregunta / numPossiblesRespostes;
                puntuacio = puntuacio - penalitzacio;
            }
        }
        return puntuacio;
    }

    

}
