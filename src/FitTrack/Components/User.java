package FitTrack.Components;

/**
 * Created by colin on 02/11/16.
 */
public class User
{
	private int age, weight;
	double height;
	private String uName, sex, email, password;


	public User(String uName, String sex, int age, int weight, double height, String email, String password )
	{
		this.uName = uName;
		this.sex = sex;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.email = email;
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getAge()
	{
		return age;
	}

	public int getWeight()
	{
		return weight;
	}

	public double getHeight()
	{
		return height;
	}

	public String getuName()
	{
		return uName;
	}

	public String getSex()
	{
		return sex;
	}

	public String getPassword()
	{
		return password;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	public void setuName(String uName)
	{
		this.uName = uName;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void print()
	{
		System.out.println(uName + " " + sex + " " + age + " " +  weight + " " + height + " " + email + " " + password );
	}

	@Override
	public String toString()
	{
		String s = uName + " " + sex + " " + age + " " +  weight + " " + height + " " + email + " " + password;
		return s;
	}
}