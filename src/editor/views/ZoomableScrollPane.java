package editor.views;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.transform.Scale;

public class ZoomableScrollPane extends ScrollPane {
	
	private Group Zoom;
	private Scale scale;
	private double zoomSize  = 1;
	
	public ZoomableScrollPane(Node content) {
		Zoom = new Group();
		Group contentGroup = new Group();
		contentGroup.getChildren().add(Zoom);
		Zoom.getChildren().add(content);
		setContent(contentGroup);
		scale = new Scale(zoomSize,zoomSize,0,0);
		Zoom.getTransforms().add(scale);
	}

	public void ZoomIn() {
		if(this.zoomSize < 5) {
			this.zoomSize += 0.5;
			this.Zoom.setScaleX(this.zoomSize);
			this.Zoom.setScaleY(this.zoomSize);
		}
	}
	
	public void ZoomOut() {
		if(this.zoomSize > 1) {
			this.zoomSize -= 0.5;
			this.Zoom.setScaleX(this.zoomSize);
			this.Zoom.setScaleY(this.zoomSize);
		}
	}
}
