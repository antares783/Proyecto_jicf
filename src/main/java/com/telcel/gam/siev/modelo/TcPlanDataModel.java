package com.telcel.gam.siev.modelo;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class TcPlanDataModel extends ListDataModel<TcPlan> implements SelectableDataModel<TcPlan>{

	public TcPlanDataModel() {}
	
	public TcPlanDataModel(List<TcPlan> data) {
		super(data);
	}
	
	@Override
	public TcPlan getRowData(String rowKey) {
		@SuppressWarnings("unchecked")
		List<TcPlan> tcPlanes = (List<TcPlan>) getWrappedData();
		for(TcPlan plan : tcPlanes) {
			if(plan.getId().equals(rowKey)) {
				return plan;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(TcPlan object) {
		// TODO Auto-generated method stub
		return object.getId();
	}

}
