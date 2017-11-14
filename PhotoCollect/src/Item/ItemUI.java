/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;
import Collection.Collection;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author ajr5723
 */
public class ItemUI extends JFrame{
    private JLabel itemNameLabel;
    private JLabel itemDateLabel;
    private JLabel itemValueLabel;
    private JLabel itemDescriptionLabel;
    private JLabel itemRarityLabel;
    private JTextField itemNameTextField;
    private JTextField itemDateTextField;
    private JTextField itemValueTextField;
    private JTextField itemDescriptionTextField;
    
    private JButton addItemButton;
    private JButton browsePhotoButton;
    private JButton editItemButton;
    private JButton deleteItemButton;
    private JButton saveItemButton;
    private JButton [] starRatingsButtons;
    
    private ImageIcon itemImage;
    private JLabel imageLabel;
    private File selectedFile;
    
    private Collection collection;
    
    public ItemUI(Collection collection){
        this.collection = collection;
        
        this.setSize(800,600);
        this.setTitle("New Item");
        this.setLocationRelativeTo(null);
        
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(1,2));
        
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(3,1));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(10,1));
        
        itemNameLabel = new JLabel("Item Name");
        itemDateLabel = new JLabel("Date");
        itemValueLabel = new JLabel("Value");
        itemDescriptionLabel = new JLabel("Description");
        itemNameTextField = new JTextField();
        itemDateTextField = new JTextField();
        itemValueTextField = new JTextField();
        itemDescriptionTextField = new JTextField();
        addItemButton = new JButton("Add Item");
        
        
        
        infoPanel.add(itemNameLabel);
        infoPanel.add(itemNameTextField);
        infoPanel.add(itemDateLabel);
        infoPanel.add(itemDateTextField);
        infoPanel.add(itemValueLabel);
        infoPanel.add(itemValueTextField);
        infoPanel.add(itemDescriptionLabel);
        infoPanel.add(itemDescriptionTextField);
        infoPanel.add(addItemButton);
        
        itemImage = new ImageIcon();
        
        
        browsePhotoButton = new JButton("Browse for Photo");
        browsePhotoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int option = fc.showOpenDialog(ItemUI.this);
                if (option == JFileChooser.APPROVE_OPTION)
                {
                    selectedFile = fc.getSelectedFile();
                    try {
                        itemImage.setImage(ImageIO.read(selectedFile));
                    }
                    catch (IOException ex) {
                        System.out.println("Image failed to load");
                    }
                }
                repaint();
                revalidate();
            }
        });
        
        itemRarityLabel = new JLabel("Rarity");
        for(int i = 0; i < 5; i++){
           //starRatingsButtons[i] = new JButton("*"); 
        }
        
        imageLabel = new JLabel(itemImage);
        imagePanel.add(imageLabel);
        
        imagePanel.add(browsePhotoButton);
        
        imagePanel.add(itemRarityLabel);
        for(int i = 0; i < 5; i++){
            //imagePanel.add(starRatingsButtons[i]);
        }
        
        addItemButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Create new item
                Item createdItem = new Item(itemNameTextField.getText());
                createdItem.setDate(itemDateTextField.getText());
                createdItem.setValue(Float.parseFloat(itemValueTextField.getText()));
                createdItem.setDescription(itemDescriptionTextField.getText());
                createdItem.setImage(itemImage);
                createdItem.setImagePath(selectedFile.getPath());
                
                collection.addItem(createdItem);
                
                //Provide feedback to the user
                infoPanel.removeAll();
                imagePanel.removeAll();
                thePanel.add(new JLabel("Item Created"));
                repaint();
                revalidate();
            }
        });
        
        
        
        thePanel.add(imagePanel);
        thePanel.add(infoPanel);
        this.add(thePanel);
        
        
    }
    
    /**
     * Constructor in the case of a window for viewing or editing
     */
    public ItemUI(Item item, Collection collection){
        this.collection = collection;
        
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(1,2));

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(3,1));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(10,1));
            
        this.setSize(800,600);
        this.setTitle("Item Details");
        this.setLocationRelativeTo(null);

        itemNameLabel = new JLabel("Item Name");
        itemDateLabel = new JLabel("Date");
        itemValueLabel = new JLabel("Value");
        itemDescriptionLabel = new JLabel("Description");
        itemNameTextField = new JTextField(item.getItemName());
        itemNameTextField.setEditable(false);
        itemDateTextField = new JTextField(item.getDate().toString());
        itemDateTextField.setEditable(false);
        itemValueTextField = new JTextField(item.getValue() + "");
        itemValueTextField.setEditable(false);
        itemDescriptionTextField = new JTextField(item.getDescription());
        itemDescriptionTextField.setEditable(false);
        editItemButton = new JButton("Edit");
        deleteItemButton = new JButton("Delete");
        saveItemButton = new JButton("Save");



        infoPanel.add(itemNameLabel);
        infoPanel.add(itemNameTextField);
        infoPanel.add(itemDateLabel);
        infoPanel.add(itemDateTextField);
        infoPanel.add(itemValueLabel);
        infoPanel.add(itemValueTextField);
        infoPanel.add(itemDescriptionLabel);
        infoPanel.add(itemDescriptionTextField);
        infoPanel.add(editItemButton);
        infoPanel.add(deleteItemButton);

        itemImage = item.getImage();
        browsePhotoButton = new JButton("Browse for Photo");
        browsePhotoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int option = fc.showOpenDialog(ItemUI.this);
                if (option == JFileChooser.APPROVE_OPTION)
                {
                    selectedFile = fc.getSelectedFile();
                    try {
                        itemImage.setImage(ImageIO.read(selectedFile));
                    }
                    catch (IOException ex) {
                        System.out.println("Image failed to load");
                    }
                }
                repaint();
                revalidate();
            }
        });
        
        itemRarityLabel = new JLabel("Rarity");
        for(int i = 0; i < 5; i++){
           //starRatingsButtons[i] = new JButton("*"); 
        }

        imageLabel = new JLabel(itemImage);
        imagePanel.add(imageLabel);
        imagePanel.add(itemRarityLabel);
        for(int i = 0; i < 5; i++){
            //imagePanel.add(starRatingsButtons[i]);
        }  
        
        saveItemButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                itemNameTextField.setEditable(false);
                itemDateTextField.setEditable(false);
                itemValueTextField.setEditable(false);
                itemDescriptionTextField.setEditable(false);
                
                //Update item
                item.setItemName(itemNameTextField.getText());
                item.setDate(itemDateTextField.getText());
                item.setValue(Float.parseFloat(itemValueTextField.getText()));
                item.setDescription(itemDescriptionTextField.getText());
                item.setImage(itemImage);
                if (selectedFile != null)
                {
                    item.setImagePath(selectedFile.getPath());
                }
                
                infoPanel.remove(saveItemButton);
                infoPanel.add(editItemButton);
                infoPanel.add(deleteItemButton);
                imagePanel.remove(browsePhotoButton);
                repaint();
                revalidate();
            }
        });
        
        editItemButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                imagePanel.add(browsePhotoButton);
                infoPanel.remove(editItemButton);
                infoPanel.remove(deleteItemButton);
                infoPanel.add(saveItemButton);
                repaint();
                revalidate();
                itemNameTextField.setEditable(true);
                itemDateTextField.setEditable(true);
                itemValueTextField.setEditable(true);
                itemDescriptionTextField.setEditable(true);
            }
            
        });
        
        deleteItemButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.removeItem(item);
                infoPanel.removeAll();
                imagePanel.removeAll();
                thePanel.add(new JLabel("Item Deleted"));
                repaint();
                revalidate();
            }
        });
        
        thePanel.add(imagePanel);
        thePanel.add(infoPanel);
        this.add(thePanel);
        
        
    }
}
