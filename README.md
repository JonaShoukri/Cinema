# Cinema
 This is a cinema Ticketing system designed for both client and administrator use.
 
This system design used the chain of responsibility pattern, the visitor pattern, the startegy pattern and the chain of responsiblity as follows:

The visitor has two interfaces (strtaegies) to choose from (admin or client). After having chose one of the two, the user visits the cinema and changes its state through the use of its chosen interface (strategy). The chain of responsability is used to compare Showtimes to one another and make sure they dont overlap. Please visit UML for further detail on design.
 
 The application starts off completely empty with no movies, showtimes, viewings or halls in the cinema. The admin must therefor login first and add a movie, a showtime and a hall. He can then create a viewing based on those three objects. without one of each of those object, the admin wont be able to create a viewing and the clients wont be able to get tickets. After a couple users have bought tickets, you can sign back in as admin and look at all the reservations made.
