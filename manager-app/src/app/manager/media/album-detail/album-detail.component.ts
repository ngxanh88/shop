import { Component, OnInit } from '@angular/core';
import {routerTransition} from '../../../router.animations';

@Component({
  selector: 'app-album-detail',
  templateUrl: './album-detail.component.html',
  styleUrls: ['./album-detail.component.scss'],
  animations: [routerTransition()]
})
export class AlbumDetailComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
