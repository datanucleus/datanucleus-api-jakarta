/**********************************************************************
Copyright (c) 2012 Andy Jefferson and others. All rights reserved.
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

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.Parameter;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.QueryTimeoutException;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.TemporalType;

import org.datanucleus.exceptions.NucleusException;
import org.datanucleus.metadata.StoredProcQueryParameterMode;
import org.datanucleus.store.query.AbstractStoredProcedureQuery;
import org.datanucleus.store.query.NoQueryResultsException;

/**
 * Implementation of a StoredProcedureQuery.
 * Wraps an internal query.
 */
public class JakartaStoredProcedureQuery extends JakartaQuery implements StoredProcedureQuery
{
    public JakartaStoredProcedureQuery(EntityManager em, org.datanucleus.store.query.Query query)
    {
        super((JakartaEntityManager)em, query, "STOREDPROCEDURE");
    }

    private AbstractStoredProcedureQuery getStoredProcQuery()
    {
        return (AbstractStoredProcedureQuery)query;
    }

    /* (non-Javadoc)
     * @see org.datanucleus.api.jakarta.JakartaQuery#setParameter(jakarta.persistence.Parameter, java.lang.Object)
     */
    @Override
    public JakartaStoredProcedureQuery setParameter(Parameter param, Object value)
    {
        super.setParameter(param, value);
        return this;
    }

    /* (non-Javadoc)
     * @see org.datanucleus.api.jakarta.JakartaQuery#setParameter(jakarta.persistence.Parameter, java.util.Calendar, jakarta.persistence.TemporalType)
     */
    @Override
    public JakartaStoredProcedureQuery setParameter(Parameter param, Calendar cal, TemporalType type)
    {
        super.setParameter(param, cal, type);
        return this;
    }

    /* (non-Javadoc)
     * @see org.datanucleus.api.jakarta.JakartaQuery#setParameter(jakarta.persistence.Parameter, java.util.Date, jakarta.persistence.TemporalType)
     */
    @Override
    public JakartaStoredProcedureQuery setParameter(Parameter param, Date date, TemporalType type)
    {
        super.setParameter(param, date, type);
        return this;
    }

