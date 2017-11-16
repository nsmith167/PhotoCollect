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
import java.nio.file.Files;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author ajr5723
 */
public class ItemUI extends JFrame {

    private JPanel thePanel;
    private JPanel imagePanel;
    private JPanel imageInfoPanel;
    private JPanel ratingPanel;
    private JPanel infoPanel;

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
    private JButton ratingButton1;
    private JButton ratingButton2;
    private JButton ratingButton3;
    private JButton ratingButton4;
    private JButton ratingButton5;

    private ImageIcon itemImage;
    private JLabel imageLabel;
    private File selectedFile;

    private Collection collection;
    private int itemRating;
    private boolean editable;

    public ItemUI(Collection collection) {
        this.collection = collection;

        this.setSize(800, 600);
        this.setTitle("New Item");
        this.setLocationRelativeTo(null);

        itemRating = 5;
        thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(1, 2));
        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(2, 1));
        imageInfoPanel = new JPanel();
        imageInfoPanel.setLayout(new GridLayout(4, 1));
        ratingPanel = new JPanel();
        ratingPanel.setLayout(new GridLayout(1, 6));
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(10, 1));
        ratingButton1 = new JButton("1");
        ratingButton2 = new JButton("2");
        ratingButton3 = new JButton("3");
        ratingButton4 = new JButton("4");
        ratingButton5 = new JButton("5");

        itemNameLabel = new JLabel("Item Name");
        itemDateLabel = new JLabel("Date");
        itemValueLabel = new JLabel("Value ($)");
        itemDescriptionLabel = new JLabel("Description");
        itemNameTextField = new JTextField();
        itemDateTextField = new JTextField();
        itemValueTextField = new JTextField();
        itemDescriptionTextField = new JTextField();
        addItemButton = new JButton("Add Item");

        //Add components to the info panel
        infoPanel.add(itemNameLabel);
        infoPanel.add(itemNameTextField);
        infoPanel.add(itemDateLabel);
        infoPanel.add(itemDateTextField);
        infoPanel.add(itemValueLabel);
        infoPanel.add(itemValueTextField);
        infoPanel.add(itemDescriptionLabel);
        infoPanel.add(itemDescriptionTextField);
        infoPanel.add(addItemButton);

        browsePhotoButton = new JButton("Browse for Photo");
        browsePhotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int option = fc.showOpenDialog(ItemUI.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fc.getSelectedFile();
                    try {
                        itemImage.setImage(ImageIO.read(selectedFile));
                    } catch (IOException ex) {
                        System.out.println("Image failed to load");
                    }
                }
                repaint();
                revalidate();
            }
        });

        itemRarityLabel = new JLabel("Rarity");
        ratingPanel.add(itemRarityLabel);
        ratingPanel.add(ratingButton1);
        ratingPanel.add(ratingButton2);
        ratingPanel.add(ratingButton3);
        ratingPanel.add(ratingButton4);
        ratingPanel.add(ratingButton5);
        itemImage = new ImageIcon("empty_image.jpg");
        imageLabel = new JLabel(itemImage);
        imagePanel.add(imageLabel);
        
        imageInfoPanel.add(browsePhotoButton);
        imageInfoPanel.add(ratingPanel);
        imagePanel.add(imageLabel);
        imagePanel.add(imageInfoPanel);

        thePanel.add(imagePanel);
        thePanel.add(infoPanel);
        this.add(thePanel);

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Store file to directory
                File newFile = new File("src/res/" + selectedFile.getName());
                try {
                    Files.copy(selectedFile.toPath(), newFile.toPath());
                } catch (IOException ex) {
                    System.out.println("file copy failed");
                }
                //Create new item
                Item createdItem = new Item(itemNameTextField.getText());
                createdItem.setDate(itemDateTextField.getText());
                createdItem.setValue(Float.parseFloat(itemValueTextField.getText()));
                createdItem.setDescription(itemDescriptionTextField.getText());
                createdItem.setImage(itemImage);
                createdItem.setImagePath(newFile.getPath());
                createdItem.setRating(itemRating);

                collection.addItem(createdItem);

                //Provide feedback to the user
                infoPanel.removeAll();
                imagePanel.removeAll();
                thePanel.add(new JLabel("Item Created"));
                repaint();
                revalidate();
            }
        });

        ratingButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                itemRating = 1;
            }
        });
        ratingButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                itemRating = 2;
            }
        });
        ratingButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                itemRating = 3;
            }
        });
        ratingButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                itemRating = 4;
            }
        });
        ratingButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                itemRating = 5;
            }
        });

    }

    /**
     * Constructor in the case of a window for viewing or editing
     *
     * @param item
     * @param collection
     */
    public ItemUI(Item item, Collection collection) {
        this.collection = collection;
        editable = false;
        itemRating = item.getRating();
        System.out.println(itemRating);

        thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(1, 2));
        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(2, 1));
        imageInfoPanel = new JPanel();
        imageInfoPanel.setLayout(new GridLayout(4, 1));
        ratingPanel = new JPanel();
        ratingPanel.setLayout(new GridLayout(1, 6));
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(10, 1));

        this.setSize(800, 600);
        this.setTitle("Item Details");
        this.setLocationRelativeTo(null);

        itemNameLabel = new JLabel("Item Name");
        itemDateLabel = new JLabel("Date");
        itemValueLabel = new JLabel("Value ($)");
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

        ratingButton1 = new JButton("1");
        ratingButton2 = new JButton("2");
        ratingButton3 = new JButton("3");
        ratingButton4 = new JButton("4");
        ratingButton5 = new JButton("5");

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
        browsePhotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int option = fc.showOpenDialog(ItemUI.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fc.getSelectedFile();
                    try {
                        itemImage.setImage(ImageIO.read(selectedFile));
                    } catch (IOException ex) {
                        System.out.println("Image failed to load");
                    }
                }
                repaint();
                revalidate();
            }
        });

        itemRarityLabel = new JLabel("Rarity");
        ratingPanel.add(itemRarityLabel);
        switch (item.getRating()) {
            case 1:
                ratingPanel.add(ratingButton1);
                ratingPanel.remove(ratingButton2);
                ratingPanel.remove(ratingButton3);
                ratingPanel.remove(ratingButton4);
                ratingPanel.remove(ratingButton5);
                repaint();
                revalidate();
                break;
            case 2:
                ratingPanel.add(ratingButton1);
                ratingPanel.add(ratingButton2);
                ratingPanel.remove(ratingButton3);
                ratingPanel.remove(ratingButton4);
                ratingPanel.remove(ratingButton5);
                repaint();
                revalidate();
                break;
            case 3:
                ratingPanel.add(ratingButton1);
                ratingPanel.add(ratingButton2);
                ratingPanel.add(ratingButton3);
                ratingPanel.remove(ratingButton4);
                ratingPanel.remove(ratingButton5);
                repaint();
                revalidate();
                break;
            case 4:
                ratingPanel.add(ratingButton1);
                ratingPanel.add(ratingButton2);
                ratingPanel.add(ratingButton3);
                ratingPanel.add(ratingButton4);
                ratingPanel.remove(ratingButton5);
                repaint();
                revalidate();
                break;
            case 5:
                ratingPanel.add(ratingButton1);
                ratingPanel.add(ratingButton2);
                ratingPanel.add(ratingButton3);
                ratingPanel.add(ratingButton4);
                ratingPanel.add(ratingButton5);
                repaint();
                revalidate();
                break;
        }

        imageLabel = new JLabel(itemImage);
        imagePanel.add(imageLabel);
        imageInfoPanel.add(ratingPanel);
        imagePanel.add(imageInfoPanel);
        for (int i = 0; i < 5; i++) {
            //imagePanel.add(starRatingsButtons[i]);
        }

        saveItemButton.addActionListener(new ActionListener() {
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
                item.setRating(itemRating);
                switch (itemRating) {
                    case 1:
                        ratingPanel.add(ratingButton1);
                        ratingPanel.remove(ratingButton2);
                        ratingPanel.remove(ratingButton3);
                        ratingPanel.remove(ratingButton4);
                        ratingPanel.remove(ratingButton5);
                        repaint();
                        revalidate();
                        break;
                    case 2:
                        ratingPanel.add(ratingButton1);
                        ratingPanel.add(ratingButton2);
                        ratingPanel.remove(ratingButton3);
                        ratingPanel.remove(ratingButton4);
                        ratingPanel.remove(ratingButton5);
                        repaint();
                        revalidate();
                        break;
                    case 3:
                        ratingPanel.add(ratingButton1);
                        ratingPanel.add(ratingButton2);
                        ratingPanel.add(ratingButton3);
                        ratingPanel.remove(ratingButton4);
                        ratingPanel.remove(ratingButton5);
                        repaint();
                        revalidate();
                        break;
                    case 4:
                        ratingPanel.add(ratingButton1);
                        ratingPanel.add(ratingButton2);
                        ratingPanel.add(ratingButton3);
                        ratingPanel.add(ratingButton4);
                        ratingPanel.remove(ratingButton5);
                        repaint();
                        revalidate();
                        break;
                    case 5:
                        ratingPanel.add(ratingButton1);
                        ratingPanel.add(ratingButton2);
                        ratingPanel.add(ratingButton3);
                        ratingPanel.add(ratingButton4);
                        ratingPanel.add(ratingButton5);
                        repaint();
                        revalidate();
                        break;
                }
                if (selectedFile != null) {
                    //Store file to directory
                    File newFile = new File("src/res/" + selectedFile.getName());
                    try {
                        Files.copy(selectedFile.toPath(), newFile.toPath());
                    } catch (IOException ex) {
                        System.out.println("file copy failed");
                    }

                    item.setImagePath(newFile.getPath());
                }

                infoPanel.remove(saveItemButton);
                infoPanel.add(editItemButton);
                infoPanel.add(deleteItemButton);
                imagePanel.remove(browsePhotoButton);
                editable = false;
                repaint();
                revalidate();
            }
        });

        editItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editable = true;
                imageInfoPanel.add(browsePhotoButton);
                ratingPanel.add(ratingButton1);
                ratingPanel.add(ratingButton2);
                ratingPanel.add(ratingButton3);
                ratingPanel.add(ratingButton4);
                ratingPanel.add(ratingButton5);
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

        deleteItemButton.addActionListener(new ActionListener() {
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

        ratingButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (editable) {
                    itemRating = 1;
                }
            }
        });
        ratingButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (editable) {
                    itemRating = 2;
                }
            }
        });
        ratingButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (editable) {
                    itemRating = 3;
                }
            }
        });
        ratingButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (editable) {
                    itemRating = 4;
                }
            }
        });
        ratingButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (editable) {
                    itemRating = 5;
                }
            }
        });

        thePanel.add(imagePanel);
        thePanel.add(infoPanel);
        this.add(thePanel);

    }
}
