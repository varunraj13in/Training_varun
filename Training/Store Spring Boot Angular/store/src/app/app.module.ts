import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InvoiceComponent } from './display/invoice/invoice.component';
import { SalesComponent } from './sales/sales.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SalesListComponent } from './sales/sales-list/sales-list.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { DisplayComponent } from './display/display.component';
import { LoginComponent } from './login/login.component';
import { AddSalesComponent } from './add-sales/add-sales.component';
import { EditSalesComponent } from './edit-sales/edit-sales.component';

const appRoutes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path:'display',component: DisplayComponent,
  children: [
    {path:'home',component: HomeComponent},
  {path:'invoice',component: InvoiceComponent},
  {path:'sales',component: SalesComponent},
  ]
  },
  {path:'login',component: LoginComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    InvoiceComponent,
    SalesComponent,
    HomeComponent,
    SalesListComponent,
    DisplayComponent,
    LoginComponent,
    AddSalesComponent,
    EditSalesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
