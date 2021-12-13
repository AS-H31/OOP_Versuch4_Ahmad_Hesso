package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxtWriterProduct extends WriterProduct{

	private BufferedWriter aus;
	
	public ConcreteTxtWriterProduct(){
		try {
			aus = new BufferedWriter(new FileWriter("Freizeitbaeder.txt", true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fuegeInDateiHinzu(Object obj) throws IOException {
		Freizeitbad fzb = (Freizeitbad) obj;
		aus.write("\nDaten des Freizeitbads:\n" +
					"Name des Freizeitbads\t" + fzb.getName() + "\n"+
					"Öffnungszeiten des Freizeitbads\t" + fzb.getGeoeffnetVon() + " - " + fzb.getGeoeffnetBis() + "\n"+
					"Beckenlänge des Freizeitbads\t" + fzb.getBeckenlaenge() + "\n" +
					"Wassertemperatur des Freizeitbads\t" + fzb.getTemperatur()
				);

	}

	@Override
	public void schliesseDatei() throws IOException {
		aus.close();			
	}

}
