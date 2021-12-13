package com.Vtiger.genericLib;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtil {
	
	/**
	 * @author SWATHI
	 * Description : This is a single ton constructor which saves memory in heap area for everytime object creation in everyTC
	 * @return obj reference
	 */
	
	private JavaUtil()
	{
		
	}
	public static JavaUtil objforJavaUtil()
	{
		JavaUtil jv = new JavaUtil();
		return jv;
	}
	
	/**
	 * @author SWATHI
	 * Description : This method generates random number
	 * @return objref interger value
	 */
	public int generateRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(1000);
	}
	
	/**
	 * @author SWATHI
	 * Description : this method generates a random full name
	 * @return fullname
	 */
	public String getFullName()
	{
		Faker faker = new Faker();
		return faker.name().firstName();
	
	}
	/**
	 * @author SWATHI 
	 * Description : This method generates random firstname
	 * @return
	 */
	public String getFirstName()
	{
		Faker faker = new Faker();
		return faker.name().firstName();
	
	}
	
	/**
	 * @author SWATHI 
	 * Description : This method generates random lastname
	 * @return
	 */
	public String getlastName()
	{
		Faker faker = new Faker();
		return faker.name().lastName();
	
	}
	
	public String getphoneNumber()
	{
		Faker faker = new Faker();
		return faker.phoneNumber().cellPhone();
	}
}
