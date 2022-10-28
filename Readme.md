# Movie Booking

## Implementation

1. Application is developed in Spring Boot 2.0.0 with Java 8 on Spring Tool Suite IDE. Database used is MySQL.

2. You can book movie tickets using the application.

3. Mandatory entities to book a ticket are - user, movie, theater with seats, shows of configured movies in configured theater with seats.


## Assumptions

For the simplicity of system, I have made following assumptions while implementing the solution -

1. Single User Model - One user will use at once. No locking implemented for seat selection. 
2. Single Screen Theaters - No multiple screen handling for a theater has been done. However an option is given for future scope.
3. 10 seats for each show are configured - 5 for CLASSIC and 5 for PREMIUM. Seat numbers are kept fixed in all theaters. 
4. No Payment flow used.


