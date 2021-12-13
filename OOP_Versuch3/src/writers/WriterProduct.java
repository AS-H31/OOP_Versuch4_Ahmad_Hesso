package writers;

import java.io.IOException;

public abstract class WriterProduct {
	
	public abstract void fuegeInDateiHinzu(Object obj)
			throws IOException;
	
	public abstract void schliesseDatei()
			throws IOException;
}
