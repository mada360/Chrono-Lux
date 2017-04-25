# Research

There are aspects of my project that my research before and during development influenced my app from what I had initially planned.

## Philips Hue API

My project utilises the Philips Hue connected light bulbs, the \cite{philipshue} system uses the \cite{zigbee} standard, though all of this is transparent as the method of interfacing with the devices is to use 'GET', 'PUSH', 'POST' and 'PUT' URL requests and provide JSON formatted commands in the body to interact.

The state of a specific light can be received using 'GET' and providing the URL
/api/devID/lights/1 or all of the lights by not specifying the number.

The state can be changed using 'PUT' instead and providing attributes and their values that you would like to change, for example:

```
{"on":true, "bri":255}
```

A few useful attributes for my application are:
on = true/false
bri = Brightness between 0 and 254

Colour settings include:
sat = Saturation between 0 and 254
hue = The hue of the light (hue runs from 0 to 65535)

Through researching into the Hue API further there existed a Hue Software Development Kit (SDK), by using implementation of the Hue SDK most interactions with the lighting that would require the use of the RESTful API are now able to be accessed using Java methods. The Hue SDK exists alongside a very basic example Android application that allows the connection to the Hue bridge used for interfacing with the lights and a button to randomly adjust the hue values of the lights connected to the bridge.

### Influence

The implementation example of the bridge connection and the storage of the API key required to authenticate a connected device/application included was very useful for the initial set-up for interfacing with the Hue lighting platform and as such a direct use of the RESTful API has not been implemented within my application to interface with the Hue lighting but instead the Hue SDK.

## Design Considerations

Through my research I have found that it has been shown bright lighting, blue light in particular can affect the circadian rhythm of the body which is used to regulate sleep patterns \cite{oh2015analysis}.
There are applications used to reduce the amount of blue light displayed in the evening and through the night, applications such as flux \parencite{flux} and features included within mobile operating systems such as iOS \parencite{iosNightShift} and Android platforms \parencite{samsungBlueFilter}.

### Influence

My application will often be used within a low-light or dark scenario and as such I will design the application to use a dark colour scheme.

A light colour scheme could be quite energising to the user and could potentially make them more alert which is not ideal before going to sleep and could extend the duration it takes to fall asleep, resulting in restlessness and a poor nights sleeps.

## Human Perception of Light

Many human senses are based on a logarithmic scale, this is to say we are far more able to distinguish changes in light or sound in the lower band of the senses compared to higher, as such a small increase in volume of a whisper will be a more distinguishable change in volume than two jet engines roaring and increasing by their volume by a small amount.

The same applies to sight, it is more important to distinguish details in low light such as that from the moon compared to the light change of daylight at varying times of the day. We do this to normalise our senses to best suit our environment.

This kind of stimulus perception is defined as the just-noticeable difference (JND). Firs summarised by Ernst Weber in 1834 his equation was called Weber's Law and simply stated that response intensity increases as stimulus intensity increases \parencite[p. 1613-1615]{salkind2010encyclopedia}. Further refined by Gustav Fechner who proposed the use a constant to provide a curve to the stimulus/perception relationship. Fechners' law was a much better fit, however some stimulus did not fit well, such as that of electric shock.

Most recently in the 60's an American psychologist S. S. Stevens produced a formula that worked for all forms of stimulus, even for electric shocks \parencite{stevens1957psychophysical}. He proposed an exponential function raising the data to a power rather than using a simple constant. This essentially stated that to get a linear increase in perception of various stimuli, the stimulus would need to increase in an exponential form.

### Influence

Due to this perception of light I feel increasing the brightness of the lighting in the room in a logarithmic fashion will produce a perceptibly more natural and linear increase in brightness over increasing the value directly from 0 to the maximum value.
