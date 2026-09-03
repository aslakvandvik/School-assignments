#items.py
import scrapy

class Book(scrapy.Item):
    title = scrapy.Field()
    price = scrapy.Field()
    thumbnail = scrapy.Field()

#spider
import scrapy
from ..items import Book

class BooksSpider(scrapy.Spider):
    name = "books_xpath"
    allowed_domains = ["books.toscrape.com"]
    start_urls = ["http://books.toscrape.com/"]

    def parse(self, response):
        # Each book card
        for prod in response.xpath("//article[contains(@class,'product_pod')]"):
            item = Book()
            item["title"] = prod.xpath(".//h3/a/@title").get()
            item["price"] = prod.xpath(".//p[contains(@class,'price_color')]/text()").get()

            src = prod.xpath(".//div[contains(@class,'image_container')]//img/@src").get()
            item["thumbnail"] = src.replace("../../", "").lstrip("/") if src else None

            yield item

        # Follow pagination
        next_href = response.xpath("//li[@class='next']/a/@href").get()
        if next_href:
            yield response.follow(next_href, callback=self.parse)