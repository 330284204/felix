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
package org.apache.felix.cm.impl;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

<<<<<<< HEAD
import junit.framework.TestCase;

=======
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.ConfigurationPlugin;

<<<<<<< HEAD
=======
import junit.framework.TestCase;

>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368

public class RankingComparatorTest extends TestCase
{

<<<<<<< HEAD
    private final Comparator srvRank = RankingComparator.SRV_RANKING;
    private final Comparator cmRank = RankingComparator.CM_RANKING;
=======
    private final Comparator<ServiceReference<?>> srvRank = RankingComparator.SRV_RANKING;
    private final Comparator<ServiceReference<?>> cmRank = RankingComparator.CM_RANKING;
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368


    public void test_service_ranking_no_property()
    {
<<<<<<< HEAD
        ServiceReference r1 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );
        ServiceReference r2 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );
        ServiceReference r3 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );
=======
        ServiceReference<?> r1 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );
        ServiceReference<?> r2 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );
        ServiceReference<?> r3 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368

        assertTrue( srvRank.compare( r1, r1 ) == 0 );
        assertTrue( srvRank.compare( r1, r2 ) < 0 );
        assertTrue( srvRank.compare( r1, r3 ) < 0 );

        assertTrue( srvRank.compare( r2, r1 ) > 0 );
        assertTrue( srvRank.compare( r2, r2 ) == 0 );
        assertTrue( srvRank.compare( r2, r3 ) < 0 );

        assertTrue( srvRank.compare( r3, r1 ) > 0 );
        assertTrue( srvRank.compare( r3, r2 ) > 0 );
        assertTrue( srvRank.compare( r3, r3 ) == 0 );

        assertTrue( cmRank.compare( r1, r1 ) == 0 );
<<<<<<< HEAD
        assertTrue( cmRank.compare( r1, r2 ) == 0 );
        assertTrue( cmRank.compare( r1, r3 ) == 0 );

        assertTrue( cmRank.compare( r2, r1 ) == 0 );
        assertTrue( cmRank.compare( r2, r2 ) == 0 );
        assertTrue( cmRank.compare( r2, r3 ) == 0 );

        assertTrue( cmRank.compare( r3, r1 ) == 0 );
        assertTrue( cmRank.compare( r3, r2 ) == 0 );
=======
        assertTrue( cmRank.compare( r1, r2 ) > 0 );
        assertTrue( cmRank.compare( r1, r3 ) > 0 );

        assertTrue( cmRank.compare( r2, r1 ) < 0 );
        assertTrue( cmRank.compare( r2, r2 ) == 0 );
        assertTrue( cmRank.compare( r2, r3 ) > 0 );

        assertTrue( cmRank.compare( r3, r1 ) < 0 );
        assertTrue( cmRank.compare( r3, r2 ) < 0 );
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        assertTrue( cmRank.compare( r3, r3 ) == 0 );
    }


    public void test_service_ranking_property()
    {
<<<<<<< HEAD
        ServiceReference r1 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( 100 ) );
        ServiceReference r2 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( -100 ) );
        ServiceReference r3 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );
=======
        ServiceReference<?> r1 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( 100 ) );
        ServiceReference<?> r2 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( -100 ) );
        ServiceReference<?> r3 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368

        assertTrue( srvRank.compare( r1, r1 ) == 0 );
        assertTrue( srvRank.compare( r1, r2 ) < 0 );
        assertTrue( srvRank.compare( r1, r3 ) < 0 );

        assertTrue( srvRank.compare( r2, r1 ) > 0 );
        assertTrue( srvRank.compare( r2, r2 ) == 0 );
        assertTrue( srvRank.compare( r2, r3 ) > 0 );

        assertTrue( srvRank.compare( r3, r1 ) > 0 );
        assertTrue( srvRank.compare( r3, r2 ) < 0 );
        assertTrue( srvRank.compare( r3, r3 ) == 0 );
    }


    public void test_service_cm_ranking_property()
    {
<<<<<<< HEAD
        ServiceReference r1 = new MockServiceReference()
            .setProperty( ConfigurationPlugin.CM_RANKING, new Integer( 100 ) );
        ServiceReference r2 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING,
            new Integer( -100 ) );
        ServiceReference r3 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING, null );
=======
        ServiceReference<?> r1 = new MockServiceReference()
            .setProperty( ConfigurationPlugin.CM_RANKING, new Integer( 100 ) );
        ServiceReference<?> r2 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING,
            new Integer( -100 ) );
        ServiceReference<?> r3 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING, null );
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368

        assertTrue( cmRank.compare( r1, r1 ) == 0 );
        assertTrue( cmRank.compare( r1, r2 ) > 0 );
        assertTrue( cmRank.compare( r1, r3 ) > 0 );

        assertTrue( cmRank.compare( r2, r1 ) < 0 );
        assertTrue( cmRank.compare( r2, r2 ) == 0 );
        assertTrue( cmRank.compare( r2, r3 ) < 0 );

        assertTrue( cmRank.compare( r3, r1 ) < 0 );
        assertTrue( cmRank.compare( r3, r2 ) > 0 );
        assertTrue( cmRank.compare( r3, r3 ) == 0 );
    }


    public void test_service_ranking_sort()
    {
<<<<<<< HEAD
        ServiceReference r1 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( 100 ) );
        ServiceReference r2 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( -100 ) );
        ServiceReference r3 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );
        ServiceReference[] refs =
