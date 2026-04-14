import { Routes } from '@angular/router';
import { Home } from './home/home';
import { ArtistList } from './employees/artist-list/artist-list';
import { ArtistAdd } from './employees/artist-add/artist-add';
import { PosterLists } from './items/poster-lists/poster-lists';
import { PosterAdd } from './items/poster-add/poster-add';

export const routes: Routes = [
    { path: '', component: Home, pathMatch: 'full' },
    { path: 'employees', component: ArtistList },
    { path: 'add-employee', component: ArtistAdd },
    { path: 'items', component: PosterLists },
    { path: 'add-item', component: PosterAdd }
];
