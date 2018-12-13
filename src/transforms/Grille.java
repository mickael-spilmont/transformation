package transforms;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static transforms.Constants.*;

class Grille extends Group {

	Line axeX;
	Line axeY;
	Line lx;
	Line ly;

	Text t;


	public Grille(double d) {
		super();
		System.out.println("ok");
		axeX = new Line(ZERO_X, MIN_Y, ZERO_X, MAX_Y);
		axeX.setStroke(Color.BLACK);
		axeX.setStrokeWidth(2.0 / d);

		axeY = new Line(MIN_X, ZERO_Y, MAX_X, ZERO_Y);
		axeY.setStroke(Color.BLACK);
		axeY.setStrokeWidth(2.0 / d);
		
		t=new Text(-1, 0.5, "-0");
		t.setFont(new Font(1));
		t.setScaleX(0.4);
		t.setScaleY(0.4);

		this.getChildren().addAll(axeX, axeY, t);

		double x = MIN_X + ((ZERO_X - MIN_X) % INC_X)+1 ;
		while (x <= MAX_X-1) {
			if (x != ZERO_X) {
				lx = new Line(x, MIN_Y, x, MAX_Y);
				lx.setStroke(Color.GREY);
				lx.setStrokeWidth(1.0 / d);
				
				t = new Text(x-1, 0.5, String.valueOf((int)x));
				t.setFont(new Font(1));
				t.setScaleX(0.4);
				t.setScaleY(0.4);
				

				this.getChildren().addAll(lx,t);
			}
			x += INC_X;
		}

		double y = MIN_Y + ((ZERO_Y - MIN_Y) % INC_Y)+1 ;
		while (y <= MAX_Y-1) {
			if (y != ZERO_Y) {
				ly = new Line(MIN_X, y, MAX_X, y);
				ly.setStroke(Color.GREY);
				ly.setStrokeWidth(1.0 / d);
				
				t = new Text(-0.7, y+0.5, String.valueOf((int)-y));
				t.setFont(new Font("Arial", 1));
				t.setScaleX(0.4);
				t.setScaleY(0.4);
				System.out.println((int)y);
				this.getChildren().addAll(ly,t);
			}
			y += INC_Y;
		}
	}
}
