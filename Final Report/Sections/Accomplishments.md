# Accomplishments

The following are some of the accomplishments within developing my application of which I am most proud.

## The Ability to Control Lighting

There are few applications available that allow for the connection to and manipulation of smart-lights from within the application. Because of my app being one of these I feel is an accomplishment.


## The Application UI Design

Overall I feel the look and feel of my application works very well; it adheres to the Android design guidelines \parencite{androiddesign} and feels like a native application by maintaining a cohesive user experience.

### Tab Navigation

The tab navigation works well, providing the user with a simple and clean way for using my application. By providing only the relevant functionality for each tab the user experience is simple and intuitive. Through avoiding too much being displayed on the screen at once, relevant information can be seen instantly ensuring ease of use and allowing the user to only spend as long as necessary within the application.

Through including tab navigation it was required to use fragments within my application, fragments are not as simple to use as a regular activity and pose multiple design challenges over an application activity. The extra difficulty associated with fragments did slow the initial development of my application and my initial tab view needed to be replaced due to the use of several deprecated styles. Despite this challenge I feel the fragments work well within my application and the functionality I outlined within my project has been accomplished.

### Snackbars and Toasts

By developing for newer versions of Android I utilised the snackbar notification system introduced in API level 23. The snackbar in most instances replaces the original Toast notification system. Snackbars improve upon toast in many ways as they; provide information to the user and allow the user to interact with the notification by performing an action if provided by the snackbar, such as undoing an action that triggered the snackbar to be displayed. The snackbar can also be dismissed by swiping, while the toast is displayed until the specified display time has passed.

Toasts are stilled used within the newer versions of Android, however they are now often used for system notification as they can be displayed without being associated with an activity and as they can't be dismissed are good for showing warnings or important information.
Snackbars also blend better within an application, showing up above or moving elements such as a floating action button, ensuring that the notification can be seen and that aspects of the view are not obstructed.

It is specified within the guidelines that a snackbar should be displayed as long as necessary, as such short notifications should not be displayed for a long time, while notifications that provide an action or consist of a lot of text should be displayed for longer to allow the user to fully read the text or provide adequate time for interaction.


### Using the Weather Icon Font

The usage of the weather icon font provides multiple advantages over that of PNG, JPG or SVG graphics. Of these graphics types JPG doesn't allow for transparency and so would require a background colour to be saved, this would not only increase the storage space required to store the image, but would require the image to be edited if the background colour of the view were to be changed, making the use of a stored background difficult to manage. PNG does allow for transparency, however PNG images requires a relatively larger amount of storage space when compared with JPG.

PNG and JPG are bitmap image types, meaning they store all the pixel data such as colour values and luminosity among other values as essentially a three dimensional array over the colour space. Due to the means of storage the graphics are not suitable for scaling, especially to increase the size of the graphic as this would require the need to generate data that does not exist; for example in an image that is $800 \times 800$ pixels, there would be 640,000 pixels, if the image were scaled to $1000 \times 1000$ pixels there would need to be 1,000,000 pixels and as a result 360,000 pixels need to be generated from the existing image, resulting in processing artefacts, banding or other graphical errors.

SVG is a vector graphic and consists of instructions on how to draw a graphic and this is handled when the image is to be displayed. Due to this flexible drawing ability, the graphic can be generated to be as large as required with a trade off of computational time for storage, compared to bitmap images. Android is now capable of handling both types, however this has not always been the case. SVG support has been officially supported for versions above 4.4 (KitKat) with many adopting workarounds using the webview library prior to support \parencite{svgAndroid}. As a result there are many poor implementations of using SVG and the current advice provided in the Android guidelines is to generate PNG graphics from SVG files as to support older devices. When the PNG files are produced multiple sizes can be generated to support devices of varying screen sizes and in doing so requires multiple sizes of the same file to be saved, taking up more storage space.

By using a TrueType Font (TTF) it is possible to gain the benefits of an SVG without the need to generate resource files or use unsupported implementations to display the graphics. Other benefits include the ability to easily colour the icons by changing the font colour, the font appears as a single file within the Android project resulting in less clutter in the project structure. Lastly the size required to store the font consisting of hundreds of icons is relatively small as it requires 98kb of storage while a single large PNG around 30kb.
