import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { DestinationService } from '../../services/destination.service';
import { Destination } from '../../models/destination.model';
import { RatingPipe } from '../../pipes/rating.pipe';

@Component({
  selector: 'app-destination-detail',
  standalone: true,
  imports: [CommonModule, RatingPipe],
  template: `
    <div class="container">
      <div *ngIf="loading" class="loading-spinner"></div>
      
      <div *ngIf="!loading && destination" class="card" style="margin-top: 20px;">
        <img [src]="destination.imageUrl" [alt]="destination.name" 
             style="width: 100%; height: 400px; object-fit: cover; border-radius: 8px;">
        
        <div style="padding: 20px 0;">
          <h1>{{ destination.name }}</h1>
          <p style="color: #666;">{{ destination.location }}</p>
          <p>{{ destination.rating | rating }}</p>
          <p style="margin-top: 20px;">{{ destination.description }}</p>
        </div>

        <button class="btn btn-primary" (click)="goBack()">Back to Destinations</button>
      </div>

      <div *ngIf="!loading && !destination" class="card">
        <h2>Destination not found</h2>
        <button class="btn btn-primary" (click)="goBack()">Back to Destinations</button>
      </div>
    </div>
  `
})
export class DestinationDetailComponent implements OnInit {
  destination?: Destination;
  loading = true;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private destinationService: DestinationService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.destinationService.getDestination(id).subscribe(destination => {
      this.destination = destination;
      this.loading = false;
    });
  }

  goBack(): void {
    this.router.navigate(['/destinations']);
  }
}