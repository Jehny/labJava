package lab.base;

import org.testng.IExecutionListener;

import lab.base.BaseTest;
import lab.base.ExtentManager;

public class ReportExecutionListener implements IExecutionListener{

	public void onExecutionStart() {
		BaseTest.report = new ExtentManager();
	}

	public void onExecutionFinish() {
		// TODO Auto-generated method stub
	}

}
