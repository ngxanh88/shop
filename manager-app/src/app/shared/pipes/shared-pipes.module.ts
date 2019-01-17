import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ReplaceStringPipe} from './replace-string.pipe';
import {SafeCssPipe} from './safe-css.pipe';
import {ArrayFromRangePipe} from './array-from-range.pipe';
import {SafeHtmlPipe} from './safe-html.pipe';
import {NumberRoundPipe} from './number-round.pipe';
import {MinMaxStringPipe} from './min-max-string.pipe';
import {OrderByPipe} from './order-by.pipe';

const PIPES = [
  MinMaxStringPipe,
  NumberRoundPipe,
  SafeHtmlPipe,
  ArrayFromRangePipe,
  SafeCssPipe,
  OrderByPipe,
  ReplaceStringPipe
];

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: PIPES,
    exports: PIPES
})
export class SharedPipesModule { }
