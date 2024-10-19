import {Routes} from "@angular/router";
import { AuthGuard } from "./shared/auth.guard";

export const routes: Routes = [
    {
        path: "",
        loadComponent: () => import('./home/home.component').then(mod => mod.HomeComponent)
    },
    {
        path: "company",
        children: [
            {
                path: 'sign-up',
                loadComponent: () => import('./company/sign-up/company-sign-up.component').then(mod => mod.CompanySignUpComponent)
            },
            {
                path: ':id',
                loadComponent: () => import('./company/company.component').then(mod => mod.CompanyComponent)
            }
        ],
    },
    {
        path: "managing",
        children: [
            {
                path: 'sign-in',
                loadComponent: () => import('./company/company.component').then(mod => mod.CompanyComponent)

            },
            {
                path: ':id', canActivateWorker: [AuthGuard],
                loadComponent: () => import('./company/company.component').then(mod => mod.CompanyComponent)

            }
        ]
    },
    {
        path: "sign-up",
        loadComponent: () => import('./sign-up/sign-up.component').then(mod => mod.SignUpComponent)
    },
    {
        path: "**",
      loadComponent: () => import('./page-not-found/page-not-found.component').then(mod => mod.PageNotFoundComponent)
    },
];