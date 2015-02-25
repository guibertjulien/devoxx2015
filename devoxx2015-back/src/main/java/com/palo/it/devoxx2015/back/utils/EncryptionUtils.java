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
package com.palo.it.devoxx2015.back.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * EncryptionUtils
 * 
 * @author pguillerm
 * @since 25 févr. 2015
 */
public class EncryptionUtils implements Serializable {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    /** The Constant serialVersionUID. */
    private static final long            serialVersionUID = -9191956072902982987L;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    private static final EncryptionUtils INSTANCE         = new EncryptionUtils();

    private EncryptionUtils() {
        super();
    }

    public static synchronized EncryptionUtils getInstance() {
        return INSTANCE;
    }

    // =========================================================================
    // METHODS
    // =========================================================================
    /**
     * Decode map.
     *
     * @param value the value
     * @return the map
     */
    public Map<String, String> decodeMap(final String value) {
        Map<String, String> result = new HashMap<>();

        String[] values = value.split("@");
        for (String item : values) {
            String[] composite = item.split(":");
            if (composite.length == 2) {
                result.put(composite[0], composite[1]);
            }
        }
        return result;
    }
}
