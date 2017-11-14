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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Item.Item;
import Item.ItemUI;
import java.awt.Dimension;
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
    
    private JTextField searchBar;
    
    public CollectionUI(Collection collection)
    {   
        //Get data for collection
        this.collection = collection;
        
        //Panel to store buttons for collection functions
        ButtonsRowUI btnRowUI = new ButtonsRowUI(this);
        
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
        
        /**
         * Add a button to the UI for each item in the collection
         * Add an ActionListener to each item
         * Add the item to the panel
         */
        for (int i = 0; i < collection.getTotalItems(); i++) 
        {
            itemButtons.add(new JButton(collection.getItems().get(i).getItemName(), collection.getItems().get(i).getImage()));
            itemButtons.get(i).addActionListener(new ItemListener());
            itemList.add(itemButtons.get(i));
        }
        
        GridLayout grid = new GridLayout(6, 1);
        setLayout(grid);

        add(btnRowUI);
        add(searchPanel);
        add(new JLabel(collection.getTitle(), SwingConstants.CENTER));
        add(itemList);
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
                if (source.getText() == collection.getItems().get(i).getItemName())
                {
                    itemToDisplay = collection.getItems().get(i);
                    itemFound = true;
                }
            }
            if (itemFound)
            {
                itemDisplay = new ItemUI(itemToDisplay, collection);
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
