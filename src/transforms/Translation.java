package transforms;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.beans.value.WritableValue;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Translation extends Translate implements Transformation{

	public Translation(double x, double y) {
        super(x, y);
    }

    @Override
    public boolean estIdentite() { 
        return this.getX() == 0.0 && this.getY() == 0.0;
    }

    @Override
    public List<KeyFrame> getKeyFrame(Duration d) {
        ArrayList<KeyFrame> list = new ArrayList<KeyFrame>();
        if (d != Duration.seconds((double)0.0)) {
            list.add(new KeyFrame(Duration.seconds((double)0.0), new KeyValue[]{new KeyValue((WritableValue)this.xProperty(), (Object)0.0), new KeyValue((WritableValue)this.yProperty(), (Object)0.0)}));
        }
        list.add(new KeyFrame(d, new KeyValue[]{new KeyValue((WritableValue)this.xProperty(), (Object)0.0), new KeyValue((WritableValue)this.yProperty(), (Object)0.0)}));
        list.add(new KeyFrame(d.add(Duration.seconds((double)2.0)), new KeyValue[]{new KeyValue((WritableValue)this.xProperty(), (Object)this.getX()), new KeyValue((WritableValue)this.yProperty(), (Object)this.getY())}));
        return list;
    }
}

	
