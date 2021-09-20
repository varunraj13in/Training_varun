import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DisplayComponent } from './display/display.component';
import { HomeComponent } from './home/home.component';
import { InvoiceComponent } from './display/invoice/invoice.component';
import { LoginComponent } from './login/login.component';
import { SalesComponent } from './sales/sales.component';
import { AddSalesComponent } from './add-sales/add-sales.component';
import { EditSalesComponent } from './edit-sales/edit-sales.component';

const appRoutes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {
    path: 'display', component: DisplayComponent,
    children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', component: HomeComponent },
      { path: 'invoice', component: InvoiceComponent },
      { path: 'sales', component: SalesComponent },
    ]
  },
  { path: 'login', component: LoginComponent },
  {path:'add', component: AddSalesComponent},
  {path:'edit', component: EditSalesComponent},
  {path:'edit/:id', component: EditSalesComponent},

];
@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
