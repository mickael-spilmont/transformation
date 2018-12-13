package transforms;

import java.util.List;

import javafx.animation.KeyValue;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;

public class Rotation extends AbstractTransformation{

	public Rotation(Transform transform) {
		super(transform);
	}
	
	public Rotation(double angle, double cx, double cy){
		super(new Rotate(angle, cx, cy));
	}

	void addStartKeyValues(List<KeyValue> keyValues) {
		
	}
	
	void addStopKeyValues(List<KeyValue> keyValues) {
		
	}
	
	protected Node getTips() {
		return null;
		
	}
	
	String showStartKeyValues() {
		return null;
		
	}
	
	String showStopKeyValues() {
		return null;
		
	}
	
}
