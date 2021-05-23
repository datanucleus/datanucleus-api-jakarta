/**********************************************************************
Copyright (c) 2009 Andy Jefferson and others. All rights reserved.
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

import java.io.Serializable;
import java.util.Map;

import jakarta.persistence.Query;

import org.datanucleus.store.query.cache.QueryResultsCache;

/**
 * Implementation of the JPA QueryCache.
 * Provides a wrapper and hands off calls to the underlying query cache.
 */
public class JPAQueryCache implements Serializable
{
    private static final long serialVersionUID = 658627275290103155L;
    QueryResultsCache resultsCache;

    /**
     * Constructor.
     * @param cache Query results cache
     */
    public JPAQueryCache(QueryResultsCache cache)
    {
        this.resultsCache = cache;
    }

    /**
     * Accessor for the underlying query cache.
     * @return Underlying query cache.
     */
    public QueryResultsCache getQueryCache()
    {
        return resultsCache;
    }

    /**
     * Evict all cached results for the provided query.
     * @param query The JPA query
     */
    public void evict(Query query)
    {
        resultsCache.evict(((JPAQuery)query).getInternalQuery());
    }

    /**
     * Evict the cached results for the provided query and params.
     * @param query The JPA query
     * @param params The input params
     */
    public void evict(Query query, Map params)
    {
        resultsCache.evict(((JPAQuery)query).getInternalQuery(), params);
    }

    /**
     * Evict the parameter instances from the second-level cache.
     * All instances in the EntityManagers cache are evicted
     * from the second-level cache.
     */
    public void evictAll()
    {
        resultsCache.evictAll();
    }

    /**
     * Method to pin the specified query in the cache, preventing garbage collection.
     * @param query The query
     */
    public void pin(Query query)
    {
        resultsCache.pin(((JPAQuery)query).getInternalQuery());
    }

    /**
     * Method to pin the specified query in the cache, preventing garbage collection.
     * @param query The query
     * @param params Its params
     */
    public void pin(Query query, Map params)
    {
        resultsCache.pin(((JPAQuery)query).getInternalQuery(), params);
    }

    /**
     * Method to unpin the specified query from the cache, allowing garbage collection.
     * @param query The query
     */
    public void unpin(Query query)
    {
        resultsCache.unpin(((JPAQuery)query).getInternalQuery());
    }

    /**
     * Method to unpin the specified query from the cache, allowing garbage collection.
     * @param query The query
     * @param params Its params
     */
    public void unpin(Query query, Map params)
    {
        resultsCache.unpin(((JPAQuery)query).getInternalQuery(), params);
    }
}