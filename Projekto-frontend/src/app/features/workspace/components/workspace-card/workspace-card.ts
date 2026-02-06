import { Component } from '@angular/core';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-workspace-card',
  imports: [RouterLink],
  templateUrl: './workspace-card.html',
  styleUrl: './workspace-card.scss',
})
export class WorkspaceCard {  
  icon = 'man';
}
