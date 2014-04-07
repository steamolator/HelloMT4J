package MCI_BrainTouch;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.metal.MetalToggleButtonUI;

import org.mt4j.*;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.components.visibleComponents.widgets.buttons.MTImageButton;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;


public class BrainTouch extends AbstractScene{
	
	private MTApplication pApplet;
 
	public BrainTouch(final MTApplication mtApplication, String name) {
		super(mtApplication, name);
		pApplet = mtApplication;
		this.setClearColor(new MTColor(146, 150, 188, 255));
		this.registerGlobalInputProcessor(new CursorTracer(mtApplication, this));
		// TODO Auto-generated constructor stub
		
		PImage keyboardImg = mtApplication.loadImage("MCI_BrainTouch/keyboard.png");
		MTImageButton addKeyboard = new MTImageButton(keyboardImg, mtApplication);
		addKeyboard.setNoStroke(true);
		addKeyboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ae.getID()) {
				case TapEvent.BUTTON_CLICKED:
					createKeyboard(mtApplication);
				}
				
			}
		});
		
		this.getCanvas().addChild(addKeyboard);
		
		addKeyboard.setPositionGlobal(new Vector3D(pApplet.width - addKeyboard.getWidthXY(TransformSpace.GLOBAL) - 5, pApplet.height - addKeyboard.getHeightXY(TransformSpace.GLOBAL) - 5, 0));
		
	}
	
	
	
	public void createTextArea(String text)
	{
		MTTextArea textArea = new MTTextArea(pApplet, FontManager.getInstance().createFont(pApplet, "arial.ttf", 50,new MTColor(255, 255, 255, 255), new MTColor(255, 255, 255, 255)));
		textArea.setText(text);
		this.getCanvas().addChild(textArea);
		textArea.setNoFill(true);
		textArea.setNoStroke(true);
		textArea.setPositionGlobal(new Vector3D(pApplet.width/2f, pApplet.height/2f));
	}
	
	public void createKeyboard(MTApplication mtApplication) {
		
		Keyboard keyboard = new Keyboard(mtApplication);
		this.getCanvas().addChild(keyboard);
		
		
	}
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		
	}
	
	

}
