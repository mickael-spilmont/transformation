package transforms;


import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Transform;

public class Grille extends Group {


        public Grille() {
            Line axeX = new Line(0.0, -10.0, 0.0, 10.0);
            axeX.setStroke((Paint)Color.RED);
            axeX.setStrokeWidth(0.05);
            Line axeY = new Line(-10.0, 0.0, 10.0, 0.0);
            axeY.setStroke((Paint)Color.BLUE);
            axeY.setStrokeWidth(0.05);
            Text text1 = new Text(0.2,0,"0");
            text1.setFont(new Font("Serif", 0.5));
            text1.setScaleX(0.5);
            text1.setScaleY(-0.5);
            text1.setY(-0.2);
            text1.setTextAlignment(TextAlignment.CENTER);
            this.getChildren().add(text1);
            
            this.getChildren().addAll((Node[])new Node[]{axeX, axeY});
            
            for (double x = -9.0; x <= 9.0; x += 1.0) {
            	if(x == 0) continue;
                Line ligneX = new Line(x, -10.0, x, 10.0);
                ligneX.setStrokeWidth(0.025);
                ligneX.setStroke((Paint)Color.LIGHTGREY);
                
                
                Text text = new Text(x+0.0,0, String.format("%3.0f",x));
                text.setFont(new Font("Serif", 0.5));
                
                text.setY(-0.2);
                text.setScaleX(0.5);
                text.setScaleY(-0.5);
                text.setTextAlignment(TextAlignment.CENTER);
               
                
                this.getChildren().addAll(text,(Node)ligneX);
               
                
            }
            for (double y = -9.0; y <= 9.0; y += 1.0) {
                Line ligneY = new Line(-10.0, y, 10.0, y);
                if(y == 0.0) continue;
                ligneY.setStroke((Paint)Color.LIGHTGREY);
                ligneY.setStrokeWidth(0.05);
                
                Text text = new Text(0,y-0.2, String.valueOf((int)y));
                text.setFont(new Font("Serif", 0.5));
                
               
                text.setScaleX(0.5);
                text.setScaleY(-0.5);
                text.setX(0.2);
                text.setTextAlignment(TextAlignment.CENTER);
                
                this.getChildren().addAll(text,(Node)ligneY);
            }
            this.getTransforms().add((Transform)Constants.SCREEN_TRANSFORM);
        }
}
