/*
<<<<<<< HEAD
 * Copyright (c) OSGi Alliance (2002, 2012). All Rights Reserved.
=======
 * Copyright (c) OSGi Alliance (2002, 2013). All Rights Reserved.
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

package org.osgi.service.url;

import java.net.URL;
<<<<<<< HEAD
=======
import org.osgi.annotation.versioning.ConsumerType;
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368

/**
 * Interface used by {@code URLStreamHandlerService} objects to call the
 * {@code setURL} method on the proxy {@code URLStreamHandler} object.
 * 
 * <p>
 * Objects of this type are passed to the
 * {@link URLStreamHandlerService#parseURL(URLStreamHandlerSetter, URL, String, int, int)}
 * method. Invoking the {@code setURL} method on the
 * {@code URLStreamHandlerSetter} object will invoke the {@code setURL} method
 * on the proxy {@code URLStreamHandler} object that is actually registered with
 * {@code java.net.URL} for the protocol.
 * 
 * @ThreadSafe
<<<<<<< HEAD
 * @version $Id: 90f25e3961fea2150cfd31117a2237304f1518f9 $
 */
=======
 * @author $Id: 96648b48a7ce8fb4baf50c7b118a0339f4efcf35 $
 */
@ConsumerType
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
public interface URLStreamHandlerSetter {
	/**
	 * @see "java.net.URLStreamHandler.setURL(URL,String,String,int,String,String)"
	 * 
	 * @deprecated This method is only for compatibility with handlers written
	 *             for JDK 1.1.
	 */
<<<<<<< HEAD
=======
	@SuppressWarnings("javadoc")
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
	public void setURL(URL u, String protocol, String host, int port, String file, String ref);

	/**
	 * @see "java.net.URLStreamHandler.setURL(URL,String,String,int,String,String,String,String)"
	 */
<<<<<<< HEAD
=======
	@SuppressWarnings("javadoc")
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
	public void setURL(URL u, String protocol, String host, int port, String authority, String userInfo, String path, String query, String ref);
}
