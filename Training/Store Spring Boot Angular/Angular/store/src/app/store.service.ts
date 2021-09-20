import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sale } from './sale';

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  constructor(private http: HttpClient) { }

  fetchSalesListFromRemote(): Observable<any> {
    return this.http.get<any>("http://localhost:8080/showsales");
  }
  addSaleToRemote(sale: Sale): Observable<any> {
    return this.http.post<any>("http://localhost:8080/addsales",sale);
  }
  fetchSalesByIdFromRemote(id: number): Observable<any> {
    return this.http.get<any>("http://localhost:8080/showsalesbyid/"+id);
  }

  deleteSalesByIdFromRemote(id: number): Observable<any> {
    return this.http.delete<any>("http://localhost:8080/deletesalesbyid/"+id);
  }
}

