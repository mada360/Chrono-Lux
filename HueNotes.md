# Hue Notes

## API Format

The API format used is JSON.

### Useful API calls

/api/devID/lights/#

# = The number of the light you would like to interact with i.e. 1

The state of a specific light can be recieved using 'GET' and providing the URL
/api/devID/lights/1 or all of the lights by not specifying the number.



The state can be changed 



{"on":true, "bri":255} 

on = true/false
bri = Brightnes between 0 and 254 

Colour settings include:
sat = Saturation between 0 and 254
hue = The hue of the light (hue runs from 0 to 65535)


