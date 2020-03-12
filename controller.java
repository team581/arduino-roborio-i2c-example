// Copyright Jonah Snider 2018

/* This is outside a method */
// Open a new I2C connection on port 4
I2C Wire = new I2C(Port.kOnboard, 4);

/* This is inside a method */

// If the back button gets pressed, run this
if (Global.driver.Buttons.Back.changedDown) {
	sendInfo(Wire, "Test String");
}

public static void sendInfo(I2C Device, string text){
	char[] CharArray = text.toCharArray(); // Turn the string into a character array
	
	byte[] WriteData = new byte[CharArray.length]; //make a new array to fill with bytes
	for(int i = 0; i < CharArray.length; i++){
		WriteData[i] = (byte)CharArray[i]; //turn each char into bytes and add it to the byte array
	}

	Device.transaction(WriteData, WriteData.length, null, 0); //send byte array to device
}
