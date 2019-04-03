package com.cours.ebenus.maven.ebenus.front.office.web.servlets;

import com.cours.ebenus.maven.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.maven.ebenus.dao.entities.Produit;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.front.office.web.utils.Utils;
import com.cours.ebenus.maven.ebenus.service.ServiceFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanierServlet extends HttpServlet {
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
            response.sendRedirect(this.getServletContext().getContextPath() + "/login");
        } else {
            HttpSession session = request.getSession();
            List<ArticleCommande> artCo = ServiceFacade.getInstance().getArticleCommandeDao().findArticleCommandeByUser(userLogged);
            List<ArticleCommande> temp_art = new ArrayList<ArticleCommande>();
            for(ArticleCommande ac: artCo){
                if(ac.getStatut().equals("T"))
                    temp_art.add(ac);
            }
            List<Produit> produits = new ArrayList<Produit>();
            Double total = 0.0;
            for(ArticleCommande ac: temp_art){
                Produit prd = ServiceFacade.getInstance().getProduitDao().findProduitById(ac.getIdProduit());
                produits.add(prd);
                total += prd.getPrix();
            }
            request.setAttribute("produits", produits);
            request.setAttribute("total", total);
            request.setAttribute("userLogged", userLogged);
            this.getServletContext().getRequestDispatcher("/pages/panier.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
