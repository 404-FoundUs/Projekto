import { Component } from '@angular/core';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-side-navigationbar-dashboard',
  imports: [RouterLink],
  templateUrl: './side-navigationbar-dashboard.html',
  styleUrl: './side-navigationbar-dashboard.scss',
})
export class SideNavigationbarDashboard {
isLinkDisabled: any;

}
