import { Component } from '@angular/core';
import { ButtonComponent } from '../../reusable/button/button.component';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrl: './search-bar.component.scss',
  standalone: true,
  imports:[ButtonComponent]
})
export class SearchBarComponent {

}
