package entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: PageResult   
 * @Description: 分页结果类
 * @author: Focus
 * @date: 2018年7月17日 下午8:01:27   
 *     
 * @Copyright: 2018 Focus All rights reserved. 
 * 注意：本内容仅限于个人训练
 */
@SuppressWarnings("rawtypes")
public class PageResult implements Serializable {

	/**   
	 * @Fields serialVersionUID : TODO  
	 */
	private static final long serialVersionUID = 2740111006651432734L;

	private long total;
	private List rows;

	public PageResult(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
