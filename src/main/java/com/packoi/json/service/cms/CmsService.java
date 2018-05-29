package com.packoi.json.service.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;

import com.alibaba.fastjson.JSON;
import com.packoi.json.dao.cms.CmsDao;
import com.packoi.json.domain.CmsFrag;
import com.packoi.json.utils.Constant;

/**
 * @Description: 新闻库数据处理Service
 * @author yuhai.li  
 * @date 2018年1月19日 下午2:34:53
 */
@Service
public class CmsService {

	@Autowired
	private CmsDao cmsDao;
	@Autowired
	private JedisCluster jedisCluster;
	
	/**
	 * @Description: 推广位碎片列表
	 * @return List<CmsFrag>
	 * @author yuhai.li
	 * @date 2018年3月12日 上午11:54:29
	 */
	public List<CmsFrag> getPromoteFrag(){
		String key=Constant.M_REDIS_KEY_BASE+"index_frag";
		List<CmsFrag> result = null;
		if(jedisCluster.exists(key)){
			String text = jedisCluster.get(key);
			result = JSON.parseArray(text, CmsFrag.class);
		}else{
			result = getCmsFrags("611", "002099,002100,002101,002102,002103,002104,002105,002106,002107,002108,002109,002110,002111,002112,002113,002114,002115,002116,002117,002118".split(","));
			jedisCluster.setex(key, 60, JSON.toJSONString(result));
		}
		return result;
	}
	
	/**
	 * @Description: 取某频道下对应的碎片
	 * @param chnmb 频道号
	 * @param clsids 栏目号数组
	 * @return List<CmsFrag>
	 * @author yuhai.li
	 * @date 2018年3月12日 上午11:54:52
	 */
	private List<CmsFrag> getCmsFrags(String chnmb, String... clsids){
		if(chnmb==null || "".equals(chnmb)){
			return null;
		}
		if(clsids==null || clsids.length==0){
			return null;
		}
		return cmsDao.getCmsFrags(chnmb, clsids);
	}
	
}
