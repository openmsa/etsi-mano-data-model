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
package com.ubiqube.etsi.mano.dao.mano.alarm;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EventType {

	COMMUNICATIONS_ALARM("COMMUNICATIONS_ALARM"),
	PROCESSING_ERROR_ALARM("PROCESSING_ERROR_ALARM"),
	ENVIRONMENTAL_ALARM("ENVIRONMENTAL_ALARM"),
	QOS_ALARM("QOS_ALARM"),
	EQUIPMENT_ALARM("EQUIPMENT_ALARM");

	private String value;

	EventType(final String string) {
		value = string;
	}

	@Override
	@JsonValue
	public String toString() {
		return value;
	}

}
