package com.cours.ebenus.maven.ebenus.front.office.web.servlets;

import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.front.office.web.utils.Utils;
import com.cours.ebenus.maven.ebenus.service.ServiceFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private ServiceFacade servicefacade = null;

    private static final Log log = LogFactory.getLog(LoginServlet.class);

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
            this.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(request, response);
        } else {
            response.sendRedirect(this.getServletContext().getContextPath() + "/index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("__email");
        String password = request.getParameter("password");

        Utilisateur userLogged = ServiceFacade.getInstance().getUtilisateurDao().authenticate(email, password);

        if (userLogged != null) {
            Cookie userCookie = new Cookie("user", email + "@@" + password);
            response.addCookie(userCookie);
            response.sendRedirect(this.getServletContext().getContextPath() + "/index");
        } else {
            response.sendRedirect(this.getServletContext().getContextPath() + "/login?error=L'utilisateur n'existe pas.");
        }
    }

    /**
     * Méthode appelée lors de la fin de la Servlet
     */
    @Override
    public void destroy() {
    }
}
