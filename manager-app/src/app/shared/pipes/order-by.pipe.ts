import { Pipe, PipeTransform } from '@angular/core';
import * as _ from 'lodash';

@Pipe({
  name: 'orderBy',
  pure: false
})
export class OrderByPipe implements PipeTransform {

  transform(array: Array<any>, args: any, isAscending: boolean = true): Array<any> {
    return _.orderBy(array, item => item.hasOwnProperty(args) ? _.toLower(item[args]) : '', [isAscending ? 'asc' : 'desc']);
  }

}
