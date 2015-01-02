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
package org.xwiki.extension;

import java.util.Collection;
import java.util.Map;

import org.xwiki.extension.repository.ExtensionRepository;

/**
 * Represent an extension.
 *
 * @version $Id$
 * @since 4.0M1
 */
public interface Extension
{
    /**
     * @return the id/version combination which makes the extension unique
     */
    ExtensionId getId();

    /**
     * Indicate in an extension a list of provided "functionalities". Then when resolving extensions dependencies they
     * can be matched in this list.
     *
     * @return the extension ids also provided by this extension, an empty collection if there is none
     * @deprecated since 7.0M1, use {@link #getExtensionFEatures()} instead
     */
    @Deprecated
    Collection<String> getFeatures();

    /**
     * Indicate in an extension a list of provided "functionalities". Then when resolving extensions dependencies they
     * can be matched in this list.
     * 
     * @return the {@link ExtensionFeature}s also provided by this extension, an empty collection if there is none
     * @since 7.0M1
     */
    Collection<ExtensionFeature> getExtensionFeatures();

    /**
     * @return the type of the extension
     */
    String getType();

    /**
     * @return the display name of the extension
     */
    String getName();

    /**
     * @return the license of the extension, an empty collection if there is none
     */
    Collection<ExtensionLicense> getLicenses();

    /**
     * @return a short description of the extension
     */
    String getSummary();

    /**
     * @return a description of the extension
     */
    String getDescription();

    /**
     * @return an URL for the extension website
     */
    String getWebSite();

    /**
     * @return the extension authors, an empty collection if there is none
     */
    Collection<ExtensionAuthor> getAuthors();

    /**
     * @return the dependencies of the extension, an empty collection if there is none
     */
    Collection<? extends ExtensionDependency> getDependencies();

    /**
     * Return extension file descriptor. Also allows to get the content of the file.
     *
     * @return the file of the extension
     */
    ExtensionFile getFile();

    /**
     * @return the repository of the extension
     */
    ExtensionRepository getRepository();

    /**
     * @return informations related to extensions's source control management
     * @since 6.3M1
     */
    ExtensionScm getScm();

    /**
     * @return informations related to extension's issues management
     * @since 6.3M1
     */
    ExtensionIssueManagement getIssueManagement();

    // Custom properties

    /**
     * Extends {@link Extension} standard properties.
     * <p>
     * Theses are generally provided by specific repositories. For example a maven repository will provide group and
     * artifacts ids.
     *
     * @return the properties
     */
    Map<String, Object> getProperties();

    /**
     * @param key the property key
     * @return the property value
     */
    Object getProperty(String key);

    /**
     * Get a property.
     *
     * @param <T> type of the property value
     * @param key the property key
     * @param def the value to return if no property is associated to the provided key
     * @return the property value or <code>default</code> of the property is not found
     * @see #getProperty(String)
     */
    <T> T getProperty(String key, T def);
}
