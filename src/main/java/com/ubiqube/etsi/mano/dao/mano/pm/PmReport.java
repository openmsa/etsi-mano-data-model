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
package com.ubiqube.etsi.mano.dao.mano.pm;

import java.io.Serializable;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.UUID;

import com.ubiqube.etsi.mano.utils.ToStringUtil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PmReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	/**
	 * The time when the report was made available.
	 */
	private LocalDateTime readyTime;

	/**
	 * The time when the report will expire.
	 */
	private LocalDateTime expiryTime;

	/**
	 * The size of the report file in bytes, if known.
	 */
	private long fileSize;

	private URI href;

	@Override
	public String toString() {
		return ToStringUtil.toString(this);
	}

}
