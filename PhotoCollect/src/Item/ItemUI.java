/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;
import java.awt.*;
import java.awt.event.*;
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
    private JButton [] starRatingsButtons;
    
    private ImageIcon itemImage;
    private JLabel imageLabel;
    
    public ItemUI(){
        this.setSize(800,600);
        this.setTitle("New Item");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        
        
        
        thePanel.add(imagePanel);
        thePanel.add(infoPanel);
        this.add(thePanel);
        
        
    }
    
    /**
     * Constructor in the case of a window for viewing or editing
     */
    public ItemUI(Item item, boolean editable){
        
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(1,2));

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(3,1));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(10,1));
            
        if (editable)
        {
            this.setSize(800,600);
            this.setTitle("Edit Item");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);

            itemNameLabel = new JLabel("Item Name");
            itemDateLabel = new JLabel("Date");
            itemValueLabel = new JLabel("Value");
            itemDescriptionLabel = new JLabel("Description");
            itemNameTextField = new JTextField(item.getItemName());
            itemDateTextField = new JTextField(item.getDateTime().toString());
            itemValueTextField = new JTextField(item.getValue() + "");
            itemDescriptionTextField = new JTextField(item.getDescription());



            infoPanel.add(itemNameLabel);
            infoPanel.add(itemNameTextField);
            infoPanel.add(itemDateLabel);
            infoPanel.add(itemDateTextField);
            infoPanel.add(itemValueLabel);
            infoPanel.add(itemValueTextField);
            infoPanel.add(itemDescriptionLabel);
            infoPanel.add(itemDescriptionTextField);

            itemImage = item.getImage();
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
        }
        else //Not editable
        {
            this.setSize(800,600);
            this.setTitle("Item Details");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);

            itemNameLabel = new JLabel("Item Name");
            itemDateLabel = new JLabel("Date");
            itemValueLabel = new JLabel("Value");
            itemDescriptionLabel = new JLabel("Description");
            itemNameTextField = new JTextField(item.getItemName());
            itemNameTextField.setEditable(false);
            itemDateTextField = new JTextField(item.getDateTime().toString());
            itemDateTextField.setEditable(false);
            itemValueTextField = new JTextField(item.getValue() + "");
            itemValueTextField.setEditable(false);
            itemDescriptionTextField = new JTextField(item.getDescription());
            itemDescriptionTextField.setEditable(false);



            infoPanel.add(itemNameLabel);
            infoPanel.add(itemNameTextField);
            infoPanel.add(itemDateLabel);
            infoPanel.add(itemDateTextField);
            infoPanel.add(itemValueLabel);
            infoPanel.add(itemValueTextField);
            infoPanel.add(itemDescriptionLabel);
            infoPanel.add(itemDescriptionTextField);

            itemImage = item.getImage();
            browsePhotoButton = new JButton("Browse for Photo");
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
        }
        
        
        
        thePanel.add(imagePanel);
        thePanel.add(infoPanel);
        this.add(thePanel);
        
        
    }
}
