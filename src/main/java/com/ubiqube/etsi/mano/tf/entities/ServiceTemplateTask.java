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
package com.ubiqube.etsi.mano.tf.entities;

import java.util.UUID;

import com.ubiqube.etsi.mano.dao.mano.v2.nfvo.NsTask;
import com.ubiqube.etsi.mano.dao.mano.vim.ResourceTypeEnum;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Getter
@Setter
@Entity
public class ServiceTemplateTask extends NsTask {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	private UUID instanceId;

	public ServiceTemplateTask() {
		super(ResourceTypeEnum.TF_SERVICE_TEMPLATE);
	}

	@Override
	public NsTask copy() {
		final ServiceTemplateTask task = new ServiceTemplateTask();
		super.copy(task);
		task.setInstanceId(instanceId);
		return task;
	}

}
