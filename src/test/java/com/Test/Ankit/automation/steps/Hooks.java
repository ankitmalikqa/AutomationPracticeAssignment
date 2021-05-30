package com.Test.Ankit.automation.steps;

//import java.io.FileOutputStream;
//import java.util.stream.Stream;
//
//import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	public static WebDriver driver;
	@Before
	public void init()
{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
	     driver = new ChromeDriver(); 
	}
	@After
	public void end() throws Exception
	{
		driver.quit();
	}}
