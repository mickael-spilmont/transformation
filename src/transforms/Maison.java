package transforms;

import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import static transforms.Constants.*;

class Maison extends Group {

	private static final double SCALE = 1.5;
	private static final double X0 = ZERO_X;
	private static final double X1 = ZERO_X + SCALE * INC_X;
	private static final double Y0 = ZERO_Y;
	private static final double Y1 = ZERO_Y - SCALE * INC_Y;
	private static final double MIDDLE_X = (X0 + X1)/2.0;
	private static final double Y2 = ZERO_Y - 3 * SCALE * INC_Y / 2;
	private static final double D0 = MIDDLE_X;
	private static final double D1 = ZERO_X + 3 * SCALE * INC_X / 4;
	private static final double DY = ZERO_Y - 3 * SCALE * INC_Y / 4;

	final static double CENTER_X = SCALE * INC_X / 2;
	final static double CENTER_Y = -3 * SCALE * INC_Y / 4;

	private Polyline pl;

	Maison(double d) {
		super();
		pl = new Polyline();
		pl.getPoints().addAll(
				X0, Y1,//a
				MIDDLE_X, Y2,//b
				X1, Y1,//c
				X1, Y0,//d
				D0, Y0,//e
				D0, DY,//f
				D1, DY,//g
				D1, Y0,//h
				X0, Y0,//i
				X0, Y1//a
				);
		pl.setStroke(Color.BLUE);
		pl.setStrokeWidth(2.0 / d);
		this.getChildren().add(pl);
	}

	public double getCenterX() {
		return this.getLayoutBounds().getWidth();
	}

	public double getCenterY() {
		return this.getLayoutBounds().getHeight();
	}

	void setStroke(Color color) {
		pl.setStroke(color);
	}

	public ObservableList<Double> getPoints() {
		return pl.getPoints();
	}
}
