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
    private JLabel welcomeText;
    private JLabel spacer;
    private JMenuBar menuBar;
    private JPanel collectionList;
    
    MainUI (ArrayList<Collection> collections) 
    {
        this.collections = collections;
        welcomeText = new JLabel("Welcome to Photo Collect!", SwingConstants.CENTER);
        
        //Create menu bar
        menuBar = new JMenuBar();
        
        //Create menu on bar
        JMenu optionsMenu = new JMenu("Options");
        
        //Create items to appear on menu
        JMenuItem saveItem = new JMenuItem("Save Collection");
        JMenuItem newItem = new JMenuItem("New Collection");
        JMenuItem openItem = new JMenuItem("Open Collection");
        JMenuItem closeItem = new JMenuItem("Close Collection");
        JMenuItem importItem = new JMenuItem("Import Collection");
        JMenuItem exportItem = new JMenuItem("Export Collection");
        
        //Add items to menu
        optionsMenu.add(saveItem);
        optionsMenu.add(newItem);
        optionsMenu.add(openItem);
        optionsMenu.add(closeItem);
        optionsMenu.add(importItem);
        optionsMenu.add(exportItem);
        
        //Add menu to menu bar
        menuBar.add(optionsMenu);
        
        this.add(menuBar);
        
        ArrayList<JButton> collectionButtons = new ArrayList<>();
        collectionList = new JPanel();
        
        GridLayout collectionsGrid = new GridLayout(2,5);
        collectionList.setLayout(collectionsGrid);
        
        for (int i = 0; i < collections.size(); i++) 
        {
            collectionButtons.add(new JButton(collections.get(i).getTitle()));
            collectionButtons.get(i).addActionListener(new CollectionListener());
            collectionList.add(collectionButtons.get(i));
        }
        
        spacer = new JLabel();
        
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
                setCurrentCollection(collectionToDisplay);
                updateCollection(collectionToDisplay);
            }
        }
    }
    
    /**
     * Updates the collection of images being displayed
     * @param collection
     */
    public void updateCollection(Collection collection)
    {
        getContentPane().remove(spacer);
        getContentPane().remove(welcomeText);
        getContentPane().remove(collectionList);
        getContentPane().add(new CollectionUI(collection));
        revalidate();
        repaint();
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
