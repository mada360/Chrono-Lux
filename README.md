# Chrono-Lux

Diary

- 03/11/2016 - Exceeded word count and so need to reduce it to below 2000
- --/--/---- - Met with Marcus
- --/--/---- - Met with Marcus
- - Reading into the Philips Hue API and trying out the app. The API seems fairly straight forward, though authenticating with the hub could be a challenge.
- - There is no need to handle the hub connection through JSON, there is instead a Philips hue library that can be imported for use. It provides extra functionality to handle all API calls, though I think I will opt for directly using the JSON API.
- 02/01/2017 - Attempting to develop the layouts for my app. I'm finding a lot of the Android library to be deprecated such as snackbars replacing the toast messages; to handle these and correctly show them as per the design guidelines is not as straight forward.
- 03/01/2017 - Using the container layout with a nested linear/relative layout is needed to handle the snackbar and it is now rendering correctly. More issues have occured as I would like a tabbed toolbar for navigating through the different aspects of the app such as alarm/light control/weather. The tabs require fragments and a pageviewer to handle displaying the correct layout and I'm having issues with the app closing on start. I have also made an icon for my app to replace the default green android.
- 04/01/2017 - I am still facing issues with the tablayout as it doesn't appear to render correctly and trying to access certain fragments closes the app. I'm finding a lot of resources are quite outdated and many show incorrect or incomplete implementations.
- 05/01/2017 - The tab pages are now working correctly. I have a spinner that can display multiple String elements, I am now trying to display alarm objects in the list instead but am having difficulties.


TODO
- [ x ] Complete interim report
- [ x ] Begin Designs
- [ ] Develop prototypes
- [ ] 
