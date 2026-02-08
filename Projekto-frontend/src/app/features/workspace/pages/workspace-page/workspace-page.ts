/* eslint-disable @typescript-eslint/no-unused-expressions */
/* eslint-disable @angular-eslint/prefer-inject */
import { Component, OnInit } from '@angular/core';
import { SideNavigationbarDashboard } from '../../../dashboard/components/side-navigationbar-dashboard/side-navigationbar-dashboard';
import { WorkspaceCard } from '../../components/workspace-card/workspace-card';
import { RouterLink } from '@angular/router';
import { WorkspaceDto } from '../../models/workspace.model';
import { Workspace } from '../../services/workspace';
import { NgForOf } from '@angular/common';

@Component({
  selector: 'app-workspace-page',
  imports: [SideNavigationbarDashboard, WorkspaceCard, RouterLink, NgForOf],
  templateUrl: './workspace-page.html',
  styleUrl: './workspace-page.scss',
})
export class WorkspacePage implements OnInit {
  userId = '4af22f20-c6a7-4df6-b864-1170237a16d3';

  workspaces: WorkspaceDto[] = [];

  constructor(private workspaceService: Workspace) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.workspaceService.getWorkspaces(this.userId).subscribe({
      next: (response) => {
        this.workspaces = response;
      },
      error: (error) => {
        console.error('error', error);
      },
    });
  }

  trackById(_: number, ws: WorkspaceDto): string {
    return ws.id;
  }
}
