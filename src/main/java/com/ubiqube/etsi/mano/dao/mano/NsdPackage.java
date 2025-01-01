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

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.audit.Audit;
import com.ubiqube.etsi.mano.dao.audit.AuditListener;
import com.ubiqube.etsi.mano.dao.audit.Auditable;
import com.ubiqube.etsi.mano.dao.mano.nfvo.ArchiveSecurityOptionEnumType;
import com.ubiqube.etsi.mano.dao.mano.nfvo.NsArchiveArtifactInfo;
import com.ubiqube.etsi.mano.dao.mano.nsd.VnffgDescriptor;
import com.ubiqube.etsi.mano.dao.mano.v2.nfvo.NsVirtualLink;
import com.ubiqube.etsi.mano.dao.rfc7807.FailureDetails;
import com.ubiqube.etsi.mano.utils.ToStringUtil;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Getter
@Setter
@Entity
@EntityListeners(AuditListener.class)
public class NsdPackage implements PackageBase, Auditable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Embedded
	private Audit audit;

	// OVI removed just for plugtest => @Version
	private long version;

	private String nsdId;

	/**
	 * Used for overriding the nsdId.
	 */
	private String overwriteDescId;

	private String nsdName;

	private String nsdVersion;

	private String nsdDesigner;

	private String nsdInvariantId;

	private String nsdExtInvariantId;

	private String instantiationLevel;

	private int minNumberOfInstance;

	private int maxNumberOfInstance;

	private String flavorId;

	private Integer serviceAvailabilityLevel;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "nsdPackage")
	private Set<NsdPackageVnfPackage> vnfPkgIds;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn
	private Set<PnfDescriptor> pnfdInfoIds;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parent")
	private Set<NsdPackageNsdPackage> nestedNsdInfoIds;

	@Enumerated(EnumType.STRING)

	private OnboardingStateType nsdOnboardingState;

	@Embedded
	private FailureDetails onboardingFailureDetails;

	@Enumerated(EnumType.STRING)

	private PackageOperationalState nsdOperationalState;

	@Enumerated(EnumType.STRING)

	private UsageStateEnum nsdUsageState;

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, String> userDefinedData;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn
	private Set<NsSap> nsSaps;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn
	private Set<NsVirtualLink> nsVirtualLinks;

	@OneToMany(cascade = CascadeType.DETACH)
	@JoinColumn
	private Set<NsdInstance> nsInstance;

	// 2.7.1
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<NsArchiveArtifactInfo> artifacts;
	// 2.7.1
	private String signingCertificate;
	// 2.7.1
	@Enumerated(EnumType.STRING)
	private ArchiveSecurityOptionEnumType archiveSecurityOption;
	// Probably 3.5.1
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<VnffgDescriptor> vnffgs;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<NsVnfIndicator> nsVnfIndicator;

	private boolean autoHealEnabled;

	@Override
	public PackageOperationalState getOperationalState() {
		return this.nsdOperationalState;
	}

	@Override
	public OnboardingStateType getOnboardingState() {
		return this.nsdOnboardingState;
	}

	@Override
	public UsageStateEnum getUsageState() {
		return this.nsdUsageState;
	}

	@Override
	public String toString() {
		return ToStringUtil.toString(this);
	}
}
