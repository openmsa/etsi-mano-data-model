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
package com.ubiqube.etsi.mano.dao.mano.v2.vnfm;

import com.ubiqube.etsi.mano.dao.audit.AuditListener;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfTask;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Entity
@EntityListeners(AuditListener.class)
@Getter
@Setter
public class MciopUserTask extends VnfTask {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	private String parentVdu;

	@Override
	public VnfTask copy() {
		final MciopUserTask t = new MciopUserTask();
		super.copy(t);
		t.setParentVdu(parentVdu);
		return t;
	}

}
