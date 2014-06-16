package iFisher;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.ClientContext;
public class Fish extends Task<ClientContext>{
	private int[] fishingIds = {14882};
	public Fish(ClientContext ctx) {
		super(ctx);
	}
	@Override
	public boolean activate(){
		return ctx.backpack.select().count() < 27 // See if inventory is less than 28
			&& !ctx.objects.select().id(fishingIds).isEmpty() //Check if there are fish
			&& ctx.players.local().animation() == -1; // Check if the player is idle
			
	}
	@Override
	public void execute(){
		GameObject fishingspot = ctx.objects.nearest().poll();
		if(fishingspot.inViewport()){ // If the fishing sopt is in view
			fishingspot.interact("Net"); // Fish
			fishingspot.interact("Cage"); // Cray Fish
			
			
		} else { // if not in view
			ctx.movement.step(fishingspot); //move towards it
			ctx.camera.turnTo(fishingspot); //turn camera
			
		}
		
	}
}
