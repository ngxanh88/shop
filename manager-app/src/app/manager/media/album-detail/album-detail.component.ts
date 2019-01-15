import {Component, OnInit} from '@angular/core';
import {routerTransition} from '../../../router.animations';
import {ActivatedRoute} from '@angular/router';
import {FileAssetDto} from '../../../dto/file-asset-dto';
import {Album} from '../../../dto/album';

@Component({
  selector: 'app-album-detail',
  templateUrl: './album-detail.component.html',
  styleUrls: ['./album-detail.component.scss'],
  animations: [routerTransition()]
})
export class AlbumDetailComponent implements OnInit {

  currentAlbum: Album;
  fileDtos: Array<FileAssetDto>;
  selectedFileMap: Map<number, FileAssetDto> = new Map();
  searchText = '';

  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }

}
