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
package com.ubiqube.etsi.mano.dao.mano.v2.nfvo;

import com.ubiqube.etsi.mano.dao.audit.AuditListener;
import com.ubiqube.etsi.mano.dao.mano.ScaleInfo;
import com.ubiqube.etsi.mano.dao.mano.v2.AbstractTask;
import com.ubiqube.etsi.mano.dao.mano.vim.ResourceTypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

/**
 * This entity is the root of all NS*Tasks.
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Getter
@Setter
@Entity
@EntityListeners(AuditListener.class)
public abstract class NsTask extends AbstractTask {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private ResourceTypeEnum type;

	private String vimReservationId;

	private String zoneId;

	private String resourceGroupId;

	protected NsTask(final ResourceTypeEnum type) {
		this.type = type;
	}

	@Override
	public ScaleInfo getScaleInfo() {
		return null;
	}

	public abstract NsTask copy();

	public NsTask copy(final NsTask task) {
		super.copy(task);
		task.setType(type);
		task.setVimReservationId(vimReservationId);
		task.setZoneId(zoneId);
		task.setResourceGroupId(resourceGroupId);
		return task;
	}

}
