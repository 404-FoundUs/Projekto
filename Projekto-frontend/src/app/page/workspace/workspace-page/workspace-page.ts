import { Component } from '@angular/core';
import { SideNavigationbarDashboard } from "../../../core/side-navigationbar-dashboard/side-navigationbar-dashboard";
import { WorkspaceCard } from "../../../shared/workspace-card/workspace-card";

@Component({
  selector: 'app-workspace-page',
  imports: [SideNavigationbarDashboard, WorkspaceCard],
  templateUrl: './workspace-page.html',
  styleUrl: './workspace-page.scss',
})
export class WorkspacePage {

}
