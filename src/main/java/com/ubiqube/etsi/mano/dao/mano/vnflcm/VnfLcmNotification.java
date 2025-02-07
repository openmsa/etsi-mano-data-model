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
package com.ubiqube.etsi.mano.dao.mano.vnflcm;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.mano.ExtVirtualLinkInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.LcmAffectedVnfc;
import com.ubiqube.etsi.mano.dao.mano.v2.OperationStatusType;
import com.ubiqube.etsi.mano.dao.mano.v2.PlanOperationType;
import com.ubiqube.etsi.mano.dao.rfc7807.FailureDetails;

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
 * @author olivier
 *
 */
@Setter
@Getter
@Entity
public class VnfLcmNotification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private UUID nfvoId;

	private String notificationType;

	private String subscriptionId;

	private OffsetDateTime timeStamp;

	private String vnfInstanceId;

	private OperationStatusType operationState;

	private PlanOperationType operation;

	private Boolean isAutomaticInvocation;

	private String vnfLcmOpOccId;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<LcmAffectedVnfc> affectedVnfcs;

	// private List<AffectedVirtualLink> affectedVirtualLinks

	// private List<AffectedVirtualStorage> affectedVirtualStorages

	// private VnfInfoModifications changedInfo
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ExtVirtualLinkInfoEntity> changedExtConnectivity;

	private FailureDetails error;
}
