import { Component } from '@angular/core';
import { ButtonComponent } from '../reusable/button/button.component';
import { RouterLink } from '@angular/router';

@Component({
    selector: 'app-nav-bar',
    templateUrl: './nav-bar.component.html',
    styleUrl: './nav-bar.component.scss',
    standalone: true,
    imports:[ButtonComponent, RouterLink],
})
export class NavBarComponent {

}
