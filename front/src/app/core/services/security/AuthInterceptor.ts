import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {AuthService} from "./AuthService";
import {Observable} from "rxjs";

@Injectable()
export class AuthInterceptor implements  HttpInterceptor{
    constructor(private authService: AuthService) {}
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const authToken = this.authService.getToken();
        request = request.clone({
            setHeaders: {
                Authorization: "Bearer " + authToken
            }
        });
        return next.handle(request);

    }
}