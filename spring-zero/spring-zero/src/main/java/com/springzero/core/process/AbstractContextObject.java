package com.springzero.core.process;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.springzero.core.support.Disposable;

/**
 * An abstract class to be extended any any Context type implementation, which allows context to carry some information. <br>
 * Note that, what to be stored in the map must be very well documented as a part of class JavaDoc. This must be done.
 * 
 * @author tnguyen443
 * @version 05/08/2017
 */
public class AbstractContextObject implements Disposable{

	/**
	 * A Map storing all Objects which require to be cached.
	 */
	private Map<String, Object> store = new HashMap<String, Object>();
	
	/**
	 * Save an object into the store, which can be used later
	 * 
	 * @param id - object id to be saved
	 * @param object - object to be saved
	 */
	public void saveObject(final String id, final Object object) {
		if (object == null) {
			removeObject(id);
		} else {
			store.put(id, object);
		}
	}
	
	/**
	 * Save an object into the store, which will be associated to its own type
	 * 
	 * @param object - object to be saved
	 */
	public void saveObject(final Object object) {
		if (object == null) {
			// do nothing as it makes no sense
		} else {
			saveObject(object.getClass().getName(), object);
		}
	}
	
	/**
	 * Save an object into the store, which can be used later
	 * 
	 * @param typeAsId - object id to be saved
	 * @param object - object to be saved
	 */
	public void saveObject(final Class<?> typeAsId, final Object object) {
		if (typeAsId == null && object == null) {
			// do nothing as it makes no sense
		} else if (typeAsId != null) {
			saveObject(typeAsId.getName(), object);
		} else {
			saveObject(object);
		}
	}
	
	/**
	 * Remove an object by given String ID
	 * 
	 * @param id - id to be removed
	 * @return null if no Object is associated with given ID or the object being removed from Map
	 */
	public Object removeObject(final String id) {
		return store.remove(id);
	}
	
	/**
	 * Remove an object by given class type, which assumes there can be only one single entry per type
	 * 
	 * @param <T> - any type being bounded.
	 * @param typeAsId - object id to be removed
	 * @return null if no Object is associated with given ID or the object being removed from Map
	 */
	@SuppressWarnings("unchecked")
	public <T> T removeObject(final Class<T> typeAsId) {
		if (typeAsId == null) {
			return null;
		} else {
			return (T) removeObject(typeAsId.getName());
		}
	}

	/**
	 * Remove an object by given instance, which type is used to do the actual remove. See {@link #removeObject(Class)}
	 * 
	 * @param <T> - any type being bounded.
	 * @param instanceAsId - object id to be removed
	 * @return null if no Object is associated with given ID or the object being removed from Map
	 */
	@SuppressWarnings("unchecked")
	public <T> T removeObject(final T instanceAsId) {
		if (instanceAsId == null) {
			return null;
		} else {
			return (T) removeObject(instanceAsId.getClass().getName());
		}
	}
	
	/**
	 * Retrieve an object from store for given String id
	 * 
	 * @param id - object id to retrieve
	 * @return null if no Object is associated with given ID
	 */
	public Object retrieveObject(final String id) {
		return store.get(id);
	}
	
	/**
	 * Return the size of store's length.
	 */
	public int getLength(){
		return store.size();
	}
	
	/**
	 * Dispose the map and invoke dispose method if it's instance of {@link Disposable}
	 */
	@Override
	public void dispose() {
		if (this.store != null && !store.isEmpty()) {
			for (Object o : store.values()) {
				if (o instanceof Disposable) {
					disposeQuietly((Disposable) o);
				}
			}
			store.clear();
		}
	}
	
	/**
	 * Dispose an object quietly.
	 *
	 * @param o o
	 */
	public static void disposeQuietly(final Disposable o) {
		if (o != null) {
			try {
				o.dispose();
			} catch (RuntimeException e) {
				LoggerFactory.getLogger(o.getClass()).warn("failed to dispose the object", e);
			}
		}
	}

}
