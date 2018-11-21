/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahomi
 */
public class abrirpagina {
    public abrirpagina(String url)
    {
        goToURL(url);
    }
    public void goToURL(String URL)
    {
        if (java.awt.Desktop.isDesktopSupported()) 
        {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) 
            {
                try 
                {
                    java.net.URI uri = new java.net.URI(URL);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(abrirpagina.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
