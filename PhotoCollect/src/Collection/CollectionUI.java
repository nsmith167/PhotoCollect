/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

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
    
    private JButton removeButton, 
            addButton,
            editButton,
            sortButton,
            statButton;
    
    private JTextField searchBar;
    
    public CollectionUI(Collection collection)
    {   
        //Get data for collection
        this.collection = collection;
        
        //Panel to store buttons for collection functions
        JPanel ButtonRowsUI = new JPanel();
        
        //Creates buttons for collection functions
        removeButton = new JButton("Remove Item");
        addButton = new JButton("Add Item");
        editButton = new JButton("Edit Item");
        sortButton = new JButton("Sort Button");
        statButton = new JButton ("VIew Statistics");
        
        //Add listeners to buttons
        removeButton.addActionListener(new FunctionsListener());
        addButton.addActionListener(new FunctionsListener());
        editButton.addActionListener(new FunctionsListener());
        sortButton.addActionListener(new FunctionsListener());
        statButton.addActionListener(new FunctionsListener());
        
        //Add buttons to button panel
        ButtonRowsUI.add(removeButton);
        ButtonRowsUI.add(addButton);
        ButtonRowsUI.add(editButton);
        ButtonRowsUI.add(sortButton);
        ButtonRowsUI.add(statButton);
        
        //Creates search bar for searching collection contents
        JPanel searchPanel = new JPanel();
        searchBar = new JTextField("Search");
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchListener());
        GridLayout searchLayout = new GridLayout(1,2);
        searchPanel.setLayout(searchLayout);
        searchPanel.add(searchBar);
        searchPanel.add(searchButton);
        
        //Create space in layout
        JLabel spacer = new JLabel();
        
        //List for storing the collection contents
        JPanel itemList = new JPanel();
        
        //Each item will be represented as a button
        ArrayList<JButton> itemButtons = new ArrayList<>();

        GridLayout itemGrid = new GridLayout(2,5);
        itemList.setLayout(itemGrid);
        
        
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
        
        GridLayout grid = new GridLayout(4,1);
        setLayout(grid);

        add(ButtonRowsUI);
        add(spacer);
        add(spacer);
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
                itemDisplay = new ItemUI(itemToDisplay);
            }
        }
        
    }
    
    //Listner for the function buttons
    private class FunctionsListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JButton source = (JButton)e.getSource();
            
            if (source == removeButton)
            {
                //Remove selected item from collection
            }
            else if (source == addButton)
            {
                //Open dialog to add new item to collection
            }
            else if (source == editButton)
            {
                //Open dialog to edit item details
            }
            else if (source == sortButton)
            {
                //Sort collection by some criteria
            }
            else if (source == statButton)
            {
                //Display dialog with collection statistics
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
}