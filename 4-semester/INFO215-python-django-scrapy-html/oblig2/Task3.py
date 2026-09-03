import ssl
from urllib.request import urlopen
from bs4 import BeautifulSoup
from urllib.parse import urljoin

""" Create unverified SSL context, im on MAC OS and this is the only thing that worked for the certificate,
should not be used in production code. """
context = ssl._create_unverified_context()

html = urlopen("https://en.wikipedia.org/wiki/Web_scraping", context=context)
bs = BeautifulSoup(html.read(), 'html.parser')

seealso = bs.find("div", {"class": "div-col"})
for link in seealso.find_all('a', href=True):
    href = link['href']
    absolute_url = urljoin("https://en.wikipedia.org/wiki/Web_scraping", href)
    print(absolute_url)

    html2 = urlopen(absolute_url, context=context)
    bs2 = BeautifulSoup(html2.read(), 'html.parser')
    firstparagraph = bs2.find("p", class_=lambda x: x != 'mw-empty-elt')

    try:
        print(firstparagraph.text)
    except:
        AttributeError
