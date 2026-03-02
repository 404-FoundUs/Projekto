/* eslint-disable @typescript-eslint/no-unused-expressions */
/* eslint-disable @angular-eslint/prefer-inject */
import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Workspace } from '../../../domain/entities/workspace.model';

@Component({
  selector: 'app-workspace-card',
  imports: [RouterLink],
  templateUrl: './workspace-card.html',
  styleUrl: './workspace-card.scss',
})
export class WorkspaceCard {
  icon = 'man';
  @Input() workspace!: Workspace;
}
