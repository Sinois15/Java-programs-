/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gmt;

/**
 *
 * @author User
 */
import java.time.Clock;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
public class Gmt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date gmt = new Date();
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        time.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println("GMT time: " + time.format(gmt));
    }
    
}
