/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import methods.FetchComments;

/**
 *
 * @author pierre
 */
public class CurrentComments {
    public static FetchComments currentComments;

    public CurrentComments(FetchComments currentComments) {
        this.currentComments = currentComments;
    }
}
