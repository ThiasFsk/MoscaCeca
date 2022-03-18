/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mc;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author lucio
 */
public class Finestra {

    private JFrame frame;
    private JPanel mainPanel;//popolo la finestra con un pannello
    private final Font mainFont = new Font("Sogoe print", Font.BOLD, 18);//creo font di default 

    public Finestra() {//inizializzo il frame poi ho aggiunto il pannello principale al frame,
        //iniziallizzo titolo progetto
        //setto dimesioni minime finestra

        frame = new JFrame();
        setupUI();
        frame.add(mainPanel);
        frame.setTitle("Progetto MC");
        frame.setMinimumSize(new Dimension(500, 650));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setupUI() { //setto il layout, faccio in modo che gli elementi all'interno del pannello abbiano un po di distanza tra loro
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel firstPlayer = new JLabel(); //metto tre JLabael che stanno ad indicare i giocatori presenti
        firstPlayer.setFont(mainFont);
        firstPlayer.setText("Primo giocatore");

        JLabel secondPlayer = new JLabel();
        secondPlayer.setFont(mainFont);
        secondPlayer.setText("Secondo giocatore");

        JLabel thirdPlayer = new JLabel();
        thirdPlayer.setFont(mainFont);
        thirdPlayer.setText("Terzo giocatore");

        JPanel classifica = new JPanel();//inserisco JPanel dentro un ulteriore JPanel ovvero classifica che presenta un layout di tipo gridere(griglia)
        // il tre sta ad indicare le righe per i giocatori
        //1 sta ad indicare le colonne ed i due 5 indicano il margine verticale e orrizzontale anche se l'orrizzontale servirà solo in caso di più colonne
        classifica.setLayout(new GridLayout(3, 1, 5, 5));
        classifica.add(firstPlayer);
        classifica.add(secondPlayer);
        classifica.add(thirdPlayer);

        JLabel turni = new JLabel();//JLabel per i turni 
        turni.setFont(mainFont);
        turni.setText("Numero di turni");

        JToolBar.Separator toolBar$Separator1 = new JToolBar.Separator();//aggiungo un separatore per fare in modo che la classifica e il numero di turni abbiano una sorta di separatore

        JPanel statisticsPanel = new JPanel();//aggiungo classifica e numero di turni nel pannello del mainpanel
        statisticsPanel.setLayout(new GridLayout(1, 3, 5, 5));
        statisticsPanel.add(classifica);
        statisticsPanel.add(toolBar$Separator1);
        statisticsPanel.add(turni);

        JPanel scacc = new JPanel() {
            public void paint(Graphics g) {
                g.setColor(Color.black);
                for(int i = 0;i<450;i+=20){
                    for(int j = 0; j<450;j+=20){
                        int n =(int)(Math.random()*3);
                        switch (n){
                            case 0:
                                 g.drawRect(i, j, 20, 20);
                                break;
                            case 1:
                                g.drawImage(new ImageIcon("C:\\Users\\lucio\\Documents\\NetBeansProjects\\MC\\src\\main\\java\\com\\mycompany\\mc\\seta.jpg").getImage(), i, j, 20, 20, null);
                                break;
                                
                            case 2:
                                g.drawImage(new ImageIcon("C:\\Users\\lucio\\Documents\\NetBeansProjects\\MC\\src\\main\\java\\com\\mycompany\\mc\\energia.jpg").getImage(), i, j, 20, 20, null);
                                break;
                        } 
                    } 
                }
            }
        };
        JButton addAgente = new JButton();
        addAgente.setFont(mainFont);
        addAgente.setText("Aggiungi un nuovo agente");
        
        /**
         * * Pannello Principale
         */
        mainPanel.add(statisticsPanel, BorderLayout.PAGE_END);//aggiungo il pannello della classificaa quello principale
        mainPanel.add(scacc, BorderLayout.CENTER);
        mainPanel.add(addAgente, BorderLayout.PAGE_START );
    }
}
