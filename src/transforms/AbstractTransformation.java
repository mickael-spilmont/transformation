package transforms;

import javafx.animation.Timeline;
import javafx.scene.transform.Transform;
import javafx.util.Duration;

public abstract class AbstractTransformation implements Transformation {
	
	public AbstractTransformation(Transform transform) {
		
	}
	
	public void addKeyFrameStop(Timeline timeline, Duration timeTo) {
		
	}
	
 	//public void animationSpécific(Timeline timeline, Duration timeFrom, Duration timeTo, transforms.DrawContext drawContext){	
 	//}
	
}