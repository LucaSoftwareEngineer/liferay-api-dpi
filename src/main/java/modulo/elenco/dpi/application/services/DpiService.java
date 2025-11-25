package modulo.elenco.dpi.application.services;

import java.util.HashMap;

public class DpiService {

	HashMap<Long, String> dpi;
	
	public DpiService() {
		dpi = new HashMap<>();
		dpi.put(1L, "Casco");
		dpi.put(2L, "Guanti");
		dpi.put(3L, "Scarpe");
	}
	
	public Boolean cercaDpi(String nome) {
		for (String singoloDpi:dpi.values())
			if (singoloDpi.equals(nome))
				return true;
		return false;
	}
	
}
