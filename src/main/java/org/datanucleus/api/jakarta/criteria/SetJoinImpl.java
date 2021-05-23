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

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.SetJoin;
import jakarta.persistence.metamodel.SetAttribute;

import org.datanucleus.api.jakarta.metamodel.SetAttributeImpl;

/**
 * Implementation of JPA2 Criteria "SetJoin".
 * 
 * @param <Z> The source type of the join
 * @param <E> The element type of the target Set
 */
public class SetJoinImpl<Z, E> extends PluralJoinImpl<Z, java.util.Set<E>, E> implements SetJoin<Z, E>
{
    private static final long serialVersionUID = 6175048298635145121L;

    public SetJoinImpl(CriteriaBuilderImpl cb, FromImpl parent, SetAttributeImpl attr, JoinType joinType)
    {
        super(cb, parent, attr, joinType);
    }

    public SetAttribute<? super Z, E> getModel()
    {
        return (SetAttribute<? super Z, E>)attribute;
    }

    public SetJoin<Z, E> on(Expression<Boolean> restriction)
    {
        return (SetJoin<Z, E>) super.on(restriction);
    }

    public SetJoin<Z, E> on(Predicate... restrictions)
    {
        return (SetJoin<Z, E>) super.on(restrictions);
    }
}