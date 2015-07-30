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
package com.ibatis.sqlmap.client;

import com.ibatis.sqlmap.engine.builder.xml.SqlMapConfigParser;

import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * Builds SqlMapClient instances from a supplied resource (e.g. XML configuration file)
 * <p/>
 * The SqlMapClientBuilder class is responsible for parsing configuration documents
 * and building the SqlMapClient instance.  Its current implementation works with
 * XML configuration files (e.g. sql-map-config.xml).
 * <p/>
 * Example:
 * <pre>
 * Reader reader = Resources.getResourceAsReader("properties/sql-map-config.xml");
 * SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient (reader);
 * </pre>
 * <p/>
 * Examples of the XML document structure used by SqlMapClientBuilder can
 * be found at the links below.
 * <p/>
 * Note: They might look big, but they're mostly comments!
 * <ul>
 * <li> <a href="sql-map-config.txt">The SQL Map Config File</a>
 * <li> <a href="sql-map.txt">An SQL Map File</a>
 * <ul>
 */
public class SqlMapClientBuilder {

  /**
   * No instantiation allowed.
   */
  protected SqlMapClientBuilder() {
  }

  /**
   * Builds an SqlMapClient using the specified reader.
   *
   * @param reader A Reader instance that reads an sql-map-config.xml file.
   *               The reader should read an well formed sql-map-config.xml file.
   * @return An SqlMapClient instance.
   */
  public static SqlMapClient buildSqlMapClient(Reader reader) {
//    return new XmlSqlMapClientBuilder().buildSqlMap(reader);
    return new SqlMapConfigParser().parse(reader);
  }

  /**
   * Builds an SqlMapClient using the specified reader and properties file.
   * <p/>
   *
   * @param reader A Reader instance that reads an sql-map-config.xml file.
   *               The reader should read an well formed sql-map-config.xml file.
   * @param props  Properties to be used to provide values to dynamic property tokens
   *               in the sql-map-config.xml configuration file.  This provides an easy way to
   *               achieve some level of programmatic configuration.
   * @return An SqlMapClient instance.
   */
  public static SqlMapClient buildSqlMapClient(Reader reader, Properties props) {
//    return new XmlSqlMapClientBuilder().buildSqlMap(reader, props);
    return new SqlMapConfigParser().parse(reader, props);
  }

  /**
   * Builds an SqlMapClient using the specified input stream.
   *
   * @param inputStream An InputStream instance that reads an sql-map-config.xml file.
   *               The stream should read a well formed sql-map-config.xml file.
   * @return An SqlMapClient instance.
   */
  public static SqlMapClient buildSqlMapClient(InputStream inputStream) {
    return new SqlMapConfigParser().parse(inputStream);
  }

  /**
   * Builds an SqlMapClient using the specified input stream and properties file.
   * <p/>
   *
   * @param inputStream An InputStream instance that reads an sql-map-config.xml file.
   *               The stream should read an well formed sql-map-config.xml file.
   * @param props  Properties to be used to provide values to dynamic property tokens
   *               in the sql-map-config.xml configuration file.  This provides an easy way to
   *               achieve some level of programmatic configuration.
   * @return An SqlMapClient instance.
   */
  public static SqlMapClient buildSqlMapClient(InputStream inputStream, Properties props) {
    return new SqlMapConfigParser().parse(inputStream, props);
  }
}
