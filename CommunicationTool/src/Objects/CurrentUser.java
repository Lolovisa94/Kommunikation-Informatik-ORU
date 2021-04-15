package Objects;

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
public class CurrentUser {
    public static User currentUser;

    public CurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    
}
