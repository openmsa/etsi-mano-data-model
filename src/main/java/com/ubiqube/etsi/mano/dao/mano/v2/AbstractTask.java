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

import java.time.LocalDateTime;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.audit.Audit;
import com.ubiqube.etsi.mano.dao.mano.ChangeType;
import com.ubiqube.etsi.mano.dao.mano.VimTask;
import com.ubiqube.etsi.mano.dao.mano.vim.PlanStatusType;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractTask implements VimTask {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Embedded
	private Audit audit;

	@Enumerated(EnumType.STRING)
	private ChangeType changeType;

	private String toscaName;

	private String toscaId = UUID.randomUUID().toString();

	private String state;
	private String alias;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	@Enumerated(EnumType.STRING)
	private PlanStatusType status;
	@Column(length = 5000)
	/**
	 * It should be a BLOB due to the size, but it pose a lot of problem with
	 * postgresql.
	 */
	private String vimResourceId;

	private String vimConnectionId;

	private String resourceProviderId;

	private UUID removedLiveInstance;

	private int rank;

	@Version
	private Long version;

	public AbstractTask copy(final AbstractTask task) {
		task.setAlias(alias);
		task.setAudit(audit);
		task.setChangeType(changeType);
		task.setEndDate(endDate);
		task.setRemovedLiveInstance(removedLiveInstance);
		task.setResourceProviderId(resourceProviderId);
		task.setStartDate(startDate);
		task.setState(state);
		task.setStatus(status);
		task.setToscaId(toscaId);
		task.setToscaName(toscaName);
		task.setVimConnectionId(vimConnectionId);
		task.setVimResourceId(vimResourceId);
		task.setRank(rank);
		return task;
	}
}
