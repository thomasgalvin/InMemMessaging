package galvin.messaging;

import java.util.UUID;

public class Message
{
    private final String uuid = UUID.randomUUID().toString();
    private final Object source;
    private final Object message;
    private final String topic;

    public Message( Object source, Object message, String topic ) {
        this.source = source;
        this.message = message;
        this.topic = topic;
    }

    public String getUuid() {
        return uuid;
    }

    public Object getSource() {
        return source;
    }

    public Object getMessage() {
        return message;
    }

    public String getTopic() {
        return topic;
    }
}
