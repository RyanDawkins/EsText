import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileModel
{

    private File file;
    private String fileName;
    private String text;

    public FileModel(String fileName)
    {
	this(new File(fileName));
    }

    public FileModel(File file)
    {
	
	if(!file.exists())
	{
	    try
	    {
		file.createNewFile();
	    }
	    catch(IOException e)
	    {
	    }
	}


	this.file = file;
    }

    public void writeToFile()
    {
	try
	{
	    BufferedWriter bf = new BufferedWriter(new FileWriter(file));
	    bf.write(this.text);
	    System.out.println("Wrote: "+this.text);
	    bf.close();
	}
	catch(IOException e)
	{
	    e.printStackTrace();
	}
    }

    public String getFileName()
    {
	return this.file.getName();
    }

    public void setText(String text)
    {
	this.text = text;
    }

    public String getText()
    {
	String fileText = "";
	if(this.file.exists())
	{
	    try
	    {
		BufferedReader bf = new BufferedReader(new FileReader(file));
		String eachLine = "";
		while((eachLine = bf.readLine()) != null){ fileText = fileText + eachLine + "\n"; }
	    }
	    catch(IOException e)
	    {}
	}
	return fileText;
    }
}