package iFisher;
import org.powerbot.script.Filter;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.Skills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Script.Manifest(name="iFisher", description="Fishes at various places")

public class iFisher extends PollingScript<ClientContext> {
	
	private List<Task> taskList = new ArrayList<Task>();
	@Override
	public void start(){
		System.out.println("iFisher Alpha 1.0 Running");
		taskList.addAll(Arrays.asList(new Fish(ctx), new Drop(ctx)));
	}
	@Override
	public void poll() {
		for (Task task : taskList) {
			if(task.activate()){
				task.execute();
				
			}
		}
		
	}
}
