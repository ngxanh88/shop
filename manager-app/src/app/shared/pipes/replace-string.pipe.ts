import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'replaceString'
})
export class ReplaceStringPipe implements PipeTransform {

  transform(value: string, searchValue: string, replaceValue: string): string {
    const regex = new RegExp(searchValue, 'g');
    return value.replace(regex, replaceValue);
  }

}
