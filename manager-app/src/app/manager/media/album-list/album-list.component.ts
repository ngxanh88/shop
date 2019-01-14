import {Component, OnInit} from '@angular/core';
import {routerTransition} from '../../../router.animations';
import {Album} from '../../../dto/album';

@Component({
  selector: 'app-album-list',
  templateUrl: './album-list.component.html',
  styleUrls: ['./album-list.component.scss'],
  animations: [routerTransition()]
})
export class AlbumListComponent implements OnInit {

  albums: Array<Album> = [];

  constructor() { }

  ngOnInit() {
    const album = new Album();
    album.categoryName = 'test';

    this.albums.push(album);
  }

  public createNewAlbum(): void {
    // TODO implement this
  }

  updateAlbum(album: Album, i: number) {
    // TODO implement this
  }

  deleteAlbum(album: Album, i: number) {
    // TODO implement this
  }
}
