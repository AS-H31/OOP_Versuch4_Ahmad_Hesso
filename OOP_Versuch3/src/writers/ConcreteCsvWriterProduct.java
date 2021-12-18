package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvWriterProduct extends WriterProduct {
	private BufferedWriter aus;
	
	public ConcreteCsvWriterProduct(){
		try {
			aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fuegeInDateiHinzu(Object obj) throws IOException {
		Freizeitbad fzb = (Freizeitbad) obj;
		aus.write(fzb.gibFreizeitbadZurueck(';') + "\n");

	}

	@Override
	public void schliesseDatei() throws IOException {
		aus.close();			
	}

}
