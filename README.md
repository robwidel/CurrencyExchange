# CurrencyExchange
Class GetCurrentRate uses selenium web driver to open chrome and gets current rate by CSS Selector from 
"http://api.nbp.pl/api/exchangerates/rates/a/gbp?format=xml" page  in XML format.
To use selenium one needs a chromium webdriver.exe with its path in System.setProperty second argument.

Class GUI creates a GUI that is responsible for visual part of application. It is created using javax.swing library and java.awt for buttons etc.
At first GUI used the button to calculate, later it was changed so it would autmatically calculate the output based on the value inserted so far.
Data type used for calculating the output is BigDecimal as it is the best way to calculate decimal numbers, since it doesnt work like double using mantissa but is a class created to control decimals. The ammount of numbers after '.' is 4 because thats the standard way in currency exchange as far as I'm aware and the exchange rate is so.

I have decided not to implement unit tests as it serves no purpose. The way to test the output is to take the current rate and use it to calculate value in some calculator and then compare to the output of the application. The value of current(today) value of exchange rate should be checked similarly, by comparing the value of seen in gui window (on the bottom) with the value from webpage.
Further testing may check what is the response for non numerical data types. The programme doesnt allow non numerical input. If one is to try to input a character it will be instatntly removed, and a box message will appear asking to input some numbers. The only way of inputing a negative number is to copy and paste it but the error box on top will display a message demanding positive value input.
Only a single input field can be accessed at a time, because the second also works as an output field.
