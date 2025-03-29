export interface Destination {
  id: number;
  name: string;
  description: string;
  imageUrl: string;
  rating: number;
  location: string;
  category: string;
}

export interface Post {
  id: number;
  title: string;
  content: string;
  authorId: number;
  destinationId: number;
  createdAt: Date;
  likes: number;
  imageUrls: string[];
}

export interface User {
  id: number;
  name: string;
  email: string;
  bio?: string;
  avatar?: string;
}