from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup
from time import sleep

BASE_URL = 'https://www.autotrader.ca/'
#change these variables to suit needs
POSTAL_CODE = 'LLL LLL'                     #Keep format with space
MAX_PRICE = 7500                            #kilometers
VEHICLE_MAKE = 'Volkswagen'                 #Make
VEHICLE_MODEL = 'Jetta'                     #Model
PAGE_SIZE = 100                             #options: 15,25,50,100 - not exact

driver = webdriver.Chrome()

#create searchURL then find page
postalCodeSplit = POSTAL_CODE.split(' ')
searchURL = BASE_URL+ "cars/?rcp="+str(PAGE_SIZE)+"""&rcs=0&prx=100&hprc=True&wcp=True&sts=New-Used&inMarket
            =basicSearch&mdl="""+VEHICLE_MODEL+"&make="+VEHICLE_MAKE+"""&loc=
            """+postalCodeSplit[0]+"%20"+postalCodeSplit[1]+"&pRng=%2C"+str(MAX_PRICE)
driver.get(searchURL)

#finds all listings
soup = BeautifulSoup(driver.page_source, 'html.parser')
listings = soup.findAll('div', class_='result-item-inner')

#will pull all names, links, details and distance of each post
listingList = []
for listing in listings:
    listingInfo = listing.find('div', class_='listing-details')
    titleAndLink = listingInfo.find('a', class_='result-title click')

    if titleAndLink is None: continue

    title = titleAndLink.find('span').text.strip()
    link = titleAndLink.get('href')
    details = listingInfo.find('p').text.strip()
    price = listing.find('span', class_='price-amount').text.strip()

    if listingInfo.find('div', class_='kms') is not None:                               #Some do not contain text attributes
        distance = listingInfo.find('div', class_='kms').text.strip().split()
    else: distance = 'N/A'
    
    listingList.append({'title':title, 'distance':distance[1], 'price':price,           #add to dictionary
                        'details':details, 'link':link})  

listingList = sorted(listingList, key = lambda i: (i['distance'], i['price']))          # sorts by distance then price
for i,post in enumerate(listingList):                                                   #print statment
    print(f"""{i+1}:\n{post["title"]}\n{post["distance"]}\n{post["price"]}              
            {post["details"]}\n{BASE_URL+post["link"]}\n\n""")

driver.quit()
