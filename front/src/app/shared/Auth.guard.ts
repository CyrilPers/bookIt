import {Injectable, Input} from "@angular/core";
import {AuthService} from "../core/services/security/AuthService";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {

    constructor(
        public authService: AuthService,
        public router: Router
    ) { }
    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        if (!this.authService.isLoggedIn) {
            window.alert("Access not allowed!");
            this.router.navigate(['authentification'])
        }
        return true;
    }

    canActivateWorker(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        const companyId = next.params['companyId']; // Assuming companyId is a route parameter
        if (!AuthService.isWorkerWorkingInCompany(parseInt(companyId))) {
            window.alert("Access not allowed!");
            this.router.navigate(['authentification'])
        }
        return true;
    }
}