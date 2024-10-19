import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {Worker} from "../../../models/worker/worker";

@Injectable({
    providedIn: 'root'
})
export class GestionCompanyService {

    constructor(private http: HttpClient) {}

    createCompany(worker: Worker): Observable<Worker> {
        const httpOptions = {
            headers: new HttpHeaders({"Content-Type": "application/json"}),
        };
        return this.http.post<Worker>(`http://localhost:8080/api/company/save`, worker, httpOptions).pipe(
            tap((response) => this.log(response)),
            catchError((error) => this.handleError(error, null))
        );
    }

    private log(response: any) {
        console.table(response);
    }

    private handleError(error: Error, errorValue: any) {
        console.log(error);
        return of(errorValue);
    }
}
