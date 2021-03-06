/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.felix.http.whiteboard.internal.manager;

<<<<<<< HEAD
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.Servlet;

import org.apache.felix.http.api.ExtHttpService;
import org.apache.felix.http.base.internal.logger.SystemLogger;
import org.apache.felix.http.whiteboard.HttpWhiteboardConstants;
import org.apache.felix.http.whiteboard.internal.manager.HttpContextManager.HttpContextHolder;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;

public final class ExtenderManager
{
    private HttpService httpService;
    private final HashMap<ServiceReference, AbstractMapping> mapping;
    private final HttpContextManager contextManager;

    public ExtenderManager()
    {
        this.mapping = new HashMap<ServiceReference, AbstractMapping>();
        this.contextManager = new HttpContextManager();
    }

    static boolean isEmpty(final String value)
    {
        return value == null || value.length() == 0;
    }

    private String getStringProperty(ServiceReference ref, String key)
=======
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.EventListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

import org.apache.felix.http.base.internal.logger.SystemLogger;
import org.apache.felix.http.whiteboard.HttpWhiteboardConstants;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.context.ServletContextHelper;

@SuppressWarnings("deprecation")
public final class ExtenderManager
{
    private static final String MARKER = "org.apache.felix.http.whiteboard";

    public enum Type {
        CONTEXT,
        FILTER,
        SERVLET,
        LISTENERS
    }

    private final Map<String, ServiceRegistration<?>> registrations = new ConcurrentHashMap<>();

    /**
     * Remove a service registration (if existing)
     * @param type The type
     * @param ref The service reference
     */
    private void removeServiceRegistration(final Type type, final ServiceReference<?> ref)
    {
        final ServiceRegistration<?> reg = this.registrations.remove(type.name() + String.valueOf(ref.getProperty(Constants.SERVICE_ID)));
        if ( reg != null )
        {
            try
            {
                reg.unregister();
            }
            catch ( final IllegalStateException ignore)
            {
                // we ignore this
            }
        }
    }

    /**
     * Add a service registration
     * @param type The type of the registration
     * @param ref The service reference
     * @param reg The service registration
     */
    private void putServiceRegistration(final Type type, final ServiceReference<?> ref, final ServiceRegistration<?> reg)
    {
        this.registrations.put(type.name() + String.valueOf(ref.getProperty(Constants.SERVICE_ID)), reg);
    }

    /**
     * Get a string property
     * @param ref The service reference
     * @param key The name of the property
     * @return The value of the property if the type is String, {@code null} otherwise
     */
    private String getStringProperty(final ServiceReference<?> ref, final String key)
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
    {
        Object value = ref.getProperty(key);
        return (value instanceof String) ? (String)value : null;
    }

<<<<<<< HEAD
    private boolean getBooleanProperty(ServiceReference ref, String key)
=======
    /**
     * Get the boolean property.
     * @param ref The service reference
     * @param key The name of the property
     * @return The value of the boolean property. Returns {@code false} as default
     */
    private boolean getBooleanProperty(final ServiceReference<?> ref, final String key)
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
    {
        Object value = ref.getProperty(key);
        if (value instanceof String)
        {
            return Boolean.valueOf((String) value);
        }
        else if (value instanceof Boolean)
        {
            return ((Boolean) value).booleanValue();
        }
        return false;
    }

<<<<<<< HEAD
    private int getIntProperty(ServiceReference ref, String key, int defValue)
    {
        Object value = ref.getProperty(key);
        if (value == null) {
            return defValue;
        }

        try {
            return Integer.parseInt(value.toString());
        } catch (Exception e) {
            return defValue;
        }
    }

