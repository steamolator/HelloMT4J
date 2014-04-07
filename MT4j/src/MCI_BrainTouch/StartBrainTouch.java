package MCI_BrainTouch;

import org.mt4j.MTApplication;

public class StartBrainTouch extends MTApplication{
	
	
	public static void main(String args[]){
		initialize();
	}
	

	@Override
	public void startUp() {
		this.addScene(new BrainTouch(this, "BraiTouch"));
		
	}

}
