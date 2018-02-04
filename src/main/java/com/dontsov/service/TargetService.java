package com.dontsov.service;

import java.util.List;

import com.dontsov.model.entity.Target;

public interface TargetService {

	public List<Target> getTargets();

	public void saveTarget(Target theTarget);

	public Target getTarget(int theId);

	public void deleteTarget(int theId);
}
