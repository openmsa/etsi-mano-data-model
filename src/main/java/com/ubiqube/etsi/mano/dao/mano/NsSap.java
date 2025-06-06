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

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.audit.Audit;
import com.ubiqube.etsi.mano.dao.audit.AuditListener;
import com.ubiqube.etsi.mano.dao.audit.Auditable;
import com.ubiqube.etsi.mano.dao.base.ToscaEntity;
import com.ubiqube.etsi.mano.dao.mano.vim.SecurityGroup;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * A part of NSD. Missing
 * com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.Cp#role
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Entity
@EntityListeners(AuditListener.class)
@Getter
@Setter
public class NsSap implements ToscaEntity, Auditable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String toscaName;

	private String role;

	private String description;

	/**
	 * Used in com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.Sap
	 */
	private String externalVirtualLink;
	/**
	 * Used in com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.Sap
	 */
	private String internalVirtualLink;

	/**
	 * Used in com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.Cp
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> layerProtocols;

	/**
	 * Used in com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.Cp As
	 * CpProtocolData.
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private Set<NsCpProtocolData> protocol;

	/**
	 * Used in com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.Cp
	 */
	private boolean trunkMode;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<SecurityGroup> securityGroups;

	@ManyToOne
	private NsdPackage nsdPackage;

	private String toscaId;

	private String state;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> virtualLink;
	@Embedded
	private Audit audit;

	public void addSecurityGroups(final SecurityGroup securityGroup) {
		if (null == securityGroups) {
			securityGroups = new HashSet<>();
		}
		securityGroups.add(securityGroup);
	}

	public void addVirtualLink(final String name) {
		if (null == virtualLink) {
			virtualLink = new HashSet<>();
		}
		virtualLink.add(name);
	}
}
