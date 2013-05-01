package com.dawkinstan.estext;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Graphics;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class WPanel extends JPanel
{

    WText textPane;

    public WPanel()
    {
	setLayout(new BorderLayout());
	textPane = new WText();
	add(new JScrollPane(textPane), BorderLayout.CENTER);
    }

    public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
    }

    public WText getPane()
    {
	return this.textPane;
    }

}