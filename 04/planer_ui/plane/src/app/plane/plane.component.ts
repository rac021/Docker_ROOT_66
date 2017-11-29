
import { Http } from '@angular/http' ;
import 'rxjs/add/operator/toPromise' ;
import {Observable} from 'rxjs/Observable';
import { Component , OnInit } from '@angular/core';
import {IntervalObservable} from 'rxjs/observable/IntervalObservable';

@Component({
  selector: 'app-plane',
  template:
  `
    <h1>Planer Dashboard - <sup>Angular 2</sup> </h1>
    <h3> Service : {{ this.url }}</h3>
     
     <div class="box-container">
        <div class="box host"> HOST <br> [ {{infosPlanes.host}} ] </div>
        <div class="box ip"> IP <br> [ {{infosPlanes.ip}} ] </div>
     </div>
     
     <div class="box-container" >
        <div class="box model"> MODEL <br> [ {{infosPlanes.model}} ] </div>
        <div class="box distance_km"> DISTANCE_KM <br> [ {{infosPlanes.distance_km}} ] </div>
        <div class="box speed_km_h"> SPEED_KM_H <br> [ {{infosPlanes.speed_km_h}} ] </div>
        <div class="box total_passengers"> TOTAL_PASSENGERS <br> [ {{infosPlanes.total_passengers}} ] </div>
        <div class="box ipsum"> Plane <br> Description <br> ...</div>
     </div>
   ` ,
   styleUrls: ['./plane_flex_component.css']
})

export class PlaneComponent implements OnInit {

 private url = "https://uncknown.org" ;

 infosPlanes = { "ip"               : "0.0.0.0" ,
                 "host"             : "NULL"    ,
                 "model"            : "NULL"    ,
                 "distance_km"      : 0         ,
                 "speed_km_h"       : 0         ,
                 "total_passengers" : 0
               } ;

 original_infosPlanes = { "ip"               : "0.0.0.0" ,
                          "host"             : "NULL"    ,
                          "model"            : "NULL"    ,
                          "distance_km"      : 0         ,
                          "speed_km_h"       : 0         ,
                          "total_passengers" : 0
                        } ;
               
 constructor( private http: Http ) {

    this.getJSON() ;

    setInterval( () =>
                {
                  this.genericGetFromUri( this.url )
                      .then( r =>  this.infosPlanes = r )
                      .catch((error: any) =>  console.log( " Oupss. Error !! " ) ) ;
                }
                , 1000
              ) ;
} ;

genericGetFromUri: any = (url: string ) : any => {
  
  return this.http.get( url , JSON.stringify({ name: Date.now()}) )
             .toPromise()
             .then( r => r.json())
             .catch((error: any) => this.infosPlanes = this.original_infosPlanes ) ;
}

ngOnInit() {
 console.log( " Init Component Planer ..." ) ;
}

 public getJSON() {
 
   this.http.get("assets/env.json" )
                 .toPromise()
                 .then( r => r.json())
                 .then( r =>  { this.url = r.data.URL  }) ;
 }

}
