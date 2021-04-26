package Objects;

import methods.DecideMeeting;
import methods.SuggestMeeting;
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
public class CurrentSM {
    public static SuggestMeeting currentSM;
    public static boolean created = false;

    public CurrentSM(SuggestMeeting currentSM) {
        this.currentSM = currentSM;
        created = true;
        
    }
    
    public boolean created(){
    return created;
    }
   


    
}
