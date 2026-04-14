import { Component, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-artist-add',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './artist-add.html',
  styleUrl: './artist-add.css',
})
export class ArtistAdd {
  artist: any = { name: '' };
  private http = inject(HttpClient);
  private router = inject(Router);

  addArtist() {
    this.http.post('/api/v1/gateway/artists', this.artist).subscribe(() => {
      this.router.navigate(['/employees']);
    });
  }
}
