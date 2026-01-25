import { Component } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-home-page',
  imports: [MatToolbarModule, MatIconModule],
  templateUrl: './home-page.html',
  styleUrl: './home-page.scss',
})
export class HomePage {}
