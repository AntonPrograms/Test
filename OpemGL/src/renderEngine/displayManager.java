package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;;


public class displayManager {
	
	private static final int WIDTH = 600;
	private static final int HIEGHT = 800;
	private static final int FPS_CAP = 60;
	
	
	//___________________________________________________
	static ContextAttribs attribs  = 				//
		new ContextAttribs(3, 2)					//
		.withForwardCompatible(true)				//
		.withProfileCore(true);						//
	//____________________________________________________
	public static void createDisplay(){
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HIEGHT));
			Display.create(new PixelFormat(), attribs);
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GL11.glViewport(0, 0, WIDTH, HIEGHT);
		
		
	}
	
	
	public static void updateDisplay(){
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	public static void closeDisplay(){
		Display.destroy();
	}

}
