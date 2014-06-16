
package iFisher;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

public class Drop extends Task<ClientContext>{
	private int[] fishID = {317,13435};
	public Drop(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() == 27; // If backpack is full
	}

	@Override
	public void execute() {
		for(Item i : ctx.backpack.id(fishID)){ //for each item in backpack that is fish
			i.interact("Drop"); //drop
			System.out.println("iFisher Alpha 1.0 Dropping");
		}
		
	}
}

