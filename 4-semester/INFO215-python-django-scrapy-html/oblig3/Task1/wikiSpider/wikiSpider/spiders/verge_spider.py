import scrapy
from scrapy.spiders import CrawlSpider, Rule
from scrapy.linkextractors import LinkExtractor
from wikiSpider.items import VergeReview

class VergeSpider(CrawlSpider):
    name = 'verge'
    allowed_domains = ['theverge.com']
    start_urls = ['https://www.theverge.com/reviews']

    rules = (
        Rule(LinkExtractor(allow=(r'https://www\.theverge\.com/\d+/[^/]+$', 
                                  r'https://www\.theverge\.com/[a-z-]+/\d+/[^/]+$')), 
                                  callback='parse_item'),
    )
    def parse_item(self, response):
        item = VergeReview()
        item['url'] = response.url

    # Extract title using XPath
        item['title'] = response.xpath('//h1/text()').get()

     # Extract author name using XPath
        item['authorname'] = response.xpath("//p//span//a/text()").get()

        # Extract author profile link using XPath
        author_link = response.xpath("//p//span//a/@href").get()
        if author_link:
            item['author_profile'] = response.urljoin(author_link)

        if item['title'] and item['authorname']:
            yield item