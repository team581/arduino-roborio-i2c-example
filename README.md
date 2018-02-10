# Arduino to RoboRIO I2C Interface Example

Example code of using the RoboRIO to interface with an [Arduino](https://www.arduino.cc/) over I2C. The RoboRIO sends a string message ([`'go'`](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/controller.java#L10)) to the Arduino. The Arduino has [a listener](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/arduino.ino#L10) running that will [enable an LED](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/arduino.ino#L35) when it [receives the message](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/arduino.ino#L10). The message is sent by [breaking it down into singular bytes](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/controller.java#L9-L18), and then [piecing it back together](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/arduino.ino#L27-L31) when [it's received](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/arduino.ino#L21-L37).

## Setup

### Materials

* `1` [Arduino](https://www.arduino.cc/)
* `1` RoboRIO
* `1` I2C capable cable

### Wiring Configuration

#### Arduino

The Arduino should have a digital LED connected to [port 13](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/arduino.ino#L6). It should also have a digital I2C connection on [port 4](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/arduino.ino#L8).

#### RoboRIO

The RoboRIO should have the I2C cable plugged into [port 4](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/controller.java#L3).

#### Java
Since the configuration of your RoboRIO can vary greatly from ours, you may want to modify how the code is run. The most important part is probably changing [when to send the message over I2C](https://github.com/blazingbulldogs/arduino-roborio-i2c-example/blob/master/controller.java#L8).
