/* eslint-disable @angular-eslint/prefer-inject */
import { Component, ChangeDetectionStrategy } from '@angular/core';
import { CommonModule } from '@angular/common';
import {} from '../../services/boards-service';

@Component({
  selector: 'app-board-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './board-card.html',
  styleUrls: ['./board-card.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class BoardCardComponent {

}
