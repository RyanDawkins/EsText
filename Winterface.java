/**

 This is the Window Interface Class
 Written by: Ryan Dawkins 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Winterface extends JFrame
{

    // Instance variables
    private JPanel panel;
    private TextArea textArea;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 300;
    
    // Menu Bar
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openFile;
    private JMenuItem saveFile;
    private JMenuItem saveAsFile;
    private JMenuItem close;

    // Static variables
    private static String fileName;
    private static File file;
    private static String contents = null;

    // Static Constants
    private static final String NAME_OF_MENU = "Menu";

    public static void main(String[] args)
    {
        try
        {
            if(args[0] != null)
            {
                fileName = args[0];
                file = new File(fileName).isFile() ? new File(fileName) : null;
                Scanner fileReader = new Scanner(file);
                while(fileReader.hasNextLine())
                {
                    contents = (contents != null) ?
                        contents + fileReader.nextLine()
                        : fileReader.nextLine();
                    contents = fileReader.hasNextLine() ?
                        (contents + "\n") : contents;
                }
            }
        } catch(Exception e){}

        Winterface open = new Winterface();

    }

    public Winterface()
    {

        this.setTitle("EsText 0.1");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.buildUI();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textArea);
        this.setVisible(true);

    }

    private void buildUI()
    {

        // Fixing the horizontal UI
        textArea = (contents != null) 
            ? new TextArea(contents, 50, 50, TextArea.SCROLLBARS_VERTICAL_ONLY) 
            : new TextArea("", 50, 50, TextArea.SCROLLBARS_VERTICAL_ONLY);

        textArea.setFont(new Font(null, 0, 12));

        // Adding the panel
        panel = new JPanel();
        panel.add(textArea);

        // MenuBar
        menuBar     = new JMenuBar();
        fileMenu    = new JMenu(NAME_OF_MENU);
        openFile    = new JMenuItem("Open..");
        saveFile    = new JMenuItem("Save");
        saveAsFile  = new JMenuItem("Save as..");
        close       = new JMenuItem("Close");

        openFile.addActionListener(new OpenFile());

        // Adds Menu contents
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(close);
        menuBar.add(fileMenu);
        
        // Ads JMenuBar
        this.setJMenuBar(menuBar);

    }

    private class OpenFile
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }
    
    private class SaveFile
    {
        public void actionPerformed(ActionEvent e)
        {
            file.delete();
            file = new File(fileName);
            String[] eachLine = textArea.getText().split("\\n");
            for(int i = 0; i < eachLine.length; i++)
            {
                eachLine[i];
            }
        }
    }

}
