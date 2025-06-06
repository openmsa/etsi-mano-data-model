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
package com.ubiqube.etsi.mano.model;

import java.util.List;
import java.util.Map;

import com.ubiqube.etsi.mano.dao.mano.VnfScaleInfo;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.ScaleToLevelData;
import com.ubiqube.etsi.mano.utils.ToStringUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VnfScaleToLevelRequest {
	private String instantiationLevelId;

	private List<CommScaleInfo> scaleInfo;

	private Map<String, String> additionalParams;

	public static VnfScaleToLevelRequest of(final ScaleToLevelData scaleData) {
		final List<VnfScaleInfo> l = scaleData.getVnfScaleInfo();
		final List<CommScaleInfo> scaleInfo = l.stream().map(CommScaleInfo::of).toList();
		return new VnfScaleToLevelRequest(scaleData.getVnfInstantiationLevelId(), scaleInfo, scaleData.getAdditionalParams());
	}

	@Override
	public String toString() {
		return ToStringUtil.toString(this);
	}

}
