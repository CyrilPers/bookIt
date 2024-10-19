import { Component, Input, OnInit } from '@angular/core';
import { NgIf, NgFor, NgClass } from '@angular/common';

interface carouselImage {
imageSrc: string;
imageAlt: string;
}

@Component({
    selector: 'app-carousel',
    templateUrl: './carousel.component.html',
    styleUrl: './carousel.component.scss',
    standalone: true,
    imports: [NgIf, NgFor, NgClass]
})
export class CarouselComponent implements OnInit {
    @Input() images: carouselImage[] = []
    @Input() indicators = true;
    @Input() controls = true;
    @Input() autoSlide = false;
    @Input() slideInterval = 3000;


    selectedIndex = 0;

    ngOnInit(): void {
      if(this.autoSlide)
        this.autoSlideImages()
    }

    autoSlideImages = ():void => {
      setInterval(() => {
        this.onNextClick();
      }, this.slideInterval);
    }

    selectImage = (index: number): void => {
      this.selectedIndex = index;
    }

    onPrevClick = ():void => {
      if (this.selectedIndex === 0) 
        this.selectedIndex = this.images.length - 1;
      else 
        this.selectedIndex--;
    }

    
    onNextClick = ():void => {
      if (this.selectedIndex === this.images.length - 1)
        this.selectedIndex = 0;
      else
        this.selectedIndex++;
    }

}
