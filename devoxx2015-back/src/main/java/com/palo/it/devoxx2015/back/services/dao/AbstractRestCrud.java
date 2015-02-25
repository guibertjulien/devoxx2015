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
package com.palo.it.devoxx2015.back.services.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.palo.it.devoxx2015.back.exception.dao.DaoException;
import com.palo.it.devoxx2015.back.utils.EncryptionUtils;

/**
 * RestCrud
 * 
 * @author pguillerm
 * @since 25 févr. 2015
 */
public abstract class AbstractRestCrud<E extends Identifiable<PK>, PK extends Serializable> {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================

    private static final Logger                  LOGGER      = LoggerFactory.getLogger(AbstractRestCrud.class);

    private static final WebApplicationException NOT_ALLOWED = new WebApplicationException(
                                                                     Response.Status.METHOD_NOT_ALLOWED);

    private Class<? extends E>                   type;

    @Inject
    private Dao                                  dao;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    protected abstract Class<? extends E> initType();

    public AbstractRestCrud() {
        super();
        type = initType();

    }

    // =========================================================================
    // METHODS
    // =========================================================================
    @GET
    @Path("{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public E getByUid(@PathParam("uid") PK uid) throws WebApplicationException {
        LOGGER.info("uid : {}", uid);
        E result = null;
        try {
            result = dao.getByUid(type, uid);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }

        checkNotFound(result);
        return result;
    }

    // =========================================================================
    // REFRESH
    // =========================================================================
    @GET
    @Path("refresh/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void refresh(@PathParam("uid") PK uid) throws WebApplicationException {
        LOGGER.info("uid : {}", uid);
        E entity = null;
        try {
            entity = dao.getByUid(type, uid);
            checkNotFound(entity);
            dao.refresh(entity);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }
    }

    // =========================================================================
    // SAVE
    // =========================================================================
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveEntity(E entity) throws WebApplicationException {
        checkNullParameter(entity);
        try {
            dao.save(entity);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }
    }

    @POST
    @Path("saveList")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveList(final List<E> entities) throws WebApplicationException {
        checkNullParameter(entities);
        try {
            dao.save(entities);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }
    }

    // =========================================================================
    // MERGE
    // =========================================================================
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public E merge(E entity) throws WebApplicationException {
        checkNullParameter(entity);
        E result = null;
        try {
            dao.merge(entity);
            result = dao.get(entity);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }
        return result;
    }

    @PUT
    @Path("mergeList")
    @Consumes(MediaType.APPLICATION_JSON)
    public void mergeList(List<E> entities) throws WebApplicationException {
        checkNullParameter(entities);
        try {
            dao.merge(entities);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }
    }

    // =========================================================================
    // FIND
    // =========================================================================
    @SuppressWarnings("unchecked")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<E> findAll() throws WebApplicationException {
        LOGGER.info("findAll");
        List<E> result = null;
        try {
            result = (List<E>) dao.findAll(type);
            checkNotFound(result);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public List<E> find(@QueryParam("first") int first, @QueryParam("pageSize") int pageSize,
                        @QueryParam("field") String field, @QueryParam("sortOrder") String sortOrder,
                        @QueryParam("filters") String filters) throws WebApplicationException {
        LOGGER.info("find");

        Map<String, String> realFilter = null;
        if (stringIsNotNull(filters)) {

            realFilter = EncryptionUtils.getInstance().decodeMap(filters);
        }

        String realField = null;
        if (stringIsNotNull(field)) {
            realField = field;
        }

        String realSortOrder = null;
        if (stringIsNotNull(sortOrder)) {
            realSortOrder = sortOrder;
        }

        List<E> result = null;
        try {
            result = (List<E>) dao.find(type, first, pageSize, realField, realSortOrder, realFilter);
            checkNotFound(result);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }
        return result;
    }

    // =========================================================================
    // COUNT
    // =========================================================================
    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count() throws WebApplicationException {
        LOGGER.info("findAll");
        int result;
        try {
            result = dao.count(type);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }
        return result;
    }

    @GET
    @Path("/countFilter")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(@QueryParam("filters") String filters) throws WebApplicationException {
        LOGGER.info("findAll");

        if (filters == null || "".equals(filters.trim())) {
            return count();
        }

        Map<String, String> realFilter = null;
        if (stringIsNotNull(filters)) {
            realFilter = EncryptionUtils.getInstance().decodeMap(filters);
        }
        int result;
        try {
            result = dao.count(realFilter, type);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }
        return result;
    }

    // =========================================================================
    // DELETE
    // =========================================================================
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(PK uid) throws WebApplicationException {
        checkNullParameter(uid);
        try {
            E entity = dao.getByUid(type, uid);
            checkNotFound(entity);
            dao.delete(entity);
        } catch (DaoException e) {
            throw NOT_ALLOWED;
        }
    }

    // =========================================================================
    // EXCEPTIONS
    // =========================================================================
    protected void checkNotFound(final Object object) throws WebApplicationException {
        if (object == null) {
            exception(Response.Status.NOT_FOUND);
        }
    }

    protected void checkNullParameter(final Object object) throws WebApplicationException {
        if (object == null) {
            exception(Response.Status.METHOD_NOT_ALLOWED);
        }
    }

    protected void exception(Response.Status status) throws WebApplicationException {
        throw new WebApplicationException(Response.status(status.getStatusCode()).build());
    }

    // =========================================================================
    // UTILS
    // =========================================================================

    protected boolean stringIsNotNull(String value) {
        boolean isNull = value == null || "".equals(value.trim()) || "null".equals(value.trim().toLowerCase());
        return !isNull;
    }

}
