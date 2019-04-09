package com.cours.ebenus.maven.ebenus.back.office.servlets;

import com.cours.ebenus.maven.ebenus.back.office.utils.Utils;
import com.cours.ebenus.maven.ebenus.dao.entities.Produit;
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

public class EditProductServlet extends HttpServlet {
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
            Produit prd = servicefacade.getProduitDao().findProduitById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("prd", prd);
            this.getServletContext().getRequestDispatcher("/pages/editPrd.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String ref = request.getParameter("ref");
            String nom = request.getParameter("nom");
            String desc = request.getParameter("desc");
            Double prix = Double.parseDouble(request.getParameter("prix"));
            Integer stock = Integer.parseInt(request.getParameter("stock"));
            String userCookie = Utils.getCookie(request.getCookies(), "user");
            Utilisateur userLogged = Utils.getUserLogged(userCookie);
            if (userLogged == null) {
                response.sendRedirect(this.getServletContext().getContextPath() + "/login");
            } else {
                if (ref != null && nom != null && desc != null && prix > 0 && stock >= 0) {
                    HttpSession session = request.getSession();
                    Produit prd = servicefacade.getProduitDao().findProduitById(Integer.parseInt(request.getParameter("id")));
                    prd.setReference(ref);
                    prd.setNom(nom);
                    prd.setPrix(prix);
                    prd.setStock(stock);
                    prd.setDescription(desc);
                    servicefacade.getProduitDao().updateProduit(prd);
                    response.sendRedirect(this.getServletContext().getContextPath() + "/products");
                } else
                    response.sendRedirect(this.getServletContext().getContextPath() + "/products?error=Tous les champs doivent etre remplis.");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e);
            response.sendRedirect(this.getServletContext().getContextPath() + "/produits?error=Tous les champs doivent etre remplis.");
        }
        catch (ClassCastException e){
            System.out.println(e);
            response.sendRedirect(this.getServletContext().getContextPath() + "/produits?error=Les valeurs ne sont pas correctes.");
        }
    }
}
