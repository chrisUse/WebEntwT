WebEntwT
========

* use NetBeans
* open all three projects in NetBeans

1. run WebService before you are running OnlineShop (OnlineShop needs to fetch the WSDL file from WebService to generate some sources)
2. run OnlineShop
3. you are done

* Bilingual pages

 - New product 
 - Edit product

* Exceptions

 - When the project starts, a file not found exception is displayed (because the webservice is'nt running and it wants to refresh the WSDL)
 - When OnlineShop is built for the first time, there may appear a file not found exception sometimes, even if the webservice is running. If this is the case, just clean&build Onlineshop again and the error is gone.

