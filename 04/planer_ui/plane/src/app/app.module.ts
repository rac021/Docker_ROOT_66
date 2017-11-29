import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { PlaneComponent } from './plane/plane.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PlaneComponent        
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule ,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [PlaneComponent]
})
export class AppModule { }
