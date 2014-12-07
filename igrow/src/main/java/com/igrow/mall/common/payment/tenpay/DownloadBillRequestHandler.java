/**
* @FileName DownloadBillRequestHandler.java
* @Package com.igrow.mall.common.payment.tenpay
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年5月26日 上午11:22:47
* @Version V1.0.1
*/
package com.igrow.mall.common.payment.tenpay;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igrow.mall.common.payment.tenpay.RequestHandler;
import com.igrow.mall.common.payment.tenpay.util.MD5Util;
/**
 * @ClassName DownloadBillRequestHandler
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2014年5月26日 上午11:22:47
 */
public class DownloadBillRequestHandler extends RequestHandler {
	public DownloadBillRequestHandler(HttpServletRequest request,
			HttpServletResponse response) {
		super(request, response);
		
	}
	
	/**
	 * 创建md5摘要,规则是:按参数固定顺序组串,遇到空值的参数不参加签名。
	 */
	protected void createSign() {
		StringBuffer sb = new StringBuffer();
        sb.append("spid=" + this.getParameter("spid") + "&");
        sb.append("trans_time=" + this.getParameter("trans_time") + "&");
        sb.append("stamp=" + this.getParameter("stamp") + "&");
        sb.append("cft_signtype=" + this.getParameter("cft_signtype") + "&");
        sb.append("mchtype=" + this.getParameter("mchtype") + "&");
		sb.append("key=" + this.getKey());
		
		String enc = "";
		String sign = MD5Util.MD5Encode(sb.toString(), enc).toLowerCase();
		
		this.setParameter("sign", sign);
		
		//debug信息
		this.setDebugInfo(sb.toString() + " => sign:" + sign);
		
	}
}
