import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-button',
    templateUrl: './button.component.html',
    styleUrl: './button.component.scss',
    standalone: true
})
export class ButtonComponent {
    @Input() label: string = "Bouton"
    @Input() fontSize: string = "1rem"
    @Input() padding: string = "0.5rem 1rem"
    @Input() disabled: boolean = false
    @Input() color: string = "primary"
}
