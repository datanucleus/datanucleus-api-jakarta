/**********************************************************************
Copyright (c) 2011 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
   ...
**********************************************************************/
package org.datanucleus.api.jakarta;

/**
 * Exception thrown when trying to create an EMF and using singleton setting yet one with this name
 * already exists.
 */
public class SingletonEMFException extends RuntimeException
{
    private static final long serialVersionUID = 4134092631249438748L;
    final JakartaEntityManagerFactory emf;

    /**
     * @param message The message
     * @param emf The EMF that is the singleton
     */
    public SingletonEMFException(String message, JakartaEntityManagerFactory emf)
    {
        super(message);
        this.emf = emf;
    }

    public JakartaEntityManagerFactory getSingleton()
    {
        return emf;
    }
}