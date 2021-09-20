import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Sale } from '../sale';
import { StoreService } from '../store.service';

@Component({
  selector: 'app-add-sales',
  templateUrl: './add-sales.component.html',
  styleUrls: ['./add-sales.component.css']
})
export class AddSalesComponent implements OnInit {

  sale = new Sale();
  constructor(private router: Router,private service:StoreService) { }

  ngOnInit(): void {
  }

  addSaleFormSubmit()
  {
    this.service.addSaleToRemote(this.sale).subscribe(
      
      )
      this.router.navigateByUrl('display');  
  }  

  goToList(){
    this.router.navigateByUrl('/display/home');
  }

}
