import { Injectable } from '@angular/core';
import { Observable, of, delay } from 'rxjs';
import { Destination } from '../models/destination.model';

@Injectable({
  providedIn: 'root'
})
export class DestinationService {
  private destinations: Destination[] = [
    {
      id: 1,
      name: 'Paris',
      description: 'The City of Light',
      imageUrl: 'C:\angular\travel1\project\.angular\assets\Paris.jpg',
      rating: 4.8,
      location: 'France',
      category: 'Cities'
    },
    {
      id: 2,
      name: 'Bali',
      description: 'Island of the Gods',
      imageUrl: '.angular\assets\Bali.jpg',
      rating: 4.6,
      location: 'Indonesia',
      category: 'Beaches'
    }
  ];

  getDestinations(): Observable<Destination[]> {
    return of(this.destinations).pipe(delay(1000));
  }

  getDestination(id: number): Observable<Destination | undefined> {
    return of(this.destinations.find(d => d.id === id)).pipe(delay(500));
  }

  addDestination(destination: Omit<Destination, 'id'>): Observable<Destination> {
    const newDestination = {
      ...destination,
      id: this.destinations.length + 1
    };
    this.destinations.push(newDestination);
    return of(newDestination).pipe(delay(1000));
  }
}