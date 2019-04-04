package com.cours.ebenus.maven.ebenus.front.office.web.servlets;

import com.cours.ebenus.maven.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.maven.ebenus.dao.entities.Commande;
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
import java.util.List;

public class DeleteArtCoServlet extends HttpServlet {
    private ServiceFacade servicefacade = null;

    private static final Log log = LogFactory.getLog(DeleteArtCoServlet.class);

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
            System.out.println("IN DELETE");
            HttpSession session = request.getSession();
            Produit prd = ServiceFacade.getInstance().getProduitDao().findProduitById(Integer.parseInt(request.getParameter("id")));
            List<ArticleCommande> list_artCo = ServiceFacade.getInstance().getArticleCommandeDao().findArticleCommandeByUser(userLogged);
            for (ArticleCommande art: list_artCo){
                if(art.getIdProduit() == prd.getIdProduit() && art.getStatut().equals("T")) {
                    ServiceFacade.getInstance().getArticleCommandeDao().deleteArticleCommande(art);
                    prd.setStock(prd.getStock()+1);
                    ServiceFacade.getInstance().getProduitDao().updateProduit(prd);
                    List<Commande> co = ServiceFacade.getInstance().getCommandeDao().findCommandeByUser(userLogged);
                    for(Commande c: co){
                        if (c.getStatut().equals("T")) {
                            c.setTotalCommande(c.getTotalCommande() - prd.getPrix());
                            ServiceFacade.getInstance().getCommandeDao().updateCommande(c);
                        }
                    }
                }
            }
            request.setAttribute("userLogged", userLogged);
            response.sendRedirect(this.getServletContext().getContextPath() + "/panier");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
