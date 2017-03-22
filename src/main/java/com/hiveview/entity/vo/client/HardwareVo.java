package com.hiveview.entity.vo.client;

import com.hiveview.entity.client.Cp;
import com.hiveview.entity.client.Hardware;

public class HardwareVo extends Hardware {

	private Cp cp;

	public Cp getCp() {
		return cp;
	}

	public void setCp(Cp cp) {
		this.cp = cp;
	}
}
