import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Sale } from 'src/app/sale';
import { StoreService } from 'src/app/store.service';

@Component({
  selector: 'app-sales-list',
  templateUrl: './sales-list.component.html',
  styleUrls: ['./sales-list.component.css']
})
export class SalesListComponent implements OnInit {

  sales:any;


  constructor(private route: Router,private service: StoreService, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    let resp = this.service.fetchSalesListFromRemote();
    resp.subscribe((data) => this.sales = data);

  }

  goToAddSales() {
    this.route.navigateByUrl('add');  
  }
  goToUpdateSales(id: number) {
    this.route.navigate(['/edit',id]);  
  }

  deleteSales(id: number) {
    this.service.deleteSalesByIdFromRemote(id).subscribe(
      data => {
      }
    )
    this.route.navigateByUrl('display');  
  }

}
