/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author ajr5723
 */
public class ItemUI extends JFrame{
    public ItemUI(){
        this.setSize(800,600);
        this.setTitle("Edit Item");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(1,2));
        
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(3,1));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(10,1));

    }
}
