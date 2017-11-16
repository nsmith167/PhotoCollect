/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import Main.ButtonsRowUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Item.Item;
import Item.ItemUI;
import Main.MainUI;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.SwingConstants;

/**
 * The class creates the user interface for a Collection. Included are the following functions:
 * Add item
 * Remove item
 * Edit item
 * View item details
 * View collection statistics
 * Search collection
 * Sort collection
 * 
 * @author nps5120
 */
public class CollectionUI extends JPanel
{
    private Collection collection;
    private ItemUI itemDisplay;
    
    private MainUI mainUI;
    
    private JTextField searchBar;
    private JScrollPane scrollPanel;
    public CollectionUI(Collection collection, MainUI mainUI)
    {   
        this.mainUI = mainUI;
        
        //Get data for collection
        this.collection = collection;
        
        //Panel to store buttons for collection functions
        ButtonsRowUI btnRowUI = new ButtonsRowUI(this, mainUI);
        
        //Creates search bar for searching collection contents
        JPanel searchPanel = new JPanel();
        searchBar = new JTextField("Search");
        searchBar.setPreferredSize(new Dimension(250, 25));
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchListener());
        searchPanel.add(searchBar);
        searchPanel.add(searchButton);
        
        //List for storing the collection contents
        JPanel itemList = new JPanel();
        GridLayout itemGrid = new GridLayout();
        itemList.setLayout(itemGrid);
        
        //Each item will be represented as a button
        ArrayList<JButton> itemButtons = new ArrayList<>();
        ArrayList<JPanel> itemPanels = new ArrayList<>();
        /**
         * Add a button to the UI for each item in the collection
         * Add an ActionListener to each item
         * Add the item to the panel
         */
        for (int i = 0; i < collection.getTotalItems(); i++) 
        {
            ImageIcon curImage = collection.getItems().get(i).getImage();
            Image im = curImage.getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(im);
            String name = collection.getItems().get(i).getItemName();
            itemButtons.add(new JButton(name, img));
            itemButtons.get(i).addActionListener(new ItemListener());
            itemList.add(itemButtons.get(i));
        }
        
        GridLayout grid = new GridLayout(2, 1);
        setLayout(grid);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3,1));
        
        
        topPanel.add(btnRowUI);
        topPanel.add(searchPanel);
        topPanel.add(new JLabel(collection.getTitle(), SwingConstants.CENTER));
        scrollPanel = new JScrollPane(itemList,
                                        JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(600,400));
        add(topPanel);
        add(scrollPanel);
    }
        //Listener for each item button in the collection UI
    private class ItemListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JButton source = (JButton)e.getSource();
            Item itemToDisplay = new Item("");
            boolean itemFound = false;
            
            //Find the item that matches the button pressed
            for(int i = 0; i < collection.getItems().size() && itemFound == false; i++)
            {
                if (source.getText().equals(collection.getItems().get(i).getItemName()))
                {
                    itemToDisplay = collection.getItems().get(i);
                    itemFound = true;
                }
            }
            if (itemFound)
            {
                itemDisplay = new ItemUI(itemToDisplay, collection, mainUI);
                itemDisplay.setVisible(true);
            }
        }
        
    }
    
    //Listener for the search button
    public class SearchListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            collection.search(searchBar.getText());
        }    
    }
    
    public Collection getCollection()
    {
        return this.collection;
    }
}
