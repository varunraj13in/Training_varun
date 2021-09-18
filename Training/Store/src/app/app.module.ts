import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { SalesComponent } from './sales/sales.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

const appRoutes = [
  {path:'',component: HomeComponent},
  {path:'invoice',component: InvoiceComponent},
  {path:'sales',component: SalesComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    InvoiceComponent,
    SalesComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
