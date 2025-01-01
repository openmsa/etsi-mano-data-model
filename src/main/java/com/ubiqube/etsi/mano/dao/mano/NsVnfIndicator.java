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

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.audit.Audit;
import com.ubiqube.etsi.mano.dao.audit.Auditable;
import com.ubiqube.etsi.mano.dao.base.ToscaEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class NsVnfIndicator implements ToscaEntity, Auditable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Map<String, TriggerDefinition> triggers;

	private String source;

	private String name;

	private String toscaName;

	private String state;

	private String toscaId;

	@Embedded
	private Audit audit;

	@ElementCollection(targetClass = String.class)
	private List<String> targets;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<MonitoringParams> monitoringParameters;

}
