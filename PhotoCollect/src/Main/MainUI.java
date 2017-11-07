package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import Collection.Collection;
import Collection.CollectionUI;
import Item.Item;
import Item.ItemUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
        
/**
 *
 * @author Adlan Ramly
 */
public class MainUI extends JFrame 
{
    
    private ArrayList<Collection> collections;
    private Collection currentCollection;
    
    MainUI (ArrayList<Collection> collections) 
    {
        this.collections = collections;
        JLabel welcomeText = new JLabel("Welcome to Photo Collect!", SwingConstants.CENTER);
        
        JPanel collectionList = new JPanel();
        
        GridLayout collectionsGrid = new GridLayout(2,5);
        collectionList.setLayout(collectionsGrid);
        
        for (int i = 0; i < collections.size(); i++) 
        {
            collectionList.add(new JButton(collections.get(i).getTitle()));
        }
        
        JLabel spacer = new JLabel();
        
        GridLayout grid = new GridLayout(4,1);
        setLayout(grid);
        
        getContentPane().add(welcomeText);
        getContentPane().add(spacer);
        getContentPane().add(spacer);
        getContentPane().add(collectionList);
        
        
        
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class CollectionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton)e.getSource();
            Collection collectionToDisplay = new Collection("");
            boolean collectionFound = false;
            
            //Find the collection that matches the button pressed
            for(int i = 0; i < collections.size() && collectionFound == false; i++)
            {
                if (source.getText() == collections.get(i).getTitle())
                {
                    collectionToDisplay = collections.get(i);
                    collectionFound = true;
                }
            }
            if (collectionFound)
            {
                collectionDisplay = new CollectionUI(collectionToDisplay, false);
            }
        }
        }
        
    }
    
    /**
     * Updates the collection of images being displayed
     * @param collection
     */
    public void updateCollection(Collection collection)
    {
        getContentPane().add(new CollectionUI(collection));
    }
    
    /**
     * Updates the items being displayed (for instance if an item was added, 
     * updated, or deleted)
     */
    public void updateItems()
    {
        getContentPane().add(new CollectionUI(currentCollection));
    }
    
    public void setCurrentCollection(Collection collection)
    {
        this.currentCollection = collection;
    }
}
