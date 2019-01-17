import { Pipe, PipeTransform } from '@angular/core';
import {DomSanitizer} from '@angular/platform-browser';

@Pipe({
  name: 'safeCss'
})
export class SafeCssPipe implements PipeTransform {
  constructor(private _sanitizer: DomSanitizer) {}

  transform(style): any {
    return this._sanitizer.bypassSecurityTrustStyle(style);
  }
}

