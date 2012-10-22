/*  * Copyright (c) 2005 Brian Wellington (bwelling@xbill.org)  *   * Copied from the DnsJava project  *  * This program is free software: you can redistribute it and/or modify  * it under the terms of the GNU Affero General Public License as published by  * the Free Software Foundation, either version 3 of the License, or  * (at your option) any later version.  * This program is distributed in the hope that it will be useful,  * but WITHOUT ANY WARRANTY; without even the implied warranty of  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the  * GNU General Public License for more details.  * You should have received a copy of the GNU General Public License  * along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

package io.milton.dns.record;

import io.milton.dns.Name;

import java.util.*;

/**
 * Recource Record Signature - An RRSIG provides the digital signature of an
 * RRset, so that the data can be authenticated by a DNSSEC-capable resolver.
 * The signature is generated by a key contained in a DNSKEY Record.
 * @see RRset
 * @see DNSSEC
 * @see KEYRecord
 *
 * @author Brian Wellington
 */

public class RRSIGRecord extends SIGBase {

private static final long serialVersionUID = -2609150673537226317L;

RRSIGRecord() {}

Record
getObject() {
	return new RRSIGRecord();
}

/**
 * Creates an RRSIG Record from the given data
 * @param covered The RRset type covered by this signature
 * @param alg The cryptographic algorithm of the key that generated the
 * signature
 * @param origttl The original TTL of the RRset
 * @param expire The time at which the signature expires
 * @param timeSigned The time at which this signature was generated
 * @param footprint The footprint/key id of the signing key.
 * @param signer The owner of the signing key
 * @param signature Binary data representing the signature
 */
public
RRSIGRecord(Name name, int dclass, long ttl, int covered, int alg, long origttl,
	    Date expire, Date timeSigned, int footprint, Name signer,
	    byte [] signature)
{
	super(name, Type.RRSIG, dclass, ttl, covered, alg, origttl, expire,
	      timeSigned, footprint, signer, signature);
}

}