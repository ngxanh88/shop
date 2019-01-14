import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {MediaRoutingModule} from './media-routing.module';
import {PageHeaderModule} from '../../shared/modules';
import { AlbumListComponent } from './album-list/album-list.component';
import { AlbumDetailComponent } from './album-detail/album-detail.component';

@NgModule({
  declarations: [AlbumListComponent, AlbumDetailComponent],
  imports: [
    CommonModule,
    MediaRoutingModule,
    PageHeaderModule
  ]
})
export class MediaModule { }
