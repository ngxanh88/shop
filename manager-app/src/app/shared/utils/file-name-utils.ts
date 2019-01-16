export class FileNameUtils {

  public static FILE_SEPARATOR = '/';

  private static isSeparator(ch: string): boolean {
    return ch === FileNameUtils.FILE_SEPARATOR;
  }

  public static indexOfLastSeparator(filePath: string): number {
    return filePath.lastIndexOf(FileNameUtils.FILE_SEPARATOR);
  }

  public static indexOfExtension(filePath: string): number {
    const extensionPos = filePath.lastIndexOf('.');
    const lastSeparator = FileNameUtils.indexOfLastSeparator(filePath);
    return lastSeparator > extensionPos ? -1 : extensionPos;
  }

  public static getName(filePath: string): string {
    const index = FileNameUtils.indexOfLastSeparator(filePath);
    return filePath.substring(index + 1);
  }

  public static getExtension(filename: string): string {
    const index = FileNameUtils.indexOfExtension(filename);
    return index === -1 ? '' : filename.substring(index + 1);
  }

  public static removeExtension(filename: string): string {
    const index = FileNameUtils.indexOfExtension(filename);
    return index === -1 ? filename : filename.substring(0, index);
  }

  public static getBaseName(filename: string): string {
    return FileNameUtils.removeExtension(FileNameUtils.getName(filename));
  }

  public static isExtension(filename: string, extension: string): boolean {
    if (extension != null && extension.length > 0) {
      const fileExt = FileNameUtils.getExtension(filename);
      return fileExt === extension;
    }

    return FileNameUtils.indexOfExtension(filename) === -1;
  }

  public static normalize(filename: string): string {
    return FileNameUtils.doNormalize(filename, true);
  }

  private static doNormalize(filename: string, keepSeparator: boolean): string {
    // TODO normalize file name
    return filename;
  }

  public static concat(basePath: string, fullFilenameToAdd: string): string {
    const len = basePath.length;
    if (len === 0) {
      return FileNameUtils.normalize(fullFilenameToAdd);
    }

    const ch = basePath.charAt(len - 1);
    return FileNameUtils.isSeparator(ch) ?
      FileNameUtils.normalize(basePath + fullFilenameToAdd) :
      FileNameUtils.normalize(basePath + FileNameUtils.FILE_SEPARATOR + fullFilenameToAdd);
  }

  public static getFullPathNoEndSeparator(filename: string): string {
    return FileNameUtils.doGetFullPath(filename, false);
  }

  private static doGetFullPath(filename: string, includeSeparator: boolean): string {
    const index = FileNameUtils.indexOfLastSeparator(filename);
    if (index < 0) {
      return filename;
    }

    let end: number = index + (includeSeparator ? 1 : 0);
    if (end === 0) {
      ++end;
    }
    return filename.substring(0, end);
  }
}
