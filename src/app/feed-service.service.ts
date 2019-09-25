import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import {Observable} from 'rxjs'
import { Feed } from './model/feed';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class FeedServiceService {
  private rssToJsonServiceBaseUrl: string = 'https://rss2json.com/api.json?rss_url=';
  feed:any
  constructor(
    private http: HttpClient
  ) { }

 

  
}