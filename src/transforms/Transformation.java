package transforms;


import java.util.List;

import javafx.animation.KeyFrame;
import javafx.scene.transform.Transform;
import javafx.util.Duration;

interface Transformation {
		
	 default public Transform getTransform() {
		return (Transform)this;
	}
	 
	 public boolean estIdentite();
	 
	 public List<KeyFrame> getKeyFrame(Duration d);
}
