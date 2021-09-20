import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { SalesComponent } from '../sales/sales.component';
import { InvoiceComponent } from './invoice/invoice.component';

const appRoutes = [
  { path: 'home', component: HomeComponent },
  { path: 'invoice', component: InvoiceComponent },
  { path: 'sales', component: SalesComponent },
];
@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {

  constructor(private router: Router,) { }

  ngOnInit(): void {
  }

}
