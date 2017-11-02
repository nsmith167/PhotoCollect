/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nps5120
 */
public class CollectionUI extends JPanel
{
    public CollectionUI(Collection collection)
        {
            JPanel ButtonRowsUI = new JPanel();
            JButton removeButton, 
                addButton, 
                editButton, 
                sortButton, 
                statButton;

            removeButton = new JButton("Remove Item");
            addButton = new JButton("Add Item");
            editButton = new JButton("Edit Item");
            sortButton = new JButton("Sort Button");
            statButton = new JButton ("VIew Statistics");

            ButtonRowsUI.add(removeButton);
            ButtonRowsUI.add(addButton);
            ButtonRowsUI.add(editButton);
            ButtonRowsUI.add(sortButton);
            ButtonRowsUI.add(statButton);
            
            JTextField searchBar = new JTextField();

            JLabel spacer = new JLabel();
            
            JPanel itemList = new JPanel();
            
            GridLayout itemGrid = new GridLayout(2,5);
            itemList.setLayout(itemGrid);
        
            for (int i = 0; i < collection.getTotalItems(); i++) 
            {
                itemList.add(new JButton(collection.getItems().get(i).getItemName()));
            }
            
            GridLayout grid = new GridLayout(4,1);
            setLayout(grid);
            
            add(ButtonRowsUI);
            add(spacer);
            add(spacer);
            add(itemList);
        }
}
