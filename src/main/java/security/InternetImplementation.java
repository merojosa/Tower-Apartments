package security;

public class InternetImplementation implements InternetService {

	// Este metodo se entiende que es tonto, es para testeo. Si se llega aca, quiere decir que si se pudo acceder a Internet.
	public boolean accessWebsite(String url)
	{
		return true;
	}

}
