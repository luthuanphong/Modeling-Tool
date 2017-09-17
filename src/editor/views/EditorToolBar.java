package editor.views;

import editor.actions.ActionArc;
import editor.actions.ActionConfig;
import editor.actions.ActionCopy;
import editor.actions.ActionDelete;
import editor.actions.ActionExport;
import editor.actions.ActionImport;
import editor.actions.ActionNew;
import editor.actions.ActionPaste;
import editor.actions.ActionPlace;
import editor.actions.ActionRedo;
import editor.actions.ActionSelect;
import editor.actions.ActionToken;
import editor.actions.ActionTransition;
import editor.actions.ActionUndo;
import editor.canvas.Icons;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;

public class EditorToolBar extends ToolBar {
	private EditorWindow editor;
	private Button btnNew, btnImport, btnExport;
	private Button btnUndo, btnRedo, btnCopy, btnPaste, btnDelete;
	private Button btnSelect, btnPlace, btnTransition, btnArc, btnToken;
	private Button btnConfig;

	public EditorToolBar(EditorWindow editor) {
		this.editor = editor;
		initialize();
		setIcons();
		setAlts();
		setActions();
		getItems().addAll(btnNew, btnImport, btnExport, new Separator(), btnCopy, btnPaste, new Separator(), btnUndo,
				btnRedo, btnDelete, new Separator(), btnSelect, btnPlace, btnTransition, btnArc, btnConfig, btnToken);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		// -- Toolbar
		btnNew = new Button();
		btnImport = new Button();
		btnExport = new Button();
		btnCopy = new Button();
		btnPaste = new Button();
		btnUndo = new Button();
		btnRedo = new Button();
		btnDelete = new Button();
		btnSelect = new Button();
		btnPlace = new Button();
		btnTransition = new Button();
		btnArc = new Button();
		btnToken = new Button();
		btnConfig = new Button();
	}

	private void setIcons() {
		// -- Set Image
		btnNew.setGraphic(Icons.getImageNew());
		btnImport.setGraphic(Icons.getImageImport());
		btnExport.setGraphic(Icons.getImageExport());
		btnCopy.setGraphic(Icons.getImageCopy());
		btnPaste.setGraphic(Icons.getImagePaste());
		btnUndo.setGraphic(Icons.getImageUndo());
		btnRedo.setGraphic(Icons.getImageRedo());
		btnDelete.setGraphic(Icons.getImageDelete());
		btnSelect.setGraphic(Icons.getImageSelect());
		btnPlace.setGraphic(Icons.getImagePlace());
		btnTransition.setGraphic(Icons.getImageTransition());
		btnArc.setGraphic(Icons.getImageArc());
		btnToken.setGraphic(Icons.getImageToken());
		btnConfig.setGraphic(Icons.getImageConfig());
	}

	private void setAlts() {
		// -- Set Hover Text
		btnNew.setTooltip(new Tooltip("New"));
		btnImport.setTooltip(new Tooltip("Import"));
		btnExport.setTooltip(new Tooltip("Export"));
		btnCopy.setTooltip(new Tooltip("Copy"));
		btnPaste.setTooltip(new Tooltip("Paste"));
		btnUndo.setTooltip(new Tooltip("Undo"));
		btnRedo.setTooltip(new Tooltip("Redo"));
		btnDelete.setTooltip(new Tooltip("Delete"));
		btnSelect.setTooltip(new Tooltip("Select"));
		btnPlace.setTooltip(new Tooltip("Place"));
		btnTransition.setTooltip(new Tooltip("Transition"));
		btnArc.setTooltip(new Tooltip("Arc"));
		btnToken.setTooltip(new Tooltip("Token"));
		btnConfig.setTooltip(new Tooltip("Config"));
	}

	private void setActions() {
		// -- Actions Menu
		btnNew.setOnAction(e -> new ActionNew(editor).actionPerformed(e));
		btnImport.setOnAction(e -> new ActionImport(editor).actionPerformed(e));
		btnExport.setOnAction(e -> new ActionExport(editor).actionPerformed(e));
		btnCopy.setOnAction(e -> new ActionCopy(editor).actionPerformed(e));
		btnPaste.setOnAction(e -> new ActionPaste(editor).actionPerformed(e));
		btnDelete.setOnAction(e -> new ActionDelete(editor).actionPerformed(e));
		btnUndo.setOnAction(e -> new ActionUndo(editor).actionPerformed(e));
		btnRedo.setOnAction(e -> new ActionRedo(editor).actionPerformed(e));
		btnSelect.setOnAction(e -> new ActionSelect(editor).actionPerformed(e));
		btnPlace.setOnAction(e -> new ActionPlace(editor).actionPerformed(e));
		btnTransition.setOnAction(e -> new ActionTransition(editor).actionPerformed(e));
		btnArc.setOnAction(e -> new ActionArc(editor).actionPerformed(e));
		btnToken.setOnAction(e -> new ActionToken(editor).actionPerformed(e));
		btnConfig.setOnAction(e -> new ActionConfig(editor).actionPerformed(e));
	}

	public Button getButtonSelect() {
		return btnSelect;
	}
}
