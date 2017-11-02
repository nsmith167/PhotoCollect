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
import Collection.Collection;
        
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
}

 

        
        
    
    