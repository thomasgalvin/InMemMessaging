package galvin.messaging;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageCenter
{
    private static final Logger logger = LoggerFactory.getLogger( MessageCenter.class );
    private static final Object LOCK = new Object();
    private static HashMap<String, Topic> topics = new HashMap<>();
    
    public static Topic topic( String name ){
        synchronized( LOCK ){
            Topic result = topics.get( name );
            if( result == null ){
                result = new Topic( name );
                topics.put( name, result );
            }
            return result;
        }
    }
}
