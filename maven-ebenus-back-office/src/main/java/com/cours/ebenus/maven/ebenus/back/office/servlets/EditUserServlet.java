package com.cours.ebenus.maven.ebenus.back.office.servlets;

import com.cours.ebenus.maven.ebenus.back.office.utils.Utils;
import com.cours.ebenus.maven.ebenus.dao.entities.Adresse;
import com.cours.ebenus.maven.ebenus.dao.entities.Role;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.service.ServiceFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class EditUserServlet extends HttpServlet {
    private ServiceFacade servicefacade = null;

    private static final Log log = LogFactory.getLog(DeleteUserServlet.class);

    @Override
    public void init() throws ServletException {
        this.servicefacade = ServiceFacade.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userCookie = Utils.getCookie(request.getCookies(), "user");
        Utilisateur userLogged = Utils.getUserLogged(userCookie);
        if (userLogged == null)  {
            response.sendRedirect(this.getServletContext().getContextPath() + "/login");
        } else {
            HttpSession session = request.getSession();
            Utilisateur user = ServiceFacade.getInstance().getUtilisateurDao().findUtilisateurById(Integer.parseInt(request.getParameter("id")));
            if(user != null) {
                request.setAttribute("userLogged", userLogged);
                request.setAttribute("user", user);
                request.setAttribute("allRoles", servicefacade.getRoleDao().findAll());
                request.setAttribute("userMainAddr", servicefacade.getAdresseDao().findUserMainAdresse(user));
                request.setAttribute("userAllAddr", servicefacade.getAdresseDao().findUserAllAdresses(user));
                this.getServletContext().getRequestDispatcher("/pages/edit_user.jsp").forward(request, response);
            }
            else
                response.sendRedirect(this.getServletContext().getContextPath() + "/users");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //User
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String role = request.getParameter("select-rol");
        String passUser = request.getParameter("passUser");

        //Main addr
        String rue = request.getParameter("street-Bill");
        String codePostal = request.getParameter("postalcodeBill");
        String ville = request.getParameter("cityBill");
        String pays = request.getParameter("countryBill");


        String userCookie = Utils.getCookie(request.getCookies(), "user");
        Utilisateur userLogged = Utils.getUserLogged(userCookie);
        if (userLogged == null)  {
            response.sendRedirect(this.getServletContext().getContextPath() + "/login");
        } else {
            if (firstName != null && secondName != null && role != null && passUser != null
                    && rue != null && codePostal != null && ville != null && pays != null) {
                HttpSession session = request.getSession();
                Utilisateur user = servicefacade.getUtilisateurDao().findUtilisateurById(Integer.parseInt(request.getParameter("id")));
                user.setPrenom(firstName);
                user.setNom(secondName);
                Role role_db = servicefacade.getRoleDao().findRoleByIdentifiant(role);
                if (role_db != null)
                    user.setRole(role_db);
                user.setMotPasse(passUser);
                servicefacade.getUtilisateurDao().updateUtilisateur(user);
                Adresse addr = servicefacade.getAdresseDao().findUserMainAdresse(user);
                addr.setRue(rue);
                addr.setCodePostal(codePostal);
                addr.setVille(ville);
                addr.setPays(pays);
                servicefacade.getAdresseDao().updateAdresse(addr);
                response.sendRedirect(this.getServletContext().getContextPath() + "/users");
            }
            else
                response.sendRedirect(this.getServletContext().getContextPath() + "/users?error=Tous les champs doivent etre remplis.");
        }

    }

}
