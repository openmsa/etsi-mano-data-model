/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.dao.mano;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.base.BaseEntity;
import com.ubiqube.etsi.mano.dao.rfc7807.FailureDetails;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class PnfDescriptor implements BaseEntity, Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String pnfdId;

	private String pnfdName;

	private String pnfdersion;

	private String pnfdProvider;

	private String pnfdInvariantId;
	@Enumerated(EnumType.STRING)
	private OnboardingStateType pnfdOnboardingState;
	@Embedded
	private FailureDetails onboardingFailureDetails;
	@Enumerated(EnumType.STRING)
	private UsageStateEnum pnfdUsageState;
	private String userDefinedData;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> virtualLink;

	public void addVirtualLink(final String name) {
		if (null == virtualLink) {
			virtualLink = new HashSet<>();
		}
		virtualLink.add(name);
	}

}
