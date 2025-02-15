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
package com.ubiqube.etsi.mano.dao.mano.nsd.wan;

import java.io.Serializable;
import java.util.List;

import com.ubiqube.etsi.mano.dao.mano.nsd.wan.type.PeerModeType;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Data;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Data
@Embeddable
public class VxLanConfig implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	private PeerModeType peerMode;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> peers;
}
