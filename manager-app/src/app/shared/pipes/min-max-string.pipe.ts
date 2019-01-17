/**
 * this pipe transform the string for view with ... in the middle if string too long
 * return the new converted String
 *
 * value (string): the input string
 * preStringLength (number): prestring length
 * surStringLength (number): substring length
 */


import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'minMaxString'
})
export class MinMaxStringPipe implements PipeTransform {

  transform(value: string, preStringLength?: number, surStringLength?: number): any {
    let convertedString = '';
    const separation = '...';

    if (value.length > preStringLength + surStringLength) {
      convertedString = value.substring(0, preStringLength) + separation + value.substring(preStringLength + 3, value.length);
    } else {
      convertedString = value;
    }

    return convertedString;
  }

}
