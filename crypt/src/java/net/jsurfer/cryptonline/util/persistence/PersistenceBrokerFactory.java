package net.jsurfer.cryptonline.util.persistence;

import net.jsurfer.cryptonline.util.persistence.hibernate.HibernatePersistenceAdapter;

/**
 * Criado em 19/11/2003
 * PatternBox:Factory+Adapter: "Client" implementation.
 * <ul>
 *   <li>collaborates with objects conforming to the Target interface
 * 		 and also fabricates persistenceObjects.</li>
 * </ul>
 * 
 * @author <a href="mailto:javaman@moomia.com">Marcello Sales</a>
 */
public class PersistenceBrokerFactory {

	private final PersistenceLayer targetDefaultPersistence;
	
	private static PersistenceBrokerFactory sInstance = new PersistenceBrokerFactory();

	/** 
	 * The private constructor of this class is a Singleton constructor
	 * and a FactoryMethod. If you wanna change the persistence layer,
	 * just switch to another adapter that implements @see PersisteceLayer.
	 */
	private PersistenceBrokerFactory() {
		this.targetDefaultPersistence = HibernatePersistenceAdapter.getInstance();
	}
	
	/** 
	 * Get the unique instance of this class. 
	 */
	public static synchronized PersistenceBrokerFactory getInstance() {
		return sInstance;
	}	

	/** 
	 * Access the previously constructed persistence layer object from the
	 * factory method used in the constructor. 
	 */
	public PersistenceLayer getPersistenceLayer() {
		return this.targetDefaultPersistence;
	}

}
