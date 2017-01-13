package org.usfirst.frc.team1360.robot.IO;

import org.usfirst.frc.team1360.robot.util.XboxRemote;

public class HumanInput {
	
	private static HumanInput instance;
	private XboxRemote driver;
	private XboxRemote operator;
	private boolean autonIncreaseStepWasPressed = false;
	private boolean autonDecreaseStepWasPressed = false;
	
	private HumanInput()
	{
		this.driver = new XboxRemote(0);
		this.operator = new XboxRemote(1);
	}
	
	public static HumanInput getInstance()
	{
		if (instance == null)
		{
			instance = new HumanInput();
		}
		
		return instance;
	}
	
	//Driver Controls
	public double getDriverForward(){
		return this.driver.getLeftTrigger();
	}
	public double getDriverBackward(){
		return this.driver.getRightTrigger();
	}
	public double getDriverTurn(){
		return this.driver.getLeftXAxis();
	}
	public double getDriverLeftMove(){
		return this.driver.getLeftYAxis();
	}
	public double getDriverRightMove(){
		return this.driver.getRightYAxis();
	}
	public boolean getDriverActuate(){
		return this.driver.getButtonA();
	}
	//Operator Controls
	/*public double getOperatorIn(){
		return this.operator.RightTrigger();
	}*/
	public double getOperatorIn(){
		return this.operator.getRightTrigger();
	}
	public double getOperatorOut(){
		return this.operator.getLeftTrigger();
	}
	//Auto Controls
	 public boolean getAutonSetModeButton() 
	 {
		 return this.driver.getButtonA();
	 }
	    
	 public boolean getAutonSetDelayButton() 
	 {
		 return this.driver.getButtonB();
	 }
	    
	 public double getAutonSelectStick() 
	 {
		 return this.driver.getLeftYAxis();
	 }

	 public boolean getAutonStepIncrease() 
	 {
	    	// only returns true on rising edge
		boolean result = this.driver.getButtonRB() && !this.autonIncreaseStepWasPressed;
	    this.autonIncreaseStepWasPressed = this.driver.getButtonRB();
	    return result;
	    	
	}
	    
	public boolean getAutonStepDecrease() 
	{
	    	// only returns true on rising edge
	    boolean result = this.driver.getButtonLB() && !this.autonDecreaseStepWasPressed;
	    this.autonDecreaseStepWasPressed = this.driver.getButtonLB();
	    return result;
	}
	
}
