This is a simple RSS crawler spring boot application.
In order to run it simply
```
git clone https://github.com/nirtsruya/rsscrawler.git

mvn package
```

run the rsscrawler-1.0.jar file from target.

Paths:
/
The homepage
you will see the crawled posts being added to a table

GET /posts
will return a list of the crawled posts

POST /crawl
sample request body:
```
{
    "url" : "http://rss"
}
```

On startup the application will start a thread that will start crawling on a sample rss feed.
To add new urls to crawl, use the POST /crawl api.