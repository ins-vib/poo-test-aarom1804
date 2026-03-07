package com.daw1a;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<Pregunta> preguntes = inicialitzarPreguntes();

        Test test = new Test(preguntes);

        boolean finalitzar = false;

        while (finalitzar == false) {

            System.out.println("Pregunta " + (test.getNumeroPregunta() + 1) + "." + test.getEnunciatPreguntaActual());

            String[] respostes = test.getRespostesPreguntaActual();
            for (int i = 0; i < respostes.length; i++) {
                System.out.print((i + 1) + "." + respostes[i] + " ");
            }
            System.out.println();

            System.out.print("Tria una opcio: \n1-Endarrera \n2-Respondre  \n3-Endavant  \n4-Finalitzar \nOpcio: ");
            System.out.println();

            if (entrada.hasNextInt()) {
                int opcio = entrada.nextInt();

                switch (opcio) {
                    case 1:
                        boolean haPogutRetrocedir = test.anarEndarrera();
                        if (haPogutRetrocedir == false) {
                            System.out.println("No pots anar mes endarrera.");
                        }
                        break;

                    case 2:
                        System.out.println("La teva resposta es:");
                        if (entrada.hasNextInt()) {
                            int resposta = entrada.nextInt();
                            if (resposta >= 1 && resposta <= respostes.length) {
                                test.respondre(resposta - 1);
                                boolean haAvançat = test.anarEndavant();
                                if (!haAvançat) {
                                    System.out.println("Has respost l'ultima pregunta.");
                                }
                            } else {
                                System.out.println("Opcio no valida.");
                            }
                        } else {
                            System.out.println("Has de posar un numero.");
                            entrada.next();
                        }
                        break;

                    case 3:
                        boolean haAvançat = test.anarEndavant();
                        if (haAvançat == false) {
                            System.out.println("Aquesta és l'última pregunta.");
                        }
                        break;

                    case 4:
                        finalitzar = true;
                        break;

                    default:
                        System.out.println("Opció no vàlida. Ha de ser 1, 2, 3 o 4.");
                }
            } else {
                System.out.println("Error: Has d'escriure un número enter.");
                entrada.next();
            }
        }

        double puntuacio = test.solucionarTest();
        System.out.println("Has aconseguit un " + puntuacio);

        entrada.close();
    }

    public static ArrayList<Pregunta> inicialitzarPreguntes() {
        ArrayList<Pregunta> preguntes = new ArrayList<>();

        preguntes.add(new Pregunta("¿Qui va pintar el Guernica?",
                new String[] { "Velàzquez", "Goya", "Picasso" }, 2));

        preguntes.add(new Pregunta("¿Qui va escriure Alicia al país de les meravelles?",
                new String[] { "Grimm", "Stevenson", "Carrol" }, 2));

        preguntes.add(new Pregunta("¿Quina és la magnitud que relaciona espai i temps?",
                new String[] { "velocitat", "temperatura", "pes" }, 0));

        preguntes.add(new Pregunta("¿Si el radi d'una circumferència és 4, el seu diàmetre és?",
                new String[] { "4", "8", "12", "14" }, 1));

        preguntes.add(new Pregunta("¿Quants segons té 1 hora?",
                new String[] { "420", "760", "3600" }, 2));

        preguntes.add(new Pregunta("¿Quin no és un llenguatge de programació?",
                new String[] { "java", "php", "samsung" }, 2));

        preguntes.add(new Pregunta("¿Dins un termòmetre hi trobem?",
                new String[] { "aigua", "aigua amb gas", "mercuri" }, 2));

        preguntes.add(new Pregunta("¿L'Acropolis es troba a?",
                new String[] { "Atenes", "Roma", "París" }, 0));

        preguntes.add(new Pregunta("¿L'element químic amb símbol Fe és?",
                new String[] { "Estronci", "Ferro", "Feril·li" }, 1));

        preguntes.add(new Pregunta("¿La capital d'Estats Units és?",
                new String[] { "Georgetown", "New York", "Washington" }, 2));

        return preguntes;
    }
}