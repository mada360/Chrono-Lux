# Literature Review

There a currently several home automation systems available to the public market including smart heating with the \cite{hive} and \cite{nest}, automated lighting with the \cite{philipshue} and integrated automation in the form of the \cite{echo} which provides a wide array of functionality and can be linked with many of the previously mentioned systems to provide whole home automation. 

The market of home automation is growing while the cost of entry decreases, with advancements in LED technology the \cite{philipshue} has become more affordable. The \cite{echo} is also at a very affordable price with Amazon keeping the costs low to increase market saturation. 

Current devices use the Bluetooth low energy and Wi-Fi standards, often with a internet connected hub to handle communications. Wi-Fi is relatively power intensive and provides a bandwidth excessively large for the application, while BLE has limited range. 

New standards \cite{zwave} and \cite{zigbee} are being developed, both using far less power allowing for extended battery life. Both have limited range like BLE however \cite{zwave} is designed to create an interconnected network between devices to maintain low power while extending the range.

## Philips Hue

The \cite{philipshue} system uses the \cite{zigbee} standard, though all of this is transparent as the method of interfacing with the devices is to use 'GET', 'PUSH', 'POST' and 'PUT' URL requests and provide JSON formatted commands in the body to interact.

The state of a specific light can be received using 'GET' and providing the URL
/api/devID/lights/1 or all of the lights by not specifying the number.

The state can be changed using 'PUT' instead and providing attributes and their values that you would like to change, for example: 

```json
{"on":true, "bri":255} 
```

A few useful attributes:
on = true/false
bri = Brightness between 0 and 254 

Colour settings include:
sat = Saturation between 0 and 254
hue = The hue of the light (hue runs from 0 to 65535)


## Human Perception of Light

Many human senses are based on a logarithmic scale, this is to say we are far more able to distinguish changes in light or sound in the lower band of the senses compared to higher, so whispering occurring will have a more distinguishable change in volume than two jet engines roaring.

The same applies to sight, it is more important to distinguish details in low light such as that from the moon compared to the light change of daylight at varying times of the day. We do this to normalise our senses to best suit our environment. 

