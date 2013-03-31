package location.rnd.app;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;



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
	
	public Broker getBroker(String name){
		return brokers.get(name);
	}
	
	public List<Broker> getBrokers(){
		Enumeration<Broker> enums = brokers.elements();
		List<Broker> _brokers = new ArrayList<Broker>();
		while(enums.hasMoreElements()){
			_brokers.add(enums.nextElement());
		}
		return _brokers;
	}
	
}
