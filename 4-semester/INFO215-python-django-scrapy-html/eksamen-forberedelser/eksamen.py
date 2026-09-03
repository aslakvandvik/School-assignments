#1.
#Import necessary libraries
from bs4 import BeautifulSoup # For parsing HTML
from urllib.request import urlopen
#Define the URL to scrape
url = "http://books.toscrape.com/"
#Open the URL and get the HTML content
html= urlopen(url)

#Parse the HTML content using BeautifulSoup and the built-in HTML parser
bs= BeautifulSoup(html.read(), "html.parser")
#Find all book entries on the page

#Each book is contained in a tag with class "product_pod"
books = bs.find_all("article", {"class": "product_pod"})
#Loop through each book found and extract specific information
for book in books: # Extract the title of the book from the tag using the 'title' attribute
    title = book.h3.a.get("title")

    # Extract the price of the book from the <p> tag with class "price_color"
    price = book.find("p", {"class": "price_color"}).text

    # Extract the image thumbnail source URL from the <img> tag
    thumbnail = book.find("img").attrs["src"]

    # Print the extracted information
    print("Title: " + title + ", Price: " + price + ", Thumbnail: " + thumbnail)