package gui.guiSportstaetten;

import java.io.IOException;

import business.FreizeitbaederModel;
import business.SporthallenModel;
import javafx.stage.Stage;
import observ.Observer;
import ownUtil.PlausiException;

public class SportstaettenControl implements Observer {
	private SportstaettenView sportView;
	private FreizeitbaederModel freiModel;
	private SporthallenModel sporthallenModel;

	public SportstaettenControl(Stage fensterSportstaetten) {
		this.freiModel = FreizeitbaederModel.getModel();
		this.sporthallenModel = SporthallenModel.getModel();
		this.sportView = new SportstaettenView(this, fensterSportstaetten, freiModel, sporthallenModel);
		freiModel.addObserver(this);
	}
	
	public void leseDateiausCsv() {
		try {
			sporthallenModel.leseSporthallenAusCsvDatei();
		} catch (IOException | PlausiException e) {
			sportView.zeigeInformationsfensterAn("Fehler beim lesen aus der CSV Datei");
		}
	}

	@Override
	public void update() {
		sportView.zeigeFreizeitbaederAn();
	}

}
