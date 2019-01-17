import { Pipe, PipeTransform } from '@angular/core';
import * as _ from 'lodash';
/* return array in range from original array
*  from and to are indexes of item in array (starts with 0)
*/
@Pipe({name: 'arrayFromRange'})
export class ArrayFromRangePipe implements PipeTransform {
  transform(array: Array<any>, from: number, to: number): Array<any> {
    if (array.length < from) {
      return array;
    }
    return _.filter(array, (item) => {
      const index = array.indexOf(item);
      return index >= from && index <= to;
    });
  }
}
