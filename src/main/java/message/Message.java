package message;

import sun.security.x509.IPAddressName;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by nofuruct on 13.02.15.
 */
public class Message implements Serializable {
    private Calendar date = new GregorianCalendar();
    private IPAddressName ipAddressName;
    private String messageText;

    public Message(IPAddressName ipAddressName, Calendar date, String messageText) {
        this.ipAddressName = ipAddressName;
        this.date = date;
        this.messageText = messageText;
    }

    public Message(String messageText) {
        this.messageText = messageText;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public IPAddressName getIpAddressName() {
        return ipAddressName;
    }

    public void setIpAddressName(IPAddressName ipAddressName) {
        this.ipAddressName = ipAddressName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return// ", ipAddressName=" + ipAddressName +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
