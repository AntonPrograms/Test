package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import renderEngine.displayManager;
import renderEngine.loader;
import renderEngine.rawModel;
import renderEngine.renderer;

public class mainGameLoop {
		public static void main(String[] arg){
			displayManager.createDisplay();
			
			loader load = new loader(); 
			renderer render = new renderer();
			
			
			
			float[] vertices = { 
					-0.5f, 0.5f, 0f, -0.5f, 
					-0.5f, 0f, 0.5f, -0.5f, 0f,
					0.5f, -0.5f, 0f, 0.5f, 0.5f, 
					0f, -0.5f, 0.5f, 0f
			};
			
			rawModel model = load.loadToVAO(vertices);

			
			while(!Display.isCloseRequested()){
				
				render.prepare();
				
				render.render(model);
				displayManager.updateDisplay();
				
				
			}
			
			load.cleanUP();
			
			
			
			displayManager.closeDisplay();
		}
}
