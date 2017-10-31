/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.*;
        
/**
 *
 * @author Adlan Ramly
 */
public class MainUI extends JFrame {
    
    private ArrayList<Collection> collections;
    
    MainUI (ArrayList<Collection> collections) {
        this.collections = collections;
        JLabel welcomeText = new JLabel("Welcome to Photo Collect!", SwingConstants.CENTER);
        
        JPanel collectionList = new JPanel();
        
        GridLayout collectionsGrid = new GridLayout(2,5);
        collectionList.setLayout(collectionsGrid);
        
        for (int i = 0; i < collections.size(); i++) {
            collectionList.add(new JButton(collections.get(i).getTitle()));
        }
        
        JLabel spacer = new JLabel();
        
        GridLayout grid = new GridLayout(4,1);
        setLayout(grid);
        
        getContentPane().add(welcomeText);
        getContentPane().add(spacer);
        getContentPane().add(spacer);
        getContentPane().add(collectionList);
        
        
        
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class CollectionUI extends JPanel
    {
        public CollectionUI(Collection collection)
        {
            JPanel ButtonRowsUI = new JPanel();
            JButton removeButton, 
                addButton, 
                editButton, 
                sortButton, 
                statButton;

            removeButton = new JButton("Remove Item");
            addButton = new JButton("Add Item");
            editButton = new JButton("Edit Item");
            sortButton = new JButton("Sort Button");
            statButton = new JButton ("VIew Statistics");

            ButtonRowsUI.add(removeButton);
            ButtonRowsUI.add(addButton);
            ButtonRowsUI.add(editButton);
            ButtonRowsUI.add(sortButton);
            ButtonRowsUI.add(statButton);
            
            JTextField searchBar = new JTextField();

            JLabel spacer = new JLabel();
            
            JPanel itemList = new JPanel();
            
            GridLayout itemGrid = new GridLayout(2,5);
            itemList.setLayout(itemGrid);
        
            for (int i = 0; i < collection.getTotalItems(); i++) 
            {
                itemList.add(new JButton(collection.getItems().get(i).getItemName()));
            }
            
            GridLayout grid = new GridLayout(4,1);
            setLayout(grid);
            
            add(ButtonRowsUI);
            add(spacer);
            add(spacer);
            add(itemList);
        }
    }
}

 

        
        
    
    