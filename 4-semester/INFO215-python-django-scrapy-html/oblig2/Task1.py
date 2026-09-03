import ssl
from urllib.request import urlopen
from bs4 import BeautifulSoup
from urllib.parse import urljoin

# Create an SSL context that does not verify certificates
context = ssl._create_unverified_context()

# Open the Wikipedia page using the context
html = urlopen("https://en.wikipedia.org/wiki/Star_Wars:_The_Rise_of_Skywalker", context=context)

# Parse the HTML content using BeautifulSoup
bs = BeautifulSoup(html.read(), 'html.parser')

# 1. Extract all links (absolute URLs)
print("Links:")
for link in bs.find_all('a', href=True):
    href = link['href']
    absolute_url = urljoin("https://en.wikipedia.org/wiki/Star_Wars:_The_Rise_of_Skywalker", href)  # Get absolute URL
    print(absolute_url)

# 2. Extract all image sources (absolute URLs)
print("\nImage Sources:")
for img in bs.find_all('img', src=True):
    src = img['src']
    absolute_url = urljoin("https://en.wikipedia.org/wiki/Star_Wars:_The_Rise_of_Skywalker", src)  # Get absolute image URL
    print(absolute_url)
                                                                        