import {Injectable} from "@angular/core";
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Customer} from "../../../models/customer/customer";
import {catchError, map, Observable, throwError} from "rxjs";
import { jwtDecode } from "jwt-decode";
import {User} from "../../../models/user/user";

@Injectable({ providedIn: 'root' })
export class AuthService {

    constructor(private http: HttpClient,
                private router: Router) {
    }

    private log(response: any) {
        console.table(response);
    }

    loginCustomer(user: User): Observable<Customer> {
        const httpOptions = {
            headers: new HttpHeaders({'Content-Type': 'application/json'}),
        };
        return this.http.post<User>(`http://localhost:8080/api/customer/login`, user, httpOptions).pipe(
            map((res: any) => {
                localStorage.setItem("token", res.token);
                return res;
            }),
            catchError((error) => this.handleError(error)));
    };

    getToken() {
        return localStorage.getItem("token");
    }

    logout() {
        const removeToken = localStorage.getItem("token");
        if (removeToken == null) {
            this.router.navigate(["/authentication"]);
        }
    }

    handleError(error: HttpErrorResponse) {
        let msg = '';
        if (error.error instanceof ErrorEvent) {
            // client-side error
            msg = error.error.message;
        } else {
            // server-side error
            msg = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        return throwError(msg);
    }

    get isLoggedIn(): boolean {
        const authToken = localStorage.getItem('token');
        return authToken !== null;
    }


    static isWorkerWorkingInCompany(companyId: number) {
        const token: any = localStorage.getItem('token');
        if (token) {
            try {
                const decodedToken = jwtDecode(token);
                //TODO check token info !
                const companies = [] || decodedToken;
            } catch (e) {
                console.error("Failed to decode token", e);
                return false;
            }
        }
        return false;
    }
}
