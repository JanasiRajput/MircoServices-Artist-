import { Component, OnInit, inject, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-artist-list',
  imports: [],
  templateUrl: './artist-list.html',
  styleUrl: './artist-list.css',
})
export class ArtistList implements OnInit {
  artists: any[] = [];
  private http = inject(HttpClient);
  private cdr = inject(ChangeDetectorRef);

  ngOnInit() {
    this.http.get<any[]>('/api/v1/gateway/artists').subscribe(
      (data) => {
        this.artists = data;
        this.cdr.detectChanges();
      }
    );
  }
}
