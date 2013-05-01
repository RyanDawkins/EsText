package com.dawkinstan.estext;

import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class WText extends JEditorPane
{

    public WText()
    {
	this("");
    }

    public WText(String text)
    {

	setText(text);

    }

}