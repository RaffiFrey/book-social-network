import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookRoutingModule } from './book-routing.module';
import {BookListComponent} from "./pages/book-list/book-list.component";
import {MainComponent} from "./pages/main/main.component";
import {MenuComponent} from "./components/menu/menu.component";


@NgModule({
  declarations: [
    BookListComponent,
    MainComponent,
    MenuComponent
  ],
  imports: [
    CommonModule,
    BookRoutingModule,
  ],
  providers: [
  ]
})
export class BookModule { }
