# Accomplishments

The following are some of the accomplishments within developing my application of which I am most proud.

## The Ability to Control Lighting

There are very applications available that allow for the connection to and manipulation of smart-lights from within the application. Because of my app being one of these few I feel is an accomplishment.


## The Application UI Design

Overall I feel the look and feel of application works very well; it adheres to the Android design guidelines \parencite{androiddesign} and feels like a native application by maintaining a cohesive user experience.

### Tab Navigation

The tab navigation works well, providing the user with a simple and clean way for using my application. By providing only the relevant functionality for each tab the user experience is simple and intuitive. Through avoiding too much being displayed on the screen at once, relevant information can be seen instantly ensuring ease of use and allowing the user to only spend as long as necessary within the application.

Through including tab navigation it was required to use fragments within my application, fragments are not as simple to use as a regular activity and pose multiple design challenges over an application activity. The extra difficulty associated with fragments did slow the initial development of my application and my initial tab view needed to be replaced due to the use of several deprecated styles. Despite this challenge I feel the fragments work well within my application and the functionality I outlined within my project has been accomplished.

### Snackbars and Toasts

By developing for newer versions of Android I utilised the snackbar notification system introduced in API level 23. The snackbar in most instances replaces the original Toast notification system. Snackbars improve upon toast in many ways as they; provide information to the user and allow the user to interact with the notification by performing an action if provided by the snackbar, such as undoing an action that triggered the snackbar to be displayed. The snackbar can also be dismissed by swiping, while the toast is displayed until the specified display time has passed.

Toasts are stilled used within the newer versions of Android, however they are now often used for system notification as they can be displayed without being associated with an activity and as they can't be dismissed are good for showing warnings or important information.
Snackbars also blend better within an application, showing up above or moving elements such as a floating action button, ensuring that the notification can be seen and that aspects of the view are not obstructed.

It is specified within the guidelines that a snackbar should be displayed as long as necessary, as such short notifications should not be displayed for a long time, while notifications that provide an action or consist of a lot of text should be displayed for longer to allow the user to fully read the text or provide adequate time for interaction.


### Using the Weather Icon Font

*TODO*
