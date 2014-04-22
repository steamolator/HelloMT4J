package MCI_BrainTouch;

import org.mt4j.components.visibleComponents.widgets.keyboard.MTTextKeyboard;

import processing.core.PApplet;

public class Keyboard extends MTTextKeyboard {
	
	public Keyboard(PApplet pApplet) {
		super(pApplet);
		this.createNewTextArea();
	}
	

}
