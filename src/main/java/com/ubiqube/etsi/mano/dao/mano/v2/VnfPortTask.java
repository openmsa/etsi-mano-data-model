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

import java.util.LinkedHashSet;
import java.util.Set;

import com.ubiqube.etsi.mano.dao.mano.ExtManagedVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.VnfLinkPort;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class VnfPortTask extends VnfTask {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private VnfLinkPort vnfLinkPort;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private ExtManagedVirtualLinkDataEntity external;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<IpSubnet> ipSubnet = new LinkedHashSet<>();

	private String macAddress;

	@Override
	public VnfTask copy() {
		final VnfPortTask t = new VnfPortTask();
		super.copy(t);
		t.setVnfLinkPort(vnfLinkPort);
		t.setExternal(external);
		t.setIpSubnet(ipSubnet);
		t.setMacAddress(macAddress);
		return t;
	}
}
