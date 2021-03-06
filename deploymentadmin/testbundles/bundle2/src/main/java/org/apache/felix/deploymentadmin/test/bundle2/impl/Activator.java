/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.felix.deploymentadmin.test.bundle2.impl;

import org.apache.felix.deploymentadmin.test.bundle1.TestService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class Activator implements BundleActivator, ServiceTrackerCustomizer {

    ServiceTracker m_tracker;
    BundleContext m_context;

    public void start(BundleContext context) throws Exception {
        m_context = context;

        m_tracker = new ServiceTracker(context, TestService.class.getName(), this);
        m_tracker.open();
    }

    public void stop(BundleContext context) throws Exception {
        // Nop
        m_tracker.close();
    }

    public Object addingService(ServiceReference reference) {
<<<<<<< HEAD
        Object service = m_context.getService(reference);
        System.out.println("Service added: " + service);
        return service;
    }

    public void modifiedService(ServiceReference reference, Object service) {
        System.out.println("Service modified: " + service);
    }

    public void removedService(ServiceReference reference, Object service) {
        System.out.println("Service removed: " + service);
=======
        return null;
    }

    public void modifiedService(ServiceReference reference, Object service) {
        // Nop
    }

    public void removedService(ServiceReference reference, Object service) {
        // Nop
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
    }
}
