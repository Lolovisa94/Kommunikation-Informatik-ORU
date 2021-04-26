package Objects;

import methods.DecideMeeting;
import methods.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierre
 */
public class CurrentDM {
    public static DecideMeeting currentDM;
    public static boolean created = false;

    public CurrentDM(DecideMeeting currentDM) {
        this.currentDM = currentDM;
        created = true;
        
    }
    
    public boolean created(){
    return created;
    }
   


    
}
