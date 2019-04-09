package com.cours.ebenus.maven.ebenus.back.office.servlets;

import com.cours.ebenus.maven.ebenus.back.office.utils.Utils;
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

public class EditRoleServlet extends HttpServlet {
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
            Role role = servicefacade.getRoleDao().findRoleById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("role", role);
            this.getServletContext().getRequestDispatcher("/pages/editRole.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identifiant = request.getParameter("identifiant");
        String desc = request.getParameter("description");
        String userCookie = Utils.getCookie(request.getCookies(), "user");
        Utilisateur userLogged = Utils.getUserLogged(userCookie);
        if (userLogged == null)  {
            response.sendRedirect(this.getServletContext().getContextPath() + "/login");
        } else {
            if (identifiant != null && desc != null) {
                HttpSession session = request.getSession();
                Role role = servicefacade.getRoleDao().findRoleById(Integer.parseInt(request.getParameter("id")));
                role.setDescription(desc);
                role.setIdentifiant(identifiant);
                servicefacade.getRoleDao().updateRole(role);
                response.sendRedirect(this.getServletContext().getContextPath() + "/roles");
            }
            else
                response.sendRedirect(this.getServletContext().getContextPath() + "/roles?error=Tous les champs doivent etre remplis.");
        }

    }
}
