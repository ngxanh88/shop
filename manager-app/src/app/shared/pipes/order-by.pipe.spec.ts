import { OrderByPipe } from './order-by.pipe';

describe('OrderByPipe', () => {
  const pipe = new OrderByPipe();

  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });

  it('should sort array by id with ascending', function () {
    const toSortArray = getMockArray();
    const sortedArray = pipe.transform(toSortArray, 'id', true);

    expect(sortedArray[0].id).toEqual(1);
    expect(sortedArray[0].name).toEqual('alpha');

    expect(sortedArray[1].id).toEqual(2);
    expect(sortedArray[1].name).toEqual('beta');

    expect(sortedArray[2].id).toEqual(3);
    expect(sortedArray[2].name).toEqual('cesa');

    expect(sortedArray[3].id).toEqual(4);
    expect(sortedArray[3].name).toEqual('dora');
  });

  it('should sort array by id with descending', function () {
    const toSortArray = getMockArray();
    const sortedArray = pipe.transform(toSortArray, 'id', false);

    expect(sortedArray[3].id).toEqual(1);
    expect(sortedArray[3].name).toEqual('alpha');

    expect(sortedArray[2].id).toEqual(2);
    expect(sortedArray[2].name).toEqual('beta');

    expect(sortedArray[1].id).toEqual(3);
    expect(sortedArray[1].name).toEqual('cesa');

    expect(sortedArray[0].id).toEqual(4);
    expect(sortedArray[0].name).toEqual('dora');
  });

  it('should sort array by name with ascending', function () {
    const toSortArray = getMockArray();
    const sortedArray = pipe.transform(toSortArray, 'name', true);

    expect(sortedArray[0].id).toEqual(1);
    expect(sortedArray[0].name).toEqual('alpha');

    expect(sortedArray[1].id).toEqual(2);
    expect(sortedArray[1].name).toEqual('beta');

    expect(sortedArray[2].id).toEqual(3);
    expect(sortedArray[2].name).toEqual('cesa');

    expect(sortedArray[3].id).toEqual(4);
    expect(sortedArray[3].name).toEqual('dora');
  });

  it('should sort array by name with descending', function () {
    const toSortArray = getMockArray();
    const sortedArray = pipe.transform(toSortArray, 'name', false);

    expect(sortedArray[3].id).toEqual(1);
    expect(sortedArray[3].name).toEqual('alpha');

    expect(sortedArray[2].id).toEqual(2);
    expect(sortedArray[2].name).toEqual('beta');

    expect(sortedArray[1].id).toEqual(3);
    expect(sortedArray[1].name).toEqual('cesa');

    expect(sortedArray[0].id).toEqual(4);
    expect(sortedArray[0].name).toEqual('dora');
  });


  function getMockArray(): Array<any> {
    return [
      {id: 1, name: 'alpha'},
      {id: 3, name: 'cesa'},
      {id: 2, name: 'beta'},
      {id: 4, name: 'dora'},
    ];
  }
});
