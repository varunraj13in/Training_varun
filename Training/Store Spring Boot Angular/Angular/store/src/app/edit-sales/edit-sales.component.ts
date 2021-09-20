import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Sale } from '../sale';
import { StoreService } from '../store.service';

@Component({
  selector: 'app-edit-sales',
  templateUrl: './edit-sales.component.html',
  styleUrls: ['./edit-sales.component.css']
})
export class EditSalesComponent implements OnInit {

  
  sale = new Sale();
  constructor(private router: Router,private service:StoreService,private activatedRouter: ActivatedRoute) { }

  ngOnInit(){
    let id = Number(this.activatedRouter.snapshot.paramMap.get('id'));
    this.service.fetchSalesByIdFromRemote(id).subscribe(
      data => {this.sale=data}

    )
  }

  updateSaleFormSubmit()
  {
    this.service.addSaleToRemote(this.sale).subscribe(
      
      )
      this.router.navigateByUrl('display');  

  }  

  goToList(){
    this.router.navigateByUrl('/display/home');
  }

}
