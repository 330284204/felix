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
package org.apache.felix.cm.impl.helper;

<<<<<<< HEAD
=======
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
import java.util.Dictionary;

import org.apache.felix.cm.impl.ConfigurationManager;
import org.osgi.framework.ServiceReference;
<<<<<<< HEAD
=======
import org.osgi.service.cm.ConfigurationException;
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
import org.osgi.service.cm.ManagedServiceFactory;

public class ManagedServiceFactoryTracker extends BaseTracker<ManagedServiceFactory>
{

    public ManagedServiceFactoryTracker( ConfigurationManager cm )
    {
        super( cm, true );
    }


    @Override
    protected ConfigurationMap<?> createConfigurationMap( String[] pids )
    {
        return new ManagedServiceFactoryConfigurationMap( pids );
    }


    /**
     * Always returns the raw PID because for a ManagedServiceFactory
     * the configuration's PID is automatically generated and is not a
     * real targeted PID.
     */
    @Override
    public String getServicePid( ServiceReference<ManagedServiceFactory> service, TargetedPID pid )
    {
        return pid.getRawPid();
    }


    @Override
    public void provideConfiguration( ServiceReference<ManagedServiceFactory> reference, TargetedPID configPid,
        TargetedPID factoryPid, Dictionary<String, ?> properties, long revision, ConfigurationMap<?> configs )
    {
        // Get the ManagedServiceFactory and terminate here if already
        // unregistered from the framework concurrently
        ManagedServiceFactory service = getRealService( reference );
        if (service == null) {
            return;
        }

        // Get the Configuration-to-PID map from the parameter or from
        // the service tracker. If not available, the service tracker
        // already unregistered this service concurrently
        if ( configs == null )
        {
            configs =  this.getService( reference );
            if ( configs == null )
            {
                return;
            }
        }

        // Both the ManagedService to update and the Configuration-to-PID
        // are available, so the service can be updated with the
        // configuration (which may be null)

        if ( configs.shallTake( configPid, factoryPid, revision ) )
        {
            try
            {
                Dictionary props = getProperties( properties, reference, configPid.toString(),
                    factoryPid.toString() );
<<<<<<< HEAD
                service.updated( configPid.toString(), props );
=======
                updated( reference, service, configPid.toString(), props );
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
                configs.record( configPid, factoryPid, revision );
            }
            catch ( Throwable t )
            {
                this.handleCallBackError( t, reference, configPid );
            }
            finally
            {
                this.ungetRealService( reference );
            }
        }
    }


    @Override
    public void removeConfiguration( ServiceReference<ManagedServiceFactory> reference, TargetedPID configPid,
        TargetedPID factoryPid )
    {
        final ManagedServiceFactory service = this.getRealService( reference );
        final ConfigurationMap configs = this.getService( reference );
        if ( service != null && configs != null)
        {
            if ( configs.removeConfiguration( configPid, factoryPid ) )
            {
                try
                {
<<<<<<< HEAD
                    service.deleted( configPid.toString() );
=======
                    deleted( reference, service, configPid.toString() );
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
                    configs.record( configPid, factoryPid, -1 );
                }
                catch ( Throwable t )
                {
                    this.handleCallBackError( t, reference, configPid );
                }
                finally
                {
                    this.ungetRealService( reference );
                }
            }
        }
    }
<<<<<<< HEAD
=======


    private void updated( final ServiceReference<ManagedServiceFactory> reference, final ManagedServiceFactory service, final String pid, final Dictionary properties )
        throws ConfigurationException
    {
        if ( System.getSecurityManager() != null )
        {
            try
            {
                AccessController.doPrivileged( new PrivilegedExceptionAction()
                {
                    public Object run() throws ConfigurationException
                    {
                        service.updated( pid, properties );
                        return null;
                    }
                }, getAccessControlContext( reference.getBundle() ) );
            }
            catch ( PrivilegedActionException e )
            {
                throw ( ConfigurationException ) e.getException();
            }
        }
        else
        {
            service.updated( pid, properties );
        }
    }


    private void deleted( final ServiceReference<ManagedServiceFactory> reference, final ManagedServiceFactory service, final String pid )
    {
        if ( System.getSecurityManager() != null )
        {
            AccessController.doPrivileged( new PrivilegedAction()
            {
                public Object run()
                {
                    service.deleted( pid );
                    return null;
                }
            }, getAccessControlContext( reference.getBundle() ) );
        }
        else
        {
            service.deleted( pid );
        }
    }
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
}