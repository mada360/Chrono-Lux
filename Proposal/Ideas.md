# List of Ideas

- An alarm app with smartbulb and news/weather integration.
- Password stength and the limitations enforced.
- An android lock application that will unlock with a specific knock pattern.
- LiFi - Data transmission over light

# Breaking down ideas

## A smartbulb alarm (Android)


### Intro

There are plenty of alarm apps available for Android and iOS devices but they don't really do much besides set an alarm, something an alarm clock has been able to do for years. Newer alarm clocks with new features and gimmicks are released but the phone alarm is rather stagnant. I'd like to devlop an app that improves upon just waking you up with useful and informative features such as;

- Using WiFi bulbs to increase the ligthing in the room leading to a sunrise affect and allowing for a smoother transition into wakefullness.

- Announcing/Displaying useful information. Many people check the weather or news in the morning and many have busy lifestyles with varied task daily; by announcing (Text to speech) or displaying all the usefull and relevant information to them as they wake up.

- Being a great alarm, without having all the features that users are accustomed to why would they want to switch? So the alarm must have the ability to set reccuring alarms and other useful features. 

### Pros

The pros of this idea:

- I am familiar with android devlopment and own an android phone/tablet allowing for faster devlopment.

- WiFi bulbs can be fairly inexpensive and bluetoth enabled bulbs exist also.

- The app is very practicle and could be submitted to the playstore for downlaod and use by millions of users. 


### Cons

- Although WiFI bulbs are fairly inexpensive, many require expensive hubs making the expense a potentially limitting factor.

- Many smart bulbs run using propriatary APIs which could lead to difficulty in development and mass use.

- Developing an attractive and functional app could be quite difficult and I may waste time on trying to tweak appearance over devloping the core functions of the app.
 
## Password strength and limitations enforced

### Intro

Many websites require strict password requirements and can vary massively from being as simple as minimum length required to requring upper case, lower case, numerical and symbols. Some websites even have a maximum character limit. All of this has resulted in many people having simple passwords such as a word and a number, usually related to them making them easy to remember but also extremely easy to guess or crack. 

Due to the level of complexity usually required many people use shorter passwords that are usually the minimum characters required and are harder to remember so they use the same password on multiple sites; if one site is compromised it would be easy for an attacker to breach all of their other accounts.

I would like to produce an experiment in how secure password really are and just how memorable they can be if the only restriction is a longer character limit and suggestions rather than requirements.

By having a group of subjects think of several passwords with varying levels of password requirments and over a period of time have them attempt to sign into a basic test account and see how easily they are able to correctly sign in. The varying password requirments would be as follows;

1) Only a minimum character limit of 10 characters. 

Minimum entropy = approx 47 bits

2) A minimum character count of 8, but must also include at least one number and upper case. (Common for mose websites)

Minimum entropy = approx 47.6 bits

3) A minimum count of 20 characters with at least one uppercase character and a hint.

Minimum entropy = approx 119 bits

Passwords with fewer characters are more rapidly cracked by means of brute force and for many years it has been required to add varying alphanumeric and symbol characters to increase the entropy, but in doing so passwords become a challenge to remember.  


For reference at a fairly moddest 350 billion guesses per seccond the minimum entropy of the first 2 types of password would take less than an hour to crack, while the 3rd would require many lifetimes.


### Pros

- Would be relatively easy to setup as it would require a basic database and login portal

- As the passwords wouldn't neccesarily need to be hashed and salted this reduces complexity and system resources required.

- A good way to verify if a longer password would be easier to remember than a shorter more complex password.

### Cons

- Not that difficult to devlop.

- Requires users to use the system and so may be difficult to get enough people to test the system which would skew the results.

- As the password(s) wouldn't be used for anything of personal interest to the subjects they may be more likely to forget the passwords than in a realworld sittuation.


## An android lock screen based on knock pattern recognition

### Intro

On android there are multiple lock screen types such as a PIN, password, pattern or facial recognition. Each has their strengths and weaknesses and moslty depend on personal preference, for example;

PIN - Can be quite short and so is eaisly and quickly typed in, however the length also makes it easier to crack.

Pattern - Quick and easy to use but not too complex and someone could pottentialy see the pattern as you swipe or by looking for marks on the screen.

Facial recogniton - Can be fairly quick and requires almost no interaction but doesn't work 100% of the time and requires a second form of security verification if it fails several of times consecuatively.

Most people are ok with using fairly simple security on their phones as they are used multiple times throught the day and so a more complex security system may take longer to unlock the device leading to frustration and wasted time.

The knock pattern unlock would most likely take longer than any of the other forms of secuirty however it doesn't require the user to see their device making it ideal for those whith impaired vision of blindness. It also makes for a more fun unlock experience much like the pattern unlock.

### Pros

- Can be used by blind people.

- As I would be developing for android and own an android device it would make development easier.


### Cons

- Not very practical for most people.

- Unknown level of complexity to devlop a lock screen for android and pattern recognition. 

## LiFi - Data transmission over light

### Intro


As WiFi is the tranceiving of radio waves in the 2.4 GHz and 5.0 GHz bands of the electromagnetic spectrum it is possible to transmit that same data in varying wavelengths including those in the visible spectrum. The benefit of using a shorter wavelength for transfering data is the higher frequnecies that be used allowing for higher throughput than on lower frequencies such as 2.4GHz. The drawback of using the short wavelenghts is very apparent in the visible spectrum with interference from multiple sources such as the sun or artifical lighting which could lead to dropped packets and missing data. Light has another limmiting factor and that is it can be blocked by any opaque object, this means LiFi would only have a practicle application in open spaces with light interference having to be accounted for.

However in rural areas with vast open spaces there would be the potential of erecting towers able to transmit data at much higher rates than possible using radio waves and cheaper than running cables along large stretches of land or underground.

I would be interested in devloping a basic LiFi system that's able to transmit simple data between two devices in both directions. 

### Pros

- An interesting and practicle technology that multiple departments and groups are looking into for future communications technologies.

- Would allow me to devlop software and work with hardware I normally wouldn't interact with.


### Cons

- Requires varying hardware and could potentially be expensive to obtain all the required equipment.

- Could be quite difficult to produce as there are multiple obsticles and challenges with the project.

 
