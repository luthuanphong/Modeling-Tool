package editor.views;

import editor.actions.ActionArc;
import editor.actions.ActionCopy;
import editor.actions.ActionDelete;
import editor.actions.ActionExport;
import editor.actions.ActionImport;
import editor.actions.ActionNew;
import editor.actions.ActionPaste;
import editor.actions.ActionPlace;
import editor.actions.ActionQuit;
import editor.actions.ActionRedo;
import editor.actions.ActionSelect;
import editor.actions.ActionToken;
import editor.actions.ActionTransition;
import editor.actions.ActionUndo;
import editor.canvas.Icons;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

public class EditorMenuBar extends MenuBar {
	private MenuItem fileNew, fileImport, fileExport, fileQuit;
	private MenuItem editCopy, editPaste, editUndo, editRedo, editDelete;
	private MenuItem toolSelect, toolPlace, toolTransition, toolArc, toolToken;
	
	public EditorMenuBar(EditorWindow editor) {		
		// -- Menu
		Menu menuFile = new Menu("_File");
		Menu menuEdit = new Menu("_Edit");
		Menu menuTool = new Menu("_Tool");
 
		// -- Menu File
		fileNew = new MenuItem("_New", Icons.getImageNew());
		fileImport = new MenuItem("_Import", Icons.getImageImport());
		fileExport = new MenuItem("_Export", Icons.getImageExport());
		fileQuit = new MenuItem("_Quit");
		fileQuit.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
		menuFile.getItems().addAll(fileNew, fileImport, fileExport, fileQuit);

		// ---- Menu Edit
		editUndo = new MenuItem("_Undo", Icons.getImageUndo());
		editRedo = new MenuItem("_Redo", Icons.getImageRedo());
		editCopy = new MenuItem("_Copy", Icons.getImageCopy());
		editPaste = new MenuItem("_Paste", Icons.getImagePaste());
		editDelete = new MenuItem("_Delete", Icons.getImageDelete());

		editUndo.setAccelerator(KeyCombination.keyCombination("Ctrl+Z"));
		editRedo.setAccelerator(KeyCombination.keyCombination("Ctrl+Y"));
		editCopy.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
		editPaste.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
		editDelete.setAccelerator(KeyCombination.keyCombination("Delete"));

		menuEdit.getItems().addAll(editUndo, editRedo, editCopy, editPaste, editDelete);

		toolSelect = new MenuItem("_Select", Icons.getImageSelect());
		toolPlace = new MenuItem("_Place", Icons.getImagePlace());
		toolTransition = new MenuItem("_Transition", Icons.getImageTransition());
		toolArc = new MenuItem("_Arc", Icons.getImageArc());
		toolToken = new MenuItem("Token/_Fire transitions", Icons.getImageToken());
		menuTool.getItems().addAll(toolSelect, toolPlace, toolTransition, toolArc, toolToken);

		// -- Actions Menu		
		fileNew.setOnAction(e -> new ActionNew(editor).actionPerformed(e));
		fileImport.setOnAction(e -> new ActionImport(editor).actionPerformed(e));
		fileExport.setOnAction(e -> new ActionExport(editor).actionPerformed(e));
		fileQuit.setOnAction(e -> new ActionQuit(editor).actionPerformed(e));
		
		editCopy.setOnAction(e -> new ActionCopy(editor).actionPerformed(e));
		editPaste.setOnAction(e -> new ActionPaste(editor).actionPerformed(e));
		editDelete.setOnAction(e -> new ActionDelete(editor).actionPerformed(e));
		editUndo.setOnAction(e -> new ActionUndo(editor).actionPerformed(e));
		editRedo.setOnAction(e -> new ActionRedo(editor).actionPerformed(e));
		
		toolSelect.setOnAction(e -> new ActionSelect(editor).actionPerformed(e));
		toolPlace.setOnAction(e -> new ActionPlace(editor).actionPerformed(e));
		toolTransition.setOnAction(e -> new ActionTransition(editor).actionPerformed(e));
		toolArc.setOnAction(e -> new ActionArc(editor).actionPerformed(e));
		toolToken.setOnAction(e -> new ActionToken(editor).actionPerformed(e));
		
		getMenus().addAll(menuFile, menuEdit, menuTool);
	}
	
	public MenuItem getEditPaste() {
		return editPaste;
	}	
}
