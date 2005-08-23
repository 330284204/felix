/*
 *   Copyright 2005 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.apache.felix.framework;

import java.io.IOException;
import java.net.*;

import org.apache.felix.moduleloader.ModuleManager;

class BundleURLStreamHandler extends URLStreamHandler
{
    private ModuleManager m_mgr = null;

    public BundleURLStreamHandler(ModuleManager mgr)
    {
        m_mgr = mgr;
    }

    protected URLConnection openConnection(URL url) throws IOException
    {
        return new BundleURLConnection(m_mgr, url);
    }
}