package modulo.elenco.dpi.application;

import java.util.Collections;
import java.util.Set;

import modulo.elenco.dpi.application.services.DpiService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;


/**
 * @author Utente
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api/dpi",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=ApiDpi.Rest",
		"auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true",
		"com.liferay.jaxrs.disable.security=true"
	},
	service = Application.class
)
public class ModuloElencoDpiApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	DpiService dpiService = new DpiService();

	@GET
	@Path("/cerca")
	@Produces("application/json")
	public Boolean cercaDpi(@QueryParam("nome") String nome) {
		return dpiService.cercaDpi(nome);
	}

}