package fr.esigelec.projetStruts.controleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.esigelec.projetStruts.dao.DAOFactory;


public class VoirFamilleAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String nom = new String(request.getParameter("nom"));
		
		//Par JDBC
		DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.JDBC);
		request.setAttribute("memeFamille", dao.getPersonneDAO().getFamille(nom));

		return mapping.findForward("succes");
	}

}
