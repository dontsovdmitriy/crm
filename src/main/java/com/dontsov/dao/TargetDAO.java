package com.dontsov.dao;

import java.util.List;

import com.dontsov.model.entity.Target;

public interface TargetDAO {

	public List<Target> getTargets();

	public void saveTarget(Target theTarget);

	public Target getTarget(int theId);

	public void deleteTarget(int theId);
}
