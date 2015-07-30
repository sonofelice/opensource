/*
 *  Copyright 2004 Clinton Begin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.ibatis.sqlmap.engine.impl;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.common.logging.Log;
import com.ibatis.common.logging.LogFactory;
import com.ibatis.sqlmap.client.*;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatis.sqlmap.engine.execution.BatchException;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.mapping.result.ResultObjectFactory;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Implementation of ExtendedSqlMapClient
 */
public class SqlMapClientImpl implements SqlMapClient, ExtendedSqlMapClient {

  private static final Log log = LogFactory.getLog(SqlMapClientImpl.class);

  /**
   * Delegate for SQL execution
   */
  public SqlMapExecutorDelegate delegate;

  protected ThreadLocal localSqlMapSession = new ThreadLocal();

  /**
   * Constructor to supply a delegate
   *
   * @param delegate - the delegate
   */
  public SqlMapClientImpl(SqlMapExecutorDelegate delegate) {
    this.delegate = delegate;
  }

  public Object insert(String id, Object param) throws SQLException {
    return getLocalSqlMapSession().insert(id, param);
  }

  public Object insert(String id) throws SQLException {
    return getLocalSqlMapSession().insert(id);
  }

  public int update(String id, Object param) throws SQLException {
    return getLocalSqlMapSession().update(id, param);
  }

  public int update(String id) throws SQLException {
    return getLocalSqlMapSession().update(id);
  }

  public int delete(String id, Object param) throws SQLException {
    return getLocalSqlMapSession().delete(id, param);
  }

  public int delete(String id) throws SQLException {
    return getLocalSqlMapSession().delete(id);
  }

  public Object queryForObject(String id, Object paramObject) throws SQLException {
    return getLocalSqlMapSession().queryForObject(id, paramObject);
  }

  public Object queryForObject(String id) throws SQLException {
    return getLocalSqlMapSession().queryForObject(id);
  }

  public Object queryForObject(String id, Object paramObject, Object resultObject) throws SQLException {
    return getLocalSqlMapSession().queryForObject(id, paramObject, resultObject);
  }

  public List queryForList(String id, Object paramObject) throws SQLException {
    return getLocalSqlMapSession().queryForList(id, paramObject);
  }

  public List queryForList(String id) throws SQLException {
    return getLocalSqlMapSession().queryForList(id);
  }

  public List queryForList(String id, Object paramObject, int skip, int max) throws SQLException {
    return getLocalSqlMapSession().queryForList(id, paramObject, skip, max);
  }

  public List queryForList(String id, int skip, int max) throws SQLException {
    return getLocalSqlMapSession().queryForList(id, skip, max);
  }

  /**
   * @deprecated All paginated list features have been deprecated
   */
  public PaginatedList queryForPaginatedList(String id, Object paramObject, int pageSize) throws SQLException {
    return getLocalSqlMapSession().queryForPaginatedList(id, paramObject, pageSize);
  }

  /**
   * @deprecated All paginated list features have been deprecated
   */
  public PaginatedList queryForPaginatedList(String id, int pageSize) throws SQLException {
    return getLocalSqlMapSession().queryForPaginatedList(id, pageSize);
  }

  public Map queryForMap(String id, Object paramObject, String keyProp) throws SQLException {
    return getLocalSqlMapSession().queryForMap(id, paramObject, keyProp);
  }

  public Map queryForMap(String id, Object paramObject, String keyProp, String valueProp) throws SQLException {
    return getLocalSqlMapSession().queryForMap(id, paramObject, keyProp, valueProp);
  }

  public void queryWithRowHandler(String id, Object paramObject, RowHandler rowHandler) throws SQLException {
    getLocalSqlMapSession().queryWithRowHandler(id, paramObject, rowHandler);
  }

  public void queryWithRowHandler(String id, RowHandler rowHandler) throws SQLException {
    getLocalSqlMapSession().queryWithRowHandler(id, rowHandler);
  }

  public void startTransaction() throws SQLException {
    getLocalSqlMapSession().startTransaction();
  }

  public void startTransaction(int transactionIsolation) throws SQLException {
    getLocalSqlMapSession().startTransaction(transactionIsolation);
  }

  public void commitTransaction() throws SQLException {
    getLocalSqlMapSession().commitTransaction();
  }

  public void endTransaction() throws SQLException {
    try {
      getLocalSqlMapSession().endTransaction();
    } finally {
      getLocalSqlMapSession().close();
    }
  }

  public void startBatch() throws SQLException {
    getLocalSqlMapSession().startBatch();
  }

  public int executeBatch() throws SQLException {
    return getLocalSqlMapSession().executeBatch();
  }

  public List executeBatchDetailed() throws SQLException, BatchException {
    return getLocalSqlMapSession().executeBatchDetailed();
  }
  
  public void setUserConnection(Connection connection) throws SQLException {
  try {
    getLocalSqlMapSession().setUserConnection(connection);
  } finally {
    if (connection == null) {
      getLocalSqlMapSession().close();
    }
  }
}

  /**
   * TODO Deprecated
   *
   * @return Current connection
   * @throws SQLException
   * @deprecated
   */
  public Connection getUserConnection() throws SQLException {
    return getCurrentConnection();
  }

  public Connection getCurrentConnection() throws SQLException {
    return getLocalSqlMapSession().getCurrentConnection();
  }

  public DataSource getDataSource() {
    return delegate.getDataSource();
  }

  public MappedStatement getMappedStatement(String id) {
    return delegate.getMappedStatement(id);
  }

  public boolean isLazyLoadingEnabled() {
    return delegate.isLazyLoadingEnabled();
  }

  public boolean isEnhancementEnabled() {
    return delegate.isEnhancementEnabled();
  }

  public SqlExecutor getSqlExecutor() {
    return delegate.getSqlExecutor();
  }

  public SqlMapExecutorDelegate getDelegate() {
    return delegate;
  }

  public SqlMapSession openSession() {
    SqlMapSessionImpl sqlMapSession = new SqlMapSessionImpl(this);
    sqlMapSession.open();
    return sqlMapSession;
  }

  public SqlMapSession openSession(Connection conn) {
    try {
      SqlMapSessionImpl sqlMapSession = new SqlMapSessionImpl(this);
      sqlMapSession.open();
      sqlMapSession.setUserConnection(conn);
      return sqlMapSession;
    } catch (SQLException e) {
      throw new SqlMapException("Error setting user provided connection.  Cause: " + e, e);
    }
  }

  /**
   * TODO : DEPRECATED
   *
   * @deprecated Use openSession()
   */
  public SqlMapSession getSession() {
    log.warn("Use of a deprecated API detected.  SqlMapClient.getSession() is deprecated.  Use SqlMapClient.openSession() instead.");
    return openSession();
  }

  public void flushDataCache() {
    delegate.flushDataCache();
  }

  public void flushDataCache(String cacheId) {
    delegate.flushDataCache(cacheId);
  }

  protected SqlMapSessionImpl getLocalSqlMapSession() {
    SqlMapSessionImpl sqlMapSession = (SqlMapSessionImpl) localSqlMapSession.get();
    if (sqlMapSession == null || sqlMapSession.isClosed()) {
      sqlMapSession = new SqlMapSessionImpl(this);
      localSqlMapSession.set(sqlMapSession);
    }
    return sqlMapSession;
  }

  public ResultObjectFactory getResultObjectFactory() {
    return delegate.getResultObjectFactory();
  }
}
