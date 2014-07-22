package org.computerist.sniexperiments;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SingleTCPForwarder extends BaseStreamForwarder {

  private InetAddress serverAddress;
  private int serverPort;

  public SingleTCPForwarder(InetAddress serverAddress, int serverPort) {
    this.serverAddress = serverAddress;
    this.serverPort = serverPort;
  }

  @Override
  public void forward(InputStream inputStream, OutputStream outputStream,
      String host) {
    try {
      Socket socket = new Socket(this.serverAddress, this.serverPort);
      this.connectStreams(inputStream, outputStream, socket.getInputStream(), socket.getOutputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
    

  }

}