=======
        ServiceReference<?> r1 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( 100 ) );
        ServiceReference<?> r2 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( -100 ) );
        ServiceReference<?> r3 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );
        ServiceReference<?>[] refs =
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
            { r1, r2, r3 };

        assertSame( r1, refs[0] );
        assertSame( r2, refs[1] );
        assertSame( r3, refs[2] );

        Arrays.sort( refs, srvRank );

        assertSame( r1, refs[0] );
        assertSame( r2, refs[2] );
        assertSame( r3, refs[1] );
    }


    public void test_service_ranking_set()
    {
<<<<<<< HEAD
        ServiceReference r1 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( 100 ) );
        ServiceReference r2 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( -100 ) );
        ServiceReference r3 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );

        Set refSet = new TreeSet( srvRank );
=======
        ServiceReference<?> r1 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( 100 ) );
        ServiceReference<?> r2 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, new Integer( -100 ) );
        ServiceReference<?> r3 = new MockServiceReference().setProperty( Constants.SERVICE_RANKING, null );

        Set<ServiceReference<?>> refSet = new TreeSet<ServiceReference<?>>( srvRank );
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        refSet.add( r1 );
        refSet.add( r2 );
        refSet.add( r3 );

<<<<<<< HEAD
        Iterator refIter = refSet.iterator();
=======
        Iterator<ServiceReference<?>> refIter = refSet.iterator();
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        assertSame( r1, refIter.next() );
        assertSame( r3, refIter.next() );
        assertSame( r2, refIter.next() );
    }


    public void test_service_cm_ranking_sort()
    {
<<<<<<< HEAD
        ServiceReference r1 = new MockServiceReference()
            .setProperty( ConfigurationPlugin.CM_RANKING, new Integer( 100 ) );
        ServiceReference r2 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING,
            new Integer( -100 ) );
        ServiceReference r3 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING, null );
        ServiceReference[] refs =
=======
        ServiceReference<?> r1 = new MockServiceReference()
            .setProperty( ConfigurationPlugin.CM_RANKING, new Integer( 100 ) );
        ServiceReference<?> r2 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING,
            new Integer( -100 ) );
        ServiceReference<?> r3 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING, null );
        ServiceReference<?>[] refs =
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
            { r1, r2, r3 };

        assertSame( r1, refs[0] );
        assertSame( r2, refs[1] );
        assertSame( r3, refs[2] );

        Arrays.sort( refs, cmRank );

        assertSame( r1, refs[2] );
        assertSame( r2, refs[0] );
        assertSame( r3, refs[1] );
    }


    public void test_service_cm_ranking_set()
    {
<<<<<<< HEAD
        ServiceReference r1 = new MockServiceReference()
            .setProperty( ConfigurationPlugin.CM_RANKING, new Integer( 100 ) );
        ServiceReference r2 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING,
            new Integer( -100 ) );
        ServiceReference r3 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING, null );

        Set refSet = new TreeSet( cmRank );
=======
        ServiceReference<?> r1 = new MockServiceReference()
            .setProperty( ConfigurationPlugin.CM_RANKING, new Integer( 100 ) );
        ServiceReference<?> r2 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING,
            new Integer( -100 ) );
        ServiceReference<?> r3 = new MockServiceReference().setProperty( ConfigurationPlugin.CM_RANKING, null );

        Set<ServiceReference<?>> refSet = new TreeSet<ServiceReference<?>>( cmRank );
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        refSet.add( r1 );
        refSet.add( r2 );
        refSet.add( r3 );

<<<<<<< HEAD
        Iterator refIter = refSet.iterator();
=======
        Iterator<ServiceReference<?>> refIter = refSet.iterator();
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        assertSame( r2, refIter.next() );
        assertSame( r3, refIter.next() );
        assertSame( r1, refIter.next() );
    }

<<<<<<< HEAD
    private static class MockServiceReference implements ServiceReference
=======
    private static class MockServiceReference implements ServiceReference<Object>
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
    {

        static long id = 0;

<<<<<<< HEAD
        private final Map props = new HashMap();
=======
        private final Map<String, Object> props = new HashMap<String, Object>();
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368

        {
            props.put( Constants.SERVICE_ID, new Long( id ) );
            id++;
        }


        MockServiceReference setProperty( final String key, final Object value )
        {
            if ( value == null )
            {
                props.remove( key );
            }
            else
            {
                props.put( key, value );
            }
            return this;
        }


<<<<<<< HEAD
=======
        @Override
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        public Object getProperty( String key )
        {
            return props.get( key );
        }


<<<<<<< HEAD
        public String[] getPropertyKeys()
        {
            return ( String[] ) props.keySet().toArray( new String[props.size()] );
        }


=======
        @Override
        public String[] getPropertyKeys()
        {
            return props.keySet().toArray( new String[props.size()] );
        }


        @Override
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        public Bundle getBundle()
        {
            return null;
        }


<<<<<<< HEAD
=======
        @Override
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        public Bundle[] getUsingBundles()
        {
            return null;
        }


<<<<<<< HEAD
=======
        @Override
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        public boolean isAssignableTo( Bundle bundle, String className )
        {
            return false;
        }


<<<<<<< HEAD
=======
        @Override
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        public int compareTo( Object reference )
        {
            return 0;
        }


<<<<<<< HEAD
=======
        @Override
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        public String toString()
        {
            return "ServiceReference " + getProperty( Constants.SERVICE_ID );
        }
    }

}
