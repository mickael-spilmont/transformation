package transforms;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.beans.value.WritableValue;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Rotation extends Rotate implements Transformation{

	double angle;
	double pivotXx;
	double pivotYy;
	
	public double getAnglee() {
		return angle;
	}

	public double getPivotXx() {
		return pivotXx;
	}

	public double getPivotYy() {
		return pivotYy;
	}

	public Rotation(double angle, double cx, double cy) {
        this.setAngle(angle);
        this.setPivotX(cx);
        this.setPivotY(cy);
        this.angle = angle;
        this.pivotXx = cx;
        this.pivotYy = cy;
    }

    @Override
    public boolean estIdentite() {
        return this.getAngle() == 0.0;
    }

    @Override
    public List<KeyFrame> getKeyFrame(Duration d) {
        ArrayList<KeyFrame> list = new ArrayList<KeyFrame>();
        if (d != Duration.seconds((double)0.0)) {
            list.add(new KeyFrame(Duration.seconds((double)0.0), new KeyValue[]{new KeyValue((WritableValue)this.angleProperty(), (Object)0.0)}));
        }
        list.add(new KeyFrame(d, new KeyValue[]{new KeyValue((WritableValue)this.angleProperty(), (Object)0.0)}));
        list.add(new KeyFrame(d.add(Duration.seconds((double)2.0)), new KeyValue[]{new KeyValue((WritableValue)this.angleProperty(), (Object)this.getAngle())}));
        return list;
    }

	

	

}
