package editor.utils;

import javafx.application.Platform;

public class BackgroundRunner extends Thread {
	
	private BackgroundCallBack callBack;
	
	public BackgroundRunner(BackgroundCallBack callBack) {
		// TODO Auto-generated constructor stub
		this.callBack = callBack;
   	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String baseDirectoryPath = new java.io.File(".").getAbsolutePath();
			java.io.File tempFolderPath = new java.io.File(baseDirectoryPath,"temp");
			java.io.File pnmlFilePath = new java.io.File(tempFolderPath.getPath(),"temp.pnml");
			java.io.File txtFilePath = new java.io.File(tempFolderPath.getPath(),"temp.txt");
			java.io.File txtMinimizeFilePath = new java.io.File(tempFolderPath.getPath(),"temp_minimize.txt");
			Verify verify = new Verify();
			String verifyResult = verify.getVeriInfo(pnmlFilePath.getPath(), txtFilePath.getPath(), txtMinimizeFilePath.getPath());
			verify = null;	
			System.gc();
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					BackgroundRunner.this.callBack.TransferSignal(verifyResult);
				}
			});	
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					BackgroundRunner.this.callBack.UpdateProgressStatus();
				}
			});
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					BackgroundRunner.this.callBack.UpdateButton();
				}
			});
		
		}catch(Exception ex) {
			//callBack.TransferSignal(ex.getMessage());
		}
	}
		
}
