package FitTrack.Data;

import FitTrack.Components.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.jar.Pack200;

/**
 * Created by colin on 30/11/16.
 */
public class loadUserData
{
	public static BufferedReader reader;
	public static BufferedWriter writer;
	public static ArrayList<String[]> userData = new ArrayList<String[]>();

	private static void loadData()
	{
		try
		{
			reader = new BufferedReader(new FileReader("src/resources/users.txt"));
			String temp;
			while( ( temp = reader.readLine() ) != null)
			{
				userData.add(temp.split(" "));
			}
			reader.close();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	private static void saveData()
	{
		try
		{
			String data = "";
			writer = new BufferedWriter(new FileWriter("src/resources/users.txt"));
			for(String[] str : userData)
			{
				for(String st : str)
				{
					data += ( st + " " );
				}
				data += "\n";
			}
			writer.write(data);
			writer.close();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	public static User checkLoad(String unm, String pass)
	{
		loadData();

		for(String[] str : userData)
		{
			if(str[0].equals(unm)  && str[str.length - 1].equals(pass))
			{
				System.out.println("User [ " + unm + " ] found and being loaded.");
				User usr = new User( str[0], str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3]),
									 Double.parseDouble(str[4]), str[5], str[6] );
				return usr;
			}
		}
		return null;
	}

	public static User checkAdd(User user)
	{
		loadData();

		for(String[] str : userData)
		{
			if( str[0].equals(user.getuName()) )
			{
				System.out.println("User [ " + user.getuName() + " ] already exists.");
				return null;
			}
		}

		System.out.println("User [ " + user.getuName() + " ] being created.");
		userData.add(user.toString().split(" "));
		saveData();
		return user;
	}
}
