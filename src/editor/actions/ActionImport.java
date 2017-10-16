package editor.actions;

import java.io.File;

import editor.utils.DataImport;
import editor.views.EditorWindow;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ActionImport implements Action {
	private EditorWindow editor;
	private FileChooser chooser;
	
	public ActionImport(EditorWindow editor) {
		this.editor = editor;
		this.chooser = new FileChooser();
		this.chooser.getExtensionFilters().add(new ExtensionFilter("Kwsn files", "*.kwsn"));
		this.chooser.getExtensionFilters().add(new ExtensionFilter("Topology files", "*.topo"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		File chosenFile = this.chooser.showOpenDialog(this.editor.getStage());
		if(chosenFile != null) {
			this.editor.getBoard().clear();
			DataImport.Import(chosenFile,this.editor);
		}
	}
}
