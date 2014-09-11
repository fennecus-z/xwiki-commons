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
package org.xwiki.filter.output;

import java.io.Closeable;

import org.xwiki.stability.Unstable;

/**
 * Represent a target were to store data generated by a filter output stream. What kind of {@link OutputTarget} is
 * supported by each input stream is entirely output stream choice.
 * <p>
 * {@link #clone()} is only closing {@link Closeable} created by the {@link OutputTarget} itself. For example
 * {@link DefaultOutputStreamOutputTarget} is not going to close the {@link java.io.OutputStream} passed to its
 * constructor because it did not created it.
 *
 * @version $Id$
 * @since 6.2M1
 */
@Unstable
public interface OutputTarget extends Closeable
{
    /**
     * @return true if it's possible to close and reset the target to its beginning
     * @since 6.2M1
     */
    boolean restartSupported();
}
