import {BaseDto} from './base-dto';
import {Album} from './album';

export class FileAssetDto extends BaseDto {

  category: Album;
  fileName:  string;
  fileSize: number;
  fileUrl: string;
  rawName: string;
  extension: string;
  fileType: string;
  content: string;

  hashFileName: string;
}
