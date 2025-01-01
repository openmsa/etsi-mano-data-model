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
package com.ubiqube.etsi.mano.dao.mano.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 *
 *         Define an VNF inside a NSD.
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class NsVnf {
	private String vnfdId;
	private String name;
	private String flavourId;
	private String virtualLink;
	private String virtualLink1;
	private String virtualLink2;
	private String virtualLink3;
	private String virtualLink4;
	private String virtualLink5;
	private String virtualLink6;
	private String virtualLink7;
	private String virtualLink8;
	private String virtualLink9;
	private String virtualLink10;

}
