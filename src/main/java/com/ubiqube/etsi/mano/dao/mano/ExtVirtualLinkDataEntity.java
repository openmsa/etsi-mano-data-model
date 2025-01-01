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

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import lombok.Data;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Data
@Entity
public class ExtVirtualLinkDataEntity implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// extVirtualLinkId on Sol005 ?
	private UUID id;

	// VimId on SOL005
	private String vimConnectionId;

	private String resourceProviderId;

	private String resourceId;

	// 2.7.1
	private String vimLevelResourceType;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<VnfExtCpDataEntity> extCps = new LinkedHashSet<>();

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ExtLinkPortDataEntity> extLinkPorts;

	@JsonIgnore
	@ManyToOne
	private VnfInstance vnfInstance;

	// 3.3.1
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<VnfExtCpDataEntity> currentVnfExtCpData;

	/**
	 * @since 4.3.1
	 */
	@OneToOne
	private AdditionalResourceInfo vimLevelAdditionalResourceInfo;

	/**
	 * @since 4.3.1
	 */
	private String containerNamespace;

	@OneToMany
	private List<NetAttDefResourceInfo> extNetAttDefResource;
}
