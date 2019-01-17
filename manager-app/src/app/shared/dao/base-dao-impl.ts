import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {IBaseDao} from '../base';

export abstract class BaseDaoImpl<T> implements IBaseDao<T> {

  protected constructor(protected http: HttpClient) {
  }

  public create(body: T): Observable<T> {
    return this.http.post<T>(this.buildDefaultProxyUrl(this.getBaseEntryUrl()), body);
  }

  public update(body: T): Observable<T> {
    return this.http.put<T>(this.buildDefaultProxyUrl(this.getBaseEntryUrl()), body);
  }

  public delete(id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.buildDefaultProxyUrl(this.getBaseEntryUrl() + '?id=' + id));
  }

  public getById(id: number): Observable<T> {
    return this.http.get<T>(this.buildDefaultProxyUrl(this.getBaseEntryUrl() + '?id=' + id));
  }

  public getAll(): Observable<Array<T>> {
    return this.http.get<Array<T>>(this.buildDefaultProxyUrl(this.getBaseEntryUrl() + '/list'));
  }

  protected abstract getBaseEntryUrl(): string;

  protected buildDefaultProxyUrl(pathUri: string): string {
    return pathUri;
  }
}
