import { Component } from "@angular/core";
import { RouterLink } from "@angular/router";

@Component({
    selector: "page-404",
    styles: [`
  .not-found-page {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 80%;
  }
  h1{
    margin-bottom:20px;
  }
`],
    template: `
    <div class="not-found-page">
      <h1>Hey, cette page n'existe pas !</h1>
      <a routerLink="">
        Retourner à l'accueil
      </a>
    </div>
  `,
    standalone: true,
    imports: [RouterLink],
})
export class PageNotFoundComponent {}
