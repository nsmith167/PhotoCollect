/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
        
/**
 *
 * @author Adlan Ramly
 */
public class MainUI extends JFrame {
    MainUI () {
        ButtonsRowUI br = new ButtonsRowUI();
        JTextField searchBar = new JTextField();
        ItemListUI il = new ItemListUI();
        JLabel spacer = new JLabel();
        
        GridLayout grid = new GridLayout(5,1);
        setLayout(grid);
        
        getContentPane().add(br);
        getContentPane().add(spacer);
        getContentPane().add(searchBar);
        getContentPane().add(spacer);
        getContentPane().add(il);
        
        
        
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

 

        
        
    
    