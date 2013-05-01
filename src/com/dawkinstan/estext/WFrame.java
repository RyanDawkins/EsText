package com.dawkinstan.estext;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import javax.swing.event.MenuListener;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JOptionPane;

public class WFrame extends JFrame
{

    private static String TITLE = "EsText";
    private static int DEFAULT_WIDTH = 500;
    private static int DEFAULT_HEIGHT = 500;
    private static boolean IS_VISIBLE = true;
    private static int option;
    private static final int ITEM_NEW  = 0;
    private static final int ITEM_SAVE = 1;
    private static final int ITEM_SAVE_AS = 2;
    private static final int ITEM_OPEN = 3;
    private static final int ITEM_EXIT = 4;
    private static WPanel panel;
    private FileModel fileModel;

    public WFrame()
    {
	this.setSize(DEFAULT_HEIGHT, DEFAULT_WIDTH);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle(TITLE);
	this.setLayout(new BorderLayout());

	Container cp = this.getContentPane();
	cp.add(getMenu(), BorderLayout.PAGE_START);
	
	this.panel = new WPanel();
	cp.add(this.panel, BorderLayout.CENTER);

	this.setVisible(IS_VISIBLE);
    }

    private JMenuBar getMenu()
    {
	JMenuBar menuBar = new JMenuBar();
	
	// File Menu
	JMenu fileMenu = new JMenu("File");

	JMenuItem itemNew = new JMenuItem("New");
	itemNew.addActionListener(new MenuListener(ITEM_NEW));
	fileMenu.add(itemNew);

	JMenuItem itemSave = new JMenuItem("Save");
	itemSave.addActionListener(new MenuListener(ITEM_SAVE));
	fileMenu.add(itemSave);

	JMenuItem itemSaveAs = new JMenuItem("Save As..");
	itemSaveAs.addActionListener(new MenuListener(ITEM_SAVE_AS));
	fileMenu.add(itemSaveAs);

	JMenuItem itemOpen = new JMenuItem("Open");
	itemOpen.addActionListener(new MenuListener(ITEM_OPEN));
	fileMenu.add(itemOpen);

	JMenuItem itemExit = new JMenuItem("Exit");
	itemExit.addActionListener(new MenuListener(ITEM_EXIT));
	fileMenu.add(itemExit);

	menuBar.add(fileMenu);

	return menuBar;
    }

    private class MenuListener implements ActionListener
    {

	private int option;

	public MenuListener(int option)
	{
	    this.option = option;
	}

	public void actionPerformed(ActionEvent e)
	{

	    WText textPane = panel.getPane();
	    String text = "";
	    String fileName = "";
	    int returnVal = -999;

	    switch(this.option)
	    {

	        case ITEM_NEW:
		    fileName = "";
		    JFileChooser chooser = new JFileChooser();
		    returnVal = chooser.showSaveDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION)
		    {
			File file = chooser.getSelectedFile();
			if(file.exists())
			{
			    JOptionPane.showMessageDialog(null, null, "ERROR: File alredady exists.", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
			    fileModel = new FileModel(file);
			}
		    }
		    break;

	        case ITEM_SAVE:
		    text = textPane.getText();
		    fileModel.setText(text);
		    fileModel.writeToFile();
		    break;

	        case ITEM_SAVE_AS:
		    text = textPane.getText();
		    JFileChooser jc = new JFileChooser();
		    returnVal = jc.showSaveDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION)
		    {
			File file = jc.getSelectedFile();
			if(file.exists())
			{
			    fileModel = new FileModel(file);
			    fileModel.setText(textPane.getText());
			    fileModel.writeToFile();
			}
			else
			{
			    fileModel = new FileModel(file);
			    fileModel.setText(textPane.getText());
			    fileModel.writeToFile();
			}
		    }
		    break;

	        case ITEM_OPEN:
		    fileName = "";
		    jc = new JFileChooser();
		    returnVal = jc.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION)
		    {
			File file = jc.getSelectedFile();
			if(file.exists())
			{
			    fileModel = new FileModel(file);
			    panel.getPane().setText(fileModel.getText());
			}
			else
			{
			}
		    }
		    break;

	        case ITEM_EXIT:
		    System.exit(0);
		    break;

	    }

	}

    }

}