# Evaluation

The following is a critical evaluation of every significant area my project, including my choice of project and how it fits in with the modules that I have studied over the course of my degree.

## Choice of Project

Deciding upon a project that was challenging and feasible for the amount of time allocated for completion was quite a difficult task. Many ideas and concepts that I thought of were either already well investigated or posed the risk of being incomplete by the final deadline.
I proposed several ideas for a final year project to Marcus Winter, my project supervisor and he helped me decide upon my home automation alarm as the project that I should undertake.

The project I decided upon however addressed less of a computer science research project and instead is more focused on user design and interaction.

My reasons for the choice of my project are due to my interest in mobile applications development and in the concept of home automation.
I'm particularly interested in a future in which many common actions are handled transparently by automated systems, such as opening and closing curtains and adjusting lighting as required by the user without the need for direct user interaction and many other situations that can provide benefits by saving time each day, to assisting those who are unable to live alone and require regular assistance and house calls.

Overall I feel the project I chose has been challenging and is suited towards my degree and the modules that I have undertaken.

## Course Relation

Over the course of my degree I have undertaken multiple modules many of which are relevant to my final project.

### Mobile Application Development

Mobile app development is one module that clearly relates to my final year project having worked on a mobile application for my project.
Throughout the module issues such as platform independent issues and general principles for mobile user interaction design and the constraints of developing for a mobile platform.

The issues surrounding mobile web vs native applications were also addressed, deciding on leveraging native tools by developing directly for a platform or for the development of a cross platform application.

There are also many platform specific issues from the development environment and tool-chain, to the architecture and APIs provided that need to be addressed throughout the development and maintaining of the application.

I have worked with both physical and virtual devices and have been able to see the benefits and restrictions of both, such as leveraging the speed of a physical device both in installation and application usage, over the ability to emulate numerous devices and test the application in ways that could be very costly and time consuming.

Many requirements of most applications today are the need for; persistence and storage, multimedia, interacting with hardware sensors and web services. Arguably most important of all the deployment to the relevant platforms application store was also addressed, allowing an application to go from a development build to a signed and globally installable application.

Each of the mentioned aspects of the module influenced my design and development choices.

### Programming languages, concurrency and client server computing

As Android is based upon the Java development language, a language that has been taught and worked with throughout the course, much of what has been learned has been put into practice within my project. Many programming principles from the SOLID principles influencing my development choices to ensure the code being written wasn't fragile and could be easily extended in the future.

UI thread and concurrency are both key when developing for Android as there is a focus around ensuring only UI based activities take place within the UI thread, this is to prevent lock-ups and ensure that the user experience remains fluid and feels fast. Through the use of asynchronous tasks and other features available within Java, it is possible to run activities over multiple threads or cores, something that is becoming increasingly more important as the speed of cores remains the same or slower each year, with an increased focus on lower energy usage cores that can be activated as needed.

Java 8 provides many useful features to take advantage of aspects of functional programming, this can allow for easier implementation of concurrency within the application with the use of lambda expressions. Unfortunately the use of Java 8 is only available in the latest version of Android and as such, reduces the target market when developing. It is possible to write for both Java 8 and the same code for older versions of Android, however this would add unneeded complexity to my application.

RESTful APIs were covered within the module and proved useful for the development of my application with many APIs available today using RESTful interfaces including the Philips hue and weather API.

### Project management

Throughout the development of my application project management has been a useful skill to have, allowing for a balance between multiple projects and the insight to set goals and milestones to be able to evaluate the project during development.

By addressing issues outlined through missed deadlines, it is possible to reduce the impact of certain aspects of development, such as scope creep, or too much time being spent on one aspect while others go without being addressed.

### User design and product evaluation

My project focused mainly on the user design and so this module was helpful in how to perform user evaluation and to address not only the aspects that could do with improvement but also those that worked well, providing a useful feedback loop during development, allowing me to work towards the strengths of the application design and re-work aspects that could be improved.
