from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from urllib.parse import urljoin, urlparse

def crawl_site(base_url):
    options = Options()
    options.add_argument('--headless')
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)

    visited = set()
    to_visit = [base_url]

    while to_visit:
        current_url = to_visit.pop()
        if current_url in visited:
            continue
        visited.add(current_url)
        print("Visiting:", current_url)

        driver.get(current_url)
        # Print text from elements matching the XPath
        for element in driver.find_elements(By.XPATH, "//span[@class='C9DxTc ']"):
            text = element.text.strip()
            if text:
                print("Text:", text)

        # Find internal links and add them to the list
        for link in driver.find_elements(By.TAG_NAME, "a"):
            href = link.get_attribute("href")
            if href and urlparse(href).netloc == urlparse(base_url).netloc and href not in visited:
                to_visit.append(urljoin(base_url, href))

    driver.quit()

if __name__ == "__main__":
    crawl_site("https://sites.google.com/view/nikt2024?usp=sharing")