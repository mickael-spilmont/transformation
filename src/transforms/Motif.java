package transforms;

import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public interface Motif extends Cloneable{

	Motif clone();

	ObservableList<Double> getPoints();

	DoubleProperty getStrokeWidthProperty();

	void setStroke(Color color);

	Group toGroup();
}
