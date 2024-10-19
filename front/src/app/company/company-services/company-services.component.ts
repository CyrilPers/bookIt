import { Component } from '@angular/core';
import { ButtonComponent } from '../../reusable/button/button.component';

@Component({
    selector: 'app-company-services',
    templateUrl: './company-services.component.html',
    styleUrl: './company-services.component.scss',
    standalone: true,
    imports:[ButtonComponent]
})
export class CompanyServicesComponent {}
