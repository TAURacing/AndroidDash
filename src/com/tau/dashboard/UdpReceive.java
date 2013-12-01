package com.tau.dashboard;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import android.R.string;
import android.util.Log;

public class UdpReceive implements Runnable {
	private final static int PORT = 5555;
	private final String TAG = "UDPReceive";
	
	@Override
	public void run() {
		try {
			Log.d(TAG, "Opening port to listen!");
			DatagramSocket socket = new DatagramSocket(PORT);
			
			while (true) {
				Log.d(TAG, "Listening...");
				byte[] buf = new byte[1024];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
	            socket.receive(packet);
	            Log.d(TAG, "Received: '" + new String(packet.getData()).trim() + "'");
			}
		} catch (Exception e) {
			Log.e(TAG, "Receiver error", e);
		}
		
	}
}