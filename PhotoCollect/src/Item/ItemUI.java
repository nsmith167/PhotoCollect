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
    private JLabel itemName;
    private JTextField itemNameTextField;
    
    
    public ItemUI(){
        this.setSize(800,600);
        this.setTitle("Edit Item");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(2,1));
        
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(3,1));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(10,1));
        
        
        JPanel[] cellNumbers = new JPanel[8];
        for(int i = 0; i < 8; i++)
        {
            JPanel nextPanel = new JPanel();
            cellNumbers[i] = nextPanel;
            thePanel.add(nextPanel);
        }
        
        
    }
}
