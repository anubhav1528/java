import { Injectable } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FeedServiceService } from './feed-service.service';
import { FeedEntry } from './model/feed-entry';
import { HttpClient, HttpResponse } from '@angular/common/http';
import {Observable} from 'rxjs'
import { Feed } from './model/feed';
import { map } from 'rxjs/operators';

// Add the RxJS Observable operators we need in this app.
@Injectable({
  providedIn: 'root'
})

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  private feedUrl: string = 'https://www.who.int/rss-feeds/news-english.xml';
  private rssToJsonServiceBaseUrl: string = 'https://rss2json.com/api.json?rss_url='
private feed:any;
private feeds :any;
private responseText = document.getElementById('response');

  constructor (
    private feedService: FeedServiceService,
    private http: HttpClient
  ) {}

  ngOnInit() {
    
    
    this.refreshFeed();
  }

  refreshFeed() {
    // Adds 1s of delay to provide user's feedback.
    this.getFeedContent(this.feedUrl)
        .subscribe(
          feed => this.feeds = feed.items,
            
            );
  }
 
  
  

  getFeedContent(url: string): Observable<Feed> {
    return this.http.get(this.rssToJsonServiceBaseUrl + url)
            .pipe(map(this.extractFeeds));
            

  }
  private extractFeeds(res: Response): Feed {
    this.feed = res;
    console.log(this.feed);
    console.log(this.feed.items[0].title);
    
    return this.feed;
  }

}