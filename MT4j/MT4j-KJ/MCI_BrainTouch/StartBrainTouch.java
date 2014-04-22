package MCI_BrainTouch;

import org.mt4j.MTApplication;

public class StartBrainTouch extends MTApplication{
	
	
	/**
	 * Generated SerialVersionUID
	 */
	private static final long serialVersionUID = 140927156222806194L;


	public static void main(String args[]){
		initialize();
	}
	

	@Override
	public void startUp() {
		this.addScene(new BrainTouch(this, "BraiTouch"));
		
	}

}
