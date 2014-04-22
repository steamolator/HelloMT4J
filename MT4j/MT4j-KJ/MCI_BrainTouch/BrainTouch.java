package MCI_BrainTouch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.mt4j.MTApplication;
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
		initKeyboardButtons(mtApplication); 
		
	}
	
	public void initKeyboardButtons(final MTApplication mtApplication){
		PImage keyboardImg = mtApplication.loadImage("data/plus23.png");
		keyboardImg.resize(64, 64);
		//Keyboardbutton at the upper left corner
		final MTImageButton ulKeyboard = new MTImageButton(keyboardImg, mtApplication);
		ulKeyboard.setNoStroke(true);
		ulKeyboard.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ae.getID()) {
				case TapEvent.BUTTON_CLICKED:
					createKeyboard(mtApplication, ulKeyboard.getPosition(TransformSpace.GLOBAL));
				}
			}
		}); 
		this.getCanvas().addChild(ulKeyboard); 
		ulKeyboard.setPositionGlobal(new Vector3D(0 + ulKeyboard.getWidthXY(TransformSpace.GLOBAL) + 5,
				0 + ulKeyboard.getHeightXY(TransformSpace.GLOBAL) + 5,
				0));
		
		//Keyboardbutton at the upper right corner
		final MTImageButton urKeyboard = new MTImageButton(keyboardImg, mtApplication);
		urKeyboard.setNoStroke(true);
		urKeyboard.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ae.getID()) {
				case TapEvent.BUTTON_CLICKED:
					createKeyboard(mtApplication, urKeyboard.getPosition(TransformSpace.GLOBAL));
				}
			}
		}); 
		this.getCanvas().addChild(urKeyboard); 
		urKeyboard.setPositionGlobal(new Vector3D(pApplet.width - urKeyboard.getWidthXY(TransformSpace.GLOBAL) - 5,
				0 + urKeyboard.getHeightXY(TransformSpace.GLOBAL) + 5,
				0));
		
		//Keyboardbutton at the lower left corner
		final MTImageButton llKeyboard = new MTImageButton(keyboardImg, mtApplication);
		llKeyboard.setNoStroke(true);
		llKeyboard.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ae.getID()) {
				case TapEvent.BUTTON_CLICKED:
					createKeyboard(mtApplication, llKeyboard.getPosition(TransformSpace.GLOBAL));
				}	
			}
		});
				
		this.getCanvas().addChild(llKeyboard);
				
		llKeyboard.setPositionGlobal(new Vector3D(0 + llKeyboard.getWidthXY(TransformSpace.GLOBAL) + 5,
				pApplet.height - llKeyboard.getHeightXY(TransformSpace.GLOBAL) - 5,
				0));
				
		//Keyboardbutton at the lower right corner
		final MTImageButton lrKeyboard = new MTImageButton(keyboardImg, mtApplication);
		lrKeyboard.setNoStroke(true);
		lrKeyboard.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ae.getID()) {
				case TapEvent.BUTTON_CLICKED:
					createKeyboard(mtApplication, lrKeyboard.getPosition(TransformSpace.GLOBAL));
				}	
			}
		});
				
		this.getCanvas().addChild(lrKeyboard);
				
		lrKeyboard.setPositionGlobal(new Vector3D(pApplet.width - lrKeyboard.getWidthXY(TransformSpace.GLOBAL) - 5,
				pApplet.height - lrKeyboard.getHeightXY(TransformSpace.GLOBAL) - 5,
				0));
	}
	
	public void createTextArea(String text)
	{
		MTTextArea textArea = new MTTextArea(pApplet, 
				FontManager.getInstance().createFont(pApplet, "arial.ttf", 50,new MTColor(255, 255, 255, 255), 
						new MTColor(255, 255, 255, 255)));
		textArea.setText(text);
		this.getCanvas().addChild(textArea);
		textArea.setNoFill(true);
		textArea.setNoStroke(true);
		textArea.setPositionGlobal(new Vector3D(pApplet.width/2f, pApplet.height/2f));
	}
	
	public void createKeyboard(MTApplication mtApplication, Vector3D position) {
		Keyboard keyboard = new Keyboard(mtApplication);
		this.getCanvas().addChild(keyboard);
		keyboard.setPositionGlobal(position);
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
