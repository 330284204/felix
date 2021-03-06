/*
<<<<<<< HEAD
 * Copyright (c) OSGi Alliance (2001, 2011). All Rights Reserved.
=======
 * Copyright (c) OSGi Alliance (2001, 2013). All Rights Reserved.
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.osgi.framework;

<<<<<<< HEAD
=======
import org.osgi.annotation.versioning.ConsumerType;

>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
/**
 * A synchronous {@code BundleEvent} listener. {@code SynchronousBundleListener}
 * is a listener interface that may be implemented by a bundle developer. When a
 * {@code BundleEvent} is fired, it is synchronously delivered to a
 * {@code SynchronousBundleListener}. The Framework may deliver
 * {@code BundleEvent} objects to a {@code SynchronousBundleListener} out of
 * order and may concurrently call and/or reenter a
 * {@code SynchronousBundleListener}.
 * 
 * <p>
 * For {@code BundleEvent} types {@link BundleEvent#STARTED STARTED} and
 * {@link BundleEvent#LAZY_ACTIVATION LAZY_ACTIVATION}, the Framework must not
 * hold the referenced bundle's &quot;state change&quot; lock when the
 * {@code BundleEvent} is delivered to a {@code SynchronousBundleListener}. For
 * the other {@code BundleEvent} types, the Framework must hold the referenced
 * bundle's &quot;state change&quot; lock when the {@code BundleEvent} is
 * delivered to a {@code SynchronousBundleListener}. A
 * {@code SynchronousBundleListener} cannot directly call life cycle methods on
 * the referenced bundle when the Framework is holding the referenced bundle's
 * &quot;state change&quot; lock.
 * 
 * <p>
 * A {@code SynchronousBundleListener} object is registered with the Framework
 * using the {@link BundleContext#addBundleListener(BundleListener)} method.
 * {@code SynchronousBundleListener} objects are called with a
 * {@code BundleEvent} object when a bundle has been installed, resolved,
 * starting, started, stopping, stopped, updated, unresolved, or uninstalled.
 * <p>
 * Unlike normal {@code BundleListener} objects,
 * {@code SynchronousBundleListener}s are synchronously called during bundle
 * lifecycle processing. The bundle lifecycle processing will not proceed until
 * all {@code SynchronousBundleListener}s have completed.
 * {@code SynchronousBundleListener} objects will be called prior to
 * {@code BundleListener} objects.
 * <p>
 * {@code AdminPermission[bundle,LISTENER]} is required to add or remove a
 * {@code SynchronousBundleListener} object.
 * 
 * @since 1.1
 * @see BundleEvent
 * @ThreadSafe
<<<<<<< HEAD
 * @version $Id: 74246f4ceeba7f9a5ee198048522f93d4691c51a $
 */

=======
 * @author $Id: 6b50c6c9d8b8b091928495eb036552773284b13a $
 */
@ConsumerType
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
public interface SynchronousBundleListener extends BundleListener {
	// This is a marker interface
}
