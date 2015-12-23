package galvin.messaging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Topic
{
    private static final Logger logger = LoggerFactory.getLogger(Topic.class );
    private final String name;
    private final List<Listener> listeners = new ArrayList();

    public Topic( String name ) {
        this.name = name;
    }
    
    public void add( Listener listener ){
        remove( listener );
        listeners.add( listener );
    }
    
    public void remove( Listener listener ){
        listeners.remove( listener );
    }
    
    public void removeAll(){
        listeners.clear();
    }

    public String getName() {
        return name;
    }
    
    public void notify( Object source, Object message ){
        Message msg = new Message( source, message, name );
        
        List<Listener> targets = new ArrayList();
        targets.addAll(  listeners );
        Collections.reverse( targets );
        
        for( Listener listener : targets ){
            try {
                listener.message( msg );
            }
            catch( Throwable t ){
                logger.error( "Error sending message", t );
            }
        }
    }
}
