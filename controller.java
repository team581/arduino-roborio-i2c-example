// Copyright Jonah Snider 2018

/* This is outside a method */
// Open a new I2C connection on port 4
I2C Wire = new I2C(Port.kOnboard, 4);

/* This is inside a method */

// If the back button gets pressed, run this
if (Global.driver.Buttons.Back.changedDown) {
	// The string message to be sent to the Arduino
	String WriteString = "go";
	// Turn the string into a character array
	char[] CharArray = WriteString.toCharArray();
	// Make each character a single byte
	byte[] WriteData = new byte[CharArray.length];
	// For each item in the character array, add it as a single byte to the I2C connection
	for (int i = 0; i < CharArray.length; i++) {
		WriteData[i] = (byte) CharArray[i];
	}
	// Send the data to the I2C connection
	Wire.transaction(WriteData, WriteData.length, null, 0);
}
