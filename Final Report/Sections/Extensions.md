# Further Areas of Investigation and Enhancements

During this project there are areas that given time and resources would like to have investigated or developed further into.

## Further Investigation

There are areas that I would like to have investigated into that through requiring a restricted scope I did not a get an opportunity to investigate further into.

### Android Platform

While developing my application for the Android platform it became clear there are plenty of libraries available for use. This can be attributed to not only being based upon Java, with Java having a large codebase and many libraries included and even more available by importing external libraries such as *Some android libraries/helpers*.

As the space of development is so large I would often conceive of a plan to resolve issues or implement functions within my application that may not have been the optimum solution. Through further experience with the platform and further time for development several solutions I implemented could have been implemented more efficiently, safer and more stable through the use of Android libraries or external libraries known to be improve development speed and code readability by addressing common Android development paradigms and styles.

### iOS and Other Platforms

Though Android makes the majority of the current mobile platform, iOS is second taking around a 12.5% market share \parencite{osMarketSahre} and so should be considered when developing applications.
It has been found that iOS users often will spend more on and within applications making the platform potentially more lucrative over others according to deatils from 2013 \parencite{appMoney}.

iOS applications can be written in several languages such as; Swift, C++, C Objective-C and more \parencite{iosDeveloperLanguage}. Much like the Android studio integrated development environment (IDE), iOS applications can be written within Xcode; Apple's own IDE. The benefits of using the IDEs is a tool-chain useful for developing, debugging and designing applications.

It would clearly be beneficial to be able to develop and application once and be able to deploy it across multiple platforms and systems. By leveraging systems such as \cite{cordova} it is possible to develop an application once and have it wrapped in a native container, this is then able to be distributed on respective platforms application store.

Cordova is able to use many native APIs available on the platforms being targeted and in doing so is able to blend with the native platform and appear like a regular app. There are APIs that are unavailable through Cordova however and so there may be a need to target a platform directly. Other benefits of buidling natively is the ability to write code at a lower level, for instance Android applications can be written in C and C++, allowing for lower level development which can be beneficial if applications are being written for lower powered devices or further performance is to be desired from the application.

### Functional Programming for Mobile Platforms

#### Java 8

#### Other languages

## Enhancements

Due to the limited timeframe to develop my application and the other projects and work undertaken throughout the year there are many aspects of my application that given the time, I would like to have implemented or improved.

### Integration With Other Smart-devices

One key area of enhancement would be to allow for my application to interact with other smart-devices that may be available around the home, anything from heating and kettles to a smart-toaster. By integrating more devices into my application this could allow for a greater level of home automation and make the morning work around the user and reduce the amount of interaction the user would be required to make in the morning.

### Improve the Weather functionality

The weather functionality within my app is limited to presenting the users with the weather of their specified city. Preferably the ability to obtain the users current location to pull the relevant weather would have worked better, though this would have required requesting the user to allow permissions for location tracking, something the user may not want to provide to an alarm application.

Other aspects of the weather that could use improvement would be to allow users to pick the source of their weather data as there multiple sources of weather data and each provide varying weather accuracy. This was not implemented due to API restrictions presented by many of the sources, limiting API usage for free accounts or requiring the need to pay for use. As this application is not currently intended for public use I opted for the OpenWeatherMaps (OWM) API \parencite{openweathermap}.

The weather icon font used within my application provides a neat way of displaying scalable graphics that can easily be displayed in different colours and reduce the number of graphics imported within my application, reducing the size of the application and clutter within the project structure during development. The icons fit well within the material design outlined by the Android design guidelines making them ideal for use within my application.

As each weather icon is presented using different character codes and these codes are stored within the strings.xml file within my application and the reference for each string includes the weather code returned by OWM, this is used to display the appropriate weather icon. Each weather API may return different weather codes however and due to this it is not possible to request the icon be displayed with a weather code provided by a different API. This could be implemented by providing an interface that can obtain the weather from various weather APIs and have a standardised weather code returned, though this would have taken quite some time as OWM returns over 90 different weather codes with more possible through the use of modifiers, for example; sunny with cloud or cloudy at night. As there are so many different weather codes to be handled I felt the time would be better spent on other aspects of my application.


### Increase Focus of An Intelligent Morning

Initially the concept for the application came from a desire for a greater level of home automation and a more useful alarm.

Currently there is a strong focus for contextual and relevant information being presented to the user as and when they need it. An example of this is if a user had a flight booked, through the use of Google Now/Assistant Google maps could recommend the time you would need to leave to get to the airport and the best route to take, once the user is at the airport their boarding pass can be easily accessed and any delays can be pushed to the user via notifications so the information is presented to the user and doesn't require any effort on behalf of the user.

This focus towards improving the user experience by reducing the effort required by the user is of interest and I feel there is a lot of work that can be done to improve such functionality. Currently these artificial assistants require some user interaction to see the information being presented; integrating my alarm application with the user schedule however it would be possible to present useful information after the alarm has been turned off. This information could be presented using text to speech (TTS) or by the use of a bold and brief notification being displayed on the screen.


### Implement more smart-bulb functionality

Currently my application allows for lights to be turned off and on however I would like to increase the functionality to match that provided by the manufacturer, this could include grouping lights, changing their names for easier identification but most essential would be the ability to adjust the brightness and hue of the lighting. I was unable to implement this before the deadline as there were other key aspects of my application that required work and refinement. Currently my application supports only Philips hue lighting systems, however the current product range for the Hue system alone covers 33 products of varying functionality and handling each in a user friendly way posed a challenge on presenting only the relevant options. By providing a simple switch to turn the light on or off however accounted for all of the products and in a way that fits within the Android platform well.
