package transforms;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.beans.value.WritableValue;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

public class Homothetie extends Scale implements Transformation{

	double scaleY;
	double scaleX;
	
	public Homothetie(double scale) {
		super(scale,0.0,0.0);
	}
	
	public Homothetie(double scaleX,double scaleY) {
		super(scaleX,scaleY);
		this.scaleY = scaleX;
		this.scaleX = scaleY;
	}
	
	public double getScaleY() {
		return scaleY;
	}

	public double getScaleX() {
		return scaleX;
	}

	public boolean estIdentite() {
		return this.getX() == 1.0 && this.getY() == 1.0;
	}
	
	public List<KeyFrame> getKeyFrame(Duration dernier){
		ArrayList<KeyFrame>list = new ArrayList<>();
		
		if (dernier != Duration.seconds((double)0.0)) {
            list.add(new KeyFrame(Duration.seconds((double)0.0), new KeyValue[]{new KeyValue((WritableValue)this.xProperty(), (Object)1.0), new KeyValue((WritableValue)this.yProperty(), (Object)1.0)}));
        }
        list.add(new KeyFrame(dernier, new KeyValue[]{new KeyValue((WritableValue)this.xProperty(), (Object)1.0), new KeyValue((WritableValue)this.yProperty(), (Object)1.0)}));
        list.add(new KeyFrame(dernier.add(Duration.seconds((double)2.0)), new KeyValue[]{new KeyValue((WritableValue)this.xProperty(), (Object)this.getX()), new KeyValue((WritableValue)this.yProperty(), (Object)this.getY())}));
        return list;
    }
		
		
	}
	
