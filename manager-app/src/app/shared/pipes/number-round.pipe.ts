// this pipe round float comma number

import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'numberRound'
})
export class NumberRoundPipe implements PipeTransform {
  // numberOfDigitAfterComma
  transform(number: any, numberOfDigitAfterComma?: number): any {
      const multiplier = Math.pow(10, numberOfDigitAfterComma ? numberOfDigitAfterComma : 2);
      const result = (Math.round(number * multiplier) / multiplier);

      // set min value for result
      if (result === 0) {

      }

      return result;
  }

}
