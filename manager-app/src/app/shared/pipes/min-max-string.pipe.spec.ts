import { MinMaxStringPipe } from './min-max-string.pipe';

describe('MinMaxStringPipe', () => {
  it('create an instance', () => {
    const pipe = new MinMaxStringPipe();
    expect(pipe).toBeTruthy();
  });
});
