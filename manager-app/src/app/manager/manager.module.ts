import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ManagerComponent} from './manager.component';
import {TranslateModule} from '@ngx-translate/core';
import {NgbDropdownModule} from '@ng-bootstrap/ng-bootstrap';
import {SidebarComponent} from './components/sidebar/sidebar.component';
import {HeaderComponent} from './components/header/header.component';
import {ManagerRoutingModule} from './manager-routing.module';

@NgModule({
  imports: [
    CommonModule,
    ManagerRoutingModule,
    TranslateModule,
    NgbDropdownModule
  ],
  declarations: [ManagerComponent, SidebarComponent, HeaderComponent]
})
export class ManagerModule { }
