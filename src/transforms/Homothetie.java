package transforms;

import java.util.List;

import javafx.animation.KeyValue;
import javafx.scene.Node;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;

public class Homothetie extends AbstractTransformation{

	public Homothetie(Transform transform) {
		super(transform);
	}
	
	public Homothetie(double scale) {
		super(new Scale(scale,scale));
	}
	
	public Homothetie(double scale, double pivotX, double pivotY) {
		super(new Scale(scale, scale, pivotX, pivotY));
		
	}
	
	void addStartKeyValues(List<KeyValue> KeyValues) {
		
	}
	
	Scale getScale() {
		return (Scale) transform;
		
	}
	
	double 	getStrokeScale() {
		return 0;
		
	}
	
	protected Node getTips() {
		return null;
		
	}
	
	String showStartKetValues() {
		return null;
		
	}
	
	String 	showStopKeyValues() {
		return null;
		
	}
}
