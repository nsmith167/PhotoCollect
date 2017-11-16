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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Calendar;
        
/**
 *
 * @author Adlan Ramly
 */
public class MainUI extends JFrame 
{
    private ArrayList<Collection> collections;
    ArrayList<JButton> collectionButtons;
    private Collection currentCollection;
    private JLabel welcomeText;
    private JLabel loadText;
    private JLabel spacer;
    private JMenuBar menuBar;
    private JPanel collectionList;
    int latestID;
    
    MainUI (Controller controller) 
    {
        this.collections = controller.getCollections();
        this.latestID = controller.getLatestID();

        welcomeText = new JLabel("Welcome to Photo Collect!", SwingConstants.CENTER);
        loadText = new JLabel("Please select a collection to load:", SwingConstants.CENTER);
        
        //Create menu bar
        menuBar = new JMenuBar();
        
        //Create menu on bar
        JMenu optionsMenu = new JMenu("Options");
        
        //Create items to appear on menu
        JMenuItem saveCollectionButton = new JMenuItem("Save Collection");
        JMenuItem newCollectionButton = new JMenuItem("New Collection");
        JMenuItem openCollectionButton = new JMenuItem("Open Collection");
        JMenuItem closeCollectionButton = new JMenuItem("Close Collection");
        JMenuItem importCollectionButton = new JMenuItem("Import Collection");
        JMenuItem exportCollectionButton = new JMenuItem("Export Collection");
        
        //Add items to menu
        optionsMenu.add(saveCollectionButton);
        optionsMenu.add(newCollectionButton);
        optionsMenu.add(openCollectionButton);
        optionsMenu.add(closeCollectionButton);
        optionsMenu.add(importCollectionButton);
        optionsMenu.add(exportCollectionButton);
        
        //Buttons to represent collections saved
        collectionButtons = new ArrayList<>();
        collectionList = new JPanel();
        
        //Grid to display collection buttons
        GridLayout collectionsGrid = new GridLayout(2,5);
        collectionList.setLayout(collectionsGrid);
        
        //Create buttons and add to panel
        for (int i = 0; i < collections.size(); i++) 
        {
            collectionButtons.add(new JButton(collections.get(i).getTitle()));
            collectionButtons.get(i).addActionListener(new CollectionListener());
            collectionList.add(collectionButtons.get(i));
        }
        
        //Listener for save collection menu item
        saveCollectionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.saveCollection(currentCollection);
            } 
        });
        
        //Listener for new collection menu item
        newCollectionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame nameFrame = new JFrame();
                nameFrame.setSize(300, 100);
                nameFrame.setTitle("New Collection");
                nameFrame.setLocationRelativeTo(null);
                JPanel namePanel = new JPanel();
                JTextField nameField = new JTextField("Enter collection name");
                JButton saveButton = new JButton("Save");
                saveButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Collection newCollection = new Collection(nameField.getText());
                        newCollection.setCollectionID(latestID);
                        Calendar now = Calendar.getInstance();
                        newCollection.setStartDate(now.get((Calendar.MONTH) + 1) + "/" + now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.YEAR));
                        collections.add(newCollection);
                        setCurrentCollection(newCollection);
                        updateCollection(newCollection);
                        nameFrame.dispatchEvent(new WindowEvent(nameFrame, WindowEvent.WINDOW_CLOSING));
                    }
                });
                
                namePanel.add(nameField);
                namePanel.add(saveButton);
                nameFrame.add(namePanel);
                nameFrame.setVisible(true);
                
            }
        });
        
        //Listener for open collection menu item
        openCollectionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(menuBar, BorderLayout.NORTH);
                getContentPane().add(loadText, BorderLayout.CENTER);
                collectionList.removeAll();
                refreshHome();
                getContentPane().add(collectionList, BorderLayout.SOUTH);
                currentCollection = null;
                repaint();
                revalidate();
            } 
        });
        
        //Listener for close collection menu item
        closeCollectionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(menuBar, BorderLayout.NORTH);
                getContentPane().add(welcomeText, BorderLayout.CENTER);
                collectionList.removeAll();
                refreshHome();
                getContentPane().add(collectionList, BorderLayout.SOUTH);
                currentCollection = null;
                repaint();
                revalidate();
            } 
        });
        
        //Listener for import collection menu item
        importCollectionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO open window to select folder to import as new collection
            } 
        });
        
        //Listener for export collection menu item
        exportCollectionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO open window to allow user to save current collection as a folder
            } 
        });
        
        //Add menu to menu bar
        menuBar.add(optionsMenu);
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(welcomeText, BorderLayout.CENTER);
        getContentPane().add(collectionList, BorderLayout.SOUTH);
        
        
        
        setSize(750,500);
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
        getContentPane().removeAll();
        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(new CollectionUI(collection, this), BorderLayout.CENTER);
        repaint();
        revalidate();
    }
    
    /**
     * Updates the items being displayed (for instance if an item was added, 
     * updated, or deleted)
     */
    public void updateItems()
    {
        getContentPane().removeAll();
        getContentPane().add(menuBar);
        getContentPane().add(new CollectionUI(currentCollection, this));
        repaint();
        revalidate();
    }
    
    public void setCurrentCollection(Collection collection)
    {
        this.currentCollection = collection;
    }
    
    private void refreshHome()
    {
        collectionButtons.clear();
        
        //Create buttons and add to panel
        for (int i = 0; i < collections.size(); i++) 
        {
            collectionButtons.add(new JButton(collections.get(i).getTitle()));
            collectionButtons.get(i).addActionListener(new CollectionListener());
            collectionList.add(collectionButtons.get(i));
        }
    }
}
