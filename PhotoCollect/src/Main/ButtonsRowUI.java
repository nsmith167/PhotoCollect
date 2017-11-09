package Main;


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
    
    JButton removeButton, 
            addButton, 
            editButton, 
            sortButton, 
            statButton;
    
    public ButtonsRowUI() {
    
    
        removeButton = new JButton("Remove Item");
        
        addButton = new JButton("Add Item");
        
        editButton = new JButton("Edit Item");
        
        sortButton = new JButton("Sort Button");
        
        statButton = new JButton ("VIew Statistics");
        
        add(removeButton);
        add(addButton);
        add(editButton);
        add(sortButton);
        add(statButton);
        
        removeButton.addActionListener(new FunctionsListener());
        addButton.addActionListener(new FunctionsListener());
        editButton.addActionListener(new FunctionsListener());
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
            
            if (source == removeButton)
            {
                //Remove selected item from collection
            }
            else if (source == addButton)
            {
                System.out.println("Add Button pressed");
                ItemUI aUI = new ItemUI(); 
                aUI.setVisible(true);
            }
            else if (source == editButton)
            {
                //Open dialog to edit item details
            }
            else if (source == sortButton)
            {
                //Sort collection by some criteria
            }
            else if (source == statButton)
            {
                //Display dialog with collection statistics
            }
        }
        
    }
}
