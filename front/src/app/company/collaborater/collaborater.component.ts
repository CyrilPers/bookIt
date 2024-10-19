import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-collaborater',
  templateUrl: './collaborater.component.html',
  styleUrl: './collaborater.component.scss',
  standalone: true,
})
export class CollaboraterComponent {
  @Input() collabName: String;
  collabs: any[];
}
