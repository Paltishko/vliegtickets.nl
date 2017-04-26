# vliegtickets.nl
*This project performs autotesting of vliegtickets.nl website

##Current functionality:
###LoginPage:
    - positiveLogin
    - invalidLogin
    - noEntryLogin (Currently site reloads login page in case no username and password were provided, I would expect to see some error message without page reloading. The same happens if I try to enter login less then 3 symbols or password less then 5 symbols)
    
###SearchResultsPage:
    - getCheapestTickets: This TC look for tickets to Kiev Borispol on tomorrow date. Gets two cheapest prices and saves it to file Log.txt
