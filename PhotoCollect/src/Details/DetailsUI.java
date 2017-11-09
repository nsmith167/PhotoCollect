/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Random;

public class DetailsUI extends JPanel implements ActionListener {

    JLabel ItemNameLanel, DateLabel, ValueLabel, DescriptionLabel;
    JTextField ItemNameTF, DateTF, ValueTF, DescriptionTF;
    JButton PicButton, backButton;


    public DetailsUI() {
        super();
        
        setLayout(null);
        JLabel ItemNameLabel = new JLabel("Item Name");
        JTextField ItemNameTF = new JTextField("Item Name - Not Editable");
        JLabel DateLabel = new JLabel("Date");
        JTextField DateTF = new JTextField("Date - Not Editable");
        JLabel ValueLabel = new JLabel("Value");
        JTextField ValueTF = new JTextField("Value - Not Editable");
        JLabel DescriptionLabel = new JLabel("Description");
        JTextField DescriptionTF = new JTextField("Description - Not Editable");
        JButton PicButton = new JButton();
        JButton BackButton = new JButton("Back");
        
        BackButton.addActionListener(this);
          
        add(ItemNameLabel);
        add(ItemNameTF);
        add(DateLabel);
        add(DateTF);
        add(ValueLabel);
        add(ValueTF);
        add(DescriptionLabel);
        add(DescriptionTF);
        add(PicButton);
        add(BackButton);
        
        ItemNameLabel.setBounds(new Rectangle(300, 0, 100, 50));
        ItemNameTF.setBounds(new Rectangle(300, 50, 250, 40));
        DateLabel.setBounds(new Rectangle(300, 75, 100, 50));
        DateTF.setBounds(new Rectangle(300, 125, 250, 40));
        ValueLabel.setBounds(new Rectangle(300, 150, 100, 50));
        ValueTF.setBounds(new Rectangle(300, 200, 250, 40));
        DescriptionLabel.setBounds(new Rectangle(300, 225, 100, 50));
        DescriptionTF.setBounds(new Rectangle(300, 275, 250, 100));
        PicButton.setBounds(new Rectangle(25, 25, 250, 300));
        BackButton.setBounds(new Rectangle(25, 390, 525, 50));
    }
    
    public void actionPerformed(ActionEvent event)
    {
        //Return to main menu - Redraw Panels
    }

    
}
