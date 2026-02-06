import { Component } from '@angular/core';
import { SideNavigationbarDashboard } from "../../../shared/side-navigationbar-dashboard/side-navigationbar-dashboard";
import { WorkspaceCard } from "../../../shared/workspace-card/workspace-card";
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-workspace-page',
  imports: [SideNavigationbarDashboard, WorkspaceCard, RouterLink],
  templateUrl: './workspace-page.html',
  styleUrl: './workspace-page.scss',
})
export class WorkspacePage {

}
