package net.chinahrd.entity.dto.pc.manpowerCost;

import java.io.Serializable;
import java.util.List;

/**
 * 人力总成本月度趋势  最后返回到前台的对象
 * @author htpeng
 *2015年12月30日上午11:19:09
 */
public class ManpowerTrendDto implements Serializable{
	private static final long serialVersionUID = 1718464667014625023L;
	private double total;
	private double budget;
	private List<ManpowerDto> detail;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public List<ManpowerDto> getDetail() {
		return detail;
	}
	public void setDetail(List<ManpowerDto> detail) {
		this.detail = detail;
	}
	
	
}
