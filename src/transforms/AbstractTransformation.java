package transforms;

import java.util.List;

import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.transform.Transform;
import javafx.util.Duration;

public abstract class AbstractTransformation implements Transformation {
	
	protected Transform transform ;
	
	public AbstractTransformation(Transform transform) {
		
	}
	
	public void addKeyFrameStop(Timeline timeline, Duration timeTo) {
		
	}
	
 	public void animationSpécific(Timeline timeline, Duration timeFrom, Duration timeTo, transforms.DrawContext drawContext){	
 	}
	
	protected Node getTips() {
		return null;
		
	}
	
	Transform getTransform() {
		return transform;
		
	}
	
	List <Transform> getTransforms(){
		return null;
		
	}
}