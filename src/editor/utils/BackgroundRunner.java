package editor.utils;

public class BackgroundRunner extends Thread {
	
	private BackgroundCallBack callBack;
	
	public BackgroundRunner(BackgroundCallBack callBack) {
		// TODO Auto-generated constructor stub
		this.callBack = callBack;
	}
	
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		
		callBack.TransferSignal("1");
	}
	

}