    private void addInitParams(ServiceReference ref, AbstractMapping mapping)
    {
        for (String key : ref.getPropertyKeys()) {
            if (key.startsWith(HttpWhiteboardConstants.INIT_PREFIX)) {
                String paramKey = key.substring(HttpWhiteboardConstants.INIT_PREFIX.length());
                String paramValue = getStringProperty(ref, key);

                if (paramValue != null) {
                    mapping.getInitParams().put(paramKey, paramValue);
=======
   /**
     * Add the init parameters
     * @param ref The service reference
     * @param prefix The prefix to use
     * @param props The properties
     */
    private void addInitParams(final ServiceReference<?> ref, final String prefix, final Dictionary<String, Object> props)
    {
        for (final String key : ref.getPropertyKeys()) {
            if (key.startsWith(HttpWhiteboardConstants.INIT_PREFIX)) {
                final String paramKey = key.substring(HttpWhiteboardConstants.INIT_PREFIX.length());
                final Object paramValue = ref.getProperty(paramKey);

                if (paramValue != null) {
                    props.put(prefix + paramKey, paramValue);
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
                }
            }
        }
    }

<<<<<<< HEAD
    public void add(HttpContext service, ServiceReference ref)
    {
        String contextId = getStringProperty(ref, HttpWhiteboardConstants.CONTEXT_ID);
        if (!isEmpty(contextId))
        {
            boolean shared = getBooleanProperty(ref, HttpWhiteboardConstants.CONTEXT_SHARED);
            Bundle bundle = shared ? null : ref.getBundle();
            Collection<AbstractMapping> mappings = this.contextManager.addHttpContext(bundle, contextId, service);
            for (AbstractMapping mapping : mappings)
            {
                registerMapping(mapping);
            }
        }
        else
        {
            SystemLogger.debug("Ignoring HttpContext Service " + ref + ", " + HttpWhiteboardConstants.CONTEXT_ID
                + " is missing or empty");
        }
    }

    public void remove(HttpContext service)
    {
        Collection<AbstractMapping> mappings = this.contextManager.removeHttpContext(service);
        if (mappings != null)
        {
            for (AbstractMapping mapping : mappings)
            {
                unregisterMapping(mapping);
            }
        }
    }

    private void getHttpContext(AbstractMapping mapping, ServiceReference ref)
    {
        Bundle bundle = ref.getBundle();
        String contextId = getStringProperty(ref, HttpWhiteboardConstants.CONTEXT_ID);
        this.contextManager.getHttpContext(bundle, contextId, mapping);
    }

    private void ungetHttpContext(AbstractMapping mapping, ServiceReference ref)
    {
        Bundle bundle = ref.getBundle();
        String contextId = getStringProperty(ref, HttpWhiteboardConstants.CONTEXT_ID);
        this.contextManager.ungetHttpContext(bundle, contextId, mapping);
    }

    public void add(Filter service, ServiceReference ref)
    {
        int ranking = getIntProperty(ref, Constants.SERVICE_RANKING, 0);
        String pattern = getStringProperty(ref, HttpWhiteboardConstants.PATTERN);

        if (isEmpty(pattern)) {
=======
    /**
     * Add the service ranking (if available)
     * @param ref The service reference
     * @param props The new properties
     */
    private void addServiceRanking(final ServiceReference<?> ref, final Dictionary<String, Object> props)
    {
        // we don't care about the type and assume it's correct
        final Object val = ref.getProperty(Constants.SERVICE_RANKING);
        if ( val != null )
        {
            props.put(Constants.SERVICE_RANKING, val);
        }
    }

    /**
     * Add the context select property
     * @param ref The service reference
     * @param props The properties
     */
    private void addHttpContextSelect(final ServiceReference<?> ref, final Dictionary<String, Object> props)
    {
        final String contextId = getStringProperty(ref, HttpWhiteboardConstants.CONTEXT_ID);
        // if context id is missing, the default context is used
        if ( contextId != null )
        {
            final StringBuilder select = new StringBuilder();
            select.append("(!(");
            select.append(org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME);
            select.append('=');
            select.append(getHttpContextName(ref, contextId, false));
            select.append(")(");
            select.append(org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME);
            select.append('=');
            select.append(getHttpContextName(ref, contextId, true));
            select.append("))");
            props.put(org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT, select.toString());
        }
        else
        {
            props.put(org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT,
                    "(" + org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME
                    + "=org.osgi.service.http)");
        }
    }

    /**
     * Return the http context name
     * @param ref The service reference
     * @return The name or {@code null}
     */
    private String getHttpContextName(final ServiceReference<?> ref,
            final String contextId,
            final boolean shared)
    {
        final StringBuilder name = new StringBuilder();
        name.append(MARKER);
        name.append('.');
        if ( shared )
        {
            name.append("shared");
        }
        else
        {
            name.append(ref.getBundle().getBundleId());
        }
        name.append('.');
        name.append(contextId);

        return name.toString();
    }

    /**
     * Add a HttpContext
     * @param service The HttpContext
     * @param ref The service reference
     */
    public void addHttpContext(final HttpContext service, final ServiceReference<HttpContext> ref)
    {
        final String contextId = getStringProperty(ref, HttpWhiteboardConstants.CONTEXT_ID);
        if (contextId != null && !contextId.isEmpty())
        {
            final boolean shared = getBooleanProperty(ref, HttpWhiteboardConstants.CONTEXT_SHARED);
            final String contextName = getHttpContextName(ref, contextId, shared);
            final Dictionary<String, Object> props = new Hashtable<>();
            props.put(org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME, contextName);
            props.put(org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_PATH, "/");
            props.put(org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_SERVICE_CONTEXT_PROPERTY, "true");
            props.put(MARKER + ".id", contextId);
            props.put(MARKER, "true");
            this.addServiceRanking(ref, props);
            final ServiceRegistration<ServletContextHelper> reg = ref.getBundle().getBundleContext().registerService(
                    ServletContextHelper.class,
                    new ServletContextHelper() {

                        @Override
                        public boolean handleSecurity(final HttpServletRequest request, final HttpServletResponse response)
                                throws IOException {
                            return service.handleSecurity(request, response);
                        }

                        @Override
                        public URL getResource(final String name) {
                            return service.getResource(name);
                        }

                        @Override
                        public String getMimeType(final String name) {
                            return service.getMimeType(name);
                        }

                    },
                    props);
            this.putServiceRegistration(Type.CONTEXT, ref, reg);
        }
        else
        {
            SystemLogger.debug("Ignoring HttpContext Service " + ref + ", " + HttpWhiteboardConstants.CONTEXT_ID
                + " is missing or empty");
        }
    }

    /**
     * Remove a HttpContext
     * @param ref The service reference
     */
    public void removeHttpContext(final ServiceReference<HttpContext> ref)
    {
        this.removeServiceRegistration(Type.CONTEXT, ref);
    }

    /**
     * Add a filter.
     * @param service The filter
     * @param ref The filter reference
     */
    public void addFilter(final Filter service, final ServiceReference<Filter> ref)
    {
        final String pattern = getStringProperty(ref, HttpWhiteboardConstants.PATTERN);

        if (pattern == null || pattern.isEmpty()) {
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
            SystemLogger.debug("Ignoring Filter Service " + ref + ", " + HttpWhiteboardConstants.PATTERN
                + " is missing or empty");
            return;
        }

<<<<<<< HEAD
        FilterMapping mapping = new FilterMapping(ref.getBundle(), service, pattern, ranking);
        getHttpContext(mapping, ref);
        addInitParams(ref, mapping);
        addMapping(ref, mapping);
    }

    public void add(Servlet service, ServiceReference ref)
    {
        String alias = getStringProperty(ref, HttpWhiteboardConstants.ALIAS);
        if (isEmpty(alias))
        {
            SystemLogger.debug("Ignoring Servlet Service " + ref + ", " + HttpWhiteboardConstants.ALIAS
                + " is missing or empty");
            return;
        }

        ServletMapping mapping = new ServletMapping(ref.getBundle(), service, alias);
        getHttpContext(mapping, ref);
        addInitParams(ref, mapping);
        addMapping(ref, mapping);
    }

    public void remove(ServiceReference ref)
    {
        removeMapping(ref);
    }

    public synchronized void setHttpService(HttpService service)
    {
        this.httpService = service;
        if (this.httpService instanceof ExtHttpService) {
            SystemLogger.info("Detected extended HttpService. Filters enabled.");
        } else {
            SystemLogger.info("Detected standard HttpService. Filters disabled.");
        }

        registerAll();
    }

    public synchronized void unsetHttpService()
    {
        unregisterAll();
        this.httpService = null;
    }

    public synchronized void unregisterAll()
    {
    	AbstractMapping[] mappings = null;
    	HttpService service;
    	synchronized (this) {
			service = this.httpService;
			if (service != null) {
    			Collection<AbstractMapping> values = this.mapping.values();
    			mappings = values.toArray(new AbstractMapping[values.size()]);
    		}
    	}
    	if (mappings != null) {
    		for (AbstractMapping mapping : mappings) {
    			mapping.unregister(service);
    		}
    	}
    }

    private synchronized void registerAll()
    {
    	AbstractMapping[] mappings = null;
    	HttpService service;
    	synchronized (this) {
			service = this.httpService;
			if (service != null) {
    			Collection<AbstractMapping> values = this.mapping.values();
    			mappings = values.toArray(new AbstractMapping[values.size()]);
    		}
    	}
    	if (mappings != null) {
    		for (AbstractMapping mapping : mappings) {
    			mapping.register(service);
    		}
    	}
    }

    private synchronized void addMapping(ServiceReference ref, AbstractMapping mapping)
    {
        this.mapping.put(ref, mapping);
        this.registerMapping(mapping);
    }

    private synchronized void removeMapping(ServiceReference ref)
    {
        AbstractMapping mapping = this.mapping.remove(ref);
        if (mapping != null)
        {
            ungetHttpContext(mapping, ref);
            unregisterMapping(mapping);
        }
    }

    private void registerMapping(AbstractMapping mapping)
    {
        HttpService httpService = this.httpService;
        if (httpService != null)
        {
            mapping.register(httpService);
        }
    }

    private void unregisterMapping(AbstractMapping mapping)
    {
        HttpService httpService = this.httpService;
        if (httpService != null)
        {
            mapping.unregister(httpService);
        }
    }

    /**
     * Returns
     * {@link org.apache.felix.http.whiteboard.internal.manager.HttpContextManager.HttpContextHolder}
     * instances of HttpContext services.
     *
     * @return
     */
    Map<String, HttpContextHolder> getHttpContexts()
    {
        return this.contextManager.getHttpContexts();
    }

    /**
     * Returns {@link AbstractMapping} instances for which there is no
     * registered HttpContext as desired by the context ID.
     */
    Map<String, Set<AbstractMapping>> getOrphanMappings()
    {
        return this.contextManager.getOrphanMappings();
    }

    /**
     * Returns mappings indexed by there owning OSGi service.
     */
    Map<Object, AbstractMapping> getMappings()
    {
        synchronized (this)
        {
            return new HashMap<Object, AbstractMapping>(this.mapping);
        }
=======
        final Dictionary<String, Object> props = new Hashtable<>();
        props.put(org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_FILTER_REGEX, pattern);
        props.put(MARKER, "true");
        this.addHttpContextSelect(ref, props);
        this.addInitParams(ref, org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_INIT_PARAM_PREFIX, props);
        this.addServiceRanking(ref, props);

        final ServiceRegistration<Filter> reg = ref.getBundle().getBundleContext().registerService(
                Filter.class,
                service,
                props);
        this.putServiceRegistration(Type.FILTER, ref, reg);
    }

    /**
     * Add a servlet.
     * @param service The servlet
     * @param ref The service reference
     */
    public void addServlet(final Servlet service, final ServiceReference<Servlet> ref)
    {
        final String alias = getStringProperty(ref, HttpWhiteboardConstants.ALIAS);
        if (alias == null || alias.isEmpty() || !alias.startsWith("/"))
        {
            SystemLogger.debug("Ignoring Servlet Service " + ref + ", " + HttpWhiteboardConstants.ALIAS
                + " is missing, empty or invalid");
            return;
        }

        final Dictionary<String, Object> props = new Hashtable<>();
        props.put(org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN, alias);
        props.put(MARKER, "true");
        this.addHttpContextSelect(ref, props);
        this.addInitParams(ref, org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_INIT_PARAM_PREFIX, props);
        this.addServiceRanking(ref, props);

        final ServiceRegistration<Servlet> reg = ref.getBundle().getBundleContext().registerService(
                Servlet.class,
                service,
                props);
        this.putServiceRegistration(Type.SERVLET, ref, reg);
    }

    /**
     * Add listeners
     * @param service The service
     * @param ref The service reference
     */
    public void addListeners(final EventListener service, ServiceReference<EventListener> ref)
    {
        final Dictionary<String, Object> props = new Hashtable<>();
        final List<String> names = new ArrayList<>();
        if ( service instanceof HttpSessionAttributeListener)
        {
            names.add(HttpSessionAttributeListener.class.getName());
        }
        if ( service instanceof HttpSessionListener)
        {
            names.add(HttpSessionListener.class.getName());
        }
        if ( service instanceof ServletContextAttributeListener)
        {
            names.add(ServletContextAttributeListener.class.getName());
        }
        if ( service instanceof ServletRequestAttributeListener)
        {
            names.add(ServletRequestAttributeListener.class.getName());
        }
        if ( service instanceof ServletRequestListener)
        {
            names.add(ServletRequestListener.class.getName());
        }

        props.put(MARKER, "true");
        props.put(org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_LISTENER, "true");
        this.addHttpContextSelect(ref, props);
        this.addServiceRanking(ref, props);

        final ServiceRegistration<?> reg = ref.getBundle().getBundleContext().registerService(
                names.toArray(new String[names.size()]),
                service,
                props);
        this.putServiceRegistration(Type.LISTENERS, ref, reg);
    }


    /**
     * Remove a filter
     * @param ref The filter reference
     */
    public void removeFilter(final ServiceReference<Filter> ref)
    {
        this.removeServiceRegistration(Type.FILTER, ref);
    }

    /**
     * Remove a servlet
     * @param ref The service reference
     */
    public void removeServlet(final ServiceReference<Servlet> ref)
    {
        this.removeServiceRegistration(Type.SERVLET, ref);
    }

    /**
     * Remove a listener
     * @param ref The service reference
     */
    public void removeListeners(final ServiceReference<EventListener> ref)
    {
        this.removeServiceRegistration(Type.LISTENERS, ref);
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
    }
}
