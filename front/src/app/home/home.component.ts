import { Component } from '@angular/core';
import { SearchBarComponent } from './search-bar/search-bar.component';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrl: './home.component.scss',
    standalone: true,
    imports:[SearchBarComponent],
})
export class HomeComponent {

}
