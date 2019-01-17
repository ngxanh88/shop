import { SafeCssPipe } from './safe-css.pipe';

describe('SafeCssPipe', () => {
  it('create an instance', () => {
    const pipe = new SafeCssPipe(null);
    expect(pipe).toBeTruthy();
  });
});
