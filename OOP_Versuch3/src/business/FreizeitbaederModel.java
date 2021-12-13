package business;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import observ.Observable;
import observ.Observer;
import writers.ConcreteCsvWriterCreator;
import writers.ConcreteTxtWriterCreator;
import writers.WriterCreator;
import writers.WriterProduct;

public class FreizeitbaederModel implements Observable{
	
	private List<Observer> observers = new ArrayList<Observer>();
    private Freizeitbad freizeitbad;
    private static FreizeitbaederModel instanceModel;

    private FreizeitbaederModel() {    }

    public static FreizeitbaederModel getModel() {
    	if(instanceModel == null)
    		instanceModel = new FreizeitbaederModel();
    	
    	return instanceModel;
    }
    
	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}


	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}


	public void schreibeFreizeitbaederInCsvDatei() {
		try {
			WriterCreator writerCreator= new ConcreteCsvWriterCreator();
			WriterProduct writerProduct= writerCreator.factoryMethod();
			
			writerProduct.fuegeInDateiHinzu(this.freizeitbad);
			writerProduct.schliesseDatei();
		} catch (IOException e) {
			System.out.print("IO Fehler");
		}
	}


	public void schreibeFreizeitbaederInTxtDatei() {
		try {
			WriterCreator writerCreator= new ConcreteTxtWriterCreator();
			WriterProduct writerProduct= writerCreator.factoryMethod();
			
			writerProduct.fuegeInDateiHinzu(this.freizeitbad);
			writerProduct.schliesseDatei();
		} catch (IOException e) {
			System.out.print("IO Fehler");
		}		
	}


	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}


	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
	}


	@Override
	public void notifyObserver() {
		for(Observer obs : observers) {
			obs.update();
		}
	}
    
}
