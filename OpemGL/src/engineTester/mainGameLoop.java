package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import renderEngine.displayManager;
import renderEngine.loader;
import renderEngine.rawModel;
import renderEngine.renderer;
import shaders.StaticShader;

public class mainGameLoop {
		public static void main(String[] arg){
			displayManager.createDisplay();
			
			loader load = new loader(); 
			renderer render = new renderer();
			
			StaticShader shader = new StaticShader();
			
			
			
			
			float[] vertices = {
					  -0.5f, 0.5f, 0,    // V0
					  -0.5f, -0.5f, 0,   // V1
					  0.5f, -0.5f, 0,    // V2
					  0.5f, 0.5f, 0f     // V3
					};
			int[] indices = {
					  0,1,3,  //Top left Triangle
					  3,1,2   //Bottom right Triangle
					};
			
			
			
			rawModel model = load.loadToVAO(vertices, indices);
			

			
			while(!Display.isCloseRequested()){
				
				render.prepare();
				shader.start();
				render.render(model);
				shader.stop();
				displayManager.updateDisplay();
				
				
			}
			
			shader.cleanUP();
			
			load.cleanUP();
			
			
			
			displayManager.closeDisplay();
		}
}
