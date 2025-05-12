package independentarabia.independentarabia;
import java.io.File;
import java.nio.file.Files;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.text.SimpleDateFormat;
import java.util.Date;







public class TC001openApp {
	
	
	
	
	
	AppiumDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		// إعدادات UiAutomator2
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 7a");
		options.setPlatformName("Android");
		options.setAppPackage("com.srpc.indyarabia");
		options.setAppActivity("com.example.news.MainActivity");
		options.setAutomationName("UiAutomator2");
		options.setNewCommandTimeout(Duration.ofSeconds(300));

		// تأكد من أن العنوان يتوافق مع عنوان Appium الذي يعمل عليه الخادم
		URL serverURL = URI.create("http://127.0.0.1:4723/wd/hub").toURL();

		// إنشاء كائن AppiumDriver
		driver = new AppiumDriver(serverURL, options);
	}
	

	   @Test(priority = 1)
	public void TC001AppLaunch() throws InterruptedException {
		  
		   
		   try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement homeTab = wait.until(
	                ExpectedConditions.presenceOfElementLocated(
	                    AppiumBy.accessibilityId("اندبندنت عربية")
	                )
	            );
	            Assert.assertTrue(homeTab.isDisplayed(), "التطبيق اشتغل والعنصر الرئيسي ظاهر.");
	        } catch (Exception e) {
	            Assert.fail(" التطبيق لم يشتغل أو عنصر 'الرئيسية' غير موجود: " + e.getMessage());
	        }
	    }
		   
	   
	   
	   @Test(priority = 2)
	   public void TC002Login() {
	       try {
	           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	           // انتظار زر تسجيل الدخول الأول
	           WebElement loginBtn = wait.until(
	               ExpectedConditions.presenceOfElementLocated(
	                   AppiumBy.accessibilityId("تسجيل الدخول")
	               )
	           );
	           Assert.assertTrue(loginBtn.isDisplayed(), " Login button is not displayed!");
	           loginBtn.click();
	           System.out.println(" Clicked on the first login button.");

	           // إدخال البريد الإلكتروني
	           WebElement emailField = wait.until(
	               ExpectedConditions.presenceOfElementLocated(
	                   AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
	               )
	           );
	           emailField.click();
	           emailField.sendKeys("asseelyacoub@gmail.com");
	           System.out.println("✅ Email entered.");
	           Thread.sleep(5000);
	          

	           // إدخال كلمة المرور
	           WebElement passwordField = wait.until(
	               ExpectedConditions.presenceOfElementLocated(
	                   AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
	               )
	           );
	           passwordField.click();
	           passwordField.sendKeys("123456789");
	           System.out.println("✅ Password entered.");
	           Thread.sleep(5000);

	           // انتظار زر تسجيل الدخول الثاني 
	           WebElement submitLoginBtn = wait.until(
	               ExpectedConditions.presenceOfElementLocated(
	            		   AppiumBy.xpath("//android.widget.Button[@content-desc='تسجيل الدخول ']")
	               )
	           );
	           Assert.assertTrue(submitLoginBtn.isDisplayed(), " Submit login button is not displayed.");
	           submitLoginBtn.click();
	           System.out.println(" Clicked on the submit login button successfully.");

	       } catch (Exception e) {
	           Assert.fail(" Failed during login process: " + e.getMessage());
	       }
	   }

	   
	   @Test(priority = 3)
	   public void TC003_OpenPolicyTab_And_ClickNext() {
	       try {
	           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	           // الانتظار والنقر على تبويب "سياسة"
	           WebElement policyTab = wait.until(
	               ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("سياسة"))
	           );
	           policyTab.click();
	           System.out.println(" تم الضغط على تبويب 'سياسة'");

	           // الانتظار والنقر على زر "التالي"
	           WebElement nextButton = wait.until(
	               ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("التالي"))
	           );
	           nextButton.click();
	           System.out.println("تم الضغط على زر 'التالي'");

	       } catch (Exception e) {
	           Assert.fail(" فشل في الضغط على 'سياسة' أو 'التالي': " + e.getMessage());
	       }
	   }

	   @Test(priority = 4)
	   public void TC004clickNextButton() {
	       try {
	           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	           // انتظار ظهور زر "التالي"
	           WebElement nextButton = wait.until(
	               ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("التالي"))
	           );

	           // الضغط على الزر
	           nextButton.click();
	           System.out.println(" تم الضغط على زر 'التالي' بنجاح.");

	       } catch (Exception e) {
	           Assert.fail(" لم يتم العثور على زر 'التالي' أو لم يكن قابلاً للنقر: " + e.getMessage());
	       }
	   }

	   

	    @Test(priority = 5)
	    public void TC005denyPermissionPopup() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement denyBtn = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                    AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button")
	                )
	            );
	            denyBtn.click();
	            System.out.println(" Permission denied successfully.");
	        } catch (Exception e) {
	            System.out.println("Permission popup not shown or already handled.");
	        }
	    }
	   
	   
	   
	   
	    @AfterMethod ()
	    public void takeScreenshotAfterEachTest1(ITestResult result) {
	    	System.out.println("@AfterMethod is triggered for test: " + result.getMethod().getMethodName());

	    	try {
	        	
	            // اسم التست اللي خلص الآن
	            String testName = result.getMethod().getMethodName();

	            // توقيت لكل صورة
	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	            File scrFile = driver.getScreenshotAs(OutputType.FILE);
	            File targetFile = new File("screenshots/before-release/" + testName + "_" + timestamp + ".png");

	            targetFile.getParentFile().mkdirs(); // ينشئ المجلد إذا مش موجود
	            Files.copy(scrFile.toPath(), targetFile.toPath());

	            System.out.println(" Screenshot saved for test: " + testName);
	        } catch (Exception e) {
	            System.out.println("Failed to take screenshot: " + e.getMessage());
	        }
	    } 
	   
	   
	   /* @AfterMethod
	    public void takeScreenshotAfterEachTest2(ITestResult result) {
	        try {
	            // اسم التست اللي خلص الآن
	            String testName = result.getMethod().getMethodName();

	            // توقيت  لكل صورة
	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	            File scrFile = driver.getScreenshotAs(OutputType.FILE);
	            File targetFile = new File("screenshots/after-release/" + testName + "_" + timestamp + ".png");

	            targetFile.getParentFile().mkdirs(); // ينشئ المجلد إذا مش موجود
	            Files.copy(scrFile.toPath(), targetFile.toPath());

	            System.out.println("📸 Screenshot saved for test: " + testName);
	        } catch (Exception e) {
	            System.out.println("❌ Failed to take screenshot: " + e.getMessage());
	        }
	    } */
	   
	   
	   
	   
	   
	   
	   
	   

	   
	   
	  
}	   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


