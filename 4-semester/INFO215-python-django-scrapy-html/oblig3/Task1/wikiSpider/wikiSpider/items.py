# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy

class VergeReview(scrapy.Item):
    url = scrapy.Field()
    title = scrapy.Field()
    authorname = scrapy.Field()
    author_profile = scrapy.Field()
