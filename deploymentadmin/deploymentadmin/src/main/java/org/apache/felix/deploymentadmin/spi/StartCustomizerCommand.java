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
package org.apache.felix.deploymentadmin.spi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.felix.deploymentadmin.AbstractDeploymentPackage;
import org.apache.felix.deploymentadmin.BundleInfoImpl;
import org.osgi.framework.Bundle;
<<<<<<< HEAD
import org.osgi.framework.BundleException;
=======
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
import org.osgi.service.deploymentadmin.DeploymentException;
import org.osgi.service.log.LogService;

/**
<<<<<<< HEAD
 * Command that starts all customizer bundles defined in the source deployment packages of a deployment
 * session. In addition all customizer bundles of the target deployment package that are not present in the source
 * deployment package are started as well.
 */
public class StartCustomizerCommand extends Command {

    public void execute(DeploymentSessionImpl session) throws DeploymentException {
=======
 * Command that starts all customizer bundles defined in the source deployment
 * packages of a deployment session. In addition all customizer bundles of the
 * target deployment package that are not present in the source deployment
 * package are started as well.
 */
public class StartCustomizerCommand extends Command {

    protected void doExecute(DeploymentSessionImpl session) throws Exception {
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        AbstractDeploymentPackage target = session.getTargetAbstractDeploymentPackage();
        AbstractDeploymentPackage source = session.getSourceAbstractDeploymentPackage();

        Set bundles = new HashSet();
        Set sourceBundlePaths = new HashSet();

        BundleInfoImpl[] targetInfos = target.getBundleInfoImpls();
        BundleInfoImpl[] sourceInfos = source.getBundleInfoImpls();
        for (int i = 0; i < sourceInfos.length; i++) {
            if (sourceInfos[i].isCustomizer()) {
                sourceBundlePaths.add(sourceInfos[i].getPath());
                Bundle bundle = source.getBundle(sourceInfos[i].getSymbolicName());
                if (bundle != null) {
                    bundles.add(bundle);
                }
            }
        }

        for (int i = 0; i < targetInfos.length; i++) {
            if (targetInfos[i].isCustomizer() && !sourceBundlePaths.contains(targetInfos[i].getPath())) {
                Bundle bundle = target.getBundle(targetInfos[i].getSymbolicName());
                if (bundle != null) {
                    bundles.add(bundle);
                }
            }
        }

        for (Iterator i = bundles.iterator(); i.hasNext();) {
            Bundle bundle = (Bundle) i.next();
            try {
                bundle.start();
            }
<<<<<<< HEAD
            catch (BundleException be) {
                throw new DeploymentException(DeploymentException.CODE_OTHER_ERROR, "Could not start customizer bundle '" + bundle.getSymbolicName() + "'", be);
=======
            catch (Exception be) {
                throw new DeploymentException(CODE_OTHER_ERROR, "Could not start customizer bundle '" + bundle.getSymbolicName() + "'", be);
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
            }
            addRollback(new StopCustomizerRunnable(session, bundle));
        }
    }

<<<<<<< HEAD
    private static class StopCustomizerRunnable implements Runnable {
        private final DeploymentSessionImpl m_session;
=======
    private static class StopCustomizerRunnable extends AbstractAction {
        private final DeploymentSessionImpl m_session;

>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        private final Bundle m_bundle;

        public StopCustomizerRunnable(DeploymentSessionImpl session, Bundle bundle) {
            m_session = session;
            m_bundle = bundle;
        }

<<<<<<< HEAD
        public void run() {
            try {
                m_bundle.stop();
            }
            catch (BundleException e) {
                m_session.getLog().log(LogService.LOG_WARNING, "Failed to stop bundle '" + m_bundle.getSymbolicName() + "'", e);
            }
=======
        protected void doRun() throws Exception {
            m_bundle.stop();
        }

        protected void onFailure(Exception e) {
            m_session.getLog().log(LogService.LOG_WARNING, "Failed to stop bundle '" + m_bundle.getSymbolicName() + "'", e);
>>>>>>> 502e622adcc798bcbd433d6b42ca78673cfab368
        }
    }
}
