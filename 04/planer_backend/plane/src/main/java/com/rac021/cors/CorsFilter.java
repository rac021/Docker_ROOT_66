
package com.rac021.cors;

/**
 *
 * @author ryahiaoui
 */

import java.io.IOException ;

import javax.ws.rs.ext.Provider ;
import javax.ws.rs.container.ContainerRequestContext ;
import javax.ws.rs.container.ContainerResponseFilter ;
import javax.ws.rs.container.ContainerResponseContext ;

@Provider
public class CorsFilter implements ContainerResponseFilter {

   @Override
   public void filter( final ContainerRequestContext requestContext ,
                       final ContainerResponseContext cres          ) throws IOException {
       
      cres.getHeaders().add("PLANER_V", "1.1" )                                                             ;
      cres.getHeaders().add("Access-Control-Allow-Origin", "*" )                                            ;
      cres.getHeaders().add("Access-Control-Max-Age", "0" )                                                 ;
      cres.getHeaders().add("Connection", "Close" )                                                         ;
      cres.getHeaders().add("Access-Control-Allow-Credentials", "true" )                                    ;
      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD" )       ;
      cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization" ) ;
   }

}
