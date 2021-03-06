package editor.views;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import editor.canvas.Board;
import editor.canvas.Clip;
import editor.commands.Command;
import editor.commands.CommandStack;
import editor.tools.Tool;
import editor.tools.ToolSelect;
import editor.utils.Clipboard;
import editor.utils.ClipboardListener;
import editor.utils.EditorInterface;
import editor.utils.InitializeData;
import editor.utils.Selection;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditorWindow extends VBox implements EditorInterface, ClipboardListener {

	
	private Board board;
	private Canvas canvas;
	private Selection selection;
	private Tool tool;
	private CommandStack commandStack;
	private EditorMenuBar menuBar;
	private EditorToolBar toolBar;
	private GraphicsContext ctx;
	private InitializeData data;
	private ZoomableScrollPane scrollBar;
	private Stage stage;
	public static final String APP_NAME = "Modeling Tool";
	private double ZoomSize = 1;
	public static AtomicInteger uniqueId = new AtomicInteger();

	public EditorWindow(Stage stage) {
		// -- Setup
		this.stage = stage;
		board = new Board();
		selection = new Selection();
		canvas = new Canvas(6000, 6000);
		canvas.setScaleX(this.ZoomSize);
		canvas.setScaleY(this.ZoomSize);
		tool = new ToolSelect();
		ctx = canvas.getGraphicsContext2D();
		Clipboard.getInstance().addListener(this);
		commandStack = new CommandStack();		
		
		menuBar = new EditorMenuBar(this);
		toolBar = new EditorToolBar(this);
		scrollBar = new ZoomableScrollPane(canvas);
		scrollBar.setPrefSize(1024, 640);
		scrollBar.setMaxSize(5000, 5000);
		scrollBar.setFitToHeight(false);
		scrollBar.setFitToWidth(false);
		data = new InitializeData();
		data.setSensorClip(board.getSensorClip());
		data.setChannelClip(board.getChannelClip());
		data.setOriginSensorClip(board.getPlaceClip());
		data.setOriginChannelClip(board.getChannelClip());
		// -- Mouse Events
		updateBoard();
		canvas.setOnMousePressed((e) -> {
			Command command = tool.press(this, e);
			if (command != null) {
				command.execute();
				commandStack.addCommand(command);
				updateBoard();
			}
		});
		canvas.setOnMouseDragged((e) -> {
			tool.drag(this, e);
			tool.drawFeedback(this, ctx);
		});
		canvas.setOnMouseReleased((e) -> {
			Command command = tool.release(this, e);
			if (command != null) {
				command.execute();
				commandStack.addCommand(command);
				updateBoard();
			}
		});
		canvas.setOnMouseMoved((e) -> {
			tool.move(this, e);
		});

		// -- Stage
		VBox editor = new VBox(menuBar, toolBar, scrollBar);

		Scene scene = new Scene(editor);
        stage.resizableProperty().setValue(Boolean.FALSE);
		stage.setTitle(APP_NAME);
		stage.setScene(scene);
		stage.show();

		// Set Focus
		toolBar.getButtonSelect().requestFocus();	
	}

	public void updateBoard() {
		board.draw(ctx);
	}

	@Override
	public Board getBoard() {
		return board;
	}

	@Override
	public Selection getSelection() {
		return selection;
	}

	@Override
	public void clipboardChanged() {
		menuBar.getEditPaste().setDisable(false);
	}
	
	public GraphicsContext getGraphicsContext() {
		return ctx;
	}

	public EditorToolBar getToolBar() {
		return toolBar;
	}
	
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	
	public CommandStack getCommandStack() {
		return commandStack;
	}
        
    public List<Clip> getPlaceClip(){
        return this.board.getPlaceClip();
    }
    
    public InitializeData getData () {
    	return this.data;
    }
    
    public Stage getStage () {
    	return this.stage;
    }
    
    public void ZoomIn() {
    	this.scrollBar.ZoomIn();
    }
    
    public void ZoomOut() {
    	this.scrollBar.ZoomOut();
    }
    
}
