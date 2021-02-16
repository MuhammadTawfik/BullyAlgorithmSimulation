package Mailer;


import java.io.File;  
import java.io.IOException;  
import java.io.FileWriter;

public class SimpleStringMessage implements IMessage {

private String _sender;
private String _receiver;
private String _content;
private String _type;
private java.util.Date _date;

  public SimpleStringMessage(String sender, String receiver, String content, String type, java.util.Date date){
    _sender = sender;
    _receiver = receiver;
    _content = content.isEmpty() ? " " : content;
    _type = type;
    _date = date;
  }

    public SimpleStringMessage(String sender, String receiver, String content, String type){
    _sender = sender;
    _receiver = receiver;
    _content = content.isEmpty() ? " " : content;
    _type = type;
    _date = new java.util.Date();
  }

  public String toString() {
    return (_date + "|" + _sender + "|" + _type + "|" + _content + "|" + "\n");
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