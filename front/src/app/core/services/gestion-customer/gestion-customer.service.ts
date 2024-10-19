import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, map, Observable, of, tap} from "rxjs";
import {Customer} from "../../../models/customer/customer";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class GestionCustomerService {

  constructor(private http: HttpClient,
              private router: Router) {
  }

  createCustomer(customer: Customer): Observable<Customer> {
    const httpOptions = {
      headers: new HttpHeaders({"Content-Type": "application/json"}),
    };
    return this.http.post<Customer>(`http://localhost:8080/api/customer/save`, customer, httpOptions).pipe(
        tap((response) => this.log(response)),
        catchError((error) => this.handleError(error,null)
        ));
  }

  private handleError(error: Error, errorValue: any) {
    console.log(error);
    return of(errorValue);
  }

  private log(response: any) {
    console.table(response);
  }

}
