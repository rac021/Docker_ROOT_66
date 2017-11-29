
package org.rac021.business ;

/**
 *
 * @author ryahiaoui
 */

import java.net.InetAddress ;
import java.net.UnknownHostException ;

public class CrunchifyGetIPHostname {
 
  
   public static InetAddress getIp() {
      
        try {
              return InetAddress.getLocalHost() ;
           
        } catch (UnknownHostException ex )      {
            return null ;
        }
   }

   public static String getHostName()            {
      
       InetAddress ip = getIp() ;
       if( ip !=null ) {
         try {
              String hostname = ip.getHostName() ;
              return hostname                    ;
            } catch( Exception ex ) {
              return System.getenv("HOSTNAME")   ;
            }
       } 
       
       System.out.println(" HOSTNAME --> " + System.getenv("HOSTNAME") ) ;
       return System.getenv("HOSTNAME")          ;
   }
   
}
