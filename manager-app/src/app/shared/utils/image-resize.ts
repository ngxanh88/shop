import {Observable} from 'rxjs';

export class ImageResize {

  public static resizeFileImage(imageFile: File, size: number): Observable<string> {
    const result = Observable.create(observer => {

      const reader = new FileReader();
      reader.onloadend = () => {
        const imageElement = document.createElement('img');

        imageElement.onload = () => {
          observer.next(ImageResize.resizeImage(imageElement, size));
          observer.complete();
        };

        // @ts-ignore
        imageElement.src = reader.result;
      };

      reader.readAsDataURL(imageFile);
    });
    return result;
  }

  public static resizeImage(image: HTMLImageElement, size: number): string {
    let canvas: HTMLCanvasElement = document.createElement('canvas');
    canvas.width = image.width;
    canvas.height = image.height;
    const context = canvas.getContext('2d');
    context.drawImage(image, 0, 0, canvas.width, canvas.height);

    if (!size) {
      size = 300;
    }

    while (canvas.width > size) {
      canvas = ImageResize.getHalfSizeImage(canvas);
    }

    const base64Image = canvas.toDataURL('image/jpeg');
    return base64Image.replace(/data:image\/jpeg;base64,/g, '');
  }

  private static getHalfSizeImage(image: HTMLCanvasElement): HTMLCanvasElement {
    const canvas = document.createElement('canvas');
    canvas.width = image.width / 2;
    canvas.height = image.height / 2;
    const ctx = canvas.getContext('2d');
    ctx.drawImage(image, 0, 0, canvas.width, canvas.height);
    return canvas;
  }
}
