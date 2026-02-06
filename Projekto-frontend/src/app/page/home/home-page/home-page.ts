import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MainHeader } from '../../../shared/main-header/main-header';
import { MainFooter } from '../../../shared/main-footer/main-footer';

@Component({
  selector: 'app-home-page',
  imports: [RouterLink, MainHeader, MainFooter],
  templateUrl: './home-page.html',
  styleUrl: './home-page.scss',
})
export class HomePage {}
