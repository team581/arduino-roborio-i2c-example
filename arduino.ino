#include <Wire.h>

void setup()
{
  // The LED that is turned on
  pinMode (13, OUTPUT);
  // Open connection on I2C on port 4
  Wire.begin(4);
  // When the open I2C port receives something, run this function
  Wire.onReceive(receiveEvent);
}

void loop()
{
  // Delay a bit to prevent lagging the Arduino
  delay(100);
}

// Function that executes whenever data is received from the I2C
// This function is registered as an event, see setup()
void receiveEvent(int howMany) {
  // Set up an empty string of the data
  String data = "";

  // Data is sent one byte at a time, so piece it together
  // In the future, you should probably just send a number or something to avoid needing to piece together a string
  while ( Wire.available() > 0 ) {
    char n=(char)Wire.read();
    if(((int)n)>((int)(' ')))
   data += n; 
  }
  
  if (data == "go") {
    // Turn on LED
    digitalWrite (13, HIGH);
  }
}
