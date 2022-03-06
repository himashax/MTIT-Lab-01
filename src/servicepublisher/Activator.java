package servicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Publisher Start");
		IServicePublish publisherService = new ServicePublishImpl();
		publishServiceRegistration = bundleContext.registerService(
				IServicePublish.class.getName(), 
				publisherService, 
				null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
