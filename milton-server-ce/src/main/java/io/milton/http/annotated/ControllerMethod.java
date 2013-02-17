/*
 * Copyright 2013 McEvoy Software Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.milton.http.annotated;

/**
 *
 * @author brad
 */
class ControllerMethod {

	final Object controller;
	final java.lang.reflect.Method method;
	final Class sourceType;

	public ControllerMethod(Object controller, java.lang.reflect.Method method, Class sourceType) {
		this.controller = controller;
		this.method = method;
		this.sourceType = sourceType;
	}

	@Override
	public String toString() {
		if (sourceType != null) {
			return controller.getClass() + "::" + method.getName() + " ( " + sourceType.getCanonicalName() + " )";
		} else {
			return controller.getClass() + "::" + method.getName();
		}
	}
}