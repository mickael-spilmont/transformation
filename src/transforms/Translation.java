package transforms;

import java.util.List;

import javafx.animation.KeyValue;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

public class Translation extends AbstractTransformation{

	public Translation(Transform transform) {
		super(transform);

	}

	Translation(double x, double y) {
		super(new Translate(x, y));
	}

	void addStartKeyValues(List<KeyValue> keyValues) {

	}

	void addStopKeyValues(List<KeyValue> keyValues) {

	}

	Translate getTranslate() {
		return (Translate) transform;
	}

	String showStartKeyValues() {
		return null;

	}

	String showStopKeyValues() {
		return null;

	}
}
