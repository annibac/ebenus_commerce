package com.cours.ebenus.maven.ebenus.front.office.web.servlets;

import com.cours.ebenus.maven.ebenus.dao.entities.*;
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

public class ProductDetailServlet extends HttpServlet {
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
            Produit produit = ServiceFacade.getInstance().getProduitDao().findProduitById(Integer.parseInt(request.getParameter("id")));
            if(produit != null){
                request.setAttribute("prd", produit);
                request.setAttribute("userLogged", userLogged);
                this.getServletContext().getRequestDispatcher("/pages/detail_produit.jsp").forward(request, response);
            }
            else
                response.sendRedirect(this.getServletContext().getContextPath() + "/products");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userCookie = Utils.getCookie(request.getCookies(), "user");
        Utilisateur userLogged = Utils.getUserLogged(userCookie);
        if (userLogged == null)  {
            response.sendRedirect(this.getServletContext().getContextPath() + "/login");
        } else {
            HttpSession session = request.getSession();
            Produit produit = ServiceFacade.getInstance().getProduitDao().findProduitById(Integer.parseInt(request.getParameter("id")));
            if(produit != null){
                produit.setStock(produit.getStock()-1);
                ServiceFacade.getInstance().getProduitDao().updateProduit(produit);
                List<Commande> commandes = ServiceFacade.getInstance().getCommandeDao().findCommandeByUser(userLogged);
                Adresse addr = ServiceFacade.getInstance().getAdresseDao().findUserMainAdresse(userLogged);
                Commande cmd = null;
                if (commandes == null) {
                    cmd = new Commande(produit.getPrix(), userLogged.getIdUtilisateur(), addr.getIdAdresse(), "T");
                    ServiceFacade.getInstance().getCommandeDao().createCommande(cmd);
                    }
                else{
                    for(Commande c: commandes){
                        if(c.getStatut().equals("T"))
                            cmd = c;
                    }
                    if(cmd == null) {
                        cmd = new Commande(produit.getPrix(), userLogged.getIdUtilisateur(), addr.getIdAdresse(), "T");
                        ServiceFacade.getInstance().getCommandeDao().createCommande(cmd);
                    }
                    else {
                        cmd.setTotalCommande(cmd.getTotalCommande()+produit.getPrix());
                        ServiceFacade.getInstance().getCommandeDao().updateCommande(cmd);
                    }
                }
                ArticleCommande artCo = new ArticleCommande(cmd.getIdCommande(), userLogged.getIdUtilisateur(), addr.getIdAdresse(), produit.getIdProduit(),produit.getPrix(), produit.getReference(), 1, "T");
                ServiceFacade.getInstance().getArticleCommandeDao().createArticleCommande(artCo);
                response.sendRedirect(this.getServletContext().getContextPath() + "/panier");
            }
            else
                response.sendRedirect(this.getServletContext().getContextPath() + "/products");
        }
    }
}
