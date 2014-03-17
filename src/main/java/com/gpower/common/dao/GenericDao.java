/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.gpower.common.dao;


public interface GenericDao<T> {

	public T getById(Long id);

	public T save(T object);

	public T update(T object);

	public void remove(Long id);

}
