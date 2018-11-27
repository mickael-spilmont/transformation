package transforms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import static transforms.Constants.*;

public class Grille extends Group {

	Line axeX;
	Line axeY;
	Line lx;
	Line ly;

	public Grille(double d) {
		super();

		axeX = new Line(ZERO_X, MIN_Y, ZERO_X, MAX_Y);
		axeX.setStroke(Color.BLACK);
		axeX.setStrokeWidth(2.0 / d);

		axeY = new Line(MIN_X, ZERO_Y, MAX_X, ZERO_Y);
		axeY.setStroke(Color.BLACK);
		axeY.setStrokeWidth(2.0 / d);

		this.getChildren().addAll(axeX, axeY);

		double x = MIN_X + ((ZERO_X - MIN_X) % INC_X) ;
		while (x <= MAX_X) {
			if (x != ZERO_X) {
				lx = new Line(x, MIN_Y, x, MAX_Y);
				lx.setStroke(Color.GREY);
				lx.setStrokeWidth(1.0 / d);
				this.getChildren().add(lx);
			}
			x += INC_X;
		}

		double y = MIN_Y + ((ZERO_Y - MIN_Y) % INC_Y) ;
		while (y <= MAX_Y) {
			if (y != ZERO_Y) {
				ly = new Line(MIN_X, y, MAX_X, y);
				ly.setStroke(Color.GREY);
				ly.setStrokeWidth(1.0 / d);
				this.getChildren().add(ly);
			}
			y += INC_Y;
		}
	}
}
