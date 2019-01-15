package transforms;

import java.util.Collection;

import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class MotifConcret extends Group
implements Motif{
	
	private Polyline pl;

	MotifConcret(Collection<Double> points) {
		
		pl = new Polyline();
		pl.getPoints().addAll(points);
	}
	@Override
	public Motif clone() {
		return new MotifConcret (pl.getPoints());
	}

	@Override
	public ObservableList<Double> getPoints() {
		return pl.getPoints();
	}

	@Override
	public DoubleProperty getStrokeWidthProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStroke(Color color) {
		pl.setStroke(color);
	}

	@Override
	public Group toGroup() {
		// TODO Auto-generated method stub
		return null;
	}
}
