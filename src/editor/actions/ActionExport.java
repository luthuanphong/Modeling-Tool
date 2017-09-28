package editor.actions;

import java.io.File;

import editor.utils.DataExport;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


public class ActionExport implements Action {
	private EditorWindow editor;
	private FileChooser choser;

	public ActionExport(EditorWindow editor) {
		this.editor = editor;
		this.choser = new FileChooser();
		this.choser.getExtensionFilters().add(new ExtensionFilter("Topology files", "*.topo"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File selectedFilePath = this.choser.showSaveDialog(this.editor.getStage());
		DataExport.Export(selectedFilePath.getAbsolutePath(),
				this.editor.getBoard().getPlaceClip(), 
				this.editor.getBoard().getArcClip());
	}
}
