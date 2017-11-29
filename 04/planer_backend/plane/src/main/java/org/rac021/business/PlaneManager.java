
package org.rac021.business ;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;



/**
 *
 * @author ryahiaoui
 */

@Singleton
@Startup
public class PlaneManager {
    
   static Random      random  ;
   
   static List<Plane> planes  ;

   public PlaneManager() {
   }
    
   @PostConstruct
   public void init() {
       
     random = new Random()      ;
     planes = new ArrayList<>() ;
     
     planes.add( new Plane( "Tupolev TU-414A", 26, 15575, 900 ) ) ;
     planes.add( new Plane( "Sukhoi SU-27UBK", 0, 13401, 1400 ) ) ;
     planes.add( new Plane( "Airbus ACJ319", 156, 1112, 828 ) ) ;
     planes.add( new Plane( "Gulfstream G650" , 18   , 12964 , 904 ) ) ;
     planes.add( new Plane( "Bombardier Global 8000"  , 19   , 14631 , 904 )) ;
     planes.add( new Plane( "Boeing 787-9 Dreamliner"   , 2902 , 15742 , 945 )) ;
     planes.add( new Plane( "Boeing 777-200LR Worldliner" , 301  , 17400 , 945 )) ;
     planes.add( new Plane( "Airbus A340-500"   , 375  , 16668 , 907 ) ) ;
     planes.add( new Plane( "Boeing 747-400ER"  , 524  , 14205 , 1093 )) ;
     planes.add( new Plane( "Boeing 747-8" , 700  , 14816 , 1043 ) );
     
   }
    
   public static Plane randomPlane() {
       return planes.get(random.nextInt(planes.size())) ;
   }
}
