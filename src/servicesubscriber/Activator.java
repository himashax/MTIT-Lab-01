package servicesubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import servicepublisher.IServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Start Subscriber Service");
		serviceReference = bundleContext.getServiceReference(IServicePublish.class.getName());
		IServicePublish iServicePublish = (IServicePublish) bundleContext.getService(serviceReference);
		System.out.println("Method of the service: " + iServicePublish.publishService());
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Seem you!");
		bundleContext.ungetService(serviceReference);
	}

}
