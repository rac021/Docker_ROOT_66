
package org.rac021.service.plane ;

/**
 *
 * @author ryahiaoui
 */

import java.net.InetAddress;
import javax.json.Json ;
import javax.ws.rs.GET ;
import javax.ws.rs.Path ;
import javax.inject.Inject ;
import javax.json.JsonObject ;
import javax.inject.Singleton ;
import org.rac021.business.Plane ;
import java.net.UnknownHostException ;
import javax.annotation.PostConstruct ;
import org.rac021.business.PlaneManager ;
import org.rac021.business.CrunchifyGetIPHostname ;

/**
 *
 * @author R.Yahiaoui
 */

@Singleton
@Path("/plane")
public class ServicePlane    {
 
    @Inject
    PlaneManager manager ;
    
    @PostConstruct
    public void init() {
    }

    public ServicePlane() {
    }
    
    @GET
    public JsonObject getPlane() throws UnknownHostException {    

        Plane plane = PlaneManager.randomPlane() ;
        
        InetAddress ip  = CrunchifyGetIPHostname.getIp() ;
        String     _ip =  ip != null ?  ip.getHostAddress()  : "-.-.-.-" ;   
        
        return Json.createObjectBuilder()
                   .add("ip", _ip  )
                   .add("host", CrunchifyGetIPHostname.getHostName())
                   .add("model", plane.getModel())
                   .add("distance_km", plane.getDistance_km())
                   .add("speed_km_h", plane.getSpeed_km())
                   .add("total_passengers", plane.getTotal_passengers())
                   .build() ;
        
    }
    

}

