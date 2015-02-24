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
package com.palo.it.devoxx2015.back.exception;

/**
 * TechnicalException.
 *
 * @author pguillerm
 * @since 24 févr. 2015
 */
public class TechnicalException extends Exception {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3589003823108673251L;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    /**
     * Instantiates a new technical exception.
     */
    public TechnicalException() {
        super();
    }

    /**
     * Instantiates a new technical exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new technical exception.
     *
     * @param message the message
     */
    public TechnicalException(String message) {
        super(message);
    }

    /**
     * Instantiates a new technical exception.
     *
     * @param cause the cause
     */
    public TechnicalException(Throwable cause) {
        super(cause);
    }

}
