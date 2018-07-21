package entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: CurrentResult   
 * @Description: 返回结果 
 * @author: Focus
 * @date: 2018年7月17日 下午8:45:01   
 *     
 * @Copyright: 2018 Focus All rights reserved. 
 * 注意：本内容仅限于个人训练
 */
public class CurrentResult implements Serializable {

	/**   
	 * @Fields serialVersionUID : TODO  
	 */  
	private static final long serialVersionUID = 7053818915400132921L;
	private boolean success;
	private String message;

	public CurrentResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
