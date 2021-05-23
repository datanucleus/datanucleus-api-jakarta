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
package org.datanucleus.api.jakarta.criteria;

import java.util.List;
import java.util.Random;
import java.util.Set;

import jakarta.persistence.criteria.AbstractQuery;
import jakarta.persistence.criteria.CollectionJoin;
import jakarta.persistence.criteria.CommonAbstractCriteria;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.ListJoin;
import jakarta.persistence.criteria.MapJoin;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.SetJoin;
import jakarta.persistence.criteria.Subquery;
import jakarta.persistence.metamodel.EntityType;

import org.datanucleus.store.query.expression.VariableExpression;

/**
 * Implementation of Jakarta Persistence Criteria "Subquery".
 * A subquery in DataNucleus is represented as a variable (as it is in JDOQL), consequently this
 * expression is backed by a VariableExpression.
 */
public class SubqueryImpl<T> extends ExpressionImpl<T> implements Subquery<T>
{
    private static final long serialVersionUID = 6197187043693743756L;

    protected CriteriaQueryImpl<?> parent;

    protected CriteriaQueryImpl<T> delegate;

    private Set<Join<?,?>> correlatedJoins = null; 

    /** Random number generator, for use in naming subqueries */
    public static final Random random = new Random();

    public SubqueryImpl(CriteriaBuilderImpl cb, Class<T> type, CriteriaQuery<?> query)
    {
        super(cb, type);
        this.parent = (CriteriaQueryImpl<?>) query;
        this.delegate = new CriteriaQueryImpl<T>(cb, type);
        String variableName = "SUB" + random.nextInt();
        this.queryExpr = new VariableExpression(variableName);
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#getCorrelatedJoins()
     */
    public Set<Join<?,?>> getCorrelatedJoins()
    {
        return correlatedJoins;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#getParent()
     */
    public AbstractQuery<?> getParent()
    {
        return parent;
    }

    /**
     * Convenience accessor for the delegate criteria query that provides this subquery.
     * @return The delegate
     */
    public CriteriaQuery<?> getDelegate()
    {
        return delegate;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#correlate(jakarta.persistence.criteria.CollectionJoin)
     */
    public <X, Y> CollectionJoin<X, Y> correlate(CollectionJoin<X, Y> arg0)
    {
        // TODO Implement this
        throw new UnsupportedOperationException(
            "Not yet implemented. Provide a testcase that uses this and raise an issue attaching your testcase");
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#correlate(jakarta.persistence.criteria.Join)
     */
    public <X, Y> Join<X, Y> correlate(Join<X, Y> arg0)
    {
        // TODO Implement this
        throw new UnsupportedOperationException(
            "Not yet implemented. Provide a testcase that uses this and raise an issue attaching your testcase");
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#correlate(jakarta.persistence.criteria.ListJoin)
     */
    public <X, Y> ListJoin<X, Y> correlate(ListJoin<X, Y> arg0)
    {
        // TODO Implement this
        throw new UnsupportedOperationException(
            "Not yet implemented. Provide a testcase that uses this and raise an issue attaching your testcase");
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#correlate(jakarta.persistence.criteria.MapJoin)
     */
    public <X, K, V> MapJoin<X, K, V> correlate(MapJoin<X, K, V> arg0)
    {
        // TODO Implement this
        throw new UnsupportedOperationException(
            "Not yet implemented. Provide a testcase that uses this and raise an issue attaching your testcase");
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#correlate(jakarta.persistence.criteria.Root)
     */
    public <Y> Root<Y> correlate(Root<Y> arg0)
    {
        // TODO Implement this
        throw new UnsupportedOperationException(
            "Not yet implemented. Provide a testcase that uses this and raise an issue attaching your testcase");
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#correlate(jakarta.persistence.criteria.SetJoin)
     */
    public <X, Y> SetJoin<X, Y> correlate(SetJoin<X, Y> arg0)
    {
        // TODO Implement this
        throw new UnsupportedOperationException(
            "Not yet implemented. Provide a testcase that uses this and raise an issue attaching your testcase");
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#distinct(boolean)
     */
    public Subquery<T> distinct(boolean flag)
    {
        delegate.distinct(flag);
        return this;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.AbstractQuery#isDistinct()
     */
    public boolean isDistinct()
    {
        return delegate.isDistinct();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.AbstractQuery#getResultType()
     */
    public Class<T> getResultType()
    {
        return (Class<T>) getJavaType();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#select(jakarta.persistence.criteria.Expression)
     */
    public Subquery<T> select(Expression<T> expr)
    {
        delegate.select(expr);
        return this;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#getSelection()
     */
    public Expression<T> getSelection()
    {
        return (Expression<T>) delegate.getSelection();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.AbstractQuery#from(java.lang.Class)
     */
    public <X> Root<X> from(Class<X> cls)
    {
        return delegate.from(cls);
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.AbstractQuery#from(jakarta.persistence.metamodel.EntityType)
     */
    public <X> Root<X> from(EntityType<X> type)
    {
        return delegate.from(type);
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.AbstractQuery#getRestriction()
     */
    public Predicate getRestriction()
    {
        return delegate.getRestriction();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.AbstractQuery#getRoots()
     */
    public Set<Root<?>> getRoots()
    {
        return delegate.getRoots();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#where(jakarta.persistence.criteria.Expression)
     */
    public Subquery<T> where(Expression<Boolean> expr)
    {
        delegate.where(expr);
        return this;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#where(jakarta.persistence.criteria.Predicate[])
     */
    public Subquery<T> where(Predicate... exprs)
    {
        delegate.where(exprs);
        return this;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#groupBy(jakarta.persistence.criteria.Expression<?>[])
     */
    public Subquery<T> groupBy(Expression<?>... exprs)
    {
        delegate.groupBy(exprs);
        return this;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#groupBy(java.util.List)
     */
    public Subquery<T> groupBy(List<Expression<?>> exprs)
    {
        delegate.groupBy(exprs);
        return this;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.AbstractQuery#getGroupList()
     */
    public List<Expression<?>> getGroupList()
    {
        return delegate.getGroupList();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.AbstractQuery#getGroupRestriction()
     */
    public Predicate getGroupRestriction()
    {
        return delegate.getGroupRestriction();
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#having(jakarta.persistence.criteria.Expression)
     */
    public Subquery<T> having(Expression<Boolean> expr)
    {
        delegate.having(expr);
        return this;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.Subquery#having(jakarta.persistence.criteria.Predicate[])
     */
    public Subquery<T> having(Predicate... exprs)
    {
        delegate.having(exprs);
        return this;
    }

    /* (non-Javadoc)
     * @see jakarta.persistence.criteria.AbstractQuery#subquery(java.lang.Class)
     */
    public <U> Subquery<U> subquery(Class<U> type)
    {
        return delegate.subquery(type);
    }

    public String toString()
    {
        return delegate.toString();
    }

    public CommonAbstractCriteria getContainingQuery()
    {
        return parent;
    }
}