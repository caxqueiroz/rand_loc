package location.rnd.app;

import java.util.Hashtable;



/**
 * 
 */

/**
 * @author cq
 *
 */
public class BrokerManager {

	private static BrokerManager _instance = null;
	
	private Hashtable<String,Broker> brokers;
	
	private BrokerManager(){
		brokers = new Hashtable<String, Broker>();
	}
	
	public static synchronized BrokerManager getInstance(){
		if(_instance == null)
			_instance = new BrokerManager();
		return _instance;
	}
	
	public Broker createBroker(String name){
		Broker broker = new Broker(name);
		brokers.put(broker.getIdentifier(), broker);
		return broker;
	}
	
	
}
