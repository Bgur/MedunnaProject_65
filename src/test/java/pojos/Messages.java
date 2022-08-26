package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Messages {

    private String messagesId;
    private String messagesName;
    private String messagesEmail;
    private String messagesMessage;
    private String messagesSubject;

    public Messages() {

    }

    public String getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(String messagesId) {
        this.messagesId = messagesId;
    }

    public String getMessagesName() {
        return messagesName;
    }

    public void setMessagesName(String messagesName) {
        this.messagesName = messagesName;
    }

    public String getMessagesEmail() {
        return messagesEmail;
    }

    public void setMessagesEmail(String messagesEmail) {
        this.messagesEmail = messagesEmail;
    }

    public String getMessagesMessage() {
        return messagesMessage;
    }

    public void setMessagesMessage(String messagesMessage) {
        this.messagesMessage = messagesMessage;
    }

    public String getMessagesSubject() {
        return messagesSubject;
    }

    public void setMessagesSubject(String messagesSubject) {
        this.messagesSubject = messagesSubject;
    }
}
