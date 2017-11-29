
package entry ;

/**
 *
 * @author ryahiaoui
 */

import org.wildfly.swarm.Swarm ;
import org.jboss.shrinkwrap.api.ShrinkWrap ;
import org.wildfly.swarm.jaxrs.JAXRSArchive ;
import org.wildfly.swarm.config.io.BufferPool;
import org.wildfly.swarm.config.io.Worker;
import org.wildfly.swarm.io.IOFraction;

public class Main {
   
    
    public static void main(String[] args) throws Exception {
    
       /**
       * Debugger Mode */
       // System.setProperty("swarm.debug.port" ,"11555") ;
       
       
       /* HTTP PORT CONFIGURATION     */
       String HTTP_PORT  = "8080"      ;
               
       String tmpDirProperty = "java.io.tmpdir"                     ;
       String tmpDir         = System.getProperty( tmpDirProperty ) ;
      
       System.out.println( "\n ** Virtual File System ( VFS ) = " + tmpDir + "\n" ) ;

       System.setProperty("java.net.preferIPv4Stack" , "true")                      ;
      
       System.setProperty("swarm.http.port", HTTP_PORT )  ;
         
        Swarm  swarm  = new Swarm()                   ;
       
        Worker worker = new Worker("default")         ;
        worker.ioThreads(16).taskMaxThreads(128)      ;
        swarm.fraction( new IOFraction().worker(worker).bufferPool( new BufferPool("default"))) ;
                    
        swarm.start()                                                                ;

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "planer.war") ;
        
       /** Packages **/
       deployment.addPackage("com.rac021.cors")          ;
       deployment.addPackage("org.rac021.business")      ;
       deployment.addPackage("org.rac021.config")        ;
       deployment.addPackage("org.rac021.service.plane") ;
              
       /** Deployment **/
       deployment.addAllDependencies(true) ;
       swarm.deploy( deployment)           ;

    }

}
