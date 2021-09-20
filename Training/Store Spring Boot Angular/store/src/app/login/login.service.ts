import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class LoginService {


  constructor(private http: HttpClient,private router: Router) { }

  displayVal = '';

  getRole(){
    return this.displayVal;
  }
  checklogin(username: string, password: string): Observable<any> {
    const body = new HttpParams()
      .set('unm', username)
      .set('pwd', password);
    return this.http.post('http://localhost:8080/checkuser',
      body);
  }
}
