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
import com.ubiqube.etsi.mano.dao.mano.nsd.VnffgDescriptor;
import com.ubiqube.etsi.mano.dao.mano.vim.ResourceTypeEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Entity
@Getter
@Setter
@EntityListeners(AuditListener.class)
public class NsSfcTask extends NsTask {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private VnffgDescriptor vnffg;

	public NsSfcTask() {
		super(ResourceTypeEnum.VNFFG);
	}

	@Override
	public ScaleInfo getScaleInfo() {
		return null;
	}

	@Override
	public NsTask copy() {
		final NsSfcTask task = new NsSfcTask();
		super.copy(task);
		task.setVnffg(vnffg);
		task.setType(getType());
		return task;
	}
}
