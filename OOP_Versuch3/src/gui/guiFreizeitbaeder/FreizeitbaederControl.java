package gui.guiFreizeitbaeder;

import java.io.IOException;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import observ.Observer;

public class FreizeitbaederControl implements Observer{
	private FreizeitbaederView freiView;
	private FreizeitbaederModel freiModel;
	
	public FreizeitbaederControl(Stage stage) {
		this.freiModel = FreizeitbaederModel.getModel();
		this.freiView = new FreizeitbaederView(this, stage, freiModel);
		freiModel.addObserver(this);
	}
	
	void schreibFreizeitbaederInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				freiModel.schreibeFreizeitbaederInCsvDatei();
				freiView.zeigeInformationsfensterAn("Freizeitbad in CSV-Datei geschrieben");
			}else {
				freiModel.schreibeFreizeitbaederInTxtDatei();
				freiView.zeigeInformationsfensterAn("Freizeitbad in TXT-Datei geschrieben");
			}
			
//		} catch (IOException e) {
//			freiView.zeigeFehlermeldungsfensterAn("IO Exception beim Speichern", "Fehler");
		} catch (Exception exc) {
			freiView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern", "Fehler");
		}
	}

	@Override
	public void update() {
		freiView.zeigeFreizeitbaederAn();
	}

}
