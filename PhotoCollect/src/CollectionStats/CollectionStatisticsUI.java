/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionStats;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Random;

public class CollectionStatisticsUI extends JPanel implements ActionListener {

    JLabel ItemNameLanel, DateLabel, ValueLabel, DescriptionLabel;
    JTextField ItemNameTF, DateTF, ValueTF, DescriptionTF;
    JButton PicButton, backButton;


    public CollectionStatisticsUI() {
        super();

        setLayout(null);
        JLabel TotalItemsLabel = new JLabel("Total Items: ");
        JLabel TotalItemsLabel2 = new JLabel("N/A");
        JLabel TotalValueLabel = new JLabel("Total Value: ");
        JLabel TotalValueLabel2 = new JLabel("N/A");
        JLabel AvgRatingLabel = new JLabel("Average Rating: ");
        JLabel AvgRatingLabel2 = new JLabel("N/A");
        JLabel CollStartDateLabel = new JLabel("Value");
        JLabel CollStartDateLabel2 = new JLabel("N/A");
        JLabel LatestItemLabel = new JLabel("Latest Item: ");
        JLabel LatestItemLabel2 = new JLabel("N/A");
        JButton BackButton = new JButton("Back");
          
        add(TotalItemsLabel);
        add(TotalItemsLabel2);
        add(TotalValueLabel);
        add(TotalValueLabel2);
        add(AvgRatingLabel);
        add(AvgRatingLabel2);
        add(CollStartDateLabel);
        add(CollStartDateLabel2);
        add(LatestItemLabel);
        add(LatestItemLabel2);       
        add(BackButton);
        
        TotalItemsLabel.setBounds(new Rectangle(50, 0, 100, 50));
        TotalValueLabel.setBounds(new Rectangle(50, 75, 100, 50));
        AvgRatingLabel.setBounds(new Rectangle(50, 150, 100, 50));
        CollStartDateLabel.setBounds(new Rectangle(50, 225, 100, 50));
        LatestItemLabel.setBounds(new Rectangle(50, 300, 100, 50));
        
        TotalItemsLabel2.setBounds(new Rectangle(300, 0, 100, 50));
        TotalValueLabel2.setBounds(new Rectangle(300, 75, 100, 50));
        AvgRatingLabel2.setBounds(new Rectangle(300, 150, 100, 50));
        CollStartDateLabel2.setBounds(new Rectangle(300, 225, 100, 50));
        LatestItemLabel2.setBounds(new Rectangle(300, 300, 100, 50));
        
        BackButton.setBounds(new Rectangle(25, 390, 525, 50));
    }
    
    public void actionPerformed(ActionEvent event)
    {
        //Return to main menu - Redraw Panels
    }

    
}
