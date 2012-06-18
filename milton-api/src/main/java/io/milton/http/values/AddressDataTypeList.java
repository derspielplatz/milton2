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

package io.milton.http.values;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Holds a list of Pair<String, String>, i.e. actually address data Type, where 
 * object1 represents ContentType and object2 represents the version.
 * 
 * @author nabil.shams
 */
public class AddressDataTypeList extends ArrayList<Pair<String, String>>{
    public static AddressDataTypeList asList(Pair<String, String>... items) {
        AddressDataTypeList list = new AddressDataTypeList();
		list.addAll(Arrays.asList(items));
        return list;
    }
}