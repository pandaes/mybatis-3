package org.apache.ibatis.study.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.study.entity.UserInfo;

/**
 * @author liupiao
 * @date 2022/7/12 16:28
 * @description
 */

public interface UserInfoMapper {

    UserInfo selectUser(Integer id);

    @Select("select * from user_info where id = #{id}")
    UserInfo selectUser1(Integer id);

}
