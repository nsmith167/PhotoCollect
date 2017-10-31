
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
public class ItemListUI extends JPanel{
    ItemListUI() {
        JButton buttons[];
        int itemSize = 10;
        buttons = new JButton[itemSize];
        
        GridLayout grid = new GridLayout(2,5);
        setLayout(grid);
        
        for (int i = 0; i < itemSize; i++) {
            buttons[i] = new JButton(Integer.toString(i + 1));
            buttons[i].setSize(10,10);
            add(buttons[i]);
        }
    }
    
}
