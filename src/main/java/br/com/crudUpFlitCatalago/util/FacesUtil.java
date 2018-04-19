package br.com.crudUpFlitCatalago.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
	
		
		public static void addInfoMessage(String msg) {
			//recursos do JSF de messagens de informação
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
			
		}

}
