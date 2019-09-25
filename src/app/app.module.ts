import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

// Material design.


import { AppComponent } from './app.component';
import { FeedCardComponent } from './feed-card/feed-card.component';
import { FeedServiceService } from './feed-service.service';
import { StripHtmlTagsPipe } from './pipe/strip-html-tags.pipe';


@NgModule({
  declarations: [
    AppComponent,
    FeedCardComponent,
    StripHtmlTagsPipe,
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    
  ],
  providers: [FeedServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }