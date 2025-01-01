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
package com.ubiqube.etsi.mano.dao.mano.cnf;

import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.audit.Audit;
import com.ubiqube.etsi.mano.dao.audit.AuditListener;
import com.ubiqube.etsi.mano.dao.audit.Auditable;
import com.ubiqube.etsi.mano.dao.mano.common.GeoPoint;
import com.ubiqube.etsi.mano.dao.mano.config.Servers;
import com.ubiqube.etsi.mano.dao.mano.vim.PlanStatusType;
import com.ubiqube.etsi.mano.dao.rfc7807.FailureDetails;
import com.ubiqube.etsi.mano.service.auth.model.AuthentificationInformations;
import com.ubiqube.etsi.mano.utils.ToStringUtil;

import jakarta.annotation.Nonnull;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@EntityListeners(AuditListener.class)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionInformation implements Auditable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String name;

	@Enumerated(EnumType.STRING)
	private ConnectionType connType;

	private AuthentificationInformations authentification;

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, String> extra;

	private URI url;

	private boolean ignoreSsl;

	@Enumerated(EnumType.STRING)
	private PlanStatusType serverStatus = PlanStatusType.STARTED;

	private FailureDetails failureDetails;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> capabilities;

	private GeoPoint geoloc;

	@Version
	private long version;

	private Audit audit;

	@Override
	public String toString() {
		return ToStringUtil.toString(this);
	}

	@Nonnull
	public Servers toServers() {
		final Servers srv = new Servers();
		srv.setAuthentification(getAuthentification());
		srv.setCapabilities(getCapabilities());
		srv.setId(getId());
		srv.setIgnoreSsl(isIgnoreSsl());
		srv.setName(getName());
		srv.setServerStatus(getServerStatus());
		srv.setTupleVersion(getVersion());
		srv.setUrl(getUrl());
		return srv;
	}
}
