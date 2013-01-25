WebEntwT
========

This is a project of web development (2012/13) for M.Sc. Media Processing and Interactive Services of the University of Applied Sciences Schmalkalden.
It can also be obtained at [GitHub](https://github.com/chrisUse/WebEntwT "Project at GitHub").

Prerequisites
-------------

* use NetBeans
* open all three projects in NetBeans

Building and running
--------------------

1. clean, build and run WebService before you are running OnlineShop (OnlineShop needs to fetch the WSDL file from WebService to generate some sources)
2. clean, build and run OnlineShop
3. you are done



Additional information
----------------------

* Bilingual pages

 - New product 
 - Edit product

* Exceptions

 - When the project starts, a file not found exception is displayed (because the webservice is'nt running and it wants to refresh the WSDL)
 - When OnlineShop is built for the first time, there may appear a file not found exception sometimes, even if the webservice is running. If this is the case, just clean&build Onlineshop again and the error is gone.

