package org.apache.ibatis.study.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author liupiao
 * @date 2022/7/12 16:27
 * @description
 */

@Data
@ToString
public class UserInfo implements Serializable {

    private Long id;

    private String userName;

    private String userPhone;

}