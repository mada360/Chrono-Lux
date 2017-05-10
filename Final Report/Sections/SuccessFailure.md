# Success and Failure

In this section is an assessment of some of the successes or failures of the project as a whole.

## Successes

Within the project there were some highlights of success that are mentioned as follows.

### The Project

As outlined within the project specification several goals and stretch goals were set and if the goals were meant this would regard the project as being a success.
The application provides; alarm functionality, smart bulb integration and weather functionality each of which are the main goals set and as such the project was a success.

### Using SQLite

I had not foreseen the need to use a database within my application as the storage of alarms had not seemed to be a complex enough scenario to need a database. As the other storage methods available were not suited for storing an object with multiple variables however it was necessary to utilise the SQLite database for storage.

Though more complex than other storage methods, the use of database helpers reduced the need to write raw SQL queries and requests and allowed for a more programmatic style to interface with the database. Overall the database worked well.

### Pending intents

When developing the alarm and using the alarm manager it was necessary to use pending intents. Pending intents are simple enough to understand however their implementation is a little odd, as cancelling a pending intent requires another matching pending intent being produced, however the use of the `cancel()` method at the end cancels the pending intent.

Due to this and the need to allow the user to enable and disable an alarm, it was necessary to leave the pending intent and instead to check the alarm that was being triggered was enabled. In doing so there is no longer a need to create and delete pending intents for alarms that had been disabled, as the alarm object would still exist within the database and could cause errors if there was an ID mismatch.

## Failures

Although the project was successful, there are several aspects that failed to be implemented or did not make it into the final application.

### No Adjustable alarm

Due to the time picker not returning values, the alarms are created from within the listener method, because of this it made it difficult to be able to allow for alarms to be changed once set. The lack of ability to pass values into the time picker means that there is no way to pass an alarm id into the method either, something that could allow for a check to see if an alarm by that ID already exists, if the alarm does exist adjust the time and if not create a new alarm.

### Not Reaching Stretch Goals

This could be classed as not being a failure, as the main goals outlined have been met. However I feel that the stretch goals would have worked well within my application and helped it to stand out more through being more than a regular alarm application, more so than the inclusion of controlling smart-lights.
