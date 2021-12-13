package gui.guiSportstaetten;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import observ.Observer;

public class SportstaettenControl implements Observer {
	private SportstaettenView sportView;
	private FreizeitbaederModel freiModel;

	public SportstaettenControl(Stage fensterSportstaetten) {
		this.freiModel = FreizeitbaederModel.getModel();
		this.sportView = new SportstaettenView(this, fensterSportstaetten, freiModel);
		freiModel.addObserver(this);
	}

	@Override
	public void update() {
		sportView.zeigeFreizeitbaederAn();
	}

}
