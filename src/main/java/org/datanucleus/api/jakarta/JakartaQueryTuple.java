/**********************************************************************
Copyright (c) 2015 Andy Jefferson and others. All rights reserved.
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;

/**
 * Implementation of a Jakarta Persistence Tuple, for a query result.
 */
public class JakartaQueryTuple implements Tuple
{
    protected List<JakartaQueryTupleElement> elements = new ArrayList<JakartaQueryTupleElement>();
    protected Map<String, JakartaQueryTupleElement> elementByAlias = new HashMap<String, JakartaQueryTupleElement>();

    public JakartaQueryTuple()
    {
    }

    /**
     * Method used by DataNucleus query mechanism to load up the row results into this tuple.
     * @param key Key of the result
     * @param val Value of the result
     */
    public void put(Object key, Object val)
    {
        JakartaQueryTupleElement te = new JakartaQueryTupleElement((String) key, (val != null) ? val.getClass() : null, val);
        elements.add(te);
        elementByAlias.put((String)key, te);
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.Tuple#get(jakarta.persistence.TupleElement)
     */
    @Override
    public <X> X get(TupleElement<X> tupleElement)
    {
        if (!elements.contains(tupleElement))
        {
            throw new IllegalArgumentException("TupleElement is not present in this Tuple");
        }

        for (JakartaQueryTupleElement te : elements)
        {
            if (te.equals(tupleElement))
            {
                return (X) te.getValue();
            }
        }
        return null;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.Tuple#get(java.lang.String, java.lang.Class)
     */
    @Override
    public <X> X get(String alias, Class<X> type)
    {
        JakartaQueryTupleElement te = elementByAlias.get(alias);
        if (te == null)
        {
            throw new IllegalArgumentException("Cannot find element of Tuple with alias=" + alias);
        }

        if (!type.isAssignableFrom(te.getJavaType()))
        {
            throw new IllegalArgumentException("Cannot return value for alias=" + alias + " of this Tuple to be type=" + type.getName() + " because type is " + te.getJavaType());
        }
        return (X) te.getValue();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.Tuple#get(java.lang.String)
     */
    @Override
    public Object get(String alias)
    {
        JakartaQueryTupleElement te = elementByAlias.get(alias);
        if (te == null)
        {
            throw new IllegalArgumentException("Cannot find element of Tuple with alias=" + alias);
        }

        return te.getValue();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.Tuple#get(int, java.lang.Class)
     */
    @Override
    public <X> X get(int i, Class<X> type)
    {
        if (i < 0 || i >= elements.size())
        {
            throw new IllegalArgumentException("Cannot return value for position " + i + " of this Tuple. Max position=" + (elements.size()-1));
        }

        JakartaQueryTupleElement te = elements.get(i);
        if (!type.isAssignableFrom(te.getJavaType()))
        {
            throw new IllegalArgumentException("Cannot return value for position " + i + " of this Tuple to be type=" + type.getName() + " because type is " + te.getJavaType());
        }
        return (X) te.getValue();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.Tuple#get(int)
     */
    @Override
    public Object get(int i)
    {
        if (i < 0 || i >= elements.size())
        {
            throw new IllegalArgumentException("Cannot return value for position " + i + " of this Tuple. Max position=" + (elements.size()-1));
        }

        JakartaQueryTupleElement te = elements.get(i);
        return te.getValue();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.Tuple#toArray()
     */
    @Override
    public Object[] toArray()
    {
        Object[] values = new Object[elements.size()];
        int i = 0;
        for (JakartaQueryTupleElement te : elements)
        {
            values[i++] = te.getValue();
        }
        return values;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.Tuple#getElements()
     */
    @Override
    public List<TupleElement<?>> getElements()
    {
        List<TupleElement<?>> tupleElements = new ArrayList();
        for (JakartaQueryTupleElement te : elements)
        {
            tupleElements.add(te);
        }
        return tupleElements;
    }

    public String toString()
    {
        return "JakartaQueryTuple : " + elements.size() + " elements";
    }
}