package Objects;

import methods.FetchPosts;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierre
 */
public class CurrentFP {
    public static FetchPosts currentFP;
    public static boolean created = false;

    public CurrentFP(FetchPosts currentFP) {
        this.currentFP = currentFP;
        created = true;
        
    }
    
    public boolean created(){
    return created;
    }
   


    
}
