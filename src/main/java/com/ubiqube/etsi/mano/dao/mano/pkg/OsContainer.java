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
package com.ubiqube.etsi.mano.dao.mano.pkg;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.base.ToscaEntity;
import com.ubiqube.etsi.mano.dao.mano.vim.ImageServiceAware;
import com.ubiqube.etsi.mano.dao.mano.vim.SoftwareImage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class OsContainer implements ImageServiceAware, ToscaEntity, Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String toscaName;

	private String toscaId;

	private String state;

	private String description;

	private int requestedCpuResources;

	private int cpuResourceLimit;

	private long requestedMemoryResources;

	private long memoryResourceLimit;

	private long requestedEphemeralStorageResources;

	private long ephemeralStorageResourceLimit;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ExtendedResourceData> extendedResourceRequests;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Hugepages> hugePagesResources;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Map<String, SoftwareImage> artifacts;

	@Override
	public SoftwareImage getSoftwareImage() {
		if (null == artifacts) {
			return null;
		}
		final Iterator<Entry<String, SoftwareImage>> ite = artifacts.entrySet().iterator();
		if (!ite.hasNext()) {
			return null;
		}
		return ite.next().getValue();
	}
}