    public JakartaStoredProcedureQuery setParameter(String name, Object value)
    {
        super.setParameter(name, value);
        return this;
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#setParameter(java.lang.String, java.util.Calendar, jakarta.persistence.TemporalType)
     */
    public JakartaStoredProcedureQuery setParameter(String name, Calendar value, TemporalType temporalType)
    {
        super.setParameter(name, value, temporalType);
        return this;
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#setParameter(java.lang.String, java.util.Date, jakarta.persistence.TemporalType)
     */
    public JakartaStoredProcedureQuery setParameter(String name, Date date, TemporalType type)
    {
        super.setParameter(name, date, type);
        return this;
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#setParameter(int, java.lang.Object)
     */
    public JakartaStoredProcedureQuery setParameter(int position, Object value)
    {
        super.setParameter(position, value);
        return this;
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#setParameter(int, java.util.Calendar, jakarta.persistence.TemporalType)
     */
    public JakartaStoredProcedureQuery setParameter(int position, Calendar value, TemporalType temporalType)
    {
        super.setParameter(position, value, temporalType);
        return this;
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#setParameter(int, java.util.Date, jakarta.persistence.TemporalType)
     */
    public JakartaStoredProcedureQuery setParameter(int position, Date value, TemporalType temporalType)
    {
        super.setParameter(position, value, temporalType);
        return this;
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#registerStoredProcedureParameter(int, java.lang.Class, jakarta.persistence.ParameterMode)
     */
    public StoredProcedureQuery registerStoredProcedureParameter(int position, Class type, ParameterMode mode)
    {
        StoredProcQueryParameterMode paramMode = null;
        if (mode == ParameterMode.IN)
        {
            paramMode = StoredProcQueryParameterMode.IN;
        }
        else if (mode == ParameterMode.OUT)
        {
            paramMode = StoredProcQueryParameterMode.OUT;
        }
        else if (mode == ParameterMode.INOUT)
        {
            paramMode = StoredProcQueryParameterMode.INOUT;
        }
        else if (mode == ParameterMode.REF_CURSOR)
        {
            paramMode = StoredProcQueryParameterMode.REF_CURSOR;
        }
        getStoredProcQuery().registerParameter(position, type, paramMode);
        return this;
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#registerStoredProcedureParameter(java.lang.String, java.lang.Class, jakarta.persistence.ParameterMode)
     */
    public StoredProcedureQuery registerStoredProcedureParameter(String parameterName, Class type, ParameterMode mode)
    {
        StoredProcQueryParameterMode paramMode = null;
        if (mode == ParameterMode.IN)
        {
            paramMode = StoredProcQueryParameterMode.IN;
        }
        else if (mode == ParameterMode.OUT)
        {
            paramMode = StoredProcQueryParameterMode.OUT;
        }
        else if (mode == ParameterMode.INOUT)
        {
            paramMode = StoredProcQueryParameterMode.INOUT;
        }
        else if (mode == ParameterMode.REF_CURSOR)
        {
            paramMode = StoredProcQueryParameterMode.REF_CURSOR;
        }
        getStoredProcQuery().registerParameter(parameterName, type, paramMode);
        return this;
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#getOutputParameterValue(int)
     */
    public Object getOutputParameterValue(int position)
    {
        return getStoredProcQuery().getOutputParameterValue(position);
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#getOutputParameterValue(java.lang.String)
     */
    public Object getOutputParameterValue(String parameterName)
    {
        return getStoredProcQuery().getOutputParameterValue(parameterName);
    }

    boolean executeProcessed = false;

    /* (non-Javadoc)
     * @see StoredProcedureQuery#execute()
     */
    public boolean execute()
    {
        Object hasResultSet = query.execute();
        executeProcessed = true;
        return (Boolean)hasResultSet;
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#hasMoreResults()
     */
    public boolean hasMoreResults()
    {
        if (executeProcessed)
        {
            return getStoredProcQuery().hasMoreResults();
        }
        return false;
    }

    /* (non-Javadoc)
     * @see StoredProcedureQuery#getUpdateCount()
     */
    public int getUpdateCount()
    {
        if (executeProcessed)
        {
            return getStoredProcQuery().getUpdateCount();
        }
        return -1;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.Query#executeUpdate()
     */
    public int executeUpdate()
    {
        try
        {
            if (flushMode == FlushModeType.AUTO && em.getTransaction().isActive())
            {
                em.flush();
            }

            Boolean hasResultSet = (Boolean)query.execute();
            if (hasResultSet)
            {
                throw new IllegalStateException("Stored procedure returned a result set but method requires an update count");
            }
            return getStoredProcQuery().getUpdateCount();
        }
        catch (NoQueryResultsException nqre)
        {
            return 0;
        }
        catch (org.datanucleus.store.query.QueryTimeoutException qte)
        {
            throw new QueryTimeoutException();
        }
        catch (NucleusException jpe)
        {
            throw DataNucleusHelperJakarta.getJakartaExceptionForNucleusException(jpe);
        }
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.Query#getResultList()
     */
    public List getResultList()
    {
        if (executeProcessed)
        {
            return (List)getStoredProcQuery().getNextResults();
        }

        try
        {
            if (flushMode == FlushModeType.AUTO && em.getTransaction().isActive())
            {
                em.flush();
            }

            Boolean hasResultSet = (Boolean)query.execute();
            if (!hasResultSet)
            {
                throw new IllegalStateException("Stored proc should have returned result set but didnt");
            }
            return (List)getStoredProcQuery().getNextResults();
        }
        catch (NoQueryResultsException nqre)
        {
            return null;
        }
        catch (org.datanucleus.store.query.QueryTimeoutException qte)
        {
            throw new QueryTimeoutException();
        }
        catch (NucleusException jpe)
        {
            throw DataNucleusHelperJakarta.getJakartaExceptionForNucleusException(jpe);
        }
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.Query#getSingleResult()
     */
    public Object getSingleResult()
    {
        if (executeProcessed)
        {
            query.setUnique(true);
            return getStoredProcQuery().getNextResults();
        }

        try
        {
            if (flushMode == FlushModeType.AUTO && em.getTransaction().isActive())
            {
                em.flush();
            }

            query.setUnique(true);
            Boolean hasResultSet = (Boolean)query.execute();
            if (!hasResultSet)
            {
                throw new IllegalStateException("Stored proc should have returned result set but didnt");
            }
            return getStoredProcQuery().getNextResults();
        }
        catch (NoQueryResultsException nqre)
        {
            return null;
        }
        catch (org.datanucleus.store.query.QueryTimeoutException qte)
        {
            throw new QueryTimeoutException();
        }
        catch (NucleusException jpe)
        {
            throw DataNucleusHelperJakarta.getJakartaExceptionForNucleusException(jpe);
        }
    }

    public JakartaStoredProcedureQuery setFlushMode(FlushModeType mode)
    {
        return (JakartaStoredProcedureQuery) super.setFlushMode(mode);
    }

    /* (non-Javadoc)
     * @see org.datanucleus.api.jakarta.JakartaQuery#setHint(java.lang.String, java.lang.Object)
     */
    @Override
    public JakartaStoredProcedureQuery setHint(String hintName, Object value)
    {
        return (JakartaStoredProcedureQuery) super.setHint(hintName, value);
    }
}