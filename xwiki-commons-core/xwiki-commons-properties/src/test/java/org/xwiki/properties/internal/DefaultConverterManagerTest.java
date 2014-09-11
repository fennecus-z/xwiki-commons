/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.properties.internal;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Test;
import org.xwiki.properties.ConverterManager;
import org.xwiki.properties.converter.ConversionException;
import org.xwiki.test.jmock.AbstractComponentTestCase;

/**
 * Validate {@link DefaultConverterManager}.
 *
 * @version $Id$
 */
public class DefaultConverterManagerTest extends AbstractComponentTestCase
{
    private ConverterManager defaultConverterManager;

    public enum TestEnum
    {
        ENUMVALUE
    }

    @Override
    protected void registerComponents() throws Exception
    {
        this.defaultConverterManager = getComponentManager().getInstance(ConverterManager.class);
    }

    @Test
    public void testConvert()
    {
        Assert.assertEquals(Integer.valueOf(42), this.defaultConverterManager.convert(Integer.class, "42"));
    }

    @Test
    public void testConvertEnum()
    {
        Assert.assertEquals(TestEnum.ENUMVALUE, this.defaultConverterManager.convert(TestEnum.class, "ENUMVALUE"));
    }

    @Test
    public void testConvertColor()
    {
        Assert.assertEquals(Color.WHITE, this.defaultConverterManager.convert(Color.class, "#ffffff"));
    }

    @Test(expected = ConversionException.class)
    public void testConvertUnsupportedType()
    {
        this.defaultConverterManager.convert(DefaultConverterManagerTest.class, "#ffffff");
    }
}
