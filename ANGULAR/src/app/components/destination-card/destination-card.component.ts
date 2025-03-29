import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Destination } from '../../models/destination.model';
import { RatingPipe } from '../../pipes/rating.pipe';

@Component({
  selector: 'app-destination-card',
  standalone: true,
  imports: [CommonModule, RouterLink, RatingPipe],
  template: `
    <div class="card">
      <img [src]="destination.imageUrl" [alt]="destination.name" style="width: 100%; height: 200px; object-fit: cover; border-radius: 4px;">
      <h3>{{ destination.name }}</h3>
      <p>{{ destination.description }}</p>
      <p>{{ destination.rating | rating }}</p>
      <p>Location: {{ destination.location }}</p>
      <button class="btn btn-primary" (click)="onSelect.emit(destination)">View Details</button>
    </div>
  `
})
export class DestinationCardComponent {
  @Input() destination!: Destination;
  @Output() onSelect = new EventEmitter<Destination>();
}