import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { DestinationService } from '../../services/destination.service';
import { DestinationCardComponent } from '../../components/destination-card/destination-card.component';
import { Destination } from '../../models/destination.model';

@Component({
  selector: 'app-destinations',
  standalone: true,
  imports: [CommonModule, DestinationCardComponent],
  template: `
    <div class="container">
      <h1>Popular Destinations</h1>
      <div *ngIf="loading" class="loading-spinner"></div>
      <div *ngIf="!loading" class="grid">
        <app-destination-card
          *ngFor="let destination of destinations"
          [destination]="destination"
          (onSelect)="viewDestination($event)"
        ></app-destination-card>
      </div>
    </div>
  `
})
export class DestinationsComponent implements OnInit {
  destinations: Destination[] = [];
  loading = true;

  constructor(
    private destinationService: DestinationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.destinationService.getDestinations().subscribe(
      destinations => {
        this.destinations = destinations;
        this.loading = false;
      }
    );
  }

  viewDestination(destination: Destination): void {
    this.router.navigate(['/destinations', destination.id]);
  }
}