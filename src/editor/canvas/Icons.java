package editor.canvas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Icons {
	
	public static Image IntermediateSensor =new Image("res/img/normalsensor.png");
	
	public static Image SourceSensor = new Image("res/img/sourcesensor.png");
	
	public static Image SinkSensor = new Image("res/img/sinksensor.png");
	
	public static ImageView getImageNew() {
		return new ImageView(new Image("res/img/new.png"));
	}

	public static ImageView getImageImport() {
		return new ImageView(new Image("res/img/import.png"));
	}

	public static ImageView getImageExport() {
		return new ImageView(new Image("res/img/export.png"));
	}

	public static ImageView getImageCopy() {
		return new ImageView(new Image("res/img/copy.png"));
	}

	public static ImageView getImagePaste() {
		return new ImageView(new Image("res/img/paste.png"));
	}

	public static ImageView getImageUndo() {
		return new ImageView(new Image("res/img/undo.png"));
	}
	
	public static ImageView getImageRedo() {
		return new ImageView(new Image("res/img/redo.png"));
	}

	public static ImageView getImageDelete() {
		return new ImageView(new Image("res/img/delete.png"));
	}

	public static ImageView getImageSelect() {
		return new ImageView(new Image("res/img/select.png"));
	}

	public static ImageView getImagePlace() {
		return new ImageView(new Image("res/img/place.png"));
	}

	public static ImageView getImageTransition() {
		return new ImageView(new Image("res/img/transition.png"));
	}

	public static ImageView getImageArc() {
		return new ImageView(new Image("res/img/arc.png"));
	}

	public static ImageView getImageToken() {
		return new ImageView(new Image("res/img/token.png"));
	}
	
	public static ImageView getImageConfig() {
		return new ImageView(new Image("res/img/config.png"));
	}
	
	public static ImageView getImageZoomIn() {
		return new ImageView(new Image("res/img/zoom-in.png"));
	}
	
	public static ImageView getImageZoomOut() {
		return new ImageView(new Image("res/img/zoom-out.png"));
	}
}
