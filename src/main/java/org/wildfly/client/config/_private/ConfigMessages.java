/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wildfly.client.config._private;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ServiceConfigurationError;

import javax.xml.namespace.QName;
import javax.xml.stream.Location;

import org.jboss.logging.Messages;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageBundle;
import org.jboss.logging.annotations.Param;
import org.wildfly.client.config.ConfigXMLParseException;
import org.wildfly.client.config.XMLLocation;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
@MessageBundle(projectCode = "CONF", length = 4)
public interface ConfigMessages {

    ConfigMessages msg = Messages.getBundle(ConfigMessages.class);

    @Message(id = 1, value = "An unspecified XML parse error occurred")
    String parseError();

    @Message(id = 2, value = "Calling close() on XMLConfigurationReader is not supported")
    UnsupportedOperationException closeNotSupported();

    @Message(id = 3, value = "Unexpected end of document")
    ConfigXMLParseException unexpectedDocumentEnd(@Param(Location.class) XMLLocation location);

    @Message(id = 4, value = "Unexpected content of type \"%s\"")
    ConfigXMLParseException unexpectedContent(String eventType, @Param(Location.class) XMLLocation location);

    @Message(id = 5, value = "Unexpected element \"%s\" in namespace \"%s\" encountered")
    ConfigXMLParseException unexpectedElement(String localName, String namespaceUri, @Param(Location.class) XMLLocation location);

    @Message(id = 5, value = "Unexpected element \"%s\" (no namespace) encountered")
    ConfigXMLParseException unexpectedElement(String localName, @Param(Location.class) XMLLocation location);

    @Message(id = 6, value = "Expected start or end element, found \"%s\"")
    ConfigXMLParseException expectedStartOrEndElement(String eventTypeName, @Param(Location.class) XMLLocation location);

    @Message(id = 7, value = "Expected start element, found \"%s\"")
    ConfigXMLParseException expectedStartElement(String eventTypeName, @Param(Location.class) XMLLocation location);

    @Message(id = 8, value = "Text content cannot contain elements")
    ConfigXMLParseException textCannotContainElements(@Param(Location.class) XMLLocation location);

    @Message(id = 9, value = "Expected event type \"%s\", found \"%s\"")
    ConfigXMLParseException expectedEventType(String expectedEventTypeName, String eventTypeName, @Param(Location.class) XMLLocation location);

    @Message(id = 10, value = "Expected namespace URI \"%s\", found \"%s\"")
    ConfigXMLParseException expectedNamespace(String expectedNamespaceURI, String actualNamespaceURI, @Param(Location.class) XMLLocation location);

    @Message(id = 11, value = "Expected local name \"%s\", found \"%s\"")
    ConfigXMLParseException expectedLocalName(String expectedLocalName, String actualLocalName, @Param(Location.class) XMLLocation location);

    @Message(id = 12, value = "Failed to read from input source")
    ConfigXMLParseException failedToReadInput(@Param(Location.class) XMLLocation location, @Cause IOException cause);

    @Message(id = 13, value = "Failed to close input source")
    ConfigXMLParseException failedToCloseInput(@Param(Location.class) XMLLocation location, @Cause IOException cause);

    @Message(id = 14, value = "Invalid configuration file URL")
    ConfigXMLParseException invalidUrl(@Param(Location.class) XMLLocation location, @Cause MalformedURLException e);

    @Message(id = 15, value = "Unexpected attribute \"%s\" encountered")
    ConfigXMLParseException unexpectedAttribute(QName name, @Param(Location.class) XMLLocation location);

    @Message(id = 16, value = "Missing required element \"%2$s\" from namespace \"%s\"")
    ConfigXMLParseException missingRequiredElement(String namespaceUri, String localName, @Param(Location.class) XMLLocation location);

    @Message(id = 17, value = "Missing required attribute \"%2$s\" from namespace \"%s\"")
    ConfigXMLParseException missingRequiredAttribute(String namespaceUri, String localName, @Param(Location.class) XMLLocation location);

    @Message(id = 18, value = "Failed to parse integer value of attribute \"%s\"")
    ConfigXMLParseException intParseException(@Cause NumberFormatException e, QName attributeName, @Param(Location.class) XMLLocation location);

    @Message(id = 19, value = "Failed to parse URI value of attribute \"%s\"")
    ConfigXMLParseException uriParseException(@Cause URISyntaxException e, QName attributeName, @Param(Location.class) XMLLocation location);

    @Message(id = 20, value = "Failed to parse expression value of attribute \"%s\"")
    ConfigXMLParseException expressionParseException(@Cause IllegalArgumentException ex, QName attributeName, @Param(Location.class) XMLLocation location);

    @Message(id = 21, value = "Failed to parse expression text")
    ConfigXMLParseException expressionTextParseException(@Cause IllegalArgumentException ex, @Param(Location.class) XMLLocation location);

    @Message(id = 22, value = "Numeric value of attribute \"%s\" is out of range; actual value is \"%s\" but the value must not be less than %d or more than %d")
    ConfigXMLParseException numericAttributeValueOutOfRange(QName attributeName, String actualValue, long minValue, long maxValue, @Param(Location.class) XMLLocation location);

    @Message(id = 23, value = "Failed to parse IP address value of attribute \"%s\": \"%s\" is not a valid IP address")
    ConfigXMLParseException inetAddressParseException(QName attributeName, String address, @Param(Location.class) XMLLocation location);

    @Message(id = 24, value = "Failed to parse CIDR address value of attribute \"%s\": \"%s\" is not a valid CIDR address")
    ConfigXMLParseException cidrAddressParseException(QName attributeName, String address, @Param(Location.class) XMLLocation location);

    @Message(id = 25, value = "Failed to load a resolver for the encrypted expression.")
    ConfigXMLParseException failedToLoadResolver();

    @Message(id = 26, value = "Failed to load the \"%s\" class using a service loader.")
    ServiceConfigurationError failedToLoadUsingServiceLoader(String className);
}
