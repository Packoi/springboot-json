package com.packoi.json.dao.cms;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.packoi.json.domain.CmsFrag;

/**
 * @Description: 新闻库接口
 * @author yuhai.li  
 * @date 2018年1月19日 下午2:31:50
 */
@Mapper
public interface CmsDao {
	List<CmsFrag> getCmsFrags(@Param("chnmb") String chnmb, @Param("clsids") String[] clsids);
}
