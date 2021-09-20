import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DisplayComponent } from '../display/display.component';
import { HomeComponent } from '../home/home.component';
import { InvoiceComponent } from '../display/invoice/invoice.component';
import { SalesComponent } from '../sales/sales.component';
import { LoginService } from './login.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public uname: string;
  public pwd: string;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  displayVal = '';

  validateLogin(val: string) {
    if (val === "admin") {
      this.router.navigateByUrl('display');
      this.displayVal = val;
    } else{
      alert('Only admin is allowed');
    }
  }

}