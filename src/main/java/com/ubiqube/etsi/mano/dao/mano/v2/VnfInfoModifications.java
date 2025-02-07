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
package com.ubiqube.etsi.mano.dao.mano.v2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.mano.dto.VnfcInfoModificationsEntity;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import lombok.Data;

@Data
@Entity
public class VnfInfoModifications implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String vnfInstanceName;

	private String vnfInstanceDescription;

	@ElementCollection
	private Map<String, String> vnfConfigurableProperties;

	@ElementCollection
	private Map<String, String> metadata;

	@ElementCollection
	private Map<String, String> extensions;

	@ElementCollection
	@Valid
	private Map<String, VimConnectionInformation> vimConnectionInfo;

	private String vnfdId;

	private String vnfProvider;

	private String vnfProductName;

	private String vnfSoftwareVersion;

	private String vnfdVersion;

	@OneToMany
	private List<VnfcInfoModificationsEntity> vnfcInfoModifications;

	@ElementCollection
	private List<String> vnfcInfoModificationsDeleteIds = new ArrayList<>();
}
