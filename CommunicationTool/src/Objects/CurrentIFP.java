package Objects;

import methods.FetchInformalPosts;
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
public class CurrentIFP {
    public static FetchInformalPosts currentIFP;
    public static boolean created = false;

    public CurrentIFP(FetchInformalPosts currentIFP) {
        this.currentIFP = currentIFP;
        created = true;

    }
    
    public boolean created(){
    return created;
    }
   


    
}
