export interface IModalModel {

  title?: string;
}

export interface DefaultModalModel extends IModalModel {
  title?: string;
  message: string;
}
