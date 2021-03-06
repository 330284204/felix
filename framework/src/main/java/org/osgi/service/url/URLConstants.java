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

<<<<<<< HEAD
=======
import org.osgi.annotation.versioning.ProviderType;

>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
/**
 * Defines standard names for property keys associated with
 * {@link URLStreamHandlerService} and {@code java.net.ContentHandler} services.
 * 
 * <p>
 * The values associated with these keys are of type {@code java.lang.String[]}
 * or {@code java.lang.String}, unless otherwise indicated.
 * 
<<<<<<< HEAD
 * @noimplement
 * @version $Id: ac2b9670972d6e41d989c51067219ff7be459831 $
 */
=======
 * @author $Id: 490baaad326523bcb3915ef04572d3c28560db0b $
 */
@ProviderType
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
public interface URLConstants {
	/**
	 * Service property naming the protocols serviced by a
	 * URLStreamHandlerService. The property's value is a protocol name or an
	 * array of protocol names.
	 */
	public static final String	URL_HANDLER_PROTOCOL	= "url.handler.protocol";
	/**
	 * Service property naming the MIME types serviced by a
	 * java.net.ContentHandler. The property's value is a MIME type or an array
	 * of MIME types.
	 */
	public static final String	URL_CONTENT_MIMETYPE	= "url.content.mimetype";
}
