import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-create-model-card',
  imports: [],
  templateUrl: './create-model-card.html',
  styleUrl: './create-model-card.scss',
})
export class CreateModelCard {
 @Output() closeModal = new EventEmitter<void>();

  close(): void {
    this.closeModal.emit();
  }
}
