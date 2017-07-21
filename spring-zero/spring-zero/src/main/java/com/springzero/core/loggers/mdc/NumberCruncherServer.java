package com.springzero.core.loggers.mdc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * Example about advanced use of MDC (Mapped Diagnostic Context)
 * 
 * Ignore cái này đi. Khó hiểu quá.
 * 
 * @author tnguyen443
 * @version 07/21/2017
 */
public class NumberCruncherServer extends UnicastRemoteObject implements NumberCruncher {

	static Logger logger = LoggerFactory.getLogger(NumberCruncherServer.class);

	protected NumberCruncherServer() throws RemoteException {
	}

	private static final long serialVersionUID = 1L;

	@Override
	public int[] factor(int number) throws RemoteException {
		try {
			MDC.put("client", NumberCruncherServer.getClientHost());
		} catch (ServerNotActiveException e) {
			logger.warn("Caught unexpected ServerNotActiveException.", e);
		}
		MDC.put("number", String.valueOf(number));
		logger.info("Beginning to factor.");

		if (number <= 0) {
			throw new IllegalArgumentException(number + " is not a positive integer.");
		} else if (number == 1) {
			return new int[] { 1 };
		}
		Vector<Integer> factors = new Vector<Integer>();
		int n = number;

		for (int i = 2; (i <= n) && ((i * i) <= number); i++) {
			// It is bad practice to place log requests within tight loops.
			// It is done here to show interleaved log output from
			// different requests.
			logger.debug("Trying " + i + " as a factor.");

			if ((n % i) == 0) {
				logger.info("Found factor " + i);
				factors.addElement(new Integer(i));

				do {
					n /= i;
				} while ((n % i) == 0);
			}

			// Placing artificial delays in tight loops will also lead to
			// sub-optimal results. :-)
			delay(100);
		}

		if (n != 1) {
			logger.info("Found factor " + n);
			factors.addElement(new Integer(n));
		}

		int len = factors.size();

		int[] result = new int[len];

		for (int i = 0; i < len; i++) {
			result[i] = ((Integer) factors.elementAt(i)).intValue();
		}

		// clean up
		MDC.remove("client");
		MDC.remove("number");

		return result;
	}

	public static void delay(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	static void usage(String msg) {
		System.err.println(msg);
		System.err.println("Usage: java chapters.mdc.NumberCruncherServer configFile\n"
				+ "   where configFile is a logback configuration file.");
		System.exit(1);
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			usage("Wrong number of arguments.");
		}

		String configFile = args[0];

		if (configFile.endsWith(".xml")) {
			try {
				LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
				JoranConfigurator configurator = new JoranConfigurator();
				configurator.setContext(lc);
				lc.reset();
				configurator.doConfigure(args[0]);
			} catch (JoranException je) {
				je.printStackTrace();
			}
		}

		NumberCruncherServer ncs;

		try {
			ncs = new NumberCruncherServer();
			logger.info("Creating registry.");

			Registry registry = LocateRegistry.createRegistry(1111);
			registry.rebind("Factor", ncs);
			logger.info("NumberCruncherServer bound and ready.");
		} catch (Exception e) {
			logger.error("Could not bind NumberCruncherServer.", e);
			return;
		}
	}

}
