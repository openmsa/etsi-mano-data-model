/**
 * Copyright (C) 2019-2025 Ubiqube.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.dao.mano;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum AffinityScopeType {
	NFVI_MODE("nfvi_node"),
	ZONE("zone"),
	ZONE_GROUP("zone, zone_group"),
	NFVI_POP("nfvi_pop"),
	NETWORK_LINK_AND_NODE("network_link_and_node");

	private final String value;

	AffinityScopeType(final String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static AffinityScopeType fromValue(final String v) {
		for (final AffinityScopeType b : AffinityScopeType.values()) {
			if (String.valueOf(b.value).equals(v)) {
				return b;
			}
		}
		return null;
	}

}
