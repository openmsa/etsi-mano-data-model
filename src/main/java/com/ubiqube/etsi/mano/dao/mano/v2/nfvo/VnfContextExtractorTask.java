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

import com.ubiqube.etsi.mano.dao.mano.NsdPackage;
import com.ubiqube.etsi.mano.dao.mano.config.Servers;
import com.ubiqube.etsi.mano.dao.mano.vim.ResourceTypeEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class VnfContextExtractorTask extends NsTask {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	/**
	 * VNFM to use if any.
	 */
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private Servers server;

	@ManyToOne(fetch = FetchType.LAZY)
	private NsdPackage nsdPackage;

	private String vnfdId;

	private String vnfInstanceName;

	public VnfContextExtractorTask() {
		super(ResourceTypeEnum.VNF_EXTRACTOR);
	}

	@Override
	public NsTask copy() {
		final VnfContextExtractorTask task = new VnfContextExtractorTask();
		super.copy(task);
		task.setServer(server);
		task.setNsdPackage(nsdPackage);
		task.setVnfdId(vnfdId);
		task.setVnfInstanceName(vnfInstanceName);
		return task;
	}
}
