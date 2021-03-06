/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *  
        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package com.palo.it.devoxx2015.back.exception.dao;

/**
 * DaoExceptionNullEntity.
 *
 * @author pguillerm
 * @since 13 févr. 2015
 */
public class DaoExceptionNullEntity extends DaoException {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1230131779703379767L;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    /**
     * Instantiates a new dao exception null entity.
     */
    public DaoExceptionNullEntity() {
        super();
    }

    /**
     * Instantiates a new dao exception null entity.
     *
     * @param message the message
     * @param values the values
     */
    public DaoExceptionNullEntity(final String message, final Object... values) {
        super(message, values);
    }

    /**
     * Instantiates a new dao exception null entity.
     *
     * @param message the message
     * @param cause the cause
     * @param values the values
     */
    public DaoExceptionNullEntity(final String message, final Throwable cause, final Object... values) {
        super(message, cause, values);
    }

    /**
     * Instantiates a new dao exception null entity.
     *
     * @param message the message
     * @param cause the cause
     */
    public DaoExceptionNullEntity(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new dao exception null entity.
     *
     * @param message the message
     */
    public DaoExceptionNullEntity(final String message) {
        super(message);
    }

    /**
     * Instantiates a new dao exception null entity.
     *
     * @param cause the cause
     */
    public DaoExceptionNullEntity(final Throwable cause) {
        super(cause);
    }
}
