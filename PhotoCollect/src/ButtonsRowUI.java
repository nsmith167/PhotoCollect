
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adlan Ramly
 */
public class ButtonsRowUI extends JPanel{
    ButtonsRowUI() {
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
        
        add(removeButton);
        add(addButton);
        add(editButton);
        add(sortButton);
        add(statButton);
    }
}
