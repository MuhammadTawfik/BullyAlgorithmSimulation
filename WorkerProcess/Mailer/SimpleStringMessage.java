package Mailer;


import java.io.File;  
import java.io.IOException;  
import java.io.FileWriter;

public class SimpleStringMessage implements IMessage {

private String _sender;
private String _receiver;
private String _content;
private String _type;

  public SimpleStringMessage(String sender, String receiver, String content, String type){
    _sender = sender;
    _receiver = receiver;
    _content = content;
    _type = type;
  }

  public String toString() {
    return (new java.util.Date() + "|" + _sender + "|" + _type + "|" + _content + "\n");
  }
  public String receiver() {
    return _receiver;
  }
  public String sender() {
    return _sender;
  }
  public String type() {
    return _type;
  }
}