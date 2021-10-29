/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import javafx.scene.input.MouseEvent;
import edu.esprit.entities.Clients;
import javafx.event.ActionEvent;

/**
 *
 * @author pc
 */
public interface mylistener {
      public void onClickListener(MouseEvent event ,Clients oeuvre);
      public void onpressed(ActionEvent  event ,Clients oeuvre);
       public void onClickListener(Clients facture);

    
    
}
