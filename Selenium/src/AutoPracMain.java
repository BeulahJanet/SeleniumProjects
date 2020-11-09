
public class AutoPracMain extends AutomationPractice{

	public static void main(String[] args) throws Throwable {
		AutomationPractice.browserLaunch("chrome");
		AutomationPractice.getUrl("http://automationpractice.com/index.php?controller=addresses");
		AutomationPractice.createAccount();
	}

}
