# Recent changes
1) Actual model classes implmenetation like (DbDateTime, DbDate, DbTime) were Final, but forgot to add Final keyword at class level, that's corrected now.
2) DateUtil method, was using unnecessary method parameter - removed that
3) As given more time to read / think code, has improved few classes to make them better redable and modular.

# Instructions to run this assignment
You can change datetime input values in Main.java class and run this as simple java application using any editor

Also you can run individual JUnit's (created using JUnit 5 / Jupiter)

# Pre-requisites

* Java 11
* JUnit 5
* Maven
* IntelliJ Editor (optional)

# datetime-assignment - problem statement

Using OOAD,OOPS  concepts, write  a java program that  :

1)      Accepts an user input of date time in number format .
2)      This input  has following  Pattern dd-mm-yyyy hh:mm:ss AM/PM
3)      AM will be considered as Morning and PM will be considered as Evening
4)      Validate the date and time correctness without using java api
5)      In case of validation fails, print message invalid date time with input
6)      Prints the word equivalent of date and time
7)      Print the  day of the week for given input without using java api.
8)      This program will not use Java Calendar,  LocalDatetime and Day of week api .It can use java util date api for date creation only.
9)      Add junit test cases

* For example  
Input date time : 21-01-2021 06:07:10 AM  

* Output:

Valid Date : 21st-Jan -Twenty TwentyOne

Valid Time : Six Hours Seven Minutes Ten Seconds - Morning
