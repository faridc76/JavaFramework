package fr.esigelec.projetStruts.controleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.esigelec.projetStruts.dao.DAOFactory;

public class SupprimerPersonneAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int id=new Integer(request.getParameter("id"));
		
		//Par JDBC
		DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.JDBC);
		dao.getPersonneDAO().supprimer(id);
		request.setAttribute("liste",dao.getPersonneDAO().getListe());

		return mapping.findForward("succes");
	}

}
