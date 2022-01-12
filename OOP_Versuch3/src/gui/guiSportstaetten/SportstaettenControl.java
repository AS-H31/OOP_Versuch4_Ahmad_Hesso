package gui.guiSportstaetten;

import business.FreizeitbaederModel;
import business.SporthallenModel;
import javafx.stage.Stage;
import observ.Observer;

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

	@Override
	public void update() {
		sportView.zeigeFreizeitbaederAn();
	}

}
