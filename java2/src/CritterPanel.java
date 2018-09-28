// CSE 142 Homework 8 (Critters)
// Authors: Stuart Reges and Marty Stepp
//
// Class CritterPanel displays a grid of critters

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CritterPanel extends JPanel {
    private CritterModel myModel;
    private Font myFont;

    public static final int FONT_SIZE = 12;

    public CritterPanel(CritterModel model) {
        myModel = model;
        // construct font and compute char width once in constructor
        // for efficiency
        myFont = new Font("Monospaced", Font.BOLD, FONT_SIZE + 4);
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(FONT_SIZE * model.getWidth() + 20,
                                       FONT_SIZE * model.getHeight() + 20));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(myFont);
        Iterator<Critter> i = myModel.iterator();
        while (i.hasNext()) {
            Critter next = i.next();
            Point p = myModel.getPoint(next);
            String appearance = myModel.getAppearance(next);
            g.setColor(Color.BLACK);
            g.drawString("" + appearance, p.x * FONT_SIZE + 11,
                         p.y * FONT_SIZE + 21);
            g.setColor(myModel.getColor(next));
            g.drawString("" + appearance, p.x * FONT_SIZE + 10,
                         p.y * FONT_SIZE + 20);
        }
    }
}