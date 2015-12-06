package fr.esigelec.projetStruts.controleur;
import fr.esigelec.projetStruts.forms.*;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.esigelec.projetStruts.dao.*;
import fr.esigelec.projetStruts.dto.*;


public class AjouterPersonneAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			PersonneForm f = (PersonneForm)form;
			setLocale( request, new Locale("en", "EN"));
			Personne p = new Personne(f.getNom(),f.getPrenom(), f.getAge());
			//Par Hibernate
			DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE);
			dao.getPersonneDAO().ajouter(p);
			request.setAttribute("liste",dao.getPersonneDAO().getListe());
			
			return mapping.findForward("succes");
	}
}
