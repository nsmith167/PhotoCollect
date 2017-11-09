package Main;


import Collection.Collection;
import Collection.CollectionUI;
import CollectionStats.CollectionStatisticsUI;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Item.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adlan Ramly
 */
public class ButtonsRowUI extends JPanel{
    
    private JButton addButton, 
            sortButton, 
            statButton;
    
    public ButtonsRowUI() {
        
        addButton = new JButton("Add Item");
        
        sortButton = new JButton("Sort Button");
        
        statButton = new JButton ("VIew Statistics");
        
        add(addButton);
        add(sortButton);
        add(statButton);
        
        addButton.addActionListener(new FunctionsListener());
        sortButton.addActionListener(new FunctionsListener());
        statButton.addActionListener(new FunctionsListener());
    }
    
    //Listner for the function buttons
    private class FunctionsListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JButton source = (JButton)e.getSource();
            
            if (source == addButton)
            {
                System.out.println("Add Button pressed");
                ItemUI aUI = new ItemUI(); 
                aUI.setVisible(true);
            }
            else if (source == sortButton)
            {
                //Sort collection by some criteria
            }
            else if (source == statButton)
            {
                CollectionStatisticsUI statsUI = new CollectionStatisticsUI();
                statsUI.setVisible(true);
            }
        }
        
    }
}
