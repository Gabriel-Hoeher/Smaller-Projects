# AutoTrader-Scraper

This is a web scraping script that pulls information about vehicle listings off AutoTrader.ca.

When run the script will return a list to the console, containing information about vehicles that are listed. The user must enter their location (postal code), maximum price, vehicle make, model and page size.

Page size is not exact due to autotraders website, however it will be an estimate of the range of listings. 

This script uses the library Selenium to navigate to the specific page and BeautifulSoup to parse the data.   

# Example Output: 
92: (list number)

2011 Volkswagen Jetta Sedan (title)

226,318 (mileage in kilometers)

$6,995 (price)

The vehicle history report shows a CLEAN TITLE on this Sedan plus a 3 Month - 5000 Kilometers Power-Train warranty is included... (description)

https://www.autotrader.ca//a/volkswagen/jetta/victoria/british%20columbia/5_49614968_20190507160320146/?showcpo=ShowCpo&ncse=no&orup=40_100_361&sprx=-1 (link)
