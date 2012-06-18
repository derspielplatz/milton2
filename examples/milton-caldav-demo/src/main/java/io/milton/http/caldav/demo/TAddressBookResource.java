/*
 * Copyright 2012 McEvoy Software Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.milton.http.caldav.demo;

import io.milton.common.InternationalizedString;
import io.milton.http.exceptions.BadRequestException;
import io.milton.http.exceptions.ConflictException;
import io.milton.http.exceptions.NotAuthorizedException;
import io.milton.http.values.AddressDataTypeList;
import io.milton.http.values.Pair;
import io.milton.resource.AddressBookResource;
import io.milton.resource.ReportableResource;
import io.milton.resource.Resource;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author brad
 */
public class TAddressBookResource extends TFolderResource implements AddressBookResource, ReportableResource {

    private static final Logger log = LoggerFactory.getLogger(TCalendarResource.class);

    public TAddressBookResource(TFolderResource parent, String name) {
        super(parent, name);
    }

    @Override
    protected Object clone(TFolderResource newParent) {
        return new TCalendarResource(newParent, name);
    }

    @Override
    public Resource createNew(String newName, InputStream inputStream, Long length, String contentType) throws IOException {
        try {
            log.debug("createNew: " + contentType);
            //        if (contentType.startsWith("text/calendar")) {
            TContact e = new TContact(this, newName);
            e.replaceContent(inputStream, length);
            log.debug("created contact: " + e.name);
            return e;
            //        } else {
            //            throw new RuntimeException("eek");
            //            //log.debug( "creating a normal resource");
            //        }
            //        }
        } catch (BadRequestException ex) {
            throw new RuntimeException(ex);
        } catch (ConflictException ex) {
            throw new RuntimeException(ex);
        } catch (NotAuthorizedException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public InternationalizedString getDescription() {
        return new InternationalizedString("fr-CA", "Adresses de Oliver Daboo");
    }

    @Override
    public void setDescription(InternationalizedString description) {
    }

    @Override
    public Long getMaxResourceSize() {
        return 102400L;
    }

    @Override
    public AddressDataTypeList getSupportedAddressData() {
        AddressDataTypeList supportedAddresses = new AddressDataTypeList();
        supportedAddresses.add(new Pair<String, String>("text/vcard", "3.0"));
        return supportedAddresses;
    }
}