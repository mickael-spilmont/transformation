package transforms;

import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import static transforms.Constants.*;

class Maison extends Group {

	static final double SCALE = 1.5;
	static final double X0 = ZERO_X;
	static final double X1 = ZERO_X + SCALE * INC_X;
	static final double Y0 = ZERO_Y;
	static final double Y1 = ZERO_Y - SCALE * INC_Y;
	static final double MIDDLE_X = (X0 + X1)/2.0;
	static final double Y2 = ZERO_Y - 3 * SCALE * INC_Y / 2;
	static final double D0 = MIDDLE_X;
	static final double D1 = ZERO_X + 3 * SCALE * INC_X / 4;
	static final double DY = ZERO_Y - 3 * SCALE * INC_Y / 4;

	final static double CENTER_X = SCALE * INC_X / 2;
	final static double CENTER_Y = -3 * SCALE * INC_Y / 4;

	private Polyline pl;

	Maison(double d) {
		super();
		pl = new Polyline();
		pl.getPoints().addAll(
				X0, Y1,
				MIDDLE_X, Y2,
				X1, Y1,
				X1, Y0,
				D0, Y0,
				D0, DY,
				D1, DY,
				D1, Y0,
				X0, Y0,
				X0, Y1
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
