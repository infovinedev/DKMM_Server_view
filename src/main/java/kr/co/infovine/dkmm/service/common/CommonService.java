package kr.co.infovine.dkmm.service.common;

import kr.co.infovine.dkmm.db.model.common.TCommonCodeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonService {
    int deleteByPrimaryKey(@Param("codeGroup") String codeGroup, @Param("codeValue") String codeValue);

    int insert(TCommonCodeModel row);

    TCommonCodeModel selectByPrimaryKey(@Param("codeGroup") String codeGroup, @Param("codeValue") String codeValue);
    
    List<TCommonCodeModel> selectByCodeGroup(@Param("codeGroup") String codeGroup);
    
    List<TCommonCodeModel> selectAll();

    int updateByPrimaryKey(TCommonCodeModel row);

    public List<TCommonCodeModel> selectCommonCodeByPromotion(String mode);
}
