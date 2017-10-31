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
    MainUI (ArrayList<Collection> collections) {
        ButtonsRowUI br = new ButtonsRowUI();
        JTextField searchBar = new JTextField();
        
        JPanel il = new JPanel();
        JButton buttons[];
        int itemSize = 10;
        buttons = new JButton[itemSize];
        
        GridLayout grid = new GridLayout(2,5);
        setLayout(grid);
        
        for (int i = 0; i < itemSize; i++) {
            buttons[i] = new JButton(Integer.toString(i + 1));
            buttons[i].setSize(10,10);
            add(buttons[i]);
        }
        
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

 

        
        
    
    