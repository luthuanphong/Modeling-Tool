package editor;

import editor.views.EditorWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class EditorMain extends Application {
	private static Stage stage;
	
	@Override
	public void start(Stage stage) throws Exception {
		setStage(stage);		
		new EditorWindow(stage);
	}

	public static Stage getStage() {
		return stage;
	}
	
	private void setStage(Stage stage) {
		EditorMain.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
