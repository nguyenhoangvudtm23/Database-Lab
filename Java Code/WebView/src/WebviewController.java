

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebviewController implements Initializable{
	@FXML
	private WebView webView;
	@FXML
	private TextField addressBar;
	private WebEngine engine;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		engine = webView.getEngine();
		engine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
			if (newState == Worker.State.SUCCEEDED)
			{
				addressBar.setText(engine.getLocation());
			}
		});
	}
	public static String validateAddress(String address)
	{
		if (!address.startsWith("https://"))
		{
			if (!address.startsWith("www."))
			{
				address = "www." + address;
			}
			address = "https://" + address;
		}
		return address;
	}
	public void keyHandle(KeyEvent ke)
	{
		if (ke.getCode().equals(KeyCode.ENTER))
		{
			String address = addressBar.getText();
			address = validateAddress(address);
			engine.load(address);
		}
	}
	public void refresh(ActionEvent e)
	{
		String address = addressBar.getText();
		engine.load(address);
	}
	public void backHandle(ActionEvent e)
	{
		if (engine.getHistory().getCurrentIndex() > 0)
		{
			engine.getHistory().go(-1);
		}
	}
	public void forwardHandle(ActionEvent e)
	{
		if (engine.getHistory().getCurrentIndex() + 1 < engine.getHistory().getEntries().size())
		{
			engine.getHistory().go(1);
		}
	}
	
}
