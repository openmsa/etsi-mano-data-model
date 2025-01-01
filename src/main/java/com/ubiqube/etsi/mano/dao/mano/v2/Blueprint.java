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
import java.util.Map;
import java.util.Set;

import com.ubiqube.etsi.mano.dao.base.BaseEntity;
import com.ubiqube.etsi.mano.dao.mano.BlueZoneGroupInformation;
import com.ubiqube.etsi.mano.dao.mano.ExtManagedVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.Instance;
import com.ubiqube.etsi.mano.dao.mano.ZoneInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.cnf.ConnectionInformation;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;
import com.ubiqube.etsi.mano.dao.rfc7807.FailureDetails;

import jakarta.persistence.ManyToOne;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 * @param <U>
 */
public interface Blueprint<U extends Task, V extends Instance> extends BaseEntity {

	@ManyToOne
	Set<U> getTasks();

	void addTask(final U task);

	PlanOperationType getOperation();

	void setError(FailureDetails failureDetails);

	BlueprintParameters getParameters();

	void setOperationStatus(OperationStatusType failed);

	OperationStatusType getOperationStatus();

	void setStateEnteredTime(OffsetDateTime date);

	// Below VimBluePrint
	void setVimConnections(Set<VimConnectionInformation> vimConnections);

	//
	void setCismConnections(Set<VimConnectionInformation> vimConnections);

	void setZoneGroups(Set<BlueZoneGroupInformation> mapAsSet);

	void setZones(Set<ZoneInfoEntity> zones);

	void setGrantsRequestId(String string);

	void addExtManagedVirtualLinks(Set<ExtManagedVirtualLinkDataEntity> extManagedVirtualLinks);

	Set<VimConnectionInformation> getVimConnections();

	Set<VimConnectionInformation> getCismConnections();

	V getInstance();

	void addVimConnection(VimConnectionInformation vimConnection);

	void addExtVirtualLinks(Set<ExtVirtualLinkDataEntity> extVirtualLinks);

	void addCirConnection(VimConnectionInformation vimConnection);

	Map<String, ConnectionInformation> getCirConnectionInfo();

	void setCirConnectionInfo(Map<String, ConnectionInformation> connections);

	Map<String, ConnectionInformation> getMciopConnectionInfo();

	void setMciopConnectionInfo(Map<String, ConnectionInformation> connections);
}
