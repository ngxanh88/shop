import { ReplaceStringPipe } from './replace-string.pipe';

describe('ReplaceStringPipe', () => {
  const pipe = new ReplaceStringPipe();

  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });

  it('should replace - with /', function () {
    expect(pipe.transform('01-10-2015', '-', '/')).toEqual('01/10/2015');
  });
});
