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
package com.ubiqube.etsi.mano.dao.mano.dto;

import java.util.UUID;

public class NsInstantiatedVnffg extends NsInstantiatedBase {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	private UUID id = null;

	private String vnffgInstanceId = null;

	private String vnffgdId = null;

	@Override
	public UUID getId() {
		return id;
	}

	@Override
	public void setId(final UUID id) {
		this.id = id;
	}

	public String getVnffgInstanceId() {
		return vnffgInstanceId;
	}

	public void setVnffgInstanceId(final String vnffgInstanceId) {
		this.vnffgInstanceId = vnffgInstanceId;
	}

	public String getVnffgdId() {
		return vnffgdId;
	}

	public void setVnffgdId(final String vnffgdId) {
		this.vnffgdId = vnffgdId;
	}

}
