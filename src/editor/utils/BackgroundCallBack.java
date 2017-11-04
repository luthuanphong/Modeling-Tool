package editor.utils;

public interface BackgroundCallBack {
	void TransferSignal(String value);
	void TransferException(String Message);
	void UpdateProgressStatus();
	void UpdateButton();
}
