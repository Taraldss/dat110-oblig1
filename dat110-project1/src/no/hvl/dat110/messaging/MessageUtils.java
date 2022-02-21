package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";
	
	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		// TODO - START
		
		data = message.getData();
		
		Integer a = data.length;
		byte len = a.byteValue();
		segment = new byte[SEGMENTSIZE];
		segment[0] = len;
		
		for(int i =0; i < data.length; i++) {
			segment[i+1] = data[i];
		}
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messagin layer
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		byte[] data;
		
		int len = segment[0];
		
		data = new byte[len];
		
		for (int i = 0; i < len; i++) {
			data[i] = segment[i+1];
		}
		
		message = new Message(data);
		
		return message;
		
	}
	
}
