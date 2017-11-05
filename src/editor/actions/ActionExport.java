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
		this.choser.getExtensionFilters().add(new ExtensionFilter("Kwsn file", "*.kwsn"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File selectedFilePath = this.choser.showSaveDialog(this.editor.getStage());
		if(selectedFilePath != null) {
			if(IsExtension(selectedFilePath.getAbsolutePath(), "topo")) {
				DataExport.Export(selectedFilePath.getAbsolutePath(),
						this.editor.getBoard().getPlaceClip(), 
						this.editor.getBoard().getArcClip(),
						this.editor);
			} else if(IsExtension(selectedFilePath.getAbsolutePath(), "kwsn")) {
				DataExport.ExportKwsn(selectedFilePath.getAbsolutePath(),
						this.editor.getBoard().getPlaceClip(), 
						this.editor.getBoard().getArcClip(),
						this.editor);
			}
		}
	}
	
	private static boolean IsExtension (String filePath , String expectedExrension) {
		String[] pathArray = filePath.split("\\.");
		return pathArray[pathArray.length - 1].equals(expectedExrension);
	}
}
