/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */

package com.gpower.common.dto.parent;

import java.io.Serializable;

public abstract class TransferObject<T extends Serializable> implements Transferable<T> {

	private static final long serialVersionUID = 5911480537256662857L;

	public abstract T toObject(T obj) throws Exception;
}
