import {Component, Input, OnInit} from '@angular/core';
import {PageHeaderRoutingModel} from './page-header-routing-model';

@Component({
    selector: 'app-page-header',
    templateUrl: './page-header.component.html',
    styleUrls: ['./page-header.component.scss']
})
export class PageHeaderComponent implements OnInit {
    @Input() heading: string;
    @Input() icon: string;

    @Input() backRoutingList: Array<PageHeaderRoutingModel> = [];
    constructor() {}

    ngOnInit() {}
}
