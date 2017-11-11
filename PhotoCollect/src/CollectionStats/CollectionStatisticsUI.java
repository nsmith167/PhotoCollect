/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionStats;

import Collection.Collection;
import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class CollectionStatisticsUI extends JFrame {

    private JLabel ItemNameLanel, DateLabel, ValueLabel, DescriptionLabel;
    private JTextField ItemNameTF, DateTF, ValueTF, DescriptionTF;
    private Collection collection;

    public CollectionStatisticsUI(Collection collection) {
        
        this.collection = collection; //To get data about the collection
        
        this.setSize(600, 400);
        this.setTitle("Collection Statistics");
        this.setLocationRelativeTo(null);
        
        setLayout(null);
        JLabel TotalItemsLabel = new JLabel("Total Items: ");
        JLabel TotalItemsLabel2 = new JLabel("" + collection.getTotalItems());
        JLabel TotalValueLabel = new JLabel("Total Value: ");
        JLabel TotalValueLabel2 = new JLabel("" + collection.getTotalValue());
        JLabel AvgRatingLabel = new JLabel("Average Rating: ");
        JLabel AvgRatingLabel2 = new JLabel("" + collection.getAverageRating());
        JLabel CollStartDateLabel = new JLabel("Value");
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        JLabel CollStartDateLabel2 = new JLabel("" + sdf.format(collection.getStartDate()));
        JLabel LatestItemLabel = new JLabel("Latest Item: ");
        JLabel LatestItemLabel2 = new JLabel("" + collection.getLatestItem());
          
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
    }
}
