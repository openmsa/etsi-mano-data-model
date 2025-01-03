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

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.TenantId;

import com.ubiqube.etsi.mano.dao.audit.Audit;
import com.ubiqube.etsi.mano.dao.audit.Auditable;
import com.ubiqube.etsi.mano.dao.mano.CancelModeTypeEnum;
import com.ubiqube.etsi.mano.dao.mano.Instance;
import com.ubiqube.etsi.mano.dao.mano.cnf.ConnectionInformation;
import com.ubiqube.etsi.mano.dao.rfc7807.FailureDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Enum problem @see
 * <a href="https://hibernate.atlassian.net/browse/HHH-15970">see</a>
 *
 * @author olivier
 *
 * @param <U>
 * @param <V>
 */
@MappedSuperclass
@Setter
@Getter
public abstract class AbstractBlueprint<U extends Task, V extends Instance> implements Blueprint<U, V>, Auditable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	private OffsetDateTime startTime;

	@Embedded
	private FailureDetails error;

	@Embedded
	private Audit audit;

	@Enumerated(EnumType.STRING)
	private PlanOperationType operation;

	private OffsetDateTime stateEnteredTime;

	@Enumerated(EnumType.STRING)
	private OperationStatusType operationStatus;

	private boolean automaticInvocation;

	private boolean cancelPending;

	public abstract void setTasks(final Set<U> tasks);

	@Enumerated(EnumType.STRING)
	private CancelModeTypeEnum cancelMode;

	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Map<String, ConnectionInformation> cirConnectionInfo = new LinkedHashMap<>();

	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private Map<String, ConnectionInformation> mciopConnectionInfo = new LinkedHashMap<>();

	@ElementCollection
	private Map<String, String> additionalParams;

	@TenantId
	private String tenantId;
}
