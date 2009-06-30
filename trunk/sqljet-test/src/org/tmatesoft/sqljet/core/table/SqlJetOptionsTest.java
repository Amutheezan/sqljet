/**
 * SqlJetOptionsTest.java
 * Copyright (C) 2009 TMate Software Ltd
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * For information on how to redistribute this software under
 * the terms of a license other than GNU General Public License
 * contact TMate Software at support@svnkit.com
 */
package org.tmatesoft.sqljet.core.table;

import java.io.File;

import junit.framework.TestCase;

import org.tmatesoft.sqljet.core.SqlJetEncoding;
import org.tmatesoft.sqljet.core.SqlJetException;

/**
 * @author TMate Software Ltd.
 * @author Dmitry Stadnik (dtrace@seznam.cz)
 * 
 */
public class SqlJetOptionsTest extends TestCase {

    private File fileDb = new File(SqlJetTableTest.DB);
    private SqlJetDb db;

    public SqlJetOptionsTest() {
        super("Options Test");
    }

    @Override
    protected void setUp() throws Exception {
        db = SqlJetDb.open(fileDb, true);
    }

    @Override
    protected void tearDown() throws Exception {
        if (db != null) {
            db.close();
        }
    }

    public void testDefaultAutovacuum() throws SqlJetException {
        ISqlJetOptions options = db.getOptions();
        assertFalse(options.isAutovacuum());
        assertFalse(options.isIncrementalVacuum());
    }

    public void testDefaultCacheSize() throws SqlJetException {
        ISqlJetOptions options = db.getOptions();
        assertEquals(2000, options.getCacheSize());
    }

    public void testDefaultEncoding() throws SqlJetException {
        ISqlJetOptions options = db.getOptions();
        assertEquals(SqlJetEncoding.UTF8, options.getEncoding());
    }

    public void testDefaultSchemaVersion() throws SqlJetException {
        ISqlJetOptions options = db.getOptions();
        assertEquals(6, options.getSchemaVersion());
    }

    public void testDefaultUserVersion() throws SqlJetException {
        ISqlJetOptions options = db.getOptions();
        assertEquals(0, options.getUserVersion());
    }
}